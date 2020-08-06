package com.encore.service;

import com.encore.parents.Vehicle;
import com.encore.vo.Motocycle;
import com.encore.vo.Truck;

public class VehicleManagerImpl implements VehicleManager {
	
	private int numberOfVehicles=0;//vehicles ÀÎµ¦½º
	//vehiclesµéÀÇ ¹è¿­ ¼±¾ð
	private Vehicle[ ] vehicles = new Vehicle[100];

	//½Ì±ÛÅæ
	public VehicleManagerImpl() {}
	private static VehicleManagerImpl manager = new VehicleManagerImpl();
	public static VehicleManagerImpl getInstance() {
		return manager;
	}
	
	
	@Override
	public void add(Vehicle v) {
		vehicles[numberOfVehicles++] = v;
	}

	@Override
	public Vehicle[] getAllVehicle() {
		Vehicle[] allVehicles = new Vehicle[numberOfVehicles];
		for(int i=0; i<numberOfVehicles; i++) {
			allVehicles[i] = vehicles[i];
		}
		return allVehicles;
	}
	

	@Override
	public void updateVehicle(Vehicle vehicle) {
		for(int i=0; i<numberOfVehicles; i++) {
			if(vehicles[i].getNum()==vehicle.getNum()) {
				vehicles[i].setModel(vehicle.getModel());
				vehicles[i].setPrice(vehicle.getPrice());
			}
		}
	}

	@Override
	public void deleteVehicle(int num) {
		for(int i=0; i<numberOfVehicles; i++) {
			if(vehicles[i].getNum()==num) {
				for(int j = i; j<numberOfVehicles; j++) {
					vehicles[j] = vehicles[j+1];
				}
				vehicles[numberOfVehicles] = null;
				numberOfVehicles--;
				
			}
		}

	}

	@Override
	public double getSumPrice() {
		double total = 0;
		for(Vehicle v : vehicles) {
			if(v==null) {
				continue;
			}else {
				total += v.getPrice();
			}
			
		}
		return total;
	}

	@Override
	public Vehicle getExpensiveVehicle() {
		Vehicle ExV = null;
		double Ex = 0;
		for(int i=0; i<numberOfVehicles; i++){
			if(vehicles[i].getPrice()>Ex) {
				ExV = vehicles[i];
				Ex=vehicles[i].getPrice();
			}
		}
		
		return ExV;
	}

	@Override
	public Motocycle[] getMotocycle() {
		Motocycle[] motocycles = new Motocycle[numberOfVehicles];
		int temp=0;
		for(int i=0; i<numberOfVehicles; i++) {
			if(vehicles[i] instanceof Motocycle) {
				motocycles[temp++] = (Motocycle) vehicles[i];
			}else {
				continue;
			}
		}
		Motocycle[] realMoto = new Motocycle[temp];
		for(int i=0; i<temp; i++) {
			realMoto[i] = motocycles[i];
		}
		
		return realMoto;
	}

	@Override
	public int getSize() {
		return numberOfVehicles;
	}
	
	

}
