package servlet.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GenericServletTest2 extends GenericServlet {
	private static final long serialVersionUID = 1L;       
  
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		//PrintWriter
		PrintWriter out=response.getWriter();
		out.println("<html><body><h2>");
		out.println("Hello GenericTest2");
		out.println("</h2></body></html>");
		
		out.close();
	}
}
 
/*
 * 서블릿 인스턴스 매핑정보 -- wa s
 * FQCN : servlet.generic.GenericServletTest2
 * Server 내부이름 매핑 : GenericServletTest2 * 
 * 클라이언트 url 매핑 : GS2
 * 
 * 
 */















