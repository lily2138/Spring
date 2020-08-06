package oop.encapsulation.test;
import java.util.Scanner;

/*
 * Scanner 객체를 통해서 월과 날짜를 입력받도록
 * 마지막에 오늘은 4월 22일입니다.
 * 이런식으로 출력
 * 
 * 만약에 잘못된 월이나 날짜가 입력된 경우에는
 * 잘못된 날짜입니다.
 */

import oop.encapsulation.MyDate2;

public class MyDateTest2 {
	public static void main(String[] args) {
		
		MyDate2 md = new MyDate2();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("월을 입력하세요");
		int month = sc.nextInt();;
		System.out.println("날짜를 입력하세요");
		int day = sc.nextInt();
		
		md.setMonth(month);
		md.setDay(day);
		
		if(md.getMonth()==0 || md.getDay()==0)
			System.out.println("잘못입력되었습니다.");
		else
			System.out.println(md.getMonth()+"월"+md.getDay()+"일 입니다");

		
	}

}
