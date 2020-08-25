package com.encore.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.pms.dao.IPhoneDAO;
import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;



@Service
public class PhoneServiceImpl implements IPhoneService{
	
	@Autowired
	private IPhoneDAO iPhoneDAO;

	public int insert(Phone phone) {
		int in = iPhoneDAO.insert(phone);
		return in;
	}

	public int delete(List<String> list) {
		int del = iPhoneDAO.delete(list);
		return del;
	}

	public Phone select(Phone phone) {
		Phone ph = iPhoneDAO.select(phone);
		return ph;
	}

	public List<Phone> select() {
		List<Phone> pList = iPhoneDAO.select();
		return pList;
	}

	public UserInfo select(UserInfo user) {
		UserInfo userInfo = iPhoneDAO.select(user);
		return userInfo;
	}

	

}
