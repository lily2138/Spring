package com.encore.mybatis.test;

import java.io.Reader;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.encore.mybatis.vo.MySawon;

/*
 * Scanner를 통해서 값을 입력 (화면을 대신한다)
 * 입력받은 값을 MyBatis 라이브러리를 사용해서
 * DB에 Access하는 로직을 작성
 */
public class SimpleMyBatisAppTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MySawon vo = new MySawon();
		
		System.out.println("아이디 : ");
		vo.setId(sc.next());
		
		System.out.println("비밀번호 : ");
		vo.setPwd(sc.next());
		
		System.out.println("이름 : ");
		vo.setName(sc.next());
		
		System.out.println("나이 : ");
		vo.setAge(sc.nextInt());
		
		//MyBatis 라이브러리 사용....
		try {
			//1.... SqlMapConfig.xml을 읽어들인다.
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			
			//2. sqlSessionFactory를 리턴받는다.
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
			
			//3. SqlSession를 리턴받는다.
			SqlSession session = factory.openSession();
			
			//4. session에 쿼리문을 실행하는 모든 기능이 다 있다...
			//insert(), delete(), update(), selectList(), selectOne()
			session.insert("mysawonMapper.sawonAdd", vo);
			session.commit(); //dml일 때는 반드시 해줘야한다
			session.close();    //spring di일 때는 들어가 있다.
			
			System.out.println(vo.getName()+ " 님 정보 입력 성공^^");
		}catch(Exception e) {
			e.printStackTrace();      
			System.out.println(e);    //에러 확인
			System.out.println(vo.getName()+ " 님 정보 입력 실패^^;;;");
			
		}
		
	}
}
