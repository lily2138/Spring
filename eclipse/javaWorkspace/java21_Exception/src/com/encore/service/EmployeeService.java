package com.encore.service;
import java.util.ArrayList;

import com.encore.exception.DuplicateNameException;
import com.encore.exception.RecordNotFoundException;
import com.encore.vo.Employee;
//Manager[]을 ArrayList<Employee> 사용
public class EmployeeService {
	
	//추가...
	private ArrayList<Employee> list;
	
	//싱글톤...
	private static EmployeeService service = new EmployeeService();
	private EmployeeService(){
		list = new ArrayList<>();
	}
	public static EmployeeService getInstance() {
		return service;
	}
	
	
	//
	public void addEmployee(Employee e) throws DuplicateNameException { //DuplicateNameException 발생
		boolean find = false;
		for(Employee emp:list) {
			if(e.getName().equals(emp.getName())) { //이미 그런사람이 있다면.
				find = true;
				throw new DuplicateNameException(emp.getName()+"님은 이미 회원이십니다.");
			}
		}
		if(find==false) {	//추가하고자 하는 사람ㅇ느 기존의 리스트에는 없다
			list.add(e);
			System.out.println(e.getName()+"님은 회원으로 등록되셨습니다.");

		}
	}

	public void deleteEmployee(String name) throws RecordNotFoundException { //RecordNotFoundException 발생
		boolean find = false;
		for(Employee e:list) {
			if(e.getName().equals(name)) {
				find = true;
				System.out.println(e.getName()+"님을 삭제합니다"); //삭제하기 전에 써야한다. 삭제하고 쓰면 이름을 못찾는다
				list.remove(e);
				break;
			}
		}
		if(find==false)
			throw new RecordNotFoundException("삭제할대상이 없습니다");
		
		
	}
	
	public void updateEmployee(Employee e) throws RecordNotFoundException { //RecordNotFoundException 발생

		boolean find = false;
		for(int i=0 ; i<list.size(); i++) {
			if(list.get(i).getName().equals(e.getName())) {
				find = true;
				System.out.println(e.getName()+"님을 수정합니다");
				list.set(i, e);
				break;
			}
		}
		if(find==false)
			throw new RecordNotFoundException("수정할대상이 없습니다");
	}
	
	
	public ArrayList<Employee> findEmployee(double salary) {
		ArrayList<Employee> findList= new ArrayList<>();
		for(Employee e:list) {
			if(e.getSalary()==salary) {
				findList.add(e);
			}
		}
		return findList;
	}
	
	
	//추가
	public void getEmployee() {
		for(Employee e : list)
			System.out.println(e);
	}
}







