package info.chenli.mooc;

/**
 * This is the processor reading the crawled forum site.
 * 
 * @author Chen Li
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ForumDigester {

	private List<Thread> threads;
	private final SimpleDateFormat dateTimeFormatter = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

	public void digest() {

		BufferedReader br;

		try {

			br = new BufferedReader(new FileReader("../forum700xPreProc.htm"));
			threads = new ArrayList<Thread>();

			String line;

			while ((line = br.readLine()) != null) {

				line = line.trim();

				if (line.startsWith("<h2 id=\"index\">")) {

					int index = Integer.parseInt(line.substring(
							"<h2 id=\"index\">IndexTAG: ".length(),
							line.indexOf("</h2>")));

					Thread thread = new Thread();
					thread.setIndex(index);
					threads.add(thread);

				}

				if (line.startsWith("<h2 id=\"title\">")) {
					threads.get(threads.size() - 1).setTitle(
							line.substring(
									"<h2 id=\"title\">TitleTAG: ".length(),
									line.indexOf("</h2>")));
				}

				if (line.startsWith("<h3 id=\"body\">")) {

					String body = "";

					if (line.endsWith("</h3>")) {
						body = line.substring("<h3 id=\"body\">".length(),
								line.indexOf("</h3>"));
					} else {
						body = line.substring("<h3 id=\"body\">".length());
						while ((line = br.readLine().trim()) != null) {
							body = body.concat(line);
							if (body.endsWith("</h3>")) {
								body = body.substring(0, body.length() - 5);
								break;
							}
						}
					}
					threads.get(threads.size() - 1).setBody(body);
				}

				if (line.startsWith("<h3 id=\"userId\">UserIdTAG: ")) {
					threads.get(threads.size() - 1).setUserId(
							line.substring(
									"<h3 id=\"userId\">UserIdTAG: ".length(),
									line.indexOf("</h3>")));
				}

				if (line.startsWith("<h3 id=\"username\">UserNameTAG: ")) {
					threads.get(threads.size() - 1).setUserName(
							line.substring("<h3 id=\"username\">UserNameTAG: "
									.length(), line.indexOf("</h3>")));
				}

				if (line.startsWith("<h3 id=\"createtime\">CreateTimeTAG: ")) {
					threads.get(threads.size() - 1).setCreateTime(
							dateTimeFormatter.parse(line.substring(
									"<h3 id=\"createtime\">CreateTimeTAG: "
											.length(), line.indexOf("</h3>"))));
				}

				if (line.startsWith("<h3 id=\"vote\">VoteTAG:")) {

					int vote = Integer.parseInt(line.substring(
							"<h3 id=\"vote\">VoteTAG:".length(),
							line.indexOf("</h3>")));

					threads.get(threads.size() - 1).setVote(vote);
				}

				if (line.startsWith("<h3 id=\"courseware\">CoursewareTAG: ")) {
					threads.get(threads.size() - 1).setCourseware(
							line.substring(
									"<h3 id=\"courseware\">CoursewareTAG: "
											.length(), line.indexOf("</h3>")));
				}

				if (line.startsWith("<h3 id=\"commentableId\">CommentableIdTAG: ")) {
					threads.get(threads.size() - 1).setCommentableId(
							line.substring(
									"<h3 id=\"commentableId\">CommentableIdTAG: "
											.length(), line.indexOf("</h3>")));
				}

				if (line.startsWith("<h3 id=\"numberOfReply\">NumberOfReplyTAG: ")) {

					int vote = Integer.parseInt(line.substring(
							"<h3 id=\"numberOfReply\">NumberOfReplyTAG: "
									.length(), line.indexOf("</h3>")));

					threads.get(threads.size() - 1).setNumberOfReply(vote);
				}

				if (line.startsWith("<h4 id=\"firstChild\">FirstChildTAG: ")) {

					String content = "";

					if (line.endsWith("</h4>")) {
						content = line.substring(
								"<h4 id=\"firstChild\">FirstChildTAG: "
										.length(), line.indexOf("</h4>"));
					} else {
						content = line
								.substring("<h4 id=\"firstChild\">FirstChildTAG: "
										.length());
						while ((line = br.readLine().trim()) != null) {
							content = content.concat(line);
							if (content.endsWith("</h4>")) {
								content = content
										.substring(content.length() - 5);
								break;
							}
						}
					}

					Reply reply = new Reply();
					reply.setContent(content);

					if (threads.get(threads.size() - 1).getReplies() == null) {
						threads.get(threads.size() - 1).setReplies(
								new ArrayList<Reply>());
					}

					threads.get(threads.size() - 1).getReplies().add(reply);
				}

				if (line.startsWith("<h4 id=\"firstChildUserId\">FirstChildUserIdTAG: ")) {

					Reply reply = threads
							.get(threads.size() - 1)
							.getReplies()
							.get(threads.get(threads.size() - 1).getReplies()
									.size() - 1);
					reply.setUserId(line.substring(
							"<h4 id=\"firstChildUserId\">FirstChildUserIdTAG: "
									.length(), line.indexOf("</h4>")));

				}

				if (line.startsWith("<h4 id=\"firstChildUsername\">FirstChildUserNameTAG: ")) {

					Reply reply = threads
							.get(threads.size() - 1)
							.getReplies()
							.get(threads.get(threads.size() - 1).getReplies()
									.size() - 1);
					reply.setUserName(line.substring(
							"<h4 id=\"firstChildUsername\">FirstChildUserNameTAG: "
									.length(), line.indexOf("</h4>")));

				}

				if (line.startsWith("<h4 id=\"firstChildCreatetime\">FirstChildCreateTimeTAG: ")) {

					Reply reply = threads
							.get(threads.size() - 1)
							.getReplies()
							.get(threads.get(threads.size() - 1).getReplies()
									.size() - 1);
					reply.setCreateTime(dateTimeFormatter.parse(line.substring(
							"<h4 id=\"firstChildCreatetime\">FirstChildCreateTimeTAG: "
									.length(), line.indexOf("</h4>"))));

				}

				if (line.startsWith("<h5 id=\"secondChild\">SecondChildTAG: ")) {

					String content = "";

					if (line.endsWith("</h5>")) {
						content = line.substring(
								"<h5 id=\"secondChild\">SecondChildTAG: "
										.length(), line.indexOf("</h5>"));
					} else {
						content = line
								.substring("<h5 id=\"secondChild\">SecondChildTAG: "
										.length());
						while ((line = br.readLine().trim()) != null) {
							content = content.concat(line);
							if (content.endsWith("</h5>")) {
								content = content
										.substring(content.length() - 5);
								break;
							}
						}
					}

					Reply reply = threads
							.get(threads.size() - 1)
							.getReplies()
							.get(threads.get(threads.size() - 1).getReplies()
									.size() - 1);
					if (reply.getComments() == null) {
						reply.setComments(new ArrayList<Comment>());
					}
					Comment comment = new Comment();

					comment.setContent(content);
					reply.getComments().add(comment);

				}

				if (line.startsWith("<h5 id=\"secondChildUserId\">SecondChildUserIdTAG: ")) {

					Reply reply = threads
							.get(threads.size() - 1)
							.getReplies()
							.get(threads.get(threads.size() - 1).getReplies()
									.size() - 1);

					Comment comment = reply.getComments().get(
							reply.getComments().size() - 1);

					comment.setUserId(line.substring(
							"<h5 id=\"secondChild\">SecondChildTAG: ".length(),
							line.indexOf("</h5>")));

				}

				if (line.startsWith("<h5 id=\"secondChildUsername\">SecondChildUserNameTAG: ")) {

					Reply reply = threads
							.get(threads.size() - 1)
							.getReplies()
							.get(threads.get(threads.size() - 1).getReplies()
									.size() - 1);

					Comment comment = reply.getComments().get(
							reply.getComments().size() - 1);

					comment.setUserName(line.substring(
							"<h5 id=\"secondChild\">SecondChildTAG: ".length(),
							line.indexOf("</h5>")));

				}

				if (line.startsWith("<h5 id=\"secondChildCreatetime\">SecondChildCreateTimeTAG: ")) {

					Reply reply = threads
							.get(threads.size() - 1)
							.getReplies()
							.get(threads.get(threads.size() - 1).getReplies()
									.size() - 1);

					Comment comment = reply.getComments().get(
							reply.getComments().size() - 1);

					comment.setCreateTime(dateTimeFormatter.parse(line
							.substring(
									"<h5 id=\"secondChildCreatetime\">SecondChildCreateTimeTAG: "
											.length(), line.indexOf("</h5>"))));

				}

			}

			br.close();

		} catch (FileNotFoundException e) {

			throw new RuntimeException(e);

		} catch (IOException e) {

			throw new RuntimeException(e);
		} catch (ParseException e) {

			throw new RuntimeException(e);
		}

	}

	public static void main(String[] args) {

		ForumDigester digester = new ForumDigester();
		digester.digest();

		// Threads and stats
		System.out
				.println("threadLength,quickestResponds,totalReplyNumber,longestReply,totalReplyLength,totalCommentNumber,largestCommentNumber,longestComment,totalCommentLength");
		for (Thread thread : digester.threads) {

			int longestReply = 0, totalReplyLength = 0, totalCommentNumber = 0, largestCommentNumber = 0, longestComment = 0, totalCommentLength = 0;

			if (thread.getReplies() != null) {
				for (Reply reply : thread.getReplies()) {
					int replyLength = reply.getContent().length();
					longestReply = replyLength > longestReply ? replyLength
							: longestReply;
					totalReplyLength = totalReplyLength + replyLength;
					if (reply.getComments() != null) {
						totalCommentNumber = totalCommentNumber
								+ reply.getComments().size();
						largestCommentNumber = largestCommentNumber > reply
								.getComments().size() ? largestCommentNumber
								: reply.getComments().size();
						for (Comment comment : reply.getComments()) {
							longestComment = longestComment > comment
									.getContent().length() ? longestComment
									: comment.getContent().length();
							totalCommentLength = totalCommentLength
									+ comment.getContent().length();
						}
					}
				}
			}

			long minutes = 0;
			if (thread.getReplies() != null) {
				long diffInMillies = thread.getReplies().get(0).getCreateTime()
						.getTime()
						- thread.getCreateTime().getTime();
				minutes = TimeUnit.MINUTES.convert(diffInMillies,
						TimeUnit.MILLISECONDS);
			}

			System.out.println((thread.getBody() == null ? 0 : thread.getBody()
					.length())
					+ ","
					+ minutes
					+ ","
					+ ((thread.getReplies() == null) ? 0 : thread.getReplies()
							.size())
					+ ","
					+ longestReply
					+ ","
					+ totalReplyLength
					+ ","
					+ totalCommentNumber
					+ ","
					+ largestCommentNumber
					+ ","
					+ longestComment
					+ ","
					+ totalCommentLength);
		}

		// Number of thread
		// System.out.println("Total number of threads:");
		// System.out.println("\t" + digester.threads.size());
	}
}
