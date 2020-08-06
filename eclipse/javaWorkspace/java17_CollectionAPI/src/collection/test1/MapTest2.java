package collection.test1;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Map
 * ::
 * key-value를 쌍으로 저장하는 특징을 가진다.
 * 
 */
public class MapTest2 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("강호동", 90);
		map.put("이수근",100);
		map.put("피오", 60);
		map.put("규현", 90);
		//값은 중복가능. key값은 중복안된다
		
		
		Set<String> key = map.keySet();
		
		for(String name:key) {
			System.out.println(map.get(name));
		}
		


		
		
		
	}
}
