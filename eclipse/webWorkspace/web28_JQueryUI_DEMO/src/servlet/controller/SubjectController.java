package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubjectController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("getSubjectCopntroller....진입..");
		//비지니스로직 호출...결과값 리턴 받았다 치고...
		String result = "Algorithm | Big Data | Deep Learning | Restful API | Vue.js";
		
		request.setAttribute("result", result);
		
		return new ModelAndView("Result.jsp");//forwarding방식으로 이동..
	}
}
