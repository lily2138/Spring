package servlet.header;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PrintHeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기다가 작성한다....
		//양방향 한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor = cyan>");
		out.println("<h2>======Header Information Printed....======</h2>");
		
		//Header의 정보를 뽑아본다.
		//Enumeration<String> en = request.getParameterNames();
		Enumeration<String> en = request.getHeaderNames();
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			String value = request.getHeader(key);
			out.println(key+" : "+value+"<br/>");
		}
		
		out.println("<hr>");
		
		String id = request.getParameter("id");
		String id2 = request.getParameter("i");
		String pass2 = request.getParameter("p");
		out.println(id+", "+id2+", "+pass2);
		out.println("</body></html>");

		
	}

}
