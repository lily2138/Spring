package com.encore.vo;

import com.encore.parents.Vehicle;

public class Truck extends Vehicle{
	private int weight; //허용무게

	public Truck(int num, String model, double price, int weight) {
		super(num, model, price);
		this.weight = weight;
	}
	
	public Truck() {}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String toString() {
		return super.toString() +", "+ weight;
	}

	
	
}
