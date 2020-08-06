package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HelloAjaxServlet")
public class HelloAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//error 발생할 수 있도록 응답을 지연
/*		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			
		}*/ 
		
		String name = request.getParameter("name");
		//실제 응답이 이뤄지는 부분
		out.print("name ::" + name);
		out.close();
		
	}

}
