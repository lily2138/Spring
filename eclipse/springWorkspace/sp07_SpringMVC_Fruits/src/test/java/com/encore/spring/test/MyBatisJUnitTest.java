package com.encore.spring.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.encore.spring.domain.Item;

public class MyBatisJUnitTest {

	@Test
	public void unit() throws IOException {
		//설정문서 읽어들이기
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		List<Item> list = session.selectList("ItemMapper.getItemList");
		for(Item item : list) {
			System.out.println(item);
		}
		
		System.out.println("===================================================================");
		
		Item item = session.selectOne("ItemMapper.getItem", 1);
		System.out.println(item);
	}
}
