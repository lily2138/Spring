package servlet.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfigTest1
 */
public class ServletConfigTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name, addr;
	
	public ServletConfigTest1() {
		System.out.println("생성자 호출......");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init 호출......");
		name = getInitParameter("name");
		addr = getInitParameter("addr");
		System.out.println(name+","+addr);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기다 작성....
		System.out.println("doProcess....");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h2>A Servlet Instance Initialisation.... Using ServletConfig</h2><p>");
		
		out.println("당신의 이름 : "+name+"<br>");
		out.println("당신이 사는곳: "+addr+"<br>");
		
		out.close();
	}

}
