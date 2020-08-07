package com.encore.spring.model;

import java.sql.SQLException;
import java.util.List;

import com.encore.spring.domain.Item;

public interface ItemService {
	
	List<Item> getAllItem() throws Exception;
	Item getItem(int itemid) throws SQLException;
	
	//void updateItem(int itemid) throws SQLException;
	
}
