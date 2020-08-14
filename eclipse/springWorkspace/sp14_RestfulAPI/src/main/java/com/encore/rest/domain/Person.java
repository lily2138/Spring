package com.encore.rest.domain;

public class Person {
	private String name;
	private String message;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, String message) {
		super();
		this.name = name;
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", message=" + message + "]";
	}
	
	
}
