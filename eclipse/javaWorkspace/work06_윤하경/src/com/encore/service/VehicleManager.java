package com.encore.service;

import com.encore.parents.Vehicle;
import com.encore.vo.Motocycle;

public interface VehicleManager {
	
	void add(Vehicle v);
	Vehicle[] getAllVehicle();
	void updateVehicle(Vehicle v);
	void deleteVehicle(int num);
	
	double getSumPrice();
	Vehicle getExpensiveVehicle();
	
	Motocycle[] getMotocycle();
	
	int getSize();

}
