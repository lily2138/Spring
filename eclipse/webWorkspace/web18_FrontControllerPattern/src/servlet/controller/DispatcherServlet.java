package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;
/*
 * <servlet>
 * 		<servlet-name></servlet-name>
 * 		<servlet-class></servlet-class>
 * </servlet>
 * <servlet-mapping>
 * 		<servlet-name>DispatcherServlet</servlet-name>
 * 		<url-pattern>front.do</url-pattern>
 * </servlet-mapping>
 */
@WebServlet(urlPatterns="/front.do", loadOnStartup=1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.요청이 어디에서 들어온 요청인지를 ...... command값 받는다
		String command = request.getParameter("command");
		String path = "index.jsp";
		
		if(command.equals("register")) {
			path = register(request,response);
		}else if(command.equals("find")) {
			path = find(request,response);
		}else if(command.equals("idcheck")) {
			path = idcheck(request,response);
		}else if(command.equals("login")) {
			path = login(request,response);
		}else if(command.equals("logout")) {
			path = logout(request,response);
		}else if(command.equals("update")) {
			path = update(request,response);
		}else if(command.equals("allMember")) {
			path = allMember(request,response);
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}//process
	
	protected String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO pvo  = new MemberVO(id, password, name, address);
		String path="register_ok.jsp";
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
		}catch(SQLException e) {
			
		}
		return path;
	}
	
	protected String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String path = "find_fail.jsp";
		try {
			MemberVO vo=MemberDAOImpl.getInstance().findByIdMember(id);
			if(vo!=null) {
				request.setAttribute("vo", vo);
				path = "find_ok.jsp";
			}			
		}catch(SQLException e) {
			
		}
		return path;
		
	}
	
	protected String idcheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String path="";
		try {
			boolean flag = MemberDAOImpl.getInstance().idExist(id);
			request.setAttribute("flag", flag);
			path = "idcheck.jsp";
		}catch(Exception e){
			System.out.println(e);
		}
		
		return path;
	}
	
	protected String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path = "login_result.jsp";
		try {
			MemberVO rvo=MemberDAOImpl.getInstance().login(id, password);
			HttpSession session = request.getSession();
			
			if(rvo !=null ) {
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID :: "+session.getId());				
			}
		} catch (SQLException e) {			
		}
		
		return path;
	}
	
	protected String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = "logout.jsp";
		if(session.getAttribute("vo") !=null) { //로그인한 상태라면....
			session.invalidate();
		}
		
		return path;
	}
	
	protected String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String path = "update_result.jsp";
		
		MemberVO vo  = new MemberVO(id, password, name, address);
		
		
		try {
			MemberDAOImpl.getInstance().updateMember(vo);
			
			HttpSession session = request.getSession();
			if(session.getAttribute("vo")!=null) {
				session.setAttribute("vo", vo);
			}
		}catch(SQLException e) {
			
		}
		
		return path;
	}
	
	protected String allMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "allView.jsp";
		try {
			ArrayList<MemberVO> list=MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("list", list);
		}catch(SQLException e) {
			
		}
		
		return path;
	}

}
