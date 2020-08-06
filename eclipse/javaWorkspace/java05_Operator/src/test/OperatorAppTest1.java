package test;
/*
 * 선언된 위치에 따라서 나눠진다
 * 			Field와				 Local 변수의 차이 
 * 
 * 1. 클래스 바로 밑, 메소드 바깥	|   메소드{안
 * 2. 기본값이 있다				|	기본값이 없다.. 반드시 초기화 하고 사용...
 * 3. Heap 메모리				|	Stack
 * 4. Member Variable		|	지역변수, Temporary V, Automatically V
 * 	   인스턴스 변수, 객체 변수		|
 *    전역변수 X
 */

public class OperatorAppTest1 {
	public static void main(String[] args) {
		//Local 변수 선언
		int i=5;
		int j=3;
		
		Operator o1 = new Operator();
		Operator o2 = new Operator();
		
		o1 = o2; //주소값이 02로 동일해진다. --> 주소값이 동일하다는 것은 같은 객체
		
		System.out.println("o1주소값: "+o1);
		System.out.println("o2주소값: "+o2);
		
		System.out.println(o1==o2);
		
		System.out.println("연산자% :: "+ i%j); //2
		System.out.println(i==j); //false
		System.out.println(i!=j); //true
		
		boolean flag = false;
		System.out.println(flag);//false
		System.out.println(!flag);//true
		
		int k = 10;
		System.out.println(k++); //1씩증가.. 10
		System.out.println(k); //11
		
		int m = 10;
		System.out.println(++m);//먼저1씩증가.. 11
		System.out.println(m); //11
		
		//Short Circuit
		System.out.println(o1.test1() || o1.test2()); //true
		System.out.println(o1.test2() && o2.test1()); //flase
		
	}

}
//class를 여러개 연달아서 만들 때는 'public'은 하나의 class에만 붙힐수있다. -->main method를 가지고 있는 class에만 쓸수있다.
//또 public 쓰인 class이름으로만 저장해야한다.
class Operator{
	public boolean test1() {
		System.out.println("test1() call......");
		return true;
	}
	
	public boolean test2() {
		System.out.println("test2() call......");
		return false;
	}
}








