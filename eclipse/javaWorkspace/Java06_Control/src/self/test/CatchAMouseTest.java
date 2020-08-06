package self.test;

import java.util.Scanner;

class CatchAMouseTest{
	public static String solv(int x, int y, int z) {
		String result = "";
		int catA_d = Math.abs(x-z);
		int catB_d = Math.abs(y-z);
		if (catA_d>catB_d)
			result = "CatB Catch!!!";
		else if(catB_d>catA_d)
			result = "CatA Catch!!!";
		else
			result = "Mouse Escape";
		
		return result;
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//순서대로 값을 입력받고
		int catA = sc.nextInt();
		int catB = sc.nextInt();
		int mouse = sc.nextInt();
		
		String str = solv(catA,catB,mouse);
		System.out.printf("result: %s", str);

	}
}
