package oop.constructor.test;
/*
 * ShirtTest
 * 에서는 서로다른 셔츠 객체를 3개 만들었다.
 * 그래서 서로다른 주소값을 나타내지만....
 * 객체가 생성될때 생성자 안에 인자값을 넣어주지 않았기 때문에
 * 명시적인 값을 가지지 않는 디폴트 객체로 생성되었다.
 * ::
 * 생성자를 통해서 값을 입력 +
 * 객체가 생성됨과 동시에 값을 가지도록 로직을 수정...
 */

import oop.constructor.Shirt;

public class ShirtTest {
	public static void main(String[] args) {
		/*Shirt roundT = new Shirt();
		Shirt jumpa = new Shirt();
		Shirt banpalT = new Shirt();*/
		
		//메모리에 올라가서 우리가 사용할수 있는 객체...Instance...명시적값으로 할당
		Shirt roundT = new Shirt("유니클로", true, 'B');
		Shirt jumpa = new Shirt("베네통", true, 'B');
		Shirt banpalT = new Shirt("aaa", false, 'w');
		
		//서로 다른 셔츠 객체가 만들어졌다면 Heap 영역에 객체 3개가 로드되어있을 것이고
		//각각의 위치는 서로 다르기 때문에 참조변수의 주소값들은 서로 다르게 나와야한다.
		System.out.println(roundT);
		System.out.println(jumpa);
		System.out.println(banpalT);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(roundT.getDetails());
		System.out.println(jumpa.getDetails());
		System.out.println(banpalT.getDetails());
	}

}
