package servlet.loginForm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import servlet.loginVO.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String path = "";
    private ArrayList<User> users;
    
    public LoginForm() {
        super();
    }
    //베타 버전입니다. 
    @Override
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
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("userId");
		String password = request.getParameter("userPassword");
		
		User tempUser = null;
		for(User user: users) {
			if(user.getId().equals(id)) {
				tempUser = user;
				break;
			}
		}
		if(tempUser == null) {
			System.out.println("none id");
			response.sendRedirect("LE");  //id가 존재하지 않을때. 
		}
		else {
			if(tempUser.getPassword().equals(password)) {
				response.sendRedirect("LS?id="+id);  //객체가 넘겨지는지 확인해봐야겠음.
			}
			else {
				response.sendRedirect("LE");
			}
		}
	}
	@Override
	public void destroy() {
		super.destroy();
	}
}
