package com.encore.service;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;

public class EmployeeService {
	Manager[ ] ms;
	int midx;
	
	Engineer[ ] egs;
	int egidx;	

	public EmployeeService(int size){
		ms = new Manager[size];
		egs = new Engineer[size];
	}
	public void addManager(Manager m) {	
		ms[midx++] = m;
	}
	public void addEngineer(Engineer eg) {	
		egs[egidx++] = eg;
	}
	public void deleteManager(String name) {	
		//
	}
	public void deleteEngineer(String name) {
		//
	}
	public void updateManager(double salary, String dept,int deptno,  String name) {	
		//
	}
	public void updateEngineer(Engineer eg) {	
		//
	}	
	//Method Overloading
	/*
	 * 하는일은 똑같은데...처리하는 데이타를 달리할때 쓰는 기법
	 * 메소드의 통일감을 강조하면서도 서로다른 데이타를 처리할수 있게끔 해준다.
	 */
	public Manager findManager(String name) {
		Manager m = null;
		//
		return m;
	}
	public Manager[ ] findManager(int deptno) {
		Manager[ ] temp = new Manager[ms.length];
		
		return temp;
	}
	public Engineer findEngineer(String name) {
		Engineer eg = null;
		
		return eg;
	}	
	//추가
	public void printManagers() {		
		for(Manager m : ms) {
			if(m!=null)
			System.out.println(m.getDetails());
		}
	}
	public void printEngineers() {
		for(Engineer e : egs) {
			if(e!=null)
			System.out.println(e.getDetails());
		}
	}
}







