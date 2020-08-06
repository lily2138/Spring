package fly.child;

import fly.Flyer;
/*
 * stop_bullet() 추가....마무리.....
 */
public class SuperMan implements Flyer {
	@Override
	public void fly() {
		System.out.println("슈퍼맨이 난다");
		System.out.println("시속 "+SIZE + "km...");
	}

	@Override
	public void land() {
		System.out.println("슈퍼맨이 착륙한다");
		
	}

	@Override
	public void take_off() {
		System.out.println("슈퍼맨이 이륙한다");
		
	}

	public String stop_bullet() {
		return "총을 막다";
	}
}
