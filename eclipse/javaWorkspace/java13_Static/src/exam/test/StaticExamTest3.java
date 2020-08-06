package exam.test;
//static block
public class StaticExamTest3 {
	static int i;
	
	
	public static void main(String[] args) {
		System.out.println("1. main method static block...."+i);
		
		//°´Ã¼ »ý¼º...(); (){ // }
	}
	
	static {
		i=300;
		System.out.println("1. static initialization block...."+i);
		
	}

}
