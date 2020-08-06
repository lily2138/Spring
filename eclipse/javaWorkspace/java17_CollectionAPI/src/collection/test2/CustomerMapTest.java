package collection.test2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CustomerMapTest {

	public static void main(String[] args) {
		HashMap<String, Customer> map = new HashMap<>();
		
		map.put("111", new Customer("kim","김제동", 40));
		map.put("222", new Customer("seung","성유리", 35));
		map.put("333", new Customer("lee","이경규", 55));
		
		System.out.println(map);
		
		///1. 222에 해당하는 사람의 정보를 출력
		/*Set<String> keys = map.keySet();
		for(String key: keys) {
			if(key.equals("222"))
				System.out.println(map.get(key));
		}*/
		System.out.println(map.get("222"));
		
		///2. id가 kim인 사람을 찾아서 그사람의 이름을 출력
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			Customer c = map.get(it.next());
			if(c.getId().equals("kim")) {
				System.out.println(c.getName());
			}
		}
		
		
		///3. map에 저장된 모든 key값을 출력
		System.out.println(map.keySet());
		
		///4. 모든 사람의 나이의 총합과 평균연령을 출력
		Set<String> set1 = map.keySet();
		int totalAge = 0;
		for(String s : set1) {
			totalAge+=map.get(s).getAge();
		}
		System.out.println("종합 :" + totalAge+"세");
		System.out.println("평균연령:" + totalAge/map.size()+"세");
		
		
	}

}
