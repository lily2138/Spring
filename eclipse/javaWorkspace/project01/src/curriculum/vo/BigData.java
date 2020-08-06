package curriculum.vo;

public class BigData extends Curriculum{
	private int ptScore;
	public BigData() {
		super(1, "BigData", "Kim",0,0);
	}
	
	public int getPtScore() {
		return ptScore;
	}
	public void setPtScore(int ptScore) {
		this.ptScore = ptScore;
	}
	
	public String toString() {
		return super.toString()+"\t발표점수: "+ptScore+"\n총 점수: "+super.getTotalScore();//****************
	}
}
