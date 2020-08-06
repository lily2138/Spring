package algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Algo2 {
	public static void main(String[] args) {
		String str = "ABCD DEFGH IJK";
		String result = str.split(" ")[0];
		System.out.println(result); 

	}
	
	public int solution(int n, String[] actions){
        int result = 0;
        int step=0;
        int [] bags = new int[n];
        for(int i=0; i<n; i++){
            bags[i]=1;
        }
        int bagA = 0;
        int bagB = 0;
        
        for(int i=0; i<actions.length; i++){
            if(actions[i].split(" ")[0].equals("PUT")){
                step = 1;
                bagA = Integer.parseInt(actions[i].split(" ")[1]);
                bagB = Integer.parseInt(actions[i].split(" ")[3]);
            }else if(actions[i].split(" ")[0].equals("SET")){
                step = 2;
                bagA = Integer.parseInt(actions[i].split(" ")[1]);
                bagB = Integer.parseInt(actions[i].split(" ")[3]);
            }else if(actions[i].split(" ")[0].equals("SWAP")){
                step = 3;
                bagA = Integer.parseInt(actions[i].split(" ")[1]);
                bagB = Integer.parseInt(actions[i].split(" ")[3]);
            }
            
            switch(step){
                case 1:
                    if(bagB>bagA){
                        n=n-1;
                        bags[bagA]=0;
                    }else{
                        result = -1;
                        return result;
                    }
                case 2:
                    
                    
            }
        }
        
        
        
        return 0;
    }
	
}