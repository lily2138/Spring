package exam.test;
/*
 * Singletone Pattern
 * ::
 * 클래스로부터 오직 단 한개의 인스턴스만 생성하고
 * 외부로부터 객체 생성을 하지 못하도록 막아두는 패턴
 * 
 * 코드작성방법
 * 1. 클래스에서 일단 하나의 객체를 생성 --- private static 으로 지정해서 생성
 * 2. 외부에서 객체 생성을 못하도록 막는다 ---- private 생성자()
 * 3. 하나 만들어 놓은 객체를 외부에서 사용할 수 있도록 열어둔다 --- public static 지정
 */

class Factory{
	private static Factory factory = new Factory();
	private Factory() {
		System.out.println("Car Factory.... Creating");
	}
	public static Factory getInstance() {
		return factory;
	}
}

public class StaticExamTest5 {
	public static void main(String[] args) {
//		Factory f = new Factory(); //--->객체를 만들 때 생성자가 실행되는데, 생성자를 private으로 막아놔서 쓸수가 없다
		
		//객체생성을 못했다. 객체생성을 해서 메모리를 올려놓아야 쓸수 있는데, 객체생성을 못했으므로 접근할수 없다.
		//그래서 getInstance()앞에 static을 붙혀서 접근가능할 수 있도록 해야한다.
		
		Factory factory1 = Factory.getInstance();
		Factory factory2 = Factory.getInstance();
		Factory factory3 = Factory.getInstance();

	}


}
