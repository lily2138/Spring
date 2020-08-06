package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginSuccess
 */
public class LoginSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("i");
		String pass = request.getParameter("p");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><h2>로그인성공</h2>");
		out.println("<h2>id : "+id+"</h2>");
		out.println("<h2>pass : "+pass+"</h2>");
		
		out.println("<a href=\"\">도서등록</a>");
        out.println("<a href=\"\">로그아웃</a>");

        out.close();
		
	}



}
