package com.encore.mybatis.test;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.encore.mybatis.vo.MySawon;

/*
 * mysawon 테이블에 있는 모든 사원의 정보를 출력하는 코드를 작성
 * 
 */
public class SimpleMyBatisAppTest3 {

	public static void main(String[] args) {
			
		SqlSessionFactory factory = FactoryService.getFactory();
		SqlSession session = factory.openSession();

		List<MySawon> list = session.selectList("mysawonMapper.sawonList");
		session.commit(); //dml일 때는 반드시 해줘야한다
		session.close();    //spring di일 때는 들어가 있다.
		
		for(MySawon sawon : list) {
			System.out.println(sawon);
		}
		

	}

}
