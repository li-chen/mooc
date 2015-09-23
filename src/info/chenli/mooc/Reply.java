package info.chenli.mooc;

import java.util.List;

/**
 * 
 * @author Chen Li
 *
 */
public class Reply extends Post {

	private List<Comment> comments;

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
