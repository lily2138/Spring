package inheritance.parent;

import inheritance.util.MyDate;

public class Employee {
	public static final double BASE_SALARY = 100.0; //상수값 (고정된값) 무조건 static final 붙힌다
	private String name;
	private double salary;
	private MyDate birthDate;
	
	//기본생성자
	public Employee() {}
	
	public Employee(String name, double salary, MyDate birthDate) {
		super();
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	}
	//생성자 오버로딩 ---> salary와 birthdate은 기본값들어감
	public Employee(String name) {
		this(name,BASE_SALARY, new MyDate(1989, 4, 11));
	}


	public String getDetails() {
		return name+","+salary+","+birthDate;
	}

	public static double getBaseSalary() {
		return BASE_SALARY;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public MyDate getBirthDate() {
		return birthDate;
	}
	
	
}

/*
 * this
 * 1)변수앞에 붙이는 this
 * 로컬변수와 필드의 이름이 같은 때 둘을 구분하기 위해서 필드앞에 붙인다.
 * 2)생성자앞에 붙이는 this
 * 하나의 클래스에서 서로다른 생성자를 호출할 때 사용됨
 */



