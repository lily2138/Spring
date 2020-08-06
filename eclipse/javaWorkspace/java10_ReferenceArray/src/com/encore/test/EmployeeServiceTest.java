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
		//=======================추가===================================
		Manager man1 = new Manager("강호동", new MyDate(1991,4,11), 40000, "인사팀", 60);
		Manager man2 = new Manager("이수근", new MyDate(1994,11,06), 90000, "기획팀", 40);
		Manager man3 = new Manager("은지원", new MyDate(1981,6,15), 36000, "인사팀", 60);
		Manager man4 = new Manager("이승기", new MyDate(1986,10,9), 54000, "기획팀", 40);
		service.addManager(man1); //---> service.addManager(new Manager("강호동", new MyDate(1991,4,11), 40000, "인사팀", 60));
		service.addManager(man2);
		service.addManager(man3);
		service.addManager(man4);
	
		//service.printManagers();
		
		Engineer eng1 = new Engineer("강동원", new MyDate(1984,1,11), 36000, "JAVA", 600);
		Engineer eng2 = new Engineer("이동욱", new MyDate(1991,3,9), 56000, "C언어", 100);
		Engineer eng3 = new Engineer("윤두준", new MyDate(1990,7,04), 41000, "Python", 400);
		service.addEngineer(eng1);
		service.addEngineer(eng2);
		service.addEngineer(eng3);
		
		//service.printEngineers();
		
		//=======================삭제===================================
		
		service.deleteManager("이승기");
		service.deleteEngineer("강동원");
		//service.printManagers();
		//service.printEngineers();
		
		//=======================수정===================================
		
		service.updateManager(64000, "기획팀", 40, "이수근");
		service.updateEngineer(56000, "JAVA", 600, "이동욱");
		System.out.println("=========수정된사항=========");
		service.printManagers();
		service.printEngineers();
	}

}
