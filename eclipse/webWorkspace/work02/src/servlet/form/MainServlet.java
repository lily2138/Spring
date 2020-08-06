package servlet.form;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.loginVO.User;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String path = "";
    private ArrayList<User> users;
    
	public void init() throws ServletException {
    	this.path = getInitParameter("path");   //web.xml을 읽은후 Servlet의 기본생성자로 인스턴스를 만드므로 추가적인 초기화는 init()에서 web.xml의 parm을 읽어오는 방법을 쓴다.
    	users = new ArrayList<User>();
    	try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = "";
			String[] userInfo = null;
			while((line = br.readLine()) != null){
				userInfo = line.split(" ");
				User user = new User(userInfo[0], userInfo[1], userInfo[2], userInfo[3], userInfo[4]);
				users.add(user);
			}
			br.close();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		      
		String id = request.getParameter("userId");
		String pass = request.getParameter("userPass");
		  
		User tempUser = null;
		for(User user: users) {
			if(user.getId().equals(id)) {
				tempUser = user;
				break;
			}
		}
		
		if(tempUser == null) {
			System.out.println("none id");
			response.sendRedirect("LoginError");  //id가 존재하지 않을때. 
		}
		else {
			if(tempUser.getPassword().equals(pass)) {
				response.sendRedirect("LoginSuccess?i="+id+"&p="+pass);  //객체가 넘겨지는지 확인해봐야겠음.
			}
			else {
				response.sendRedirect("LoginError?i=\"+id+\"&p=\"+pass");
			}
		}
		
		
	}

}
