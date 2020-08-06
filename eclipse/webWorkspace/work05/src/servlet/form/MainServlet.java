package servlet.form;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.UserDAOImpl;
import servlet.model.UserVO;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String path = "";
    private ArrayList<UserVO> users;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (SQLException e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (SQLException e) {
			
		}
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	      
		String id = request.getParameter("userId");
		String pass = request.getParameter("userPass");
		  
		UserDAOImpl dao = UserDAOImpl.getInstance();
		System.out.println("2. 비즈니스로직.. id로 맴버찾기!!!");
		UserVO user = dao.login(id, pass);
		
		HttpSession session = request.getSession();
		
		if(user != null) {
			session.setAttribute("vo", user);
			System.out.println("JSESSIONID ::" + session.getId());
			
			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
		}else {
				response.sendRedirect("loginError?i=\"+id+\"&p=\"+pass");
		}
		
		
	}

}
