package exception.runtime.test;
/*
 * NullPointerException::
 * 객체 생성하지 않고 객체의 멤버에 접근하려고 할 때 발생하는 예외....
 * 객체 생성하지 않고 == null
 * 
 * catch는 여러번 할 수 있다...
 * 하지만 그 중에서 단 한번만 수행된다....
 * 
 * finally
 * ::
 * 예외와 상관없이 무조건 수행되어져야 하는 코드가 있다면...
 * 이 안에다 집어넣어야 한다.
 */
public class RuntimeExceptionTest2 {

	public static void main(String[] args) {
		System.out.println("==========NullPointerException=========");
		String str1 = "Encore"; //Literal Pool
		String str = new String("Encore"); //Heap
		System.out.println(str.toString());

		str=null; 
		try {
			System.out.println("str의 데이터 값 ::"+str);
			System.out.println("str 문자열 길이 ::" +str.length());
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("잡았다...1");
		}catch(NullPointerException e ) {
			System.out.println("잡았다...2");
		}catch(Exception e ) {
			System.out.println("잡았다...3");
		}finally {
			System.out.println("Always Print...");
		}
	}

}
/*
1. 예외 발생코드 작성... + 예외가 발생 안함.
	try + finally
2. 예외 발생코드 작성... + 예외 발생 + 그 에외를 잘 잡음
	catch + finally
3. 예외 발생코드 작성... + 예외 발생 + 그 에외를 잘 못 잡음
	finally
	
	finally에 주로 넣는 코드
	--->자원을 반납하는 코드....close()

	finally가 동작하지 않는 경우가 있다.
	1) finally 안에서 또다른 예외가 발생할 때는 동작이 안된다 ---> 그럼 또 이 안을 try catch로 감싸야한다.
	
	
	
 */
