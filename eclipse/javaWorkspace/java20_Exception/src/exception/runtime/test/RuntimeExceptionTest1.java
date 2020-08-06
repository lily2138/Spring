package exception.runtime.test;
/*
 * 예외 발생 안하면 ...try 수행
 * 예외 발생 하면...
 * 		+
 * 발생한 예외로 잘 잡으면...catch문 수행
 * 
 */
public class RuntimeExceptionTest1 {
	public static void main(String[] args) {
		String[] str = {
			"Hello Java", 
			"No I mean it", 
			"Nice to meet you"	
		};
		
		int i = 0;

		while(i<=3) {
			try {
				//예외 발생안하면 이부분 수행...
				System.out.println(str[i]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Nice Catch!!!");
			}
			i++;
		}
	}
}
