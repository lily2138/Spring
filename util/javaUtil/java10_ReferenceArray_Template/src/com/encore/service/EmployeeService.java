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
	 * �ϴ����� �Ȱ�����...ó���ϴ� ����Ÿ�� �޸��Ҷ� ���� ���
	 * �޼ҵ��� ���ϰ��� �����ϸ鼭�� ���δٸ� ����Ÿ�� ó���Ҽ� �ְԲ� ���ش�.
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
	//�߰�
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







