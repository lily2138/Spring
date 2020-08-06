package com.encore.test;

import java.util.ArrayList;

import com.encore.exception.DuplicateNameException;
import com.encore.exception.RecordNotFoundException;
import com.encore.service.EmployeeService;
import com.encore.util.MyDate;
import com.encore.vo.Employee;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;

public class EmployeeServiceTest {
	public static void main(String[] args) {
		//1. Service 객체를 생성이 아니라 생성된 객체를 하나 받아온다(싱글톤)
		EmployeeService service = EmployeeService.getInstance();
		
		//2. method를 각각 호출..
		System.out.println("============ 1. add ============ ");
		Manager m1 = new Manager("이수근", new MyDate(1978, 1, 1), 10000.0, "개발부", 10); 
		Manager m2 = new Manager("강호동", new MyDate(1975, 2, 1), 34000.0, "기획부", 20);
		Manager m3 = new Manager("강하늘", new MyDate(1980, 3, 3), 40000.0, "교육부", 30);
		
		Engineer eg1 = new Engineer("강제영", new MyDate(1995,3,4), 360000.0, "Java", 200.0);
		Engineer eg2 = new Engineer("임채은", new MyDate(1995,7,2), 360000.0, "Java", 200.0);
		
		
		try {
			service.addEmployee(m1);
		} catch (DuplicateNameException e) {
			System.out.println(e.getMessage());
		}
		try {
			service.addEmployee(m2);
		} catch (DuplicateNameException e) {
			System.out.println(e.getMessage());
		}
		try {
			service.addEmployee(m3);
		} catch (DuplicateNameException e) {
			System.out.println(e.getMessage());
		}
		try {
			service.addEmployee(eg1);
		} catch (DuplicateNameException e) {
			System.out.println(e.getMessage());
		}
		try {
			service.addEmployee(eg2);
		} catch (DuplicateNameException e) {
			System.out.println(e.getMessage());
		}
		
		service.getEmployee();
		
		System.out.println("============ 2. delete ============ ");
		try {
			service.deleteEmployee("강하늘");
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		service.getEmployee();
		
		System.out.println("============ 3. update ============ ");
		try {
			service.updateEmployee(new Manager("강호동", new MyDate(1975, 2, 1), 34000.0, "총무부", 100));
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		service.getEmployee();
		
		System.out.println("======================== 4. find ================================== ");
		ArrayList<Employee> retList=service.findEmployee(360000.0);
		System.out.println(retList);
	}
}







