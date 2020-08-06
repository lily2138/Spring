package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		      
		String id = request.getParameter("userId");
		String pass = request.getParameter("userPass");
		  
		PrintWriter out = response.getWriter();
		  
		out.println("<html><body><h2>id : "+id+"</h2>");
		out.println("<h2>pass : "+pass+"</h2>");
		if((id.equals("encore"))&&(pass.equals("1234"))) {
			out.println("<a href=LoginSuccess?i="+id+"&p="+pass+">결과확인</a>");
		}else {
			out.println("<a href=LoginError?i="+id+"&p="+pass+">결과확인</a>");
		}
		
  
		out.close();
	}

}
