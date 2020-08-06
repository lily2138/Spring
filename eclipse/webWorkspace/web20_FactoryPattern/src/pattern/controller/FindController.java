package pattern.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pattern.model.Dao;
import pattern.model.NoteBook;

public class FindController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "find_fail.jsp";
		
		String model = request.getParameter("model");
		NoteBook notebook = Dao.getInstance().findNoteBook(model);
		request.setAttribute("notebook", notebook);
		path = "find_result.jsp";
		
		return path;
	}
	
}
