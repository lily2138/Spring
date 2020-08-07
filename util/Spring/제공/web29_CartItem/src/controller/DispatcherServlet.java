package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//hidden 값으로 들어온 요청을 받지 않고..들어온 요청의 주소를 직접 인식시킨다.
		String requestURI=request.getRequestURI();
		System.out.println("RequestURI :: "+requestURI);//web22_CafeMember_Factory/find.do
		
		String contextPat=request.getContextPath();
		System.out.println("ContextPat :: "+contextPat); //web22_CafeMember_Factory
		
		//find.do 만 추출하자...substring()사용...
		String command = requestURI.substring(contextPat.length()+1);
		System.out.println("command :: "+command); // /find.do
		
		
		Controller controller=HandlerMapping.getInstance().createController(command);
		String path = "index.jsp";
		ModelAndView mv = null;
		try {
			mv = controller.handle(request, response);		
			path = mv.getPath();
		}catch(Exception e) {	
			System.out.println(e);
		}
		if( mv!=null) {
			if(mv.isRedirect()) response.sendRedirect(path);
			else
				request.getRequestDispatcher(path).forward(request, response);
		}
	}
}






















