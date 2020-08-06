package jdbc.test;

import java.util.ArrayList;

import config.ServerInfo;
import jdbc.dao.impl.CustomerDAOImpl;
import jdbc.vo.Customer;

public class CustomerDAOTest {
	//static 초기화 블락...
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading OK!!.....");
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Loading Fail.....");
		}
	}
	public static void main(String[] args) throws Exception{
		CustomerDAOImpl dao = CustomerDAOImpl.getInstance();
		//메소드 호출...할때 값 입력...해서 하나씩 완성해 나가보세요
		//dao.registerCustomer(new Customer("333", "333", "김민경", "대치동"));
		//dao.deleteCustomer("333");
		//dao.updateCustomer(new Customer("222", "211", "이정재", "서초동"));
		//System.out.println(dao.getCustomer("111"));
		ArrayList<Customer> list=dao.getAllCustomer();
		for(Customer c : list)System.out.println(c);
		
		
		Customer returnCust=dao.login(new Customer("222", "211", null, null));
		System.out.println(returnCust);
	}
}





