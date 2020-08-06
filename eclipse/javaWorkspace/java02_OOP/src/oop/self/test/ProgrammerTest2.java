package oop.self.test;

import java.util.Scanner;

import oop.self.Programmer;

public class ProgrammerTest2 {

	public static void main(String[] args) {
		Programmer pro = new Programmer();
		

		
		while(true) {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("이름을 입력하세요");
			String name = sc.nextLine();
			System.out.println("나이를 입력하세요");
			int age = sc.nextInt();
			
			pro.setProgrammer(name, age, 400.0f, 600);
			
			System.out.println("정보를 출력합니다");
			System.out.println(pro.getProgrammer());
			System.out.println("당신의 연봉은");
			System.out.println(pro.getAnnualSalary()+" 만원");
			
			
		}
		
	}

}
