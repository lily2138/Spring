package oop.constructor;
/*
 * Default Construct
 * 1.인자값이 없는 생성자
 * 2. 구현부에서 아무런 일도 하지 않는생성자
 */

public class Shirt {
	//묵시적초기화
	public String maker; //기본값을 가진다...null
	public boolean longSleeved;
	public char color;
	
	public Shirt() {} //Default Construct
	public Shirt(String m, boolean longs, char c) { //필드초기화
		maker = m;
		longSleeved = longs;
		color = c;
	}
	public String getDetails() { //worker메소드 = 구현이 있는 메소드
		return maker+", "+longSleeved+", "+color;
	}

}
