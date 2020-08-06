package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

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
		/*
		 * 1. 폼값 받아온다.
		 * 2. dao리턴 받고 biz 로직호출
		 * 3. 세션을 받아온다
		 * 4. 결과값 바인딩....세션에....이때 jsessionid값도 찍어본다...콘솔에
		 * 5. 페이지 이동....login_result.jsp
		 */
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println("1. 폼값을 받아옵니다..");
		
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		System.out.println("2. 비즈니스로직.. id로 맴버찾기!!!");
		MemberVO mem = dao.login(id, password);
		
		HttpSession session = request.getSession();
		
		if(mem != null) {
			session.setAttribute("vo", mem);
			System.out.println("JSESSIONID ::" + session.getId());
			
			//response.sendRedirect("login_result?i=\"+id+\"&p=\"+password");
			
			request.getRequestDispatcher("login_result.jsp").forward(request, response);
			/*RequestDispatcher rdp = request.getRequestDispatcher("login_result.jsp");
			rdp.forward(request, response);// 이때 페이지 이동한다...
*/		}
	}

}
