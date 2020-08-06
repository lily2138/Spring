package servlet.controller;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");

		MemberVO vo=MemberDAOImpl.getInstance().findByIdMember(id);
		out.print(vo.getName()+" "+ vo.getAddress());
			

		return null;
	}

}
