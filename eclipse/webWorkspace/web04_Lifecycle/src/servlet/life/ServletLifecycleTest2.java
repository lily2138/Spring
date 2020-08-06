package servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletLifecycleTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0; //필드....
 
    public ServletLifecycleTest2() {
    	System.out.println("1. ServletLifecycleTest1 생성자....call....by container....");
    }

	
	public void init() throws ServletException {
		System.out.println("2. init....call....by container....");
	}


	public void destroy() {
		System.out.println("4. destroy....call....by container....");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. service....call....by container....");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		count = 100;
		out.println("<a href='life2.jsp?cnt="+count+"'>life2.jsp로 이동</a>");
		
		out.close();
	}

}
