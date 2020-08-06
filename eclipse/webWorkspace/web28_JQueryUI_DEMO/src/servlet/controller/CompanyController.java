package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompanyController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CompanyController....진입....");
		
		String result = "<ul><li> Tomato System </li><br>"
				+ "<li> Ahn Lab Coporation </li><br>"
				+ "<li> East Engineering </li><br>"
				+ "<li> NcSoft Systems </li><br>"
				+ "<li> Encore Softmax Academy </li></ul><br>";
		
		request.setAttribute("result", result);
		
		return new ModelAndView("Result.jsp");
	}

}
