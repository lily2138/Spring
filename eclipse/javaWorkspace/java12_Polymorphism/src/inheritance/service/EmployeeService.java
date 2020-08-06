package inheritance.service;

import inheritance.child.Engineer;
import inheritance.parent.Employee;

public class EmployeeService {
	
	//고용인한명 출력
	public void printInfo(Employee e) {
		System.out.println(e.getDetails());
	}
	
	//고용인 여러명 출력
	public void printAllInfo(Employee[] ea) {
		for(Employee e:ea) {
			System.out.println(e.getDetails());
		}
	}
	
	//return 타입이 있을때는 첨에 선언부터함. 배열도 마찬가지. 
	public Employee findEmployeeByName(Employee[] ea, String name) {
		Employee emp = null;
		for(Employee e:ea) {
			if(e.getName().equals(name)) {
				emp = e;
				break;
			}
		}
		return emp;
	}
	
	//return 타입이 있을때는 첨에 선언부터함.
	public int getAnnualSalary(Employee e) {
		int annualSalary = 0;
		annualSalary = (int)e.getSalary()*12;
		if(e instanceof Engineer) {
			//반드시 engineer를 casting 해줘야한다. bonus는 engineer에만 있기 때문에 그냥 employee 타입으로 하면 못찾는다. 가려진다. 
			//engineer 타입에서 찾겠다고 casting 해줘야한다.
			Engineer eg = (Engineer)e;
			annualSalary=(int)(eg.getSalary()*12 + eg.getBonus());
		}
		return annualSalary;
	}
	
	public int getTotalCoast(Employee[] ea) {
		int total=0;
		for(Employee e:ea) {
			//위에함수를 활용한다.
			total += getAnnualSalary(e);
		}
		return total;
	}
	
	
	
	
	
	
	
	
}
