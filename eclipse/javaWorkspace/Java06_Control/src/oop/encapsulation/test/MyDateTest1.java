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
import oop.encapsulation.MyDate;

public class MyDateTest1 {
	public static void main(String[] args) {
		
		MyDate md = new MyDate();
		Scanner sc = new Scanner(System.in);
		System.out.println("월을 입력하세요");
		md.setMonth(sc.nextInt());
		System.out.println("날짜를 입력하세요");
		md.setDay(sc.nextInt());
		
		System.out.println(md.getMonth()+"월"+md.getDay()+"일 입니다");

		
	}

}
