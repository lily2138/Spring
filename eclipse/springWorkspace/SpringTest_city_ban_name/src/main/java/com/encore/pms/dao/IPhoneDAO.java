package com.encore.pms.dao;

import java.util.List;

import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;

public interface IPhoneDAO {
	int insert(Phone phone);

	int delete(List<String> list);

	Phone select(Phone phone);

	List<Phone> select();

	UserInfo select(UserInfo user);
}
