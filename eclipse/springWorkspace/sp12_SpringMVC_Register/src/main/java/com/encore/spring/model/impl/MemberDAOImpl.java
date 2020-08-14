package com.encore.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.Member;
import com.encore.spring.model.MemberDAO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String ns = "MemberMapper."; //"com.encore.spring.mapper.ProductMapper."
	
	@Override
	public void registerMember(Member member) throws Exception {
		sqlSession.insert(ns + "registerMember",member);
		
	}

	@Override
	public void updateMember(Member member) throws Exception {
		sqlSession.update(ns + "updateMember",member);
	}

	@Override
	public Member findBMemberId(String id) throws Exception {
		Member mem = sqlSession.selectOne(ns + "getMember", id);
		return mem;
	}

	@Override
	public List<Member> allMembers() throws Exception {
		List<Member> list = sqlSession.selectList(ns + "allMemberList");
		return list;
	}

	@Override
	public Member login(Member member) throws Exception {
		Member mem = sqlSession.selectOne(ns + "loginMember", member);
		return null;
	}
}
