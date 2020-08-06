package io.object.test;

import java.io.Serializable;
/*
 * 직렬화
 * ObjectOutPutStream....Sink쪽으로 객체가 날라간다.
 * 정확히 표현하면 객체의 필드값이 직렬화되어져서 객체스트림을 통과하는 것.
 * 
 * 이렇게 Person이 객체스트림을 직렬화로 통과할려면.....
 * 반드시
 */
public class Person implements Serializable{
	private String name;
	private int age;
	private String password;
	
	public Person(String name, int age, String password) {
		super();
		this.name = name;
		this.age = age;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", password=" + password + "]";
	}
	
	
	
}
