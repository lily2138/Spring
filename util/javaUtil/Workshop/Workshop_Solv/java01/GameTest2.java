import java.util.Scanner;

public class GameTest2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int GameSet=0;
		int WinSet=0;
		
		int ComCnt=0;
		int UserCnt=0;
		
		System.out.println("���������� ������ �����մϴ�. �Ʒ� ������ �ϳ��� ������");
		System.out.println("1. 5�� 3��");
		System.out.println("2. 3�� 2��");
		System.out.println("3. 1�� 1��");
		
		System.out.print("��ȣ�� �Է��ϼ���.");
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
			System.out.print("���������� �� �ϳ� �Է�");
			int userGame=0;
			String userInput=sc.nextLine();
			if(userInput.equals("����")) {
				userGame=1;
			}else if(userInput.equals("����")) {
				userGame=2;
			}else if(userInput.equals("��")) {
				userGame=3;
			}
			
			if(comGame==1&&userGame==3 ) {
				System.out.println("�����ϴ�");
				ComCnt++;
			}
			else if(comGame==3&&userGame==1) {
				System.out.println("�̰���ϴ�");
				UserCnt++;
			}else if(comGame>userGame) {	
				System.out.println("�����ϴ�");
				ComCnt++;
			}else if(comGame<userGame) {
				System.out.println("�̰���ϴ�");
				UserCnt++;
			}			
			else if(comGame==userGame) {
				System.out.println("�����ϴ�");
				continue;
			}
			
			if(UserCnt==WinSet) {
				System.out.println("####������ ��");
				break;
			}else if(ComCnt==WinSet) {
				System.out.println("####��ǻ�Ͱ� ��");
				break;
			}
			i++;
			
			
		}
		
		
	}
}
