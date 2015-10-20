package info.chenli.mooc.semantic;

import info.chenli.mooc.semantic.types.KeywordAnnotation;
import info.chenli.mooc.semantic.types.Transcription;
import info.chenli.mooc.semantic.types.VisualSegment;
import info.chenli.mooc.util.FileUtil;
import info.chenli.mooc.util.UIMAUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Logger;

import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.util.FileUtils;
import org.apache.uima.util.InvalidXMLException;
import org.apache.uima.util.XMLInputSource;

public class TranscriptionAnnotator extends JCasAnnotator_ImplBase {

	private static Logger logger = Logger
			.getLogger(TranscriptionAnnotator.class.getName());
	private static String taeDescriptor = "./desc/TranscriptionAnnotator.xml";

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {

		// get the video and segment information
		Video currentVideo = null;

		for (Video video : VideoSegmentor.instance.getVideoWithSegments()) {

			if (video.getName().equals(
					FileUtil.getFileNameWithoutExtension(UIMAUtil
							.getJCasFilePath(jcas)))) {
				currentVideo = video;
				break;
			}
		}
//		System.out.println(FileUtil.getFileNameWithoutExtension(UIMAUtil
//				.getJCasFilePath(jcas)));

		Scanner scanner = new Scanner(jcas.getDocumentText());
		RakeFacade rf = new RakeFacade();
		rf.readKeywords(new File(
				"data/MITx-6.00x-2013_Spring/transcription_600.rake-tutorial.txt"));

		long segmentStartTime;
		try {
			segmentStartTime = new SimpleDateFormat("hh:mm:ss,SSS").parse(
					"00:00:00,000").getTime();
		} catch (ParseException e) {
			logger.severe(e.getMessage());
			throw new RuntimeException(e);
		}

		int segmentOffsetBegin = 0;

		int offset = 0;
		while (scanner.hasNextLine()) {

			String line = scanner.nextLine();

			if (line.isEmpty()) {
				offset++;
				continue;
			}

			try {

				int index = Integer.parseInt(line);

				offset = offset + line.length() + 1;

				String timeStr = scanner.nextLine();
				offset = offset + timeStr.length() + 1;

				Date startTime = new SimpleDateFormat("hh:mm:ss,SSS")
						.parse(timeStr.substring(0, timeStr.indexOf(" --> ")));
				Date endTime = new SimpleDateFormat("hh:mm:ss,SSS")
						.parse(timeStr.substring(timeStr.indexOf(" --> ") + 5));

				String transcriptionStr = scanner.nextLine();

				// add RAKE annotations
				for (Keyword keyword : rf.getKeywords()) {
					int i = transcriptionStr.indexOf(keyword.getTheWord());
					while (i >= 0) {
						KeywordAnnotation ka = new KeywordAnnotation(jcas,
								offset + i, offset + i
										+ keyword.getTheWord().length());
						ka.setScore(keyword.getScore());
						i = transcriptionStr.indexOf(keyword.getTheWord(),
								i + 1);
						ka.addToIndexes();
					}
				}

				Transcription transcription = new Transcription(jcas, offset,
						offset + transcriptionStr.length() + 1);

				offset = offset + transcriptionStr.length() + 1;

				transcription.setIndex(index);
				transcription.setStartTime(startTime.getTime());
				transcription.setEndTime(endTime.getTime());

				transcription.addToIndexes();

				// add video segmentation annotations
				for (int i = 0; i < currentVideo.getPoints().size(); i++) {

					Date point = currentVideo.getPoints().get(i);
					String type = currentVideo.getTypes().get(i);

					if (point.getTime() > transcription.getStartTime()
							&& point.getTime() < transcription.getEndTime()
							&& point.getTime() != new SimpleDateFormat(
									"hh:mm:ss").parse("00:00:01").getTime()) {

						VisualSegment vs = new VisualSegment(jcas,
								segmentOffsetBegin, transcription.getEnd());
						vs.setStartTime(segmentStartTime);
						vs.setEndTime(transcription.getEndTime());
						vs.setSemanticType(type);

						vs.addToIndexes(jcas);

						segmentStartTime = transcription.getEndTime();
						segmentOffsetBegin = transcription.getEnd();
						break;
					}
				}

			} catch (NumberFormatException e) {
				continue;
				// logger.severe(e.getMessage());
				// throw new RuntimeException(e);
			} catch (ParseException e) {
				logger.severe(e.getMessage());
				throw new RuntimeException(e);
			} catch (NoSuchElementException e) {
				if (e.getMessage().indexOf("No line found") > -1) {
					continue;
				}
			}

		}

		scanner.close();

	}

	public static void main(String[] args) {

		try {

			//
			// wikidata entities
			//
			List<String> wikiEntities = new ArrayList<String>();
			try (BufferedReader br = new BufferedReader(new FileReader(
					"./scripts/entities.txt"))) {
				for (String line; (line = br.readLine()) != null;) {
					wikiEntities.add(line.trim().toLowerCase());
				}
				// line is not visible here.
			}

			//
			// document keyword analysis
			//
			XMLInputSource in = new XMLInputSource(new File(taeDescriptor));
			ResourceSpecifier specifier = UIMAFramework.getXMLParser()
					.parseResourceSpecifier(in);

			// create Analysis Engine
			AnalysisEngine ae = UIMAFramework.produceAnalysisEngine(specifier);
			// create a CAS
			CAS cas = ae.newCAS();

			// read contents of file
			File inputFile = new File(args[0]);
			System.out.print(inputFile.getName().substring(0,
					inputFile.getName().lastIndexOf("."))
					+ "\t");
			String document = FileUtils.file2String(inputFile);

			// send doc through the AE
			cas.setDocumentText(document);
			cas.createView("FilePath").setSofaDataURI(
					inputFile.getAbsolutePath(), "text");
			ae.process(cas);

			FSIterator<AnnotationFS> segmentIterator = cas.getAnnotationIndex(
					cas.getTypeSystem().getType(
							"info.chenli.mooc.semantic.types.VisualSegment"))
					.iterator();

			int i = 0;
			while (segmentIterator.hasNext()) {
				VisualSegment vs = (VisualSegment) segmentIterator.next();
				List<KeywordAnnotation> keywords = JCasUtil.selectCovered(
						cas.getJCas(), KeywordAnnotation.class, vs);
				for (KeywordAnnotation ka : keywords) {
					if (wikiEntities
							.contains(ka.getCoveredText().toLowerCase())) {
						System.out.print(new SimpleDateFormat("hh:mm:ss")
								.format(new Date(vs.getStartTime()))
								+ "-"
								+ new SimpleDateFormat("hh:mm:ss")
										.format(new Date(vs.getEndTime()))
								+ "\t");
						break;
					}
				}
			}
			System.out.println();
			// destroy AE
			ae.destroy();
		} catch (IOException e) {
			logger.severe(e.getMessage());
			throw new RuntimeException(e);
		} catch (ResourceInitializationException e) {
			logger.severe(e.getMessage());
			throw new RuntimeException(e);
		} catch (InvalidXMLException e) {
			logger.severe(e.getMessage());
			throw new RuntimeException(e);
		} catch (AnalysisEngineProcessException e) {
			logger.severe(e.getMessage());
			throw new RuntimeException(e);
		} catch (CASException e) {
			logger.severe(e.getMessage());
			throw new RuntimeException(e);
		}
	}
}
