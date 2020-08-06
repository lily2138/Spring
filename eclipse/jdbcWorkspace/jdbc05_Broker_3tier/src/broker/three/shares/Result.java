package broker.three.shares;

import java.util.ArrayList;
/*
 * Result는 한칸짜리 ArrayList이다 >>>> 어떤 것을 넣을지 모르기 때문에 제너릭이 객체인 arrayList를 상속받아 Result class를 만든다.
 * 성공/실패 여부를 확인할 수 있는 status 
 */
public class Result extends ArrayList {
	private int status = -1;  // 잘됐는지 안됐는지의 값을 나타내는 것. -1은 안됐을때. 

	public Result() {
		super(1);
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
