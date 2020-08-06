package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		/*
		 * 1. 세션을 하나 받아온다....request.getSession()
		 * 		JSESSIONID값 콘솔, 브라우저로 찍어본다.
		 * 2. 폼에 입력된 값을 가지고 vo객체 생성.... MemberVO
		 * 3. 세션에 바인딩....
		 * 4. 네비게이션.... 
		 * 	  A HREF = 'ProductServlet'
		 */
		
		HttpSession session = request.getSession();
		out.println("JSESSIONID : " + session.getId()+"<br>");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		MemberVO pvo = new MemberVO(id,pass,"하바리", "서현동");
		
		session.setAttribute("vo", pvo);
		out.println("<hr>");
		
		out.println("<a href = 'ProductServlet'>ProductServlet .. 두번째 요청하는 서블릿으로 이동함</a>");
	}

}
