package oop.greet.test;

//ctrl+shift+O(영문자) --> import할 것들 다 나옴.
import java.util.Scanner;

import oop.greet.EncoreGreet;
//package는 inner 개념이 아님. 다른개념. 그래서 import 써줘야함.


//실행클래스, test class
public class EncoreGreetTest {

	public static void main(String[] args) {

		//객체생성 --> EncoreGreet 구성요소를 메모리에 올린다 
		EncoreGreet en = new EncoreGreet();
		
		//지금처럼 소스코드에 값을 직접 하드코드 하지 않고 실행시에 키보드로 입력받은 값을 처리하도록 Scanner 사용
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요");
		String scName = sc.nextLine();
		en.name = scName;
		
		System.out.println("메세지를 입력하세요");
		String scMsg = sc.nextLine();
		en.message = scMsg;
		
		//필드를 쓰는 것은 할당, 메소드를 쓰는 것은 호출
//		en.name="Juliet";
//		en.message="Nice Day~~~!!!";
		en.sayHello();
		
	}

}
