package oop.self.test;

import oop.self.Programmer;

public class ProgrammerTest {

	public static void main(String[] args) {
		Programmer pro = new Programmer();
		
		pro.setProgrammer("Lily", 24, 400.0f, 600);
		
		System.out.println("정보를 출력합니다");
		System.out.println(pro.getProgrammer());
		System.out.println("당신의 연봉은");
		System.out.println(pro.getAnnualSalary()+" 만원");
		
	}

}
