package servlet.cookie;
/*
 * 요청이 들어왔을 때 첫번째 서블릿
 * ::
 * 1. 쿠키생성 : Cookie c = new Cookie("name", "value");
 * 2. 생성한 쿠키를 웹 브라우저로 보냄....response.addCookie(c)
 */
import java.io.IOException;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookieTest extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date now = new Date();
		String id = "ENCORE";
		
		//1. 쿠키생성
		Cookie c1 = new Cookie("now", "2020-06-08:10:47");
		Cookie c2 = new Cookie("id", id);
		
		//2. 쿠키의 유효시간을 지정...하루로 지정....c1.setMaxAge()
		c1.setMaxAge(24*60*60);
		//c1.setMaxAge(24*60*60*2);   //이틀...
		c2.setMaxAge(0);	//쿠키사용하지 않겠다.
		
		//3. 쿠키를 전송
		response.addCookie(c1);
		response.addCookie(c2);
		
		//4. 페이지 이동....GetCookieTest
		response.sendRedirect("GetCookieTest");
		
		
	}

}
