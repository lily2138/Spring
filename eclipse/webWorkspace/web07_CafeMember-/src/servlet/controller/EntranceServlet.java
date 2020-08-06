package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;
/*
 * 회원 가입하면...정보를 바탕으로
 * MemberVO를 생성....ArrayList에 추가
 * 회원 가입을 5명이....MemberVO 5개 생성
 * ArrayList 사이즈는 5
 * ArrayList를 통째로 ServletContext에 바인딩..
 */
public class EntranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<MemberVO> list = Collections.synchronizedList(new ArrayList<MemberVO>());
	private ServletContext context;
	
	
	public void init() throws ServletException {
		context = getServletContext();
		System.out.println("ServletContext의 주소 :: "+context);
		
		context.setAttribute("list", list);
		System.out.println("ServletContext에 까페 입장명단을 저장할 List를 미리 바인딩 합니다...");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기다가...
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String addr = request.getParameter("addr");
		System.out.println("1. 폼값을 받아옵니다..");
		
		MemberVO vo = new MemberVO(name, age, addr);
		System.out.println("2. MemberVO 생성..");
		
		list.add(vo);
		System.out.println("3. MemberVO 를 List에 저장.."); //ServletContext에 바인딩된 List에 VO가 저장
		
		out.println(name+" 님이 까페이 입장하셨습니다..<p>");
		System.out.println(name+" 님이 까페이 입장하셨습니다");
		
		out.println("<a href=viewMember.jsp?name="+name+">viewMember.jsp 페이지로 이동합니다.</a>");
	}

}








