package com.encore.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductDAO;


@Repository
public class MyProductDAOImpl implements MyProductDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String ns = "ProductMapper."; //"com.encore.spring.mapper.ProductMapper."

	@Override
	public void addProduct(MyProduct myproduct) throws Exception {
		sqlSession.insert(ns + "addProduct",myproduct);
		sqlSession.insert("ProductMapper.addProduct",myproduct);
	}
	
	@Override
	public List<MyProduct> findByProductName(String words) throws Exception {
		List<MyProduct> result = sqlSession.selectList("ProductMapper.findByProductName",words);
		return result;
	}

	@Override
	public List<MyProduct> findProducts() throws Exception {
		List<MyProduct> result = sqlSession.selectList("ProductMapper.findProducts");
		return result;
	}

}
