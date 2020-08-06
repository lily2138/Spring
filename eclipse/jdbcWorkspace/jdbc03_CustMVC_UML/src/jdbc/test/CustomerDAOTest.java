package jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import config.ServerInfo;
import jdbc.dao.impl.CustomerDAOImpl;
import jdbc.vo.Customer;

public class CustomerDAOTest {
	// static 초기화 블락
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading OK!!!");
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Loading Fail !!!!");
		}
	}
	
	
	public static void main(String[] args) throws SQLException {
		
		CustomerDAOImpl dao = CustomerDAOImpl.getInstance();
		
		Customer cust1 = new Customer("a1","aaaa", "이름A", "서초동");
		Customer cust2 = new Customer("b2","bbbb", "이름B", "삼성동");
		Customer cust3 = new Customer("c3","cccc", "이름C", "역삼동");
		Customer cust4 = new Customer("d4","dddd", "이름D", "송도동");
		
		
		//고객등록
/*		dao.registerCustomer(cust1);
		dao.registerCustomer(cust2);
		dao.registerCustomer(cust3);
		dao.registerCustomer(cust4);
		
		//고객 삭제
		dao.deleteCustomer("b2");
		
		//고객 수정
		dao.updateCustomer(new Customer("c3","cccc", "이름C", "마곡동"));*/
		
		//고객 보기
		System.out.println(dao.getCustomer("d4"));
		
		//고객 모두보기
//		System.out.println(dao.getAllCustomer());

		Customer returnCust=dao.login(new Customer("a1", "aaaa", null, null));
		System.out.println(returnCust);
		
	}

}
