package inheritance.test;

import inheritance.child.Engineer;
import inheritance.child.Manager;
import inheritance.child.Secretary;
import inheritance.parent.Employee;
import inheritance.service.PolymorphismService;
import inheritance.util.MyDate;

public class PolymorphismTest2 {
	public static void main(String[] args) {
	
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("======Polymorphism 방식으로 객체 생성------");
		Employee e2 = new Manager("강호동2", 14000.0, new MyDate(1999, 4, 11),"체육부");
		Employee e3= new Engineer("박나래2", 56000.0, new MyDate(1981,9,19),"C", 400);
		Employee e4= new Secretary("박보검2", 46000.0, new MyDate(1981,9,19),"강호동");
		Employee e5 = new Manager("강호동3", 14000.0, new MyDate(1999, 4, 11),"체육부");

		//Heterogeneous Collection
		Employee[] emps = {e2,e3,e4,e5};
		
		//서비스 실행
		PolymorphismService service = new PolymorphismService();
		service.handleEmployee(emps);
		
		//만약에 employee로 안했으면 배열 각각 돌아야한다.--->이렇게 하면 한꺼번에 관리할 수 있다.
		for(Employee e : emps) {
			System.out.println(e.getDetails());
		}
	}

}
