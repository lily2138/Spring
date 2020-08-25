package com.encore.pms.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;

public class MyBatisJUnitTest {

	@Test
	public void unit() throws IOException {
		//설정문서 읽어들이기
		Reader r = Resources.getResourceAsReader("spring/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		Phone phone = new Phone("cccc", "cccc", 491800, "10");
		System.out.println("Insert OK :: " + session.insert("PhoneMapper.insertPhone",phone));
		
		session.commit();  
		
		System.out.println("===================================================================");
		
		List<Phone> list = session.selectList("PhoneMapper.phoneList");
		for(Phone p : list) {
			System.out.println(p);
		}
		
		System.out.println("===================================================================");
		

		Phone phone2 = session.selectOne("PhoneMapper.getPhone", phone.getNum());
		System.out.println(phone2);
		
		System.out.println("===================================================================");	
		

		System.out.println("Delete OK :: " + session.delete("PhoneMapper.deletePhone",phone.getNum()));
		
		session.commit(); 
		
		System.out.println("===================================================================");
		
		List<Phone> list2 = session.selectList("PhoneMapper.phoneList");
		for(Phone p : list2) {
			System.out.println(p);
		}
		
		System.out.println("===================================================================");
		
		UserInfo user = session.selectOne("PhoneMapper.getUserInfo", "admin");
		System.out.println(user);
	}
}
