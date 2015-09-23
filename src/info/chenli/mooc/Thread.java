package info.chenli.mooc;

import java.util.List;

/**
 * 
 * @author Chen Li
 *
 */
public class Thread extends Post {

	private int index;
	private String title;
	private String body;
	private int vote;

	private String courseware;
	private String commentableId;
	private int numberOfReply;

	private List<Reply> replies;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public String getCourseware() {
		return courseware;
	}

	public void setCourseware(String courseware) {
		this.courseware = courseware;
	}

	public String getCommentableId() {
		return commentableId;
	}

	public void setCommentableId(String commentableId) {
		this.commentableId = commentableId;
	}

	public int getNumberOfReply() {
		return numberOfReply;
	}

	public void setNumberOfReply(int numberOfReply) {
		this.numberOfReply = numberOfReply;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

}
