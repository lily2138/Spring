package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class RegisterController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String path = "";
		
		MemberVO pvo  = new MemberVO(id, password, name, address);
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			//
			//request.getRequestDispatcher("AllMember").forward(request, response);
			//response.sendRedirect("AllMember?name="+name);
			path = "allMember.do";
			
		}catch(SQLException e) {
			
		}
		return new ModelAndView(path);
	}

}
