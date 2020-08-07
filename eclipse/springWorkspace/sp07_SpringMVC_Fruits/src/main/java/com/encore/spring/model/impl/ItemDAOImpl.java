package com.encore.spring.model.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.Item;
import com.encore.spring.model.ItemDAO;

@Repository
public class ItemDAOImpl implements ItemDAO {	//

	@Autowired
	private SqlSession sqlSession;
	private final String ns = "ItemMapper."; //"com.encore.spring.mapper.ItemMapper."
	
	
	public List<Item> getAllItem() throws SQLException{
		List<Item> result = sqlSession.selectList(ns + "getItemList");
		return result;
	}
	
	public Item getItem(int itemid) throws SQLException{
		Item item = sqlSession.selectOne(ns+"getItem",itemid);
			return item;
	}
	
//	public void updateItem(int itemid) throws SQLException{
//		sqlSession.update(ns+"upeateItem", itemid);
//	}
}






















