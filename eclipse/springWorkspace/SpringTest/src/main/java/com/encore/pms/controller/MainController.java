package com.encore.pms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;
import com.encore.pms.service.IPhoneService;

@Controller
public class MainController {	
	
	@Autowired
	private IPhoneService iPhoneService;
	
	@GetMapping("regPhone.do")
	public String getRegPhone(Model model) {
		model.addAttribute("title", "핸드폰 관리 - 핸드폰 등록폼");
		return "PhoneReg";
	}
	
	@PostMapping("savePhone.do")
	public String doRegPhone(Phone phone, Model model) {
		try {
			iPhoneService.insert(phone);
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 등록 성공");
			return "Result";
		}catch(RuntimeException e) {
			model.addAttribute("title", "핸드폰 관리 - 에러");
			return "Error";
		}
	}
	
	@GetMapping("searchPhone.do")
	public String doList(Model model) {
		try {
			List<Phone> list=iPhoneService.select();
			model.addAttribute("title", "핸드폰 관리 - 리스트");
			model.addAttribute("phones", list);
			return "PhoneList";
		}catch(RuntimeException e) {
			model.addAttribute("title", "핸드폰 관리 - 에러");
			model.addAttribute("message", "문제 내용 - 목록 조회중 오류가 발생했습니다.");
			return "Error";
		}
	}
	
	@GetMapping("detail.do")
	public String doDetail(Phone phone,Model model ) {
		try {
			Phone selected=iPhoneService.select(phone);
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 상세조회");
			model.addAttribute("Phone",selected);
			return "PhoneView";
		}catch(RuntimeException e) {
			model.addAttribute("title", "핸드폰 관리 - 에러");
			model.addAttribute("message", "문제 내용 - 조회중 오류가 발생했습니다.");
			return "Error";
		}
	}
	
	@GetMapping("login.do")
	public String getLoginForm() {
		return "Login";
	}
	
	@PostMapping("login.do")
	public String doLogin(UserInfo user, Model model, HttpSession session) {
		try {
			UserInfo selected=iPhoneService.select(user);
			if(selected!=null) {
				session.setAttribute("loginUser", selected);
				return "redirect:searchPhone.do";
			}else {
				return "Login";
			}
		}catch(RuntimeException e) {
			model.addAttribute("title", "핸드폰 관리 - 로그인 실패");
			model.addAttribute("message", "문제 내용 - 로그인중 오류가 발생했습니다.");
			return "Error";
		}		
	}
}





