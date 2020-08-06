package servlet.redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RedirectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * checkbox를 선택하지 않으면... error 페이지로 이동...redirect방법
		 * 그렇지 않은 경우 forwarding으로 내용을 전달함
		 */
		String choose = request.getParameter("choose");
		if(choose==null) {
			response.sendRedirect("./error/error.html");
		}else {
			request.getRequestDispatcher("redirect2.jsp").forward(request, response);
		}
		
	}

}
