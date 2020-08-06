package collection.test1;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		Properties p = System.getProperties();	
		Enumeration en=p.propertyNames();          // d에서 key 값만 받아와서 en에저장
		while(en.hasMoreElements()) {
			String name = (String)en.nextElement();
			String value= p.getProperty(name);
			System.out.println(name+"=================="+value);
		}
	}

}
