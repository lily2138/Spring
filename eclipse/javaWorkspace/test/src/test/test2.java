package test;

public class test2 {

	public static void main(String[] args) {
		System.out.println(solution("02468"));

	}
//핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
	public static int solution(String code){
		int[] num = {6,2,5,5,4,5,6,3,7,6};
        int answer=0;
        for(int i=0; i<code.length(); i++){
            answer += num[code.charAt(i)-'0'];
        }
        return answer;
    }
}