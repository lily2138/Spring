package collection.test1;

import java.util.HashSet;
import java.util.Set;

/*
 * Set
 * ::
 * Unique
 * 중복안됨 / 순서없고
 */

public class SetTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("강호동");
		set.add("이수근");
		set.add("규현");
		set.add("피오");
		set.add("이수근");
		
		System.out.println(set);
		System.out.println(set.size());
		boolean find = set.contains("김해수");
		System.out.println(find);//false
		
		set.remove("규현");
		System.out.println(set);
		
		set.clear(); 	//removeAll()
		System.out.println("비었나요??"+set.isEmpty());
		System.out.println(set);
		
	}

}





