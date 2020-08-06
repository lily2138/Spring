package algo;

import java.util.Scanner;

public class GunManTest {

	public static void main(String[] args)throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tcn=1; tcn<=T; tcn++){
			int X = sc.nextInt();
			int Y = sc.nextInt();
			
		char[ ][ ] map = new char[X][Y];
		
		for(int i=0; i<X; i++){			
			for(int j=0; j<Y ;j++){
				map[i][j] = sc.next().charAt(0);				
			}	
			
		}//fill map
		
		
		//구현하세요...
		
		
		
		}//tcn for

	}//main	
}//class




/*
Input Data
 
2
5 7
T 0 T 0 G 0 G
0 W T W W W 0
T W G 0 T W T
0 0 0 T G W 0
0 0 T 0 0 W 0
2 10
T W 0 G 0 W 0 G 0 W
G 0 T W T 0 T W T 0

*/

/*
Output

#1 6 
#2 2 
 */






