package self.test;
/*
 * 이것도 두자리 수가 되면 늘어나서 모양이 이상하댜 ㅠㅠ
 */
public class Test1_2 {

	public static void main(String[] args) {
		int num = 0;
		int a = 0;
		int b = 0;
		int row = 5;
		int top = row/2+1;
		int bottom = row-top;
		
		for(int i=0; i<top; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("  ");
			}
			for(int k=0; k<row-i-a; k++) {
				num = num+1;
				System.out.print(num+" ");
			}
			System.out.print("\n");
			a=a+1;
		}
		for(int i=0; i<bottom; i++) {
			for(int j=bottom-i-1; j>0; j--) {
				System.out.print("  ");
			}
			for(int k=0; k<i+3+b; k++) {
				num = num+1;
				System.out.print(num+" ");
			}
			System.out.print("\n");
			b=b+1;
		}

	}

}
