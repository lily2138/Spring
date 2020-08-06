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


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private ServletContext context;
	//List<MemberVO> list = (List<MemberVO>)context.getAttribute("list");

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
		
		//context.setAttribute("list", list);
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		System.out.println("1. 폼값을 받아옵니다..");
		
		MemberVO vo = new MemberVO(id,password,name,address);
		System.out.println("2. MemberVO 생성..");
		
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		dao.registerMember(vo);
		System.out.println("3. 비즈니스로직..");
		//list.add(vo);
		
		/*RequestDispatcher rdp = request.getRequestDispatcher("AllMember");
		rdp.forward(request, response);// 이때 페이지 이동한다...
*/		
		response.sendRedirect("AllMember?name="+name);
	}

}
