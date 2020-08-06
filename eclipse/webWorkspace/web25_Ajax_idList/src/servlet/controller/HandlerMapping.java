package servlet.controller;

public class HandlerMapping {
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("find.do")) {
			controller = new FindController();
			System.out.println("FindController 생성됨");
			
		}else if(command.equals("login.do")) {
			controller = new LoginController();
			System.out.println("LoginController 생성됨");
			
		}else if(command.equals("logout.do")) {
			controller = new LogoutController();
			System.out.println("LogoutController 생성됨");
			
		}else if(command.equals("register.do")) {
			controller = new RegisterController();
			System.out.println("RegisterController 생성됨");
			
		}else if(command.equals("allMember.do")) {
			controller = new AllMemberController();
			System.out.println("AllMemberController 생성됨");
		
		}else if(command.equals("update.do")) {
			controller = new UpdateController();
			System.out.println("UpdateController 생성됨");
			
		}else if(command.equals("idList.do")) {
			controller = new IdListController();
			System.out.println("IdListController 생성됨");
			
		}else if(command.equals("idCheck.do")) {
			controller = new IdCheckController();
			System.out.println("IdCheckController 생성됨");
		}
		
		return controller;
	}
}
