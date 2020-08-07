package controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class ItemListController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		////////////////// 브라우저의 모든 쿠키 정보를 받아오는 로직 ///////////////////////
		ArrayList<String> fruits = new ArrayList<>();
		
		Cookie[ ] cs=request.getCookies();
		if(cs!=null) {
			for(Cookie c : cs) {
				if(c.getName().startsWith("fruitshop")) {
					fruits.add(c.getValue());
				}
			}
		}
		//Attribute에 바인딩
		request.setAttribute("fruits", fruits);		
		//request.setAttribute("length", fruits.size());
		
		ArrayList<Item> list=ItemDao.getInstance().getAllItem();
		request.setAttribute("list", list);
		return new ModelAndView("itemList.jsp");
	}
}
