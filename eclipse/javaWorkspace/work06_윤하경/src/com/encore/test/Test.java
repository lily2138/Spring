package com.encore.test;


import com.encore.parents.Vehicle;
import com.encore.service.VehicleManagerImpl;
import com.encore.vo.Limousine;
import com.encore.vo.Motocycle;
import com.encore.vo.Truck;

public class Test {
	
	public static void printVehicles(Vehicle[] vehicles) {
		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle.toString());
		}
	}

	public static void main(String[] args) {
		VehicleManagerImpl manager = VehicleManagerImpl.getInstance();
		
		System.out.println("========= 객체생성=========");
		Vehicle v1 = new Truck(1,"T1",1000000,5);
		Vehicle v2 = new Truck(2,"T2",4000000,9);
		Vehicle v3 = new Truck(3,"T3",96000000,11);
		
		Vehicle v4 = new Motocycle(4,"M1",4000000,9);
		Vehicle v5 = new Motocycle(5,"M2",96000000,11);
		Vehicle v6 = new Motocycle(6,"M1",400000000,9);

		Vehicle v7 = new Limousine(7,"L1",1400000,4);
		Vehicle v8 = new Limousine(8,"L2",60000,6);
		
		Vehicle[] veh= {v1,v2,v3,v4,v5,v6,v7,v8};
		
		
		System.out.println("=========printVehicles========");
		printVehicles(veh);
		
		
		System.out.println("=========추가========");
		for(Vehicle v : veh) {
			manager.add(v);
		}
		
		
		System.out.println("=========보기 vehicle=========");
		Vehicle[] allVehicles = manager.getAllVehicle();
		printVehicles(allVehicles);
		
		System.out.println("=========삭제 vehicle=========");
		manager.deleteVehicle(4);
		printVehicles(manager.getAllVehicle());
		
		System.out.println("=========수정 vehicle=========");
		manager.updateVehicle(new Truck(1,"T1",60000,5));
		printVehicles(manager.getAllVehicle());

		
		System.out.println("=========가장비싼 vehicle=========");
		
		System.out.println(manager.getExpensiveVehicle().toString());

		
		System.out.println("=========오토바이 vehicle=========");
		Motocycle[] motocycles = manager.getMotocycle();
		printVehicles(motocycles);
		
		System.out.println("=========가격합산 vehicle=========");
		System.out.println(manager.getSumPrice());
	}

}
