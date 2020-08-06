package algorithm;

import java.util.Scanner;

public class Algo4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int count = sc.nextInt(); //구술 수
		int compare = sc.nextInt(); //비교하는 거 쌍 수
		int idx=0;
		int[][] comList = new int[compare][2];
		int result = 0;
		
		while(idx<compare) {
			for(int i=0; i<comList.length; i++) {
				for(int j=0; j<2; j++) {
					comList[i][j] = sc.nextInt();
				}
				idx++;
			}
		}

		int tempCnt = 0;
		for(int i=1; i<=count; i++) {
			tempCnt=0;
			for(int k=0; k<comList.length; k++) {
				if(comList[k][0]==i) {
					tempCnt++;
					if(tempCnt==2) {
						result++;
					}
				}

			}
			
			tempCnt=0;
			for(int k=0; k<comList.length; k++) {
				if(i==comList[k][1]) {
					tempCnt++;
					if(tempCnt==2) {
						result++;
					}
					
				}
			}
		}

		System.out.println(result);
		
	}	
}