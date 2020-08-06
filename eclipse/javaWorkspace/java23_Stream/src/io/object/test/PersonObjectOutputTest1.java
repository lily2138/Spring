package io.object.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * 직렬화 코드...
 * Serialization :: Data Unpack
 * Person객체를 Sink쪽으로 날린다.
 * 1. ObjectOutputStream 생성
 * 2. wrtieObject(object);
 */
public class PersonObjectOutputTest1 {

	public static void main(String[] args) throws Exception {
		//1. 스트림생성
		String fileName = "src\\person.obj";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
		
		//2. 객체생성
		Person p = new Person("김연아",28,"kim99");
		
		//3. 날린다.
		oos.writeObject(p);
		
		//4. 자원반납..
		oos.close();
		System.out.println("person.obj파일에 연아의 정보를 저장했습니다.");
		System.out.println("정보를 확인하려면 역직렬화해서 확인바랍니다.");
	}

}
