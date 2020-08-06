package inheritance.service;

import inheritance.child.Engineer;
import inheritance.child.Manager;
import inheritance.child.Secretary;
import inheritance.parent.Employee;

//기능만을 모아놓은 서비스 클래스...
public class PolymorphismService {
	
	/*	
	//1. step - 각각 관리
    public void handleManager(Manager m) {}
	public void handleEngineer(Engineer eg) {}
	public void handleSecretary(Secretary se) {}
	*/
	
	
	/*
	//2. step - 오버로딩 - 깔끔하지만 아직도 갯수는 똑같다
	public void handleEmployee(Manager m) {}
	public void handleEmployee(Engineer eg) {}
	public void handleEmployee(Secretary se) {}
	*/
	
	//3. step 상속
	//인자값을 employee 배열을 넣는다(부모를 넣는거임)
	public void handleEmployee(Employee[] earr) {
		//1.만약에 earr에 들어있는 직원이 강호동이라면...부서를 총무부로 바꾸고...정보출력
		for(Employee e : earr) {
			if(e instanceof Manager) {//e라는 객체가 Manager라면
				if(e.getName().equals("강호동2")) {
					//e.changeDept("총무부")를 casting 하면 아래코드처럼 됨.
					((Manager) e).ChangeDept("총무부");
				}
			}
			if(e instanceof Engineer) {//e라는 객체가 Engineer라면

			}
			if(e instanceof Secretary) {//e라는 객체가 Secretary라면
				
			}
		}
		//2.
		
	}
	
	
}
