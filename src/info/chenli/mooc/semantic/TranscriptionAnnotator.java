package info.chenli.mooc.semantic;

import info.chenli.mooc.semantic.types.KeywordAnnotation;
import info.chenli.mooc.semantic.types.Transcription;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Logger;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

public class TranscriptionAnnotator extends JCasAnnotator_ImplBase {

	private static Logger logger = Logger
			.getLogger(TranscriptionAnnotator.class.getName());

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {

		Scanner scanner = new Scanner(jcas.getDocumentText());
		RakeFacade rf = new RakeFacade();
		rf.readKeywords(new File(
				"data/MITx-6.00x-2013_Spring/transcription_600.rake-tutorial.txt"));

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

			} catch (NumberFormatException e) {
				logger.severe(e.getMessage());
				throw new RuntimeException(e);
			} catch (ParseException e) {
				logger.severe(e.getMessage());
				throw new RuntimeException(e);
			}

		}

		scanner.close();

	}
}
