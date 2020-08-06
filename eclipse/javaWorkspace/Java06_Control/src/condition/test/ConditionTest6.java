package condition.test;
/*
 * formating 과 삼항연산자
 */

import java.util.Random;

public class ConditionTest6 {
	public static void main(String[] args) {
		String result = "";
		Random r = new Random(); //유용하다
		System.out.println("====큰수? 혹은 작은수?");
		
		//0~99사이의 임의의 정수
		int num1 = r.nextInt(100);
		System.out.println(num1);
		
		if (num1>50) result="큰수";
		else result = "작은수";
		
		System.out.println(num1 + " 은" + result+ " 입니다.");
		System.out.printf("%d는(은) %s이다 %n", num1, result);
		
		int num2 = r.nextInt(10)+1; //1부터 10까지
		if(num2 % 2==0) result = "짝수";
		else result = "홀수";
		System.out.printf("%d는(은) %s이다 %n",num2,result);
		
		System.out.println("======삼항연산자======");
		result = (num2%2==0) ? "짝수" : "홀수";
		System.out.printf("%d는(은) %s이다 %n",num2,result);
				
			
				
	}

}
