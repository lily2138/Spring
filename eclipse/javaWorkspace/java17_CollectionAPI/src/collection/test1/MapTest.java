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
public class MapTest {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("강호동", 90);
		map.put("이수근",100);
		map.put("피오", 60);
		map.put("규현", 90);
		//값은 중복가능. key값은 중복안된다
		
		System.out.println(map);
		
		//1. 키만 받아온다...keySet()
		Set<String> set = map.keySet();
		
		//Set 컬렉션은 List 컬렉션처럼 인덱스로 객체를 검색해서 가져오는 메소드가 없다
		//대신 전체 객체를 대상으로 한 번 씩 다 가져오는 반복자, Iterator을 제공한다. 
		//Collection도 마찬가지.
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String name = it.next();
			System.out.println(name+"===="+map.get(name));
		}
		
		//2. 키에 해당하는 value를 찾아서 출력
		Collection<Integer> col = map.values();	//90,100,80,85
		int total = 0;
		
		Iterator<Integer> it2 = col.iterator();
		while(it2.hasNext()) {
			total += it2.next(); 
		}
		
		System.out.println("총점 :" + total);
		
		//3.
		System.out.println("평균: "+total/map.size());
		System.out.println("최고점수:"+Collections.max(col));
		System.out.println("최저점수:"+Collections.min(col));

		
		
		
	}
}
