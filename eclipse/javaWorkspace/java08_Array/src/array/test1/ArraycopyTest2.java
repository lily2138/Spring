package array.test1;
/*
 * 배열은 사이즈를 수정할 순 없지만
 * 사이즈가 다른 배열의 요소를 copy떠서 가져올수는 있다.
 */

public class ArraycopyTest2 {
	public static void main(String[] args) {
		int[] target = {1,2,3,4,5,6};
		int[] source = {10,9,8,7,6,5,4,3,2,1};
		
		//8,7,6,5,4,3...target
		System.arraycopy(source, 2, target, 0, target.length);
		for(int i:target)
			System.out.println(i);
	}
}
