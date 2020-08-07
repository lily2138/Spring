package com.encore.spring.model.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.spring.domain.Item;
import com.encore.spring.model.ItemDAO;
import com.encore.spring.model.ItemService;

@Service
public class ItemServiceImpl implements ItemService {	//

	@Autowired
	private ItemDAO itemDao;    //실제클래스가 코드에 노출되면 안되므로 인터페이스로 한다.
	
	
	public List<Item> getAllItem() throws Exception{
		List<Item> result = itemDao.getAllItem();
		return result;
	}
	
	public Item getItem(int itemid) throws SQLException{
		Item item = itemDao.getItem(itemid);
			return item;
	}
	
}






















