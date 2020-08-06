package array.test3;

import java.util.Arrays;
import java.util.Scanner;

public class FlattenBoxText {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("덤프의 수를 입력하세요");
		int dumpNum = sc.nextInt();
		
		int[] row = new int[100];
		System.out.println("각 열의 상자의 수를 입력하세요");
		for(int i=0; i<row.length; i++) {
			row[i] = sc.nextInt();
		}
		Arrays.sort(row);
		int n = row[99] - row[0];
		int cnt = 0;
		
		while(cnt!=dumpNum) {
			row[99] -= 1;
			row[0] += 1;
			Arrays.sort(row);
			cnt++;
		}
		System.out.println(n);
	}

}
