package collection.test2;

import java.util.ArrayList;

public class PersonListTest {

	public static void main(String[] args) {
		//List안에 여러명의 Person들을 저장... 순서대로...
		ArrayList<Person> list = new ArrayList<Person>();
		
		list.add(new Person("이순신", "여의도", 66));
		list.add(new Person("강감찬", "순천", 41));
		list.add(new Person("을지문덕", "구미", 19));
		list.add(new Person("이순신1", "여의도", 61));
		list.add(new Person("강감찬1", "순천1", 44));
		list.add(new Person("을지문덕1", "여의도", 31));
		
		System.out.println(list); //Person class에 toString 안하면 주소값으로나온다
		
		//1. 두번째 장군을 찾아서 정보를 출력
		System.out.println(list.get(1));
		
		//2. 리스트에 들어있는 장군들의 수를 출력
		System.out.println(list.size());
		
		//3. 리스트에 저장된 장군들의 평균 연령을 출력
		int total = 0;
		for(Person p: list)
			total += p.getAge();
		
		System.out.println(total/list.size());
		
		//4. 저장된 장군들의 이름만 출력
		for(Person p:list)
			System.out.println(p.getName());
		
		//5. 여의도에 사는 사람만 출력
		for(Person p:list) {
			if(p.getAddr().equals("여의도")) {
				System.out.println(p.getName());
			}
		}

	}

}
