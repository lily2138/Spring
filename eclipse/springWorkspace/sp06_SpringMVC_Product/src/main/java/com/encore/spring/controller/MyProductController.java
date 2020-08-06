package com.encore.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductService;

@Controller
public class MyProductController{

	@Autowired
	private MyProductService myProductService;
	
	@RequestMapping("myProduct.do")
	public ModelAndView insert(MyProduct pvo) throws Exception{    //폼에 입력
		System.out.println("폼으로 받은 데이타 " + pvo.getId());   //0
		myProductService.addProduct(pvo);
		System.out.println("폼으로 받은 데이타" + pvo.getId());   //4
		
		return new ModelAndView("insert_result","info",pvo);
	}
	
	@RequestMapping("mySearch.do")
	public ModelAndView getProducts(String word) throws Exception{    //폼에 입력
		List<MyProduct> list = myProductService.findByProductName(word);
		
		return new ModelAndView("find_result","list",list);
	}
	
}
