package com.encore.vo;

import com.encore.util.MyDate;

public class Manager extends Employee {

	private String dept;
	private int deptno;
	public Manager(String name, MyDate birthDate, double salary, String dept, int deptno) {
		super(name,birthDate,salary);
		this.dept = dept;
		this.deptno = deptno;
	}	
	
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	public String getDept() {
		return dept;
	}
	public int getDeptno() {
		return deptno;
	}

	@Override
	public String toString() {
		return super.toString() + " " + dept + " " + deptno;
	}

	
}






