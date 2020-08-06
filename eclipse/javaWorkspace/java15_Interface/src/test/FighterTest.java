package test;

public class FighterTest {
	public static void main(String[] args) {
		Fighter f = new Fighter();
		if(f instanceof Unit) {
			System.out.println("f는 Unit의 자손입니다...");
		}
		if(f instanceof Movable) {
			System.out.println("f는 Movable의 자손입니다...");
		}
		if(f instanceof Fightable) {
			System.out.println("f는 Fightable의 자손입니다...");
		}
	}

}

class Unit{
	int currentHP; //유닛의 체력
	int x;		   //유닛의 위치(x좌표)
	int y;		   //유닛의 위치(y좌표)
}

interface Movable{
	void move(int x, int y);
	
}

interface Attackable{
	void attack(Unit u);
}

//인터페이스 끼리는 extends 해야한다. implements하면 안된다. implements는 구체화를 해야하기 때문이다.
//인터페이스는 다중상속 된다.
interface Fightable extends Movable, Attackable{
}

//implements와 extends가 동시에 이루어질때. 
class Fighter extends Unit implements Fightable{

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack(Unit u) {
		// TODO Auto-generated method stub
		
	}
	
}













