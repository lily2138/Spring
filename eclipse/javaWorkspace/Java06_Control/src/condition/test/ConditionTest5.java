package condition.test;

public class ConditionTest5 {

	public static void main(String[] args) {
		int dice = (int)(Math.random()*6)+1 ; //1~6사이의 랜덤한 점수가 할당되도록...
		/*
		 * 1이면 Dice1, 2면 Dice
		 */
		System.out.println(dice);
		
		String message = "";
		switch(dice) {
		case 1:
			message = "Dice1";
			break;
		case 2:
			message = "Dice2";
			break;
		case 3:
			message = "Dice3";
			break;
		case 4:
			message = "Dice4";
			break;
		case 5:
			message = "Dice5";
			break;
		case 6:
			message = "Dice6";
			break;
		default:
		}
		System.out.println(message);

	}

}
