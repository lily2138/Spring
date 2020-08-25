package com.encore.pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;

@Repository
public class PhoneDaoImpl implements IPhoneDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String ns = "PhoneMapper."; 

	public int insert(Phone phone) {
		int in = sqlSession.insert(ns + "insertPhone",phone);
		return in;
	}

	public int delete(List<String> list) {
		int del = 0;
		for(String pnum : list) {
			del += sqlSession.delete(ns + "deletePhone",pnum);
		}
		return del;
	}

	public Phone select(Phone phone) {
		Phone ph = sqlSession.selectOne(ns + "getPhone", phone.getNum());
		return ph;
	}

	public List<Phone> select() {
		List<Phone> list = sqlSession.selectList(ns + "phoneList");
		return list;
	}

	public UserInfo select(UserInfo user) {
		UserInfo userInfo = sqlSession.selectOne(ns + "getUserInfo", user.getId());
		return userInfo;
	}
	
	
}
