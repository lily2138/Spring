package array.test3;

import java.util.Arrays;
import java.util.Scanner;

public class FlattenBoxText3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tc = 10;
		int boxLen = 100;
		for(int tcn=1; tcn<=tc; tcn++) {
			System.out.println("덤프의 수를 입력하세요");
			int dump = sc.nextInt();
			
			int[] boxes = new int[boxLen];
			System.out.println("각 열의 상자의 수를 입력하세요");
			for(int i=0; i<boxes.length;i++) {
				boxes[i] = sc.nextInt();
			}
			
			int heightDiff = flatten(boxes,dump);
			System.out.printf("#%d %d%n", tcn, heightDiff);
		}
	}
	private static int flatten(int[] boxes, int dump) {
		
		for(int i=0; i<dump; i++) {
			Arrays.sort(boxes);
			int diff = boxes[boxes.length-1]-boxes[0];
			if(diff<=1) {
				return diff;
			}
			boxes[0]++;
			boxes[boxes.length-1]--;
		}
		//이부분을 반드시 추가해야한다.
		Arrays.sort(boxes);
		return boxes[boxes.length-1] - boxes[0];
	}
}
