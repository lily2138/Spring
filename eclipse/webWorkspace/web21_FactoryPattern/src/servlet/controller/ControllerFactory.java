package servlet.controller;

public class ControllerFactory {
	private static ControllerFactory factory = new ControllerFactory();
	private ControllerFactory() {}
	public static ControllerFactory getInstance() {
		return factory;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("findId")) {
			controller = new FindController();
		}
		return controller;
	}
}
