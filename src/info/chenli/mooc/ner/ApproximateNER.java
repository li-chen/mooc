package info.chenli.mooc.ner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunking;
import com.aliasi.dict.ApproxDictionaryChunker;
import com.aliasi.dict.DictionaryEntry;
import com.aliasi.dict.TrieDictionary;
import com.aliasi.spell.FixedWeightEditDistance;
import com.aliasi.spell.WeightedEditDistance;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.TokenizerFactory;

public class ApproximateNER {

	private static Logger logger = Logger.getLogger(ApproximateNER.class
			.getName());

	private static TrieDictionary<String> dict = new TrieDictionary<String>();

	static {

		try (BufferedReader br = new BufferedReader(new FileReader("600.csv"))) {

			String line = br.readLine();

			while (line != null) {
				StringTokenizer st = new StringTokenizer(line, ",");
				String term = st.nextToken().trim();
				DictionaryEntry<String> entry = new DictionaryEntry<String>(
						term, st.nextToken().trim());
				line = br.readLine();
				dict.addEntry(entry);
			}

		} catch (FileNotFoundException e) {
			logger.severe(e.getMessage());
			throw new RuntimeException(e);
		} catch (IOException e) {
			logger.severe(e.getMessage());
			throw new RuntimeException(e);
		}

		// DictionaryEntry<String> entry1 = new DictionaryEntry<String>("P53",
		// "P53");
		// DictionaryEntry<String> entry2 = new DictionaryEntry<String>(
		// "protein 53", "P53");
		// DictionaryEntry<String> entry3 = new DictionaryEntry<String>("Mdm",
		// "Mdm");
		//
		// dict.addEntry(entry1);
		// dict.addEntry(entry2);
		// dict.addEntry(entry3);

		logger.info("Dictionary loaded.");
	}

	public String tag(String text) {

		TokenizerFactory tokenizerFactory = IndoEuropeanTokenizerFactory.INSTANCE;

		WeightedEditDistance editDistance = new FixedWeightEditDistance(0, -1,
				-1, -1, Double.NaN);

		double maxDistance = 2.0;

		ApproxDictionaryChunker chunker = new ApproxDictionaryChunker(dict,
				tokenizerFactory, editDistance, maxDistance);

		Chunking chunking = chunker.chunk(text);

		Set<Chunk> chunkSet = new TreeSet<Chunk>(new Comparator<Chunk>() {
			@Override
			public int compare(Chunk o1, Chunk o2) {

				if (o1.start() != o2.start()) {
					return ((Integer) o1.start()).compareTo((Integer) o2
							.start());
				} else {
					return ((Integer) o1.end()).compareTo((Integer) o2.end());
				}
			}
		});

		chunkSet = chunking.chunkSet();

		String output = "";
		int lastEnd = 0;
		for (Chunk chunk : chunkSet) {

			// // Ignore the enclosed/overlapped entities at the moment.
			if (chunk.start() < lastEnd) {
				continue;
			}

			// System.out.println(text.substring(chunk.start(), chunk.end()));
			output = output + text.substring(lastEnd, chunk.start()) + "<e>"
					+ text.substring(chunk.start(), chunk.end()) + "</e>";

			lastEnd = chunk.end();
		}

		output = output + text.substring(lastEnd);

		return output;
	}

	public String tag(File file) {

		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				tag(f);
			}
		}

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			StringBuffer sb = new StringBuffer();
			while ((line = br.readLine()) != null) {
				sb.append(tag(line) + "\n");
			}

			return sb.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	public static void main(String[] args) throws IOException {

		System.out.println(new ApproximateNER().tag(new File(args[0])));

	}
}