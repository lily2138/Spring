package com.encore.spring.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.encore.spring.domain.Member;

public class MyBatisJUnitTest {

	@Test
	public void unit() throws IOException {
		//설정문서 읽어들이기
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		Member member1 = new Member("bbb", "bbbb", "비", "비동");
		System.out.println("Insert OK :: " + session.insert("MemberMapper.registerMember",member1));
		
		session.commit();  
		
		System.out.println("===================================================================");
		
		List<Member> list = session.selectList("MemberMapper.allMemberList");
		for(Member member : list) {
			System.out.println(member);
		}
		
		System.out.println("===================================================================");
		
		Member member2 = new Member("aaa", "aaaa", "에이", "에이동이다");
		session.update("MemberMapper.updateMember", member2);
		
		session.commit(); 
		
		
		System.out.println("===================================================================");
		
		Member member = session.selectOne("MemberMapper.getMember", "aaa");
		System.out.println(member);
	}
}
