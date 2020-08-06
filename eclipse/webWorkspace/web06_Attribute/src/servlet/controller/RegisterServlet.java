package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<MemberVO> list = Collections.synchronizedList(new ArrayList<MemberVO>());
	private ServletContext context;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 양방향 한글처리
		 * 2. 폼값 받아서
		 * 3. vo객체 생성
		 * 4. DAO 리턴받고....받았다 치고
		 * 5. 비지니스로직 호출.... 했다치고
		 * 6. 객체바인딩...ServletContext에
		 * 7. 페이지 이동....안배웠으니까.... 그냥 a 태그로 이동만 하자
		 */
		
		/*request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");*/
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String addr = request.getParameter("addr");
		
		MemberVO vo = new MemberVO(name, age, addr);
		
		context = getServletContext();
		
		context.setAttribute("vo", vo);
		
		out.println("<a href='ViewServlet'>ViewServlet 결과 확인하러 가기</a>");
		//out.println("<a href='result.jsp'>결과 확인하러 가기</a>");
		out.close();
		
		
	}

}
