package com.encore.spring.model;

import java.util.List;

import com.encore.spring.domain.Member;

public interface MemberDAO {
	
	void registerMember(Member member) throws Exception;
	void updateMember(Member member) throws Exception;
	Member findBMemberId(String id) throws Exception;
	List<Member> allMembers() throws Exception;
	
}
