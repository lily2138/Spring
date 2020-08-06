package oop.self;

public class Programmer {
	
	//필드 공간
	public String name;
	public int age;
	public float salary;
	public int bonus;
	
	//필드에 들어온 값 집어넣기
	public void setProgrammer(String n, int a, float s, int b) {
		name = n;
		age = a;
		salary = s;
		bonus = b;
	}
	
	public String getProgrammer() {
		return name+","+age+","+salary+","+bonus;
	}
	
	public float getAnnualSalary() {
		return salary*12 + bonus;
	}

}
