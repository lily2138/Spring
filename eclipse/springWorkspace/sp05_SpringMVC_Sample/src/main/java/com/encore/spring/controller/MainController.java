package com.encore.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MainController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();      //뷰페이지이름, 이동경로지정 + 여기에 데이타바인딩
		mv.setViewName("result");    //확장자 안씀.... 물리적인 저장위치 안씀     ----> ViewResolver    "WEB/INF/views/result"
		mv.addObject("message", "Hello First SpringMVC!!!!");
		return mv;
	}

}
