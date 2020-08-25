package com.encore.pms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.pms.dto.Phone;
import com.encore.pms.service.IPhoneService;

@Controller
public class MainController {	
	
	@Autowired
	private IPhoneService iPhoneService;

	@RequestMapping("regPhone.do")
	public ModelAndView register(HttpServletRequest request, Phone phone) throws Exception {
		System.out.println("register.do....");
		
		String num = request.getParameter("num");
		String model = request.getParameter("model");
		int price = Integer.parseInt(request.getParameter("price"));
		String vCode = request.getParameter("vcode");
		
		phone = new Phone(num, model, price, vCode);
		iPhoneService.insert(phone);
		return new ModelAndView("Result");   //결과페이지 이동
	}
	
	@RequestMapping("phoneList.do")
	public ModelAndView phoneList() throws Exception {
		System.out.println("phoneList.do....");
	
		List<Phone> list = iPhoneService.select();
		
		return new ModelAndView("PhoneView","phoneList",list);
	}
	
	
	
}
