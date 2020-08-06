package algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Algo01 {
	public static void main(String[] args) {
		int [] candles = {2,2,2,4};
		System.out.println(solution(candles));

	}
	
	public static int solution(int[] candles){
        int count = 1;
        boolean stop = false;
        
        List<int[]> list = Arrays.asList(candles);

        Collections.reverse(list);     
        
        for(int i=0; i<=candles.length; i++){
//            Arrays.sort(candles,Collections.reverseOrder());
        	Collections.reverse(list); 
            for(int j=0; j<=i; j++){
                candles[j]=candles[j]-1;
                System.out.println(candles[j]);
                if(candles[j]==0){
                    stop = true;
                    break;
                }
            }
            count++;
            if(stop==true){
                break;
            }
            
        }
        return count;
    }
}