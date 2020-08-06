package com.encore.vo;

import com.encore.util.MyDate;

public class Manager {
	private String name;
	private MyDate birthDate;
	private double salary;
	private String dept;
	private int deptNo;
	
	public Manager(String name, MyDate birthDate, double salary, String dept, int deptNo) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
		this.dept = dept;
		this.deptNo = deptNo;
	}

	public String getName() {
		return name;
	}
	
	public MyDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(MyDate birthDate) {
		this.birthDate = birthDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDetails() {
		//아래의 코드를 실행하면 birthDate부분이 주소값으로 나온다.
		//birthDate.toString()과 같다--->toString 이 MyDate에 없는데 실행은 잘된다. ---> Object클래스에서 자동적으로 물려받음
		//======> 모든 클래스의 부모클래스는 Object이다. 
		return name +","+ birthDate+","+salary +","+ dept +","+ deptNo;
		// name +","+ birthDate.getBirthDate+","+salary +","+ dept +","+ deptNo;
	}
	
	
}
