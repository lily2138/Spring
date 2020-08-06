package com.encore.vo;

import com.encore.parents.Vehicle;

public class Motocycle extends Vehicle {
	private int fuel; //¿¬ºñ

	public Motocycle(int num, String model, double price, int fuel) {
		super(num, model, price);
		this.fuel = fuel;
	}

	public int getFuel() {
		return fuel;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}

	public String toString() {
		return super.toString() +", "+ fuel;
	}
	
	
}
