package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Controller 로직의 공식
		 * 1. 폼값 받아서
		 * 2) 폼값받아서 vo객체 생성 하는 로직이 있을 수도 있다
		 * 2. MemberDAO 리턴받고
		 * 3. 비지니스 로직 호출
		 * 4. 3번의 결과값을 Attribute 바인딩 .... (회원가입같은 거는...void...리턴값 없다 )
		 * 5. 네비게이션
		 */
		
		String id = request.getParameter("id");
		//단순조회.... forward방식으로 페이지를 이동한다 + request에 바인딩
		request.setAttribute("id", id);
		
		request.getRequestDispatcher("resultView.jsp").forward(request, response);
		
		request.getRequestDispatcher("includeTest.jps").include(request,response);
		PrintWriter out = response.getWriter();
		out.println("forwarding....일때는 이곳으로 응답이 돌아오지 않습니다....");
		
	}

}

/*
RequestDispatcher에는 forward방식과 include방식의 페이지 이동이 존재
1. forward방식
forward 하려는 페이지로 현재 서브릿의 전권을 가지고 서버상에서 다이렉트로 이동
제어권이 완전히 이동하는 jsp 페이지로 가버리기 때문에 다시 서블릿으로 되돌아오지 않는다.
그렇기 때문에 서블릿에서 PrintWriter 객체를 사용할 일이 전혀 없다.... 응답이 이곳에서 이뤄지지 않는다는 의미이다.

응답의 내용을 jsp이지만
출력된 결과창의 주소는 확인하면 전권을 가지고 이동했기 때문에 forwarding이 일어난 서블릿 주소가 뜨는 것을 확인할 수 있다.
-----------------------------------------------------------------------------------------
2.include방식
서블릿의 PrintWriter객체를 이용하려 한다면 include방식으로 페이지를 이동해야 한다.
include에 연결된 페이지의 모든 내용을 가지고 다시 서블릿으로 돌아오기 때문에 include한 다음에 있는 출력내용을 모두다
응답을 한다. 


forward, include방식이건
서버상에서 직접 다른 페이지를 호출하는 방식이기 때문에 페이지의 이동속도가 빠르다....
중요한 지점은 브라우저를 거치지 않는다는 점이다.... 서버상에서 바로 이동....
모든 페이지 연결방식의 80%이상이 forward방식을 사용
ServletRequest 객체 바인딩에 대해서 잘 다뤄야한다.
 */
