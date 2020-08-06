package fly.test;

import fly.Flyer;
import fly.child.AirPlane;
import fly.child.Bird;
import fly.child.SuperMan;

public class FlyerTest {

	public static void main(String[] args) {
//		Flyer f1 = new Flyer();
//		Flyer은 단지 타입이다. 객체 생성할 수 없다
//		다형성
		//추상클래스면 절대 객체생성 불가하다. 인터페이스도 마찬가지. 
		//interface는 완벽히 미완성이고 abstract class는 부분적인 미완성이다.
		Flyer bird = new Bird();
		Flyer ap = new AirPlane();
		Flyer sp = new SuperMan();
		
		bird.fly(); //Virtual Method Invocation원리... 오버라이딩 된 메소드에서만 나타난다.
//		bird.layEggs(); ---> type이 Flyer이므로 이건 안된다. flyer에는 알을 낳는 메소드가 없기 때문이다.
		String ret = ((Bird) bird).layEggs(); //--->그래서 bird에서 casting 해야한다. 
		System.out.println(ret);
		
	}

}


