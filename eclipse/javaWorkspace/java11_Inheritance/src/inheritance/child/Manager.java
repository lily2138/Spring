package inheritance.child;

import inheritance.parent.Employee;
import inheritance.util.MyDate;

//자식, child. sub클래스
public class Manager extends Employee{
	private String dept;
	
	//Employee에 기본생성자를 안해주면 error가 난다.
	//자식에서 부모클래스를 상속할 때는 넣어줘야한다. 
	public Manager(String name, double salary, MyDate birthDate,String dept) {
		//자식 생성자 첫라인에서 부모생성자 호출이 무조건 일어나야 한다.
		super(name,salary,birthDate);
		this.dept = dept;
	}
	
	//1.그대로 물려받는다 2.고친다
	public String getDetails() {
		return super.getDetails(); //Employee의 getDetails()호출
	}

}
