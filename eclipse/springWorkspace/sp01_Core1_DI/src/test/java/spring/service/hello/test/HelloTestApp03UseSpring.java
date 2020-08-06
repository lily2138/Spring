package spring.service.hello.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.hello.Hello;

public class HelloTestApp03UseSpring {
/*
 * ClassPathSystem -- src를 이미 먹고들어간다
 *
 * FilePathSystem -- src부터 다시 인식시켜야한다.
 */

	public static void main(String[] args) {
		//1. BeanFactory 생성.... 주문서는 공장에서 미리 받아서 읽어놔야 한다.
		//BeanFactory 생성할 때 주문서 함께 인자값으로 넣어준다.
		// Bean Configuration File(빈 설정문서)
		//Lazy loading
//		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("config/hello/xml"));
		//library logging 가져와야한다.
		System.out.println("1. BeanFactory....생성....");
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("./src/main/resources/config/hello.xml"));
		
		//2. getBean()으로 빈을 받아와서 printMessage() 호출
		System.out.println("2. getBean()....클라이언트...호출....");
		//bean은 getbean을 호출할때 부랴부랴 생성한다
		Hello hello = (Hello)factory.getBean("hello");
		hello.printMessage();
	}

}
