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
public class SimpleMyBatisAppTest2 {

	public static void main(String[] args) {
		
		List<MySawon> list = new ArrayList<MySawon>();
		
		//MyBatis 라이브러리 사용....
		try {
			//1.... SqlMapConfig.xml을 읽어들인다.
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			
			//2. sqlSessionFactory를 리턴받는다.
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
			
			//3. SqlSession를 리턴받는다.
			SqlSession session = factory.openSession();
			
			System.out.println("===================================================");
			
			/*
			 * SqlSession
			 * 
			 * query statement							execute method
			 * INSERT INTO -------------------------------insert()
			 * DELETE FROM ------------------------------- delete()
			 * UPDATE table ------------------------------ update()
			 * SELECT all -------------------------------- List selectList()
			 * SELECT one -------------------------------- Object selectOne()
			 */
			
			//4. session에 쿼리문을 실행하는 모든 기능이 다 있다...
			//insert(), delete(), update(), selectList(), selectOne()
//			List<MySawon> list = session.selectList("mysawonMapper.sawonList");
			list = session.selectList("mysawonMapper.sawonList");
			session.commit(); //dml일 때는 반드시 해줘야한다
			session.close();    //spring di일 때는 들어가 있다.
			
			for(MySawon sawon : list) {
				System.out.println(sawon);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();      
			System.out.println(e);    //에러 확인
			System.out.println(" 님 정보 조회 실패^^;;;");
			
		}
	}

}
