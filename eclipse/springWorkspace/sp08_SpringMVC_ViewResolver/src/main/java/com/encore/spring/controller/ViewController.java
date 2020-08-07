package com.encore.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

	@RequestMapping("findBoard.do")
	public ModelAndView findBoard() {
		System.out.println("findBoard() Call....");
		return new ModelAndView("board_result");
	}
	
	@RequestMapping("findProduct.do")
	public ModelAndView findProduct() {
		System.out.println("findProduct() Call....");
		return new ModelAndView("product_result");
	}
	
	@RequestMapping("register.do")
	public ModelAndView register() {
		System.out.println("register() Call....");
		return new ModelAndView("register_result");
	}
	
}
