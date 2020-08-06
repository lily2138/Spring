package com.encore.service;

import com.encore.vo.Engineer;
import com.encore.vo.Manager;

public class EmployeeService {
	Manager[] ms;
	int midx; //만들어진 배열의 사이즈 --->밑에 size는 임의의 사이즈를받는것. 
	
	Engineer[] egs;
	int egidx; //만들어진 배열의 사이즈 
	
	//사이즈 배열 생성
	public EmployeeService(int size) {
		ms = new Manager[size];
		egs = new Engineer[size];
	}
	
	//String name, String addr, ... 5개 인자 넣는거 아님... 객체를 넣는거다)
	public void addManager(Manager m) {		
		ms[midx++] = m;
	}
	
	public void addEngineer(Engineer eg) {
		egs[egidx++] = eg;
	}
	
	public void deleteManager(String name) {	//	
		for(int i=0; i<midx; i++) {
			if(ms[i].getName().equals(name)) { //삭제할 이름과 같으면
				for(int j=i; j<midx; j++) {  //한칸씩 앞으로 덮어씌우기
					ms[j] = ms[j+1];
				}
				ms[midx] = null; //마지막 칸은 null로 바꾼다.
				midx--; //정보가 하나 지워지면서 앞으로 덮어씌워졌고, 마지막칸은 null이므로 midx는 숫자하나 준다.
			}
		}
	}
	
	public void deleteEngineer(String name) {	//
		for(int i=0; i<egidx; i++) {
			if(egs[i].getName().equals(name)) { 
				for(int j=i; j<egidx; j++) {  
					egs[j] = egs[j+1];
				}
				egs[egidx] = null; 
				egidx--; 
			}
		}
	}
	
	public void updateManager(double salary, String dept, int deptNo, String name) {
		for(Manager m :ms) {
			if(m==null)
				continue;
			if(m.getName().equals(name)) {
				m.setSalary(salary);
				m.setDept(dept);
				m.setDeptNo(deptNo);
			}
		}
	}
	
	public void updateEngineer(double salary, String tech, int bonus, String name) {
		for(Engineer eg :egs) {
			if(eg==null)
				continue;
			if(eg.getName().equals(name)) {
				eg.setSalary(salary);
				eg.setTech(tech);
				eg.setBonus(bonus);
			}
		}
	}
	
	//Method Overloading
	/*
	 * 하는 일은 똑같은데...처리하는 데이터를 달리할 때 쓰는 기법
	 * 메소드의 통일감을 강조하면서도 서로 다른 데이터를 처리할 수 있게끔 해준다.
	 * --->메소드 이름은 똑같은데 받는 인자값은 다르다.
	 */
	public Manager findManager(String name) {
		Manager manager = null;
		for(Manager m:ms) {
			if(m.getName().equals(name)) {
				manager = m;
			}
		}
		return manager;
	}
	
	public Manager[] findManager(int deptno) {
		//배열이 만들어져 있으므려 size가 아닌 ms.length를 넣는다
		Manager [] mans = new Manager[ms.length];
		int idx=0;
		for(Manager m:ms) {
			if(m.getDeptNo()==deptno) {
				mans[idx++] = m;
			}
		}
		return mans;
	}
	
	public Engineer findEngineer(String name) {
		Engineer engineer = null;
		for(Engineer e:egs) {
			if(e.getName().equals(name)) {
				engineer = e;
			}
		}
		return engineer;
	}
	
	/////////////////////////////////////////////////////
	//확인용 추가
	public void printManagers() {
		for(Manager m :ms) {
			if(m!=null)
				System.out.println(m.getDetails());
		}
	}
	
	public void printEngineers() {
		for(Engineer e :egs) {
			if(e!=null)
				System.out.println(e.getDetails());
		}
	}

}
