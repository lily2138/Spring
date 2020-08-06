package servlet.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GenericServletTest1 extends GenericServlet{
	
	/*
		클라이언트가 요청을 하면 호출되는 메소드...
		이때 클라이언트의 요청정보를 ServletRequest 저장.---- Command
		요청을 수행한후 응답할 정보를 ServletResponse 저장 ---- Command안의 Result
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		//요청을 받았다...치고
		//바로 응답만 해보겠다...클라이언트...브라우저로 응답..
		PrintWriter out=res.getWriter();
		out.println("<html><body bgcolor='yellow'>");
		out.println("<h2>Hello ~~~~ GenericServlet!!! </h2>");
		out.println("</body></html>");
		
		out.close();		
	}
}
//http://127.0.0.1:8888/web01_GenericServlet/GenericServletTest1














