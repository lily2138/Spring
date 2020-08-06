package array.test2;

import java.util.Scanner;

public class ArrayPersonTypeTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("사람의 수를 입력하세요");
		int num = sc.nextInt(); //배열의 사이즈
		
		int[] people = new int[num]; //배열 만들기
		
		//배열 초기화
		System.out.println("사람의 성향을 입력하세요");
		for(int i=0; i<people.length; i++) {
			people[i] = sc.nextInt();
		}
		
		//타입의 배열을 만들고 사람의 타입이 그 배열일 때 +1씩.
		int[] types = new int[5];
		for(int i=0; i<people.length; i++) {
			switch(people[i]) {
			case 1:
				types[0]++;
				break;
			case 2:
				types[1]++;
				break;
			case 3:
				types[2]++;
				break;
			case 4:
				types[3]++;
				break;
			case 5:
				types[4]++;
				break;
			}
		}
		
		//types 에서 제일 큰 값 찾기
		int max = 0;
		for(int i=0; i<types.length; i++) {
			if(max<types[i])
				max = types[i];
		}
		
		//그 큰 값과 일치하는 인댁스값 찾기. 찾은 후 +1
		int answer = 0;
		for(int i=0; i<types.length; i++) {
			if (max==types[i])
				answer=i+1;
		}
		System.out.println("정답::" +answer);
	}

}


/*

6
1 4 4 4 5 3

*/