package fly.child;

import fly.Flyer;

public class AirPlane implements Flyer{

	@Override
	public void fly() {
		System.out.println("비행기가 난다");
		
	}

	@Override
	public void land() {
		System.out.println("비행기가 착륙한다");
		
	}

	@Override
	public void take_off() {
		System.out.println("비행기가 이륙한다");
		
	}
	
}
