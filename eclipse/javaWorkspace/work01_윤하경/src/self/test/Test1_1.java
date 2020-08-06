package self.test;
/*
 * 두자리수부터는 크기때문에 모양이 이상해진다... 이게맞는걸까욤..?
 */
public class Test1_1 {

	public static void main(String[] args) {
		int num = 0;
		int row = 8; //몇줄을 출력할건지.
		for(int i=0; i<row; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("   ");
			}
			for(int k=0; k<row-i; k++) {
				num = num+1;
				System.out.print(num+"  ");
			}
			System.out.print("\n");
		}
	}
}
