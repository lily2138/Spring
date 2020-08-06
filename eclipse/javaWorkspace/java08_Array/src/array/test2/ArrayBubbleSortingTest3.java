package array.test2;

import java.util.Random;

/*
 * 정렬
 * ::
 * 배열과 같은 자료구조에 대해서는 정렬에 대한 요구사항이 빈번하게 일어난다.
 * 정렬을 구현하기 위한 알고리즘 중 가장 대표적인 버블정렬에 대해서 살펴보겠다.
 * 
 * 버블정렬
 * ::
 * 2,5 두수를 비교--> 2,5를 유지
 * 5,3 두수를 비교--> temp라는 임시변수(5) / 3,3 / temp에서 꺼내온 5를 뒷자리에 3,5
 * 이처럼 두수의 자리를 바꾸는 방법을 swap이라 한다.
 * 
 * 주의!!!
 * 
 */

public class ArrayBubbleSortingTest3 {
	public static void main(String[] args) {
		Random r = new Random();
		int[] arr = new int[10];
		for(int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(10); //0~9까지의 난수값을 추출
		}
		System.out.println("======초기화완료======");
		for(int i : arr) {
			System.out.print(i+" ");
		}
		
		int temp = 0;
		for(int i=0; i<arr.length-1;i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]>arr[j]) {//앞의 수가 뒤의 수보다 크다면
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("======정렬완료======");
		for(int i : arr) {
			System.out.print(i+" ");
		}
		
	}

}
