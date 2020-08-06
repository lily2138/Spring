package self.test;

import java.util.Scanner;

public class PatternGameTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// %, 
		
		int start = n/10;
		int end = n%10;
		
		if (start==3 ||start==6|| start==9) {
			if (end==3 || end==6 || end==9) {
				System.out.println("@@");
				System.exit(0);  //¾ÈÇÏ¸é @@ @³ª¿È
			}
			System.out.println("@");
		}else if(end==3 || end==6 || end==9) {
			System.out.println("@");
		}else {
			System.out.println(n);
		}

	}

}
