package com.encore.test;

import com.encore.service.EmployeeService;
import com.encore.util.MyDate;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;

public class EmployeeServiceTest {
	public static void main(String[] args) {
		//1. Service 객체를 생성
		EmployeeService service = new EmployeeService(5);
		
		//2. method를 각각 호출..
		System.out.println("============ 1. addManager ============ ");
		service.addManager(new Manager("이수근", new MyDate(1978, 1, 1), 20000.0, "개발부", 10));
		service.addManager(new Manager("강호동", new MyDate(1975, 2, 1), 34000.0, "기획부", 20));
		service.addManager(new Manager("강하늘", new MyDate(1980, 3, 3), 20000.0, "교육부", 30));
		service.addManager(new Manager("옹성우", new MyDate(1995, 8, 1), 37000.0, "개발부", 10));
		
		System.out.println("============ Manager 정보확인 ============ ");
		service.printManagers();
		
		System.out.println("\n============ 1. addEngineer ============ ");
		service.addEngineer(new Engineer("강제영", new MyDate(1995,3,4), 350000.0, "Java", 200.0));
		service.addEngineer(new Engineer("임채은", new MyDate(1995,7,2), 350000.0, "Java", 200.0));
		service.addEngineer(new Engineer("김주혁", new MyDate(1994,11,2), 450000.0, "Python", 300.0));
		
		System.out.println("============ Engineer 정보확인 ============ ");
		service.printEngineers();
		
		/*
		System.out.println("\n============ 2. deleteManager(강호동 삭제) ============ ");
		service.deleteManager("강호동");
		System.out.println("============ Manager 정보확인 ============ ");
		service.printManagers();
		*/
		
		/*
		System.out.println("\n============ 3. updateManager(강하늘 연봉 수정 200->350) ============ ");
		service.updateManager(35000.0, "교육부", 30,  "강하늘");//?
		System.out.println("============ Manager 정보확인 ============ ");
		service.printManagers();
		*/
		
		/*
		System.out.println("\n============ 4. findManager(이수근) ============ ");
		Manager retM1=service.findManager("이수근");
		System.out.println(retM1.getDetails());
		*/
		
		/*
		System.out.println("\n============ 4. findManager(10) ============ ");
		System.out.println("10번 부서에 근무하는 직원들 입니다..");
		Manager[ ] retMs1 = service.findManager(10);
		for(Manager m : retMs1) {
			if(m==null) continue;
			System.out.println(m.getDetails());
		}*/
	}
}







