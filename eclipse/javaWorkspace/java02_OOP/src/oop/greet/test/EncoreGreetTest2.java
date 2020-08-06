package oop.greet.test;
/*
 * EncoreGreetTest1에서는 필드에 갑슬 직접적으로 입력했다.
 * 그런데 필드의 갯수가 늘어난다면?
 * 필드가 20개를 초과한다면?
 * 이럴경우 일일이 필드에 값을 입력하는 방식은 너무 비효율적이다.
 * 
 * 해결책
 * :
 * 모든 필드의 값을 한번에 받아서 할당해주는 기능을 가진 함수를 새롭게 정의
 * Test2에서는 그 함수를 호출하는 방식을 사용하자
 */

//ctrl+shift+O(영문자) --> import할 것들 다 나옴.
import java.util.Scanner;

import oop.greet.EncoreGreet;
//package는 inner 개념이 아님. 다른개념. 그래서 import 써줘야함.


//실행클래스, test class
public class EncoreGreetTest2 {

	public static void main(String[] args) {
		//객체생성 --> EncoreGreet 구성요소를 메모리에 올린다 
		EncoreGreet en = new EncoreGreet();
		//field에 값 할당...
		en.setEncore("James", "Hello~~~", 4, "Java");  //Method Calling
		
		System.out.println(en.getEncore()); //Method Calling
		
		en.sayHello();
		
	}

}
