package park.vo;

public class Attraction {
	private int attrNo;
	private String attrName;
	private int limitAge;
	private int maxPerson;
	private String info;
	
	public Attraction(int attrNo, String attrName, int limitAge, int maxPerson, String info) {
		super();
		this.attrNo = attrNo;
		this.attrName = attrName;
		this.limitAge = limitAge;
		this.maxPerson = maxPerson;
		this.info = info;
	}
	public int getAttrNo() {
		return attrNo;
	}
	public void setAttrNo(int attrNo) {
		this.attrNo = attrNo;
	}
	public String getAttrName() {
		return attrName;
	}
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	public int getLimitAge() {
		return limitAge;
	}
	public void setLimitAge(int limitAge) {
		this.limitAge = limitAge;
	}
	public int getMaxPerson() {
		return maxPerson;
	}
	public void setMaxPerson(int maxPerson) {
		this.maxPerson = maxPerson;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "Attraction [attrNo=" + attrNo + ", attrName=" + attrName + ", limitAge=" + limitAge + ", maxPerson="
				+ maxPerson + ", info=" + info + "]";
	}
	
}
