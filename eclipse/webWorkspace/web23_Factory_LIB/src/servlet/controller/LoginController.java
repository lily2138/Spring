package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberVO vo=MemberDAOImpl.getInstance().login(id, password);
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		
		if(vo !=null ) {
			mv.addObject("vo", vo);
			session.setAttribute("vo", vo);
			
			mv.setViewName("login_result");

		}
		
		return mv;
	}

}
