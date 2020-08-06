package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request,response);
		} catch (SQLException e) {
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request,response);
		} catch (SQLException e) {
			
		}
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher find;
		
		String id = request.getParameter("id");
		System.out.println("1. 폼값을 받아옵니다..");
		
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		System.out.println("2. 비즈니스로직.. id로 맴버찾기!!!");
		
		MemberVO vo = dao.findByIdMember(id);
		 
		context = getServletContext();
		
		context.setAttribute("vo", vo);
		
		if(vo!=null) {
			find = request.getRequestDispatcher("find_ok.jsp");
			find.forward(request, response);
		}else {
			find = request.getRequestDispatcher("find_fail.jsp");
			find.forward(request, response);
		}
		
		
	}
}
