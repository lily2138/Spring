package test;

public class test4 {

	public static void main(String[] args) {
		int [] arr={10,0,0,4,20};
		//solution(arr,3);
		System.out.println(solution(arr,8));

	}
//핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
	public static int solution(int[] arr, int num){
		int cnt=0;
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i]>num) {
				arr[i+1] = arr[i+1]+(arr[i]-num);
				arr[i]=num;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			//System.out.println(arr[i]);
			if(arr[i]!=0) {
				cnt++;
			}
		}
		//System.out.println(cnt);
		if(arr[arr.length-1]>num) {
			if(arr[arr.length-1]%num==0) {
				cnt += arr[arr.length-1]/num - 1;
			}else {
				cnt += arr[arr.length-1]/num;
			}
			
		}
		
        return cnt;
    }
}