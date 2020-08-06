package spring.service.greet;

/*
 * FileName : Hello.java
 * ㅇ package / private Field(property) / Constructor / getter,setter / 필요한 Method 
 * ㅇ를 갖는 빈 규약을 준한 일반적인 Bean ::  POJO(Plain Old Java Object)
 */
public class Greet{
	
	///Field
	private String message ;
	
	///Constructor Method
	public Greet() {
		//bean이 언제 찍히는지 알기위해 생성자에다가 찍어준다
		System.out.println(getClass().getName()+"...Instance Create...");
	}
	public Greet(String message) {
		this.message = message;
	}

	///Method
	//==> getter / setter Method definition
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	//==> message 를 출력하는 Method  
	public void printMessage() {
		System.out.println("\n"+getClass().getName()+"=>"+message);
	}
	
}//end of class