import java.util.Scanner;

public class GameTest2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int GameSet=0;
		int WinSet=0;
		
		int ComCnt=0;
		int UserCnt=0;
		
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기중 하나를 고르세요");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		
		System.out.print("번호를 입력하세요.");
		int GameState=sc.nextInt();
		sc.nextLine();
		
		switch(GameState) {
		case 1:
			GameSet=5;
			WinSet=3;
			break;
		case 2:
			GameSet=3;
			WinSet=2;
			break;
		case 3:
			GameSet=1;
			WinSet=1;
			break;
			default:
				GameSet=1;
				WinSet=1;
		}
		
		for(int i=0;i<GameSet;) {
			int comGame=(int)(Math.random()*3)+1;
			System.out.print("가위바위보 중 하나 입력");
			int userGame=0;
			String userInput=sc.nextLine();
			if(userInput.equals("가위")) {
				userGame=1;
			}else if(userInput.equals("바위")) {
				userGame=2;
			}else if(userInput.equals("보")) {
				userGame=3;
			}
			
			if(comGame==1&&userGame==3 ) {
				System.out.println("졌습니다");
				ComCnt++;
			}
			else if(comGame==3&&userGame==1) {
				System.out.println("이겼습니다");
				UserCnt++;
			}else if(comGame>userGame) {	
				System.out.println("졌습니다");
				ComCnt++;
			}else if(comGame<userGame) {
				System.out.println("이겼습니다");
				UserCnt++;
			}			
			else if(comGame==userGame) {
				System.out.println("비겼습니다");
				continue;
			}
			
			if(UserCnt==WinSet) {
				System.out.println("####유저가 승");
				break;
			}else if(ComCnt==WinSet) {
				System.out.println("####컴퓨터가 승");
				break;
			}
			i++;
			
			
		}
		
		
	}
}
