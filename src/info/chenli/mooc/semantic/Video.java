package info.chenli.mooc.semantic;

import java.util.Date;
import java.util.List;

public class Video {

	private String name;
	private List<Date> points;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Date> getPoints() {
		return points;
	}

	public void setPoints(List<Date> points) {
		this.points = points;
	}

}
