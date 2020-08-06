package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "find_fail.jsp";
		
		String member = request.getParameter("findForm");
		MemberVO notebook = MemberDAOImpl.getInstance().findByIdMember(member);
		request.setAttribute("notebook", notebook);
		path = "find_ok.jsp";
		
		return path;
	}
	
}
