package servlet.form;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.BookDAOImpl;
import servlet.model.BookVO;

public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

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
		
		String[] isbns = request.getParameterValues("isbn");
		String isbn="";
		for(String is : isbns) {
			isbn += is;
		}
		String title = request.getParameter("title");
		String catalogue = request.getParameter("catalogue");
		String nation = request.getParameter("nation");
		String publishDate = request.getParameter("publishDate");
		String publisher = request.getParameter("publisher");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String currency = request.getParameter("currency");
		String description = request.getParameter("description");
		
		BookDAOImpl dao = BookDAOImpl.getInstance();
		System.out.println("2. 비즈니스로직.. 책등록하기");
		dao.registerBook(new BookVO(isbn,title,catalogue,nation,publishDate,publisher,author,price,currency,description));
				
		response.sendRedirect("bookResult.jsp");
		
	}

}
