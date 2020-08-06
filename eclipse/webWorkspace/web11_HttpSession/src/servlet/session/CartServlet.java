package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 기존 세션을 하나 받아온다.
		 * 2. jsessionid, vo, pvo정보를 각각 받아와서 출력
		 * 3. 현재 세션에 바인딩된 정보가 있다면 --- 세션을 죽인다...
		 * 4. 현재 세션에 바인딩된 정보가 없다면 --- 처음부터...login.html
		 */
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		out.println("<h3>" + session.getId()+"<br>");
		out.println("Vo :: " + session.getAttribute("vo")+"<br>");
		out.println("Product Information :: " + session.getAttribute("pvo")+"</h3>");
		
		if(session.getAttribute("vo") != null) {
			session.invalidate();
			out.println("<script>");
			out.println("alert('로그아웃 되셨습니다...!!!')");
			out.println("locatin.href = 'login.html'");//스크립트안에서 페이지 이동할 때
			out.println("</script>");
		}else {
			response.sendRedirect("login.html");
		}
		
	}

}
