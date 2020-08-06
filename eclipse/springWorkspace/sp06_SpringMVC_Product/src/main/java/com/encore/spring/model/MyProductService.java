package com.encore.spring.model;

import java.util.List;

import com.encore.spring.domain.MyProduct;

public interface MyProductService {
	void addProduct(MyProduct myproduct) throws Exception;
	
	List<MyProduct> findByProductName(String words) throws Exception;
	List<MyProduct> findProducts() throws Exception;
}
