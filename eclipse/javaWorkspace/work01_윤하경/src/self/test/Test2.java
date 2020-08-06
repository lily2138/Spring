package self.test;
/*
 * 1을 가위, 2를 주먹, 3을 보 라고 가정했을 때 컴퓨터와
사용자가 함께하는 가위바위보 게임을 작성하여 보자.
<출력 예>
>>가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고
르세요.
1. 5판 3승
2. 3판 2승
3. 1판 1승
번호를 입력하세요. 2
가위바위보 중 하나 입력: 가위
졌습니다!!!
가위바위보 중 하나 입력: 가위
졌습니다!!!
### 컴퓨터 승!!!
 */

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 1판 1승"+"\n"+ "2. 3판 2승"+"\n"+"3. 5판 3승");
		Scanner sc = new Scanner(System.in);
		System.out.println("번호를 입력하세요");
		int roleNum = sc.nextInt();
		
		int comCnt = 0; //컴퓨터가 이긴수
		int perCnt = 0; //사람이 이긴수
		
		//컴퓨터와 사람의 이긴수가 둘다 사용자가 정한 수에 미치지 못하면 계속 반복문 수행
		while(comCnt!=roleNum && perCnt!=roleNum) {
			
			System.out.println("가위바위보 중 입력하세요");
			Scanner scan = new Scanner(System.in);  		//위에했는데 여기서 왜 또 scanner를 해줘야하는지 모르겠다... scanner를 안해주면 입력이안된다...
			String per = scan.nextLine();	//사람의 가위바위보중 선택 입력받기
			System.out.println(per);
			int com = (int)(Math.random()*3)+1; //컴퓨터의 랜덤 수 추출
//			System.out.println(com);   //컴퓨터가 뭐내는지 확인용
			
			switch(com) {
			case 1:
				if(per.equals("가위")) {
					System.out.println("비겼습니다");
				}else if(per.equals("바위")) {
					System.out.println("이겼습니다");
					perCnt++;
				}else if(per.equals("보")){
					System.out.println("졌습니다");
					comCnt++;
				}else
					System.out.println("잘못입력하였습니다");
				break;
			case 2:
				if(per.equals("가위")) {
					System.out.println("졌습니다");
					comCnt++;
				}else if(per.equals("바위")) {
					System.out.println("비겼습니다");
				}else if(per.equals("보")){
					System.out.println("이겼습니다");
					perCnt++;
				}else
					System.out.println("잘못입력하였습니다");
				break;
			case 3:
				if(per.equals("가위")) {
					System.out.println("이겼습니다");
					perCnt++;
				}else if(per.equals("바위")) {
					System.out.println("졌습니다");
					comCnt++;
				}else if(per.equals("보")){
					System.out.println("비겼습니다");
				}else
					System.out.println("잘못입력하였습니다");
				break;
			}
		}
		
		//결과 값 출력
		String result = comCnt>perCnt ? "컴퓨터가 이겼습니다":"당신이 이겼습니다";
		System.out.println(result);
		
		

		

	}

}
