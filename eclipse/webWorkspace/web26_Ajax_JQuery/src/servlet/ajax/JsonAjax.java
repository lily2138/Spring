package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
//Json형식의 비동기 코드를 작성하려면.... json 라이브러리가 필요하다....

import domain.Food;

@WebServlet("/JsonAjax")
public class JsonAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		//JSONObject 객체를 하나 생성.... json.jar가 필요하다
		
		JSONObject json = new JSONObject();
		
/*		json.put("name", "Jason");
		json.put("age", 26);
		json.put("addr", "Texas");
		
		out.print(json);*/
		
		
		Food food = new Food();
		food.setMaker("Banana");
		food.setPrice(2000);
		json.put("food", food);
		
		out.print(json);
		
	}

}
