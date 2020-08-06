package servlet.loginForm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginSuccess
 */
public class LoginSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSuccess() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기다가 작성한다...
		//양방향 한글처리
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		String id = request.getParameter("id");

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<div id='loginSuccessBox'>");
		out.println("<h2>"+id+"님이 로그인 되었습니다.</h2>");
		out.println("<a href='register?id="+id+"'>도서등록</a>");
		out.println("<a href='logout?id="+id+"'>로그아웃</a>");
		out.println("</body></html>");
		out.close();
	}
}
