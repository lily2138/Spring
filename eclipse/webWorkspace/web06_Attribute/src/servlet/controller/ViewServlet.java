package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;

/**
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. Attribute에 바인딩된 데이타를 받아와서
		 * 2. 웹브라우저로 출력하는 로직을 작성....
		 */
		
/*		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");*/
		
		PrintWriter out = response.getWriter();
		
		context = getServletContext();
		
		MemberVO vo = (MemberVO)context.getAttribute("vo");
		
		out.println("<h2>회원님의 정보를 출력합니다...</h2><br>");
		out.println("<h2>이름</h2>"+vo.getName()+"<br>");
		out.println("<h2>나이</h2>"+vo.getAge()+"<br>");
		out.println("<h2>주소</h2>"+vo.getAddr()+"<br>");
		out.close();
		
	}

}
