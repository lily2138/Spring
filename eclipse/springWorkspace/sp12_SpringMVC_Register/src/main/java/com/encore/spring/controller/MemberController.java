package com.encore.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Member;
import com.encore.spring.model.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@RequestMapping("Register.do")
	public ModelAndView register(Member member) throws Exception {
		System.out.println("register.do....");
		memberService.registerMember(member);
		return new ModelAndView("AllMember.do");   //결과페이지 이동
	}
	
	@RequestMapping("AllMember.do")
	public ModelAndView allMember() throws Exception {
		System.out.println("AllMember.do....");
		List<Member> list = memberService.allMembers();
		return new ModelAndView("allView", "allMembers",list);   //결과페이지 이동
	}
}
