package com.encore.spring.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.Member;
import com.encore.spring.model.MemberDAO;
import com.encore.spring.model.MemberService;

@Repository
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public void registerMember(Member member) throws Exception {
		memberDAO.registerMember(member);
		
	}

	@Override
	public void updateMember(Member member) throws Exception {
		memberDAO.updateMember(member);
	}

	@Override
	public Member findBMemberId(String id) throws Exception {
		Member mem = memberDAO.findBMemberId(id);
		return mem;
	}

	@Override
	public List<Member> allMembers() throws Exception {
		List<Member> list = memberDAO.allMembers();
		return list;
	}



}
