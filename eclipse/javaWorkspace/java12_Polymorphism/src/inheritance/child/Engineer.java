package inheritance.child;

import inheritance.parent.Employee;
import inheritance.util.MyDate;

//자식, child. sub클래스
public class Engineer extends Employee{
	private String tech;
	private double bonus;
	
	//Employee에 기본생성자를 안해주면 error가 난다.
	//자식에서 부모클래스를 상속할 때는 넣어줘야한다. 
	public Engineer(String name, double salary, MyDate birthDate,String tech, double bonus) {
		//자식 생성자 첫라인에서 부모생성자 호출이 무조건 일어나야 한다.
		super(name,salary,birthDate);
		this.tech = tech;
		this.bonus = bonus;
	}
	
	
	public double getBonus() {
		return bonus;
	}

	public void changeTech(String tech) {
		this.tech = tech;
	}
	
	//1.그대로 물려받는다 2.고친다
	public String getDetails() {
		return super.getDetails()+","+tech+","+bonus; //Employee의 getDetails()호출
	}

}
