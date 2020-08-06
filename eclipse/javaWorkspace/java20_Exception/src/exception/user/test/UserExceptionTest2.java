package exception.user.test;

import java.util.Scanner;

class UnderAgeException extends Exception{
	UnderAgeException(){
		this("This is UnderAgeException...");
	}
	UnderAgeException(String message){
		super(message);
		
	}
}


class AdultMovie{
	public void entrance(int age) throws UnderAgeException{
	/*
	 * 입력된 나이가 19세 미만이면 성인영화 관람불가시키고
	 * 19이상이면 입장을 허용하도록 문장을 제어합니다...
	 * 이때
	 * 사용자 정의 예외 클래스...UnderAgeExcetion으로 합니다.	
	 */
		if(age<19) {
			throw new UnderAgeException("19세 미만은 입장이 불가능합니다!!!");
		}else {
			System.out.println("입장을 허용합니다");
		}
	
	}
}

public class UserExceptionTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("당신의 나이를 입력>>>");
		int age = sc.nextInt();
		
		
		AdultMovie am = new AdultMovie();
		System.out.println("성인영화관 입장여부를 판단합니다");
		
		try {
			am.entrance(age);
		} catch (UnderAgeException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
