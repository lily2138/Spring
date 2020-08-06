package test;

public class test5 {

	public static void main(String[] args) {
		//int [] arr={10,0,0,4,20};
		//solution(arr,3);
		System.out.println(solution(41,46,56));

	}
//핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
    public static int solution(int a, int b, int range){
        int sum=0;
        for(int i=1; i<=range; i++ ){
            if(i%a==0 || i%b==0){
                sum += i;
            }
        }
        return sum;
    }
}