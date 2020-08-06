package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String path = "";
		
		MemberVO vo  = new MemberVO(id, password, name, address);
		
		
		try {
			MemberDAOImpl.getInstance().updateMember(vo);
			
			HttpSession session = request.getSession();
			if(session.getAttribute("vo")!=null) {
				session.setAttribute("vo", vo);
			}
			path = "update_result.jsp";
		}catch(SQLException e) {
			
		}
		return new ModelAndView(path);
	}

}
