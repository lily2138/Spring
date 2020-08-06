package controller;

import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class detailViewController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemNum = Integer.parseInt(request.getParameter("itemnumber"));
		String path = "";
		try {
			
			//조회수먼저 하고 상세보기가 돌아가야함 
			boolean result = ItemDao.getInstance().addCount(itemNum);
			Item item = ItemDao.getInstance().getItem(itemNum);
			
			
			////////////////////////// 오늘 본 상품정보를 저장하는 쿠키 로직을 추가 /////////////////////////
			// 1) 쿠키생성 + 2) 생성한 쿠키를 웹브라우저로 보냄
			
			Cookie cookie = new Cookie("fruitshop"+itemNum+"", item.getUrl());
			cookie.setMaxAge(24*60*60);
			response.addCookie(cookie);
			
			
			
			request.setAttribute("item", item);
			path = "detailView.jsp";
			
		}catch(SQLException e) {
			
		}
		return new ModelAndView(path);
	}

}
