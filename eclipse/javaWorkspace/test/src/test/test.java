package test;

public class test {

	public static void main(String[] args) {
		System.out.println(solution(101));

	}
//핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
	public static int solution(int n){
	      int temp=0;
	      int cnt = 0;
	      for(int i = 11; i<n; i++){
	          String num = Integer.toString(i);
	          temp=0;
	          for(int j=0; j<num.length()-1; j++){
	              for(int k=j+1; k<num.length(); k++){
	                  if(num.charAt(j)==num.charAt(k)){
	                          temp++;
	                          break;
	                  }
	              }
	              if(temp!=0) {
	            	  break; 
	              }
	          }
	          if(temp!=0){
	              cnt++;
	          }
	      }
	      int answer = n-1-cnt;
	      return answer;
	  }
}