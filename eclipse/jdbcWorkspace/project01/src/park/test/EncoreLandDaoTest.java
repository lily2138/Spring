package park.test;

import java.sql.SQLException;
import java.util.ArrayList;

import park.dao.EncoreLandDaoImpl;
import park.vo.Attraction;
import park.vo.Customer;

public class EncoreLandDaoTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		EncoreLandDaoImpl dao = EncoreLandDaoImpl.getInstance();

//		dao.entranceCustomer(new Customer(0, "F", 19));
		
//		System.out.println(dao.getMyInfo(3)); //customer에 String만들기
		
//		dao.useAttraction(4, 1003);
		
		dao.randUseAttraction(6, 4);
	}

}
