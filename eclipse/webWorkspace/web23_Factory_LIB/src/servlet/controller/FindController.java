package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		
		MemberVO vo = MemberDAOImpl.getInstance().findByIdMember(id);
		ModelAndView mv = new ModelAndView();
		if(vo!=null) {
			mv.setViewName("find_ok");
			mv.addObject("message", "Hello Spring Framework!!!!, "+vo.getName());
			mv.addObject("vo", vo);
		}else {
			mv.setViewName("find_fail");
		}


		return mv;
	}

}
