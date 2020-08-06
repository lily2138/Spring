package condition.test;

import java.util.Scanner;
/*
 * 성적과 대상자의 이름을 실행시에 입력받아서 로직을 작성...
 */
public class SwitchGradeTest3 {

	public static void main(String[] args) {
		//성적에 따른 Grade를 제어하는 문장을 작성
		
		Scanner sc = new Scanner(System.in);
		System.out.println("당신의 이름을 입력하세요...");
		String name = sc.nextLine();
		System.out.println("당신의 등급을 입력하세요...");
		String grade = sc.nextLine();

		
		switch(grade) {
			case "A":
				System.out.println(name + ", 90이상 100이하 점수입니다");
				break;
			case "B":
				System.out.println(name + ", 80이상 90미만 점수입니다");
				break;
			case "C":
				System.out.println(name + ", 70이상 80미만 점수입니다");
				break;
			default:
				System.out.println(name + "try again!!!");
		}
		
	}
}
