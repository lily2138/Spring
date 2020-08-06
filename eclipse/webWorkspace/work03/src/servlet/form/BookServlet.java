package servlet.form;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		String title = request.getParameter("title");
		String kinds = request.getParameter("kinds");
		String country = request.getParameter("country");
		String date = request.getParameter("date");
		String publisher = request.getParameter("publisher");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String contents = request.getParameter("contents");
		
		
	}

}
