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

	private static Logger logger = Logger.getLogger(VideoSegmentor.class
			.getName());

	public static VideoSegmentor instance;
	private static List<Video> videoWithSegments;
	private static String file = "data/MITx-6.00x-2013_Spring/videoSegments.csv";

	// override the default constructor
	private VideoSegmentor() {
	}

	static {

		instance = new VideoSegmentor();

		videoWithSegments = new ArrayList<Video>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line;
			while ((line = br.readLine()) != null) {

				StringTokenizer st = new StringTokenizer(line, ",");
				String videoName = st.nextToken().trim();

				Video video = new Video();
				video.setName(videoName);

				video.setPoints(new ArrayList<Date>());
				video.setTypes(new ArrayList<String>());

				while (st.hasMoreTokens()) {
					String token = st.nextToken().trim();
					if (null == token || token.equals("")) {
						break;
					}

					String timeStr = token.substring(0, token.lastIndexOf(":"));
					String type = token.substring(token.lastIndexOf(":"));

					video.getPoints().add(
							new SimpleDateFormat("hh:mm:ss").parse(timeStr));
					video.getTypes().add(type);
				}

				videoWithSegments.add(video);
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

	}

	public List<Video> getVideoWithSegments() {
		return videoWithSegments;
	}

	public void setVideoWithSegments(List<Video> videoWithSegments) {
		this.videoWithSegments = videoWithSegments;
	}

	static public void main(String[] args) {
		// new VideoSegmentor().readFromGroundTruth("./gt/2-5-false.csv");
		new VideoSegmentor().getVideoWithSegments();
	}
}
