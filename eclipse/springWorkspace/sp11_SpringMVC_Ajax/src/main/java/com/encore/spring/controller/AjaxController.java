package com.encore.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Person;

@Controller
public class AjaxController {
	
	/*
	 * ModelAndView
	 * View Page Name + ModelData
	 */

//		@RequestMapping("insert.do")
//		public ModelAndView insert() {
//			System.out.println("동기 통식....");
//			return new ModelAndView("insert_result");
//		}
		
//		@RequestMapping("insert.do")
//		public String insert() {
//			System.out.println("동기 통신....");
//			return "insert_result";
//		}
		
		@RequestMapping("insert.do")
		public String insert(Model model) {
			System.out.println("동기 통신....");
			model.addAttribute("info","와 ~~~ 동기통신이당");
			return "insert_result";   //결과페이지 이동
		}
		
		@RequestMapping("SearchId.do")
		public ModelAndView search() {
			System.out.println("비동기 통신....");
//			return new ModelAndView("redirect:/index.jsp");
//			return new ModelAndView("redirect:/allMember.do");
			return new ModelAndView("JsonView", "person", new Person("아이유", "서초동"));
		}
		
		
		
		
		
		
		
		
}
