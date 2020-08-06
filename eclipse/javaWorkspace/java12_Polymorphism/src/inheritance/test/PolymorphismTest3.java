package inheritance.test;

import inheritance.child.Engineer;
import inheritance.child.Manager;
import inheritance.child.Secretary;
import inheritance.parent.Employee;
import inheritance.service.EmployeeService;
import inheritance.service.PolymorphismService;
import inheritance.util.MyDate;

public class PolymorphismTest3 {
	public static void main(String[] args) {
	
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("======Polymorphism 방식으로 객체 생성------");
		Employee e2 = new Manager("강호동2", 14000.0, new MyDate(1999, 4, 11),"체육부");
		Employee e3= new Engineer("박나래2", 56000.0, new MyDate(1981,9,19),"C", 400);
		Employee e4= new Secretary("박보검2", 46000.0, new MyDate(1981,9,19),"강호동");
		Employee e5 = new Manager("강호동3", 14000.0, new MyDate(1999, 4, 11),"체육부");

		//Heterogeneous Collection
		Employee[] emps = {e2,e3,e4,e5};
	
		EmployeeService service = new EmployeeService();
		
		System.out.println(service.findEmployeeByName(emps, "박보검2"));
		System.out.println(service.getAnnualSalary(e4));
	}
}
