package inheritance.child;

import inheritance.parent.Employee;
import inheritance.util.MyDate;

//자식, child. sub클래스
public class Secretary extends Employee{
	private String nameOfBoss;
	
	//Employee에 기본생성자를 안해주면 error가 난다.
	//자식에서 부모클래스를 상속할 때는 넣어줘야한다. 
	public Secretary(String name, double salary, MyDate birthDate,String nameOfBoss) {
		//자식 생성자 첫라인에서 부모생성자 호출이 무조건 일어나야 한다.
		super(name,salary,birthDate);
		this.nameOfBoss = nameOfBoss;
	}
	
	//1.그대로 물려받는다 2.고친다
	public String getDetails() {
		return super.getDetails()+","+nameOfBoss; //Employee의 getDetails()호출
	}

}
