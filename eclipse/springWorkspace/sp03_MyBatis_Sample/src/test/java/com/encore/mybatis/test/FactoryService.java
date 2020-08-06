package com.encore.mybatis.test;
/*
 * SqlSessionFactory 하나 받아오는 로직을 따로 분리....
 */

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FactoryService {
	private static SqlSessionFactory factory;
	
	static {
		try {
			//1.... SqlMapConfig.xml을 읽어들인다.
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			
			//2. sqlSessionFactory를 리턴받는다.
			factory = new SqlSessionFactoryBuilder().build(r);
		}catch(Exception e) {
			
		}
	}//static
	
	public static SqlSessionFactory getFactory() {
		return factory;
		
	}
}
