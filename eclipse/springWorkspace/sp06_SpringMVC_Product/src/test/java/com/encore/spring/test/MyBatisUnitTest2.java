package com.encore.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.encore.spring.domain.MyProduct;

public class MyBatisUnitTest2 {

		//설정문서 읽어들이기
	@Test
	public void unit() throws Exception{
		
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		MyProduct vo = new MyProduct("하얀 세탁기", "엘지", 900000);
		System.out.println("디비 before::" + vo.getId());    //0 db에 아직 안들어간다. 밑에 insert해줘야 들어간다.
		
		//session.insert("ProductMapper.addProduct", vo); //디비에 값 집어넣고 + id값 자동생성 + 그 값을 vo에 setting
		System.out.println("INSERT OK!!!!");//0
		System.out.println("디비 after :: " + vo.getId());    //1
		
		session.commit();   //commit해줘야 한다
		
		System.out.println("===================================================================");
		
		List<MyProduct> list = session.selectList("ProductMapper.findByProductName", "세탁기");
		for(MyProduct v : list) {
			System.out.println(v);
		}
		
		System.out.println("===================================================================");
		
		List<MyProduct> list2 = session.selectList("ProductMapper.findProducts", "세탁기");
		for(MyProduct v : list2) {
			System.out.println(v);
		}
	
	}



}
