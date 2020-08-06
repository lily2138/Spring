package com.encore.test;

import java.util.ArrayList;

import com.encore.service.EmployeeService;
import com.encore.util.MyDate;
import com.encore.vo.Employee;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;

public class EmployeeServiceTest {
	public static void main(String[] args) {
		//1. Service 생성된 객체를 하나 받아온다..
		EmployeeService service = EmployeeService.getInstance();
		
		//2. method를 각각 호출..
		System.out.println("======================== 1. addEmployee ================================== ");
		Manager m1 = new Manager(111,"이수근", new MyDate(1978, 1, 1), 20000.0, "개발부", 10);
		Manager m2 =new Manager(222, "강호동", new MyDate(1975, 2, 1), 34000.0, "기획부", 20);
		Manager m3 =new Manager(333, "강하늘", new MyDate(1980, 3, 3), 20000.0, "교육부", 30);
		
		Engineer eg1 = new Engineer(444,"강제영", new MyDate(1995,3,4), 350000.0, "Java", 200.0);
		Engineer eg2 =new Engineer(555, "임채은", new MyDate(1995,7,2), 350000.0, "Java", 200.0);
		
		service.addEmployee(m1);
		service.addEmployee(m2);		
		service.addEmployee(m3);
		service.addEmployee(eg1);
		service.addEmployee(eg2);
		
		service.getEmployee();
		
		System.out.println("======================== 2. deleteEmployee ================================== ");
		service.deleteEmployee(333);
		
		service.getEmployee();
		
		System.out.println("======================== 3. updateEmployee ================================== ");
		service.updateEmployee(new Manager(222,"강호동", new MyDate(1975, 2, 1), 34000.0, "총무부", 200),222 );
		service.getEmployee();
		
		System.out.println("======================== 4. findEmployee ================================== ");
		ArrayList<Employee> retList=service.findEmployee(350000.0);
		System.out.println(retList);
	}
}







