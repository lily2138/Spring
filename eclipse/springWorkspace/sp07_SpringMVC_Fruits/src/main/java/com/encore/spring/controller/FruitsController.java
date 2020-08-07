package com.encore.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Item;
import com.encore.spring.model.ItemService;

@Controller
public class FruitsController{

	@Autowired
	private ItemService itemService;
		

	@RequestMapping(value = "itemList.do", method=RequestMethod.GET)
	public ModelAndView getAllItem() throws Exception{ //폼에 입력
		List<Item> list = itemService.getAllItem();
		return new ModelAndView("itemList","list",list);  //"WEB-INF/views/itemList.jsp" 라고 해주면 viewResolver 이거 안해두됨
	}
	
	@RequestMapping("itemView.do")
	public ModelAndView getItem(int itemnumber) throws Exception{    //폼에 입력
		Item item = itemService.getItem(itemnumber);
		
		return new ModelAndView("itemView","item",item);
	}

	
//	@GetMapping("itemList.do")
//	public ModelAndView getAllItem() throws Exception{    //폼에 입력
//		List<Item> list = itemService.getAllItem();
//		
//		return new ModelAndView("itemList","list",list);      //"WEB-INF/views/itemList.jsp" 라고 해주면 viewResolver 이거 안해두됨
//	}
	
}
