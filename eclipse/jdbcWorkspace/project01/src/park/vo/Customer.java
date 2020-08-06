package park.vo;

public class Customer {
	private int custNo;
	private String sex;
	private int age;
	
	
	public Customer(int custNo, String sex, int age) {
		super();
		this.custNo = custNo;
		this.sex = sex;
		this.age = age;
	}
	public int getCustNo() {
		return custNo;
	}
	public void setCustNo(int custNo) {
		this.custNo = custNo;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Customer [custNo=" + custNo + ", sex=" + sex + ", age=" + age + "]";
	}
	
	
}
