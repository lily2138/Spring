package servlet.form;

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

import servlet.model.BookDAOImpl;
import servlet.model.BookVO;

public class AllBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<BookVO> list = Collections.synchronizedList(new ArrayList<BookVO>());
	private ServletContext context;
       
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
		
		BookDAOImpl dao = BookDAOImpl.getInstance();
		list = dao.showAllBook();
		System.out.println("1. 비즈니스로직..");
		
		context = getServletContext();
		
		context.setAttribute("list", list);
		System.out.println("2. 바인딩..");
		
		RequestDispatcher rdp = request.getRequestDispatcher("allBook.jsp");
		rdp.forward(request, response);// 이때 페이지 이동한다...
	}

}
