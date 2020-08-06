package collection.test1;

import java.util.ArrayList;
import java.util.List;

/*
 * List에 데이타가 저장되는 특징
 * 1)중복 허용
 * 2)순서도 있다
 * ArrayList
 */
public class ListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("강호동");
		list.add("이수근");
		list.add("규현");
		list.add("피오");
		list.add("이수근");

		System.out.println(list);
	}

}
