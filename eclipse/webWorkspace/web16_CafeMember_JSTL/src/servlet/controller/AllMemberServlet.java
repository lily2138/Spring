package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<MemberVO> list = Collections.synchronizedList(new ArrayList<MemberVO>());
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
		
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		list = dao.showAllMember();
		System.out.println("1. 비즈니스로직..");
		
		context = getServletContext();
		
		
		context.setAttribute("list", list);
		System.out.println("2. 바인딩..");
		
		RequestDispatcher rdp = request.getRequestDispatcher("allShow.jsp");
		rdp.forward(request, response);// 이때 페이지 이동한다...
		
	}

}
