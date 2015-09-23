package info.chenli.mooc.semantic;

import java.time.Instant;
import java.util.List;

public class Video {

	private String name;
	private List<Instant> points;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Instant> getPoints() {
		return points;
	}

	public void setPoints(List<Instant> points) {
		this.points = points;
	}

}
