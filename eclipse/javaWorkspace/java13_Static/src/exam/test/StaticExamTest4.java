package exam.test;
/*
 * 
 * final 키워드 + static 키워드
 * final :: 내가 마지막이야 ~~~ 
 * final + 변수 : 내가 마지막 변수야 ~~~ ---> 상수를 의미 static final int COUNTER =1;
 * final + 클래스 : 내가 마지막 클래스야 ~~~ ---> 상속금지
 * final + 메소드 : 내가 마지막 메소드야~~~ ---> 오버라이딩 금지
 */

class A{
	public final static int BASE_SALARY = 300;
	public final String test() {
		return "Overriding 금지";
	}
}

final class B{ //상속금지
	
}

//class B가 final이기 때문에 상속못함.
/*class C extends B{
	
}
*/

class D extends A{
/*	public final String test() {
		return "Overriding 금지";
	}*/
}


public class StaticExamTest4 {
	
	public static void main(String[] args) {
		
		
	}


}
