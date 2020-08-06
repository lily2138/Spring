package oop.encapsulation;
/*
 * 월을 먼저 입력 : 1~12사이의 값만 받고..그 이외의 값이 들어오면 필드에 할당되지 않도록 로직을 작성
 * 날짜 입력:
 * 1,3,5,7,8,10,12월 : 1~31일
 * 2월:1~28일
 * 4,6,9,11월 : 1~30일까지의 값만 허용하도록 그 외이 날짜가 입력되면 필드 힐당되지 않도록 로직을 작성
 */

public class MyDate2 {
	private int month;
	private int day;
	
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if (month>=1 && month<=12)
			this.month = month;
		else {
			//필드초기화 값을 못해서 기본값 0으로 나옴
			System.out.println("잘못입력되었습니다");
			System.exit(0);
		}
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		switch(month) {
		case 2:
			if (day>=1 && day<=28)
				this.day = day;
			else
				System.out.println("잘못입력되었습니다");
			break;
		case 4: case 6: case 9: case 11:
			if (day>=1 && day<=30)
				this.day = day;
			else
				System.out.println("잘못입력되었습니다");
			break;
		default:
			if (day>=1 && day<=31)
				this.day = day;
			else
				System.out.println("잘못입력되었습니다");
		}
	}
	
	

}
