package exam.test;
/*
 * 1. static 한 멤버는 객체 생성없이 사용할 수 있다
 */
class Member{
	static String name = "길똥이";
	static int age = 24;	//static 변수, class 변수, 전역변수
	int count=1;	//필드, 멤버 V
	
	
	public static void getMember() {
		System.out.println("우/유/빛/깔/ "+ name);
		//static은 static 끼리 통하므로 error가 난다.
//		System.out.println("count : " + count);
	}
	//non=static
	public void getMember2() {
		System.out.println("우/유/빛/깔/ "+ name);
	}
}
public class StaticExamTest1 {

	public static void main(String[] args) {
		/*Member m = new Member();
		m.getMember();*/
		
		Member.getMember();
		//static은 static 끼리 통한다.
//		Member.getMember2();
		

	}

}
