package test;
/*
 * kim's
 * 1-2-3-4-5-6-7-8
 * 
 * lim's
 * 1-2-3-4-5-6-7-8-9
 */

import java.util.Scanner;

public class OperatorAlgoAooTest2 {

	static int halfDistance(int kim, int lim) {
		int cnt = 0;
		/*
		 * kim과 lim의 절반이 같지 않다면...
		 * 절반씩 줄어드는 로직을 작성. 이때마다 cnt가 1씩 증가...
		 */
		while(kim/2 != lim/2) {
			kim = kim/2;
			lim = lim/2;
			cnt++;
		}
		return cnt;
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int kims = sc.nextInt()-1;
		int lims = sc.nextInt()-1;

		int result = halfDistance(kims,lims);
		System.out.println(result);
	}

}
