package com.encore;

import java.util.ArrayList;

public class BookMgrImpl implements BookMgr{
	private ArrayList<Book> books = null;
	
	private static BookMgrImpl mgr = new BookMgrImpl();
	private BookMgrImpl() {
		books = new ArrayList<Book>();
	}
	public static BookMgrImpl getInstance() {
		return  mgr;
	}
	@Override
	public void addBook(Book b) {
		//
	}

	@Override
	public ArrayList<Book> getAllBook() {
		return null;
	}

	@Override
	public Book searchBookByIsbn(String isbn) {
		return null;
	}

	@Override
	public ArrayList<Book> searchBookByTitle(String title) {
		
		return null;
	}

	@Override
	public ArrayList<Book> onlySearchBook() {
		
		return null;
	}

	@Override
	public ArrayList<Book> onlySearchMagazin() {
		return null;
	}

	@Override
	public ArrayList<Book> magazineOfThisYearInfo(int year) {
		return null;
	}

	@Override
	public ArrayList<Book> searchBookByPublish(String publish) {
		return null;
	}

	@Override
	public ArrayList<Book> searchBookByPrice(int price) {
		return null;
	}

	@Override
	public int getTotalPrice() {
		return 0;
	}
	@Override
	public int getAvgPrice() {		
		return 0;
	}
}
