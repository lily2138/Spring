package broker.twotier.test;

import java.util.ArrayList;

import broker.twotier.dao.Database;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.StockRec;

public class DatabaseTest {

	public static void main(String[] args) throws Exception {
		Database db = new Database("127.0.0.1");
		
		// 회원추가
//		db.addCustomer(new CustomerRec("146-146", "아이유", "판교"));

		//회원삭제
//		db.deleteCustomer("123-123");
		
		//회원수정
//		db.updateCustomer(new CustomerRec("146-146", "아이유","송도"));
		
		//포트폴리오 조회
		
		//회원정보 조회
		CustomerRec custInfo = db.getCustomer("111-111");
		System.out.println(custInfo);
		
		//모든 회원정보 조회
		ArrayList<CustomerRec> customers = db.getAllCustomers();
		for(CustomerRec c : customers)
			System.out.println(c);

		//모든 주식정보 조회
		ArrayList<StockRec> stocks = db.getAllStocks();
		for(StockRec s : stocks)
			System.out.println(s);
		
		//주식사기
//		db.buyShares("146-146", "ABStk", 4);
	}

}
