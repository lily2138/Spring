package servlet.controller;

public class HandlerMapping {
	
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return handler;
	}	
	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("subject")) {
			controller = new SubjectController();
			System.out.println("SubjectController Creating...");
		}else if(command.equals("company")) {
			controller = new CompanyController();
			System.out.println("CompanyController Creating...");
		}
		return controller;
	}
}
