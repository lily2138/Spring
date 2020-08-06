package banking;
/*
 * 통장을 개설하고자 하는 고객의 정보를 저장하고 있는 클래스...
 * Customer + Account === Has a Relation
 * 1. 필드에 Account를 선언
 * 2. Account를 주입 ---- 생성자 / Setter
 */

public class Customer {
	private String name;
	private int ssn;
	//추가
	private Account account;
	
	public Customer(String name, int ssn) {
		this.name = name;
		this.ssn = ssn;
	}

	//account setter추가. 생성자랑 다름. !!!
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Account getAccount() {
		return account;
	}

	public String getCustInfo() {
		return name+" "+ssn;
	}
	
	
}
