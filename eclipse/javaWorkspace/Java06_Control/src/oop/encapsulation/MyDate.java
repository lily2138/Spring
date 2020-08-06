package oop.encapsulation;
/*
 * 월을 먼저 입력 : 1~12사이의 값만 받고..그 이외의 값이 들어오면 필드에 할당되지 않도록 로직을 작성
 * 날짜 입력:
 * 1,3,5,7,8,10,12월 : 1~31일
 * 2월:1~28일
 * 4,6,9,11월 : 1~30일까지의 값만 허용하도록 그 외이 날짜가 입력되면 필드 힐당되지 않도록 로직을 작성
 */

public class MyDate {
	private int month;
	private int day;
	
	
	public int getMonth() {
		return month;
	}
	//로컬변수와 필드의 이름이 같을 때 구분하기 위해서 필드앞에 this를 지정한다.
	public void setMonth(int month) {
		//제어문...사용
		if (month>=1 && month<=12)
			this.month = month;
		else
			System.out.println("잘못입력되었습니다");
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			if (day>=1 && day<=31)
				this.day = day;
			else
				System.out.println("잘못입력되었습니다");
		}
		else if(month == 4 || month == 6 || month == 9 || month == 11) {
			if (day>=1 && day<=30)
				this.day = day;
			else
				System.out.println("잘못입력되었습니다");
		}else if(month == 2){
			if (day>=1 && day<=28)
				this.day = day;
			else
				System.out.println("잘못입력되었습니다");
		}else
			System.out.println("잘못입력되었습니다");
	}
	
	

}
