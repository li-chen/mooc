package info.chenli.mooc.semantic;

public class Keyword {

	private String theWord;
	private double score;

	public String getTheWord() {
		return theWord;
	}

	public void setTheWord(String theWord) {
		this.theWord = theWord;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {

		return "theWord:" + theWord + ", score:" + score;

	}
}
