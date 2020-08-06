package com.encore.manager;

import com.encore.vo.Book;

/*
 * BookManager 인터페이스는 다양한 Book 객체들을 핸들링하는 템플릿기능을 가지고 있다. 
 */
public interface BookManager {
	int getNumberOfBooks();
	void insertBook(Book book);
	Book[] getAllBook();
	Book searchBookByIsbn(String isbn);
	Book[] searchBookByTitle(String title);
	Book[] searchBookByPublisher(String publisher);
	Book[] searchBookByPrice(double price);
	double getSumPriceOfBooks();
	double getAveragePriceOfBooks();
}
