package info.chenli.mooc.semantic;

public class Keyword {

	private String theWord;
	private float score;

	public String getTheWord() {
		return theWord;
	}

	public void setTheWord(String theWord) {
		this.theWord = theWord;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	@Override
	public String toString() {

		return "theWord:" + theWord + ", score:" + score;

	}
}
