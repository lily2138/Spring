package spring.service.dice.test;
import spring.service.dice.impl.DiceAImpl;
import spring.service.dice.impl.DiceBImpl;
import spring.service.dice.impl.DiceCImpl;
//Spring 안쓰고 인터페이스 만으로 이렇게 재사용성을 높일수 있다....
import spring.service.dice.play.Player02;

public class DiceTestApp02 {
	///Main Method
	public static void main(String[] args){
		
		Player02 player01 = new Player02(new DiceAImpl());
		player01.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player01.getTotalValue());
		System.out.println("=======================");
		
		Player02 player02 = new Player02(new DiceBImpl());
		player02.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player01.getTotalValue());
		System.out.println("=======================");
		
		Player02 player03 = new Player02(new DiceCImpl());
		player03.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player01.getTotalValue());
		System.out.println("=======================");
		
	}
}//end of class

