package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HttpFormServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		//폼에 값을 한꺼번에 다 가져옴...
		Enumeration<String> en = request.getParameterNames();
		while(en.hasMoreElements()){
			String name = en.nextElement();
			if(!name.equals("menu")) {
				out.println("<li>"+name+" : "+ request.getParameter(name)+"</li><br>");
			}
		}
		
		String[] menus = request.getParameterValues("menu");
		
		out.println("<b>당신이 좋아하는 음식들 입니다.</b><br>");
		String menu = "";
		for(int i=0; i<menus.length;i++) {
			menu +=menus[i]+" ";
		}
		out.println(menu);
		
		out.close();
		
		
	
	}

}
