package com.encore.spring.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductDAO;
import com.encore.spring.model.MyProductService;


@Service
public class MyProductServiceImpl implements MyProductService{
	
	@Autowired
	private MyProductDAO myProductDAO;

	@Override
	public void addProduct(MyProduct myproduct) throws Exception {
		myProductDAO.addProduct(myproduct);
	}

	@Override
	public List<MyProduct> findByProductName(String words) throws Exception {
		return myProductDAO.findByProductName(words);
	}

	@Override
	public List<MyProduct> findProducts() throws Exception {
		return myProductDAO.findProducts();
	}



}
