package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class ItemViewController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemnum =Integer.parseInt(request.getParameter("itemnumber"));
		
		boolean result = ItemDao.getInstance().updateRecordCount(itemnum);
		System.out.println("count update? "+result);
		
		Item item=ItemDao.getInstance().getItem(itemnum);
		System.out.println("Item "+item);
		
		
		///////////////////// 오늘 본 상품정보를 저장하는 쿠키 로직을 추가  /////////////////
		// 1) 쿠키 생성   + 2) 생성한 쿠키를 웹브라우저로 보냄
		
		Cookie cookie = new Cookie("fruitshop"+itemnum, item.getUrl());
		cookie.setMaxAge(24*60*60);		
		response.addCookie(cookie);
		
		
		request.setAttribute("item", item);
		return new ModelAndView("itemView.jsp");
	}
}









