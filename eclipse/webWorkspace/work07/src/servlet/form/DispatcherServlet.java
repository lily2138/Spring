package servlet.form;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.BookDAOImpl;
import servlet.model.BookVO;
import servlet.model.UserDAOImpl;
import servlet.model.UserVO;

@WebServlet(urlPatterns="/front.do", loadOnStartup=1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		//1.요청이 어디에서 들어온 요청인지를 ...... command값 받는다
		String command = request.getParameter("command");
		String path = " ";
		
		if(command.equals("login")) {
			path = login(request,response);
		}else if(command.equals("logout")) {
			path = logout(request,response);
		}else if(command.equals("bookRegister")) {
			path = bookRegister(request,response);
		}else if(command.equals("allBook")) {
			path = allBook(request,response);
		}else if(command.equals("searchBook")) {
			path = searchBook(request, response);
		}else if(command.equals("bookDetail")) {
			bookDetail(request, response);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}//process

	
	
	private String bookDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String title = request.getParameter("title");
		String path = " ";
		
		System.out.println(title);
		BookVO vo = BookDAOImpl.getInstance().bookView(title);
		
		if(vo !=null ) {
			request.setAttribute("vo", vo);
			path = "bookViewResult.jsp";
			//System.out.println("JSESSIONID :: "+session.getId());				
		}else {
			path="Error.jsp";
			//System.out.println("error");
		}
		return path;
	}


	protected String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String id = request.getParameter("userId");
		String password = request.getParameter("userPass");
		String path = "loginSuccess.jsp";
		
		UserVO rvo=UserDAOImpl.getInstance().login(id, password);
		HttpSession session = request.getSession();
		
		if(rvo !=null ) {
			session.setAttribute("vo", rvo);
			path = "loginSuccess.jsp";
			//System.out.println("JSESSIONID :: "+session.getId());				
		}else {
			path="loginError.jsp";
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
	
	protected String bookRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		String path = "bookResult.jsp";
		
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
				
		return path;
		
	}
	
	protected String allBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		ArrayList<BookVO> list; 
		
		String path = "allBook.jsp";
		
		BookDAOImpl dao = BookDAOImpl.getInstance();
		list = dao.showAllBook();
		System.out.println("1. 비즈니스로직..");

		
		request.setAttribute("list", list);
		System.out.println("2. 바인딩..");
		
		
		return path;
	}
	
	protected String searchBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String findKey = request.getParameter("findKey");
		String findValue = request.getParameter("findValue");
		
		ArrayList<BookVO> list; 
		
		BookDAOImpl dao = BookDAOImpl.getInstance();
		list = dao.findBook(findKey, findValue);
		System.out.println("1. 비즈니스로직..");

		
		request.setAttribute("list", list);
		System.out.println("2. 바인딩..");
		
		String path = "allBook.jsp";
		
		return path;
	}
}
