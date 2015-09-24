package info.chenli.mooc.semantic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;

/**
 * 
 * @author Chen Li
 *
 */
public class VideoSegmentor {

	private static Logger logger = Logger.getLogger(VideoSegmentor.class.getName());

	private List<Granule> granules;

	/**
	 * Load the ground truth from a CSV file (e.g. generated from AMT results)
	 * 
	 * @param file
	 */
	public List<Video> readFromGroundTruth(String file) {

		List<Video> videos = new ArrayList<Video>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line;
			while ((line = br.readLine()) != null) {

				StringTokenizer st = new StringTokenizer(line, ",");
				String videoName = st.nextToken().trim();

				Video video = new Video();
				video.setName(videoName);

				video.setPoints(new ArrayList<Date>());

				while (st.hasMoreTokens()) {
					String token = st.nextToken().trim();
					if (null == token || token.equals("")) {
						break;
					}

					String timeStr = token.substring(0, token.lastIndexOf(":"));
					String type = token.substring(token.lastIndexOf(":"));

					video.getPoints().add(
							new SimpleDateFormat("hh:mm:ss").parse(timeStr));
				}

				videos.add(video);
			}

			br.close();

		} catch (FileNotFoundException e) {
			logger.severe(e.getMessage());
			throw new RuntimeException(e);
		} catch (IOException e) {
			logger.severe(e.getMessage());
			throw new RuntimeException(e);
		} catch (ParseException e) {
			logger.severe(e.getMessage());
			throw new RuntimeException(e);
		}

		return videos;
	}

	static public void main(String[] args) {
		new VideoSegmentor().readFromGroundTruth("./gt/2-5-false.csv");
	}
}
