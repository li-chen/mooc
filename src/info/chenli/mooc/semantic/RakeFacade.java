package info.chenli.mooc.semantic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;

public class RakeFacade {

	private static Logger logger = Logger.getLogger(RakeFacade.class.getName());

	private List<Keyword> keywords = new ArrayList<Keyword>();

	public void readKeywords(File file) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line;
			while ((line = br.readLine()) != null) {

				if (!line.startsWith("Keywords")) {
					continue;
				}

				line = line.substring(11, line.length() - 1);
				StringTokenizer st = new StringTokenizer(line, ")");
				while (st.hasMoreTokens()) {
					String token = st.nextToken();

					Keyword keyword = new Keyword();
					keyword.setTheWord(token.substring(token.indexOf("('") + 2,
							token.lastIndexOf("',")).trim());
					keyword.setScore(Float.parseFloat(token.substring(
							token.lastIndexOf("',") + 2).trim()));

					keywords.add(keyword);
				}
			}

			br.close();

		} catch (FileNotFoundException e) {
			logger.severe(e.getMessage());
			throw new RuntimeException(e);
		} catch (IOException e) {
			logger.severe(e.getMessage());
			throw new RuntimeException(e);
		}

	}

	public List<Keyword> getKeywords() {
		return keywords;
	}

	public static void main(String[] args) {

		new RakeFacade()
				.readKeywords(new File(
						"data/MITx-6.00x-2013_Spring/transcription_600.rake-tutorial.txt"));
	}
}
