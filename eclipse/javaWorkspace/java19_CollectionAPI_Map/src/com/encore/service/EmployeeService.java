package com.encore.service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.encore.vo.Employee;
// Manager[ ]을 ArrayList<Employee> 사용
public class EmployeeService {
	
	//추가...
	private Map<Integer, Employee> map;
	
	//싱글톤
	private static EmployeeService service = new EmployeeService();	
	private EmployeeService(){
		map = new HashMap<Integer, Employee>();
	}
	public static EmployeeService getInstance() {
		return service;
	}
	
	
	//추가
	public void getEmployee() {
		Set<Integer> set = map.keySet(); //key값 불러와서 set에 저장
		/*Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.println(key+"Employee infp::"+map.get(key));
			
		}*/
		for(Integer e : set)
			System.out.println(e+"==="+map.get(e));
		
	}	
	
	
	public void addEmployee(Employee e) {
		if(map.containsKey(e.getSsn())) {
			System.out.println(e.getName()+"님은 이미 회원이십니다.");
			return;
		}else {
			map.put(e.getSsn(),e);
			System.out.println(e.getName()+"님은 회원으로 등록되셨습니다.");
		}
		
		
	}	
	public void deleteEmployee(int ssn) {	
		Object emp = map.remove(ssn);
		if(emp==null) {//삭제할 대상이 존재하지 않는다.
			System.out.println("삭제할 대상이 존재하지 않습니다.");
			return;
		}else {
			System.out.println("삭제되었습니다");
		}
		
		//삭제메소드는 굳이 for문을 돌릴필요가 없다
		
/*		boolean find = false;
		Set<Integer> set = map.keySet();
		for(Integer key : set) {
			if(key==ssn) {
				find = true;
				map.remove(ssn);
				return;
			}
		}
		if(find==false) {	
			System.out.println("삭제할 대상이 없습니다");
		}*/
		
	}	
	public void updateEmployee(Employee e, int ssn) {
		if(map.containsKey(ssn)) {
			map.put(ssn, e); //key가 이미 있으므로 수정이 된다.
			System.out.println(e.getName()+"님의 정보가 수정되었습니다");
		}else {
			System.out.println("수정할 대상이 존재하지 않습니다.");
			return;
		}
		
		
		
/*		map.get(ssn).setBirthDate(e.getBirthDate());
		map.get(ssn).setName(e.getName());
		map.get(ssn).setSalary(e.getSalary());
		map.get(ssn).setSsn(ssn);*/
		
	}	
	
	
	public Employee findEmployee(int ssn) {
		return map.get(ssn);
	}	
	
	public ArrayList<Employee> findEmployee(double sal) {

		ArrayList<Employee> temp = new ArrayList<Employee>();
		
		Collection<Employee> col = map.values();	
		
		for(Employee e : col) {
			if(e.getSalary()==sal) {
				temp.add(e);
			}
		}
		
		//두번째 코드
/*		ArrayList<Employee> temp = new ArrayList<>();
		Set<Integer> set=map.keySet();
		Iterator<Integer> it=set.iterator();
		while(it.hasNext()) {
			int key = it.next();
			Employee e = map.get(key);
			if(e.getSalary()==sal) temp.add(e);
		}*/
		
		return temp;
	}	
	
}







