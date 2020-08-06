package com.encore;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/main.do")
public class MainServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		System.out.println(action);
		if (action.equals("wordCount")) {
			wordCount(request, response);
		} else if (action.equals("kickCount")) {
			kickCount(request, response);
		}
	}// process()

	private void wordCount(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		    
		String words = request.getParameter("words");
		
		String result = Count.execute(words);   //String result = new Count().execute(words)
		
		request.setAttribute("result", result);
	    request.getRequestDispatcher("Result.jsp").forward(request, response);	
	}
	private void kickCount(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String fname = request.getParameter("fname");
		
		//String path="C:/yhk/eclipse/webWorkspace/web27_Ajax_Algorithm_Template/WebContent/res";   // 중요합니다..채워넣어보세요
		
		String path=getServletContext().getRealPath("/res");
		
		System.out.println(path);
		File f=new File(path, fname);
		
		int result=Kickboard.execute(f);
	
		request.setAttribute("result", result);
	    request.getRequestDispatcher("Result.jsp").forward(request, response);	
	}
}
