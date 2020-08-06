package com.encore.vo;

import com.encore.parents.Vehicle;

public class Limousine extends Vehicle {
	private int personNum; //탈수있는 인원수

	public Limousine(int num, String model, double price, int personNum) {
		super(num, model, price);
		this.personNum = personNum;
	}

	public int getPersonNum() {
		return personNum;
	}

	public void setPersonNum(int personNum) {
		this.personNum = personNum;
	}
	
	public String toString() {
		return super.toString() +", "+ personNum;
	}

}
