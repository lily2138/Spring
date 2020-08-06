package curriculum.vo;

public class AI extends Curriculum{
	private int quizScore;
	private int teamScore;
	public AI() {
		super(2, "AI", "Lee", 0, 0);
	}
	
	public int getQuizScore() {
		return quizScore;
	}

	public void setQuizScore(int quizScore) {
		this.quizScore = quizScore;
	}

	public int getTeamScore() {
		return teamScore;
	}

	public void setTeamScore(int teamScore) {
		this.teamScore = teamScore;
	}

	public String toString() {
		String tempString = super.toString();
		return super.toString()+"\tÄûÁîÁ¡¼ö: "+quizScore+"\tÆÀ Á¡¼ö: "+teamScore+"\nÃÑ Á¡¼ö: "+super.getTotalScore();//*************************
	}
}
