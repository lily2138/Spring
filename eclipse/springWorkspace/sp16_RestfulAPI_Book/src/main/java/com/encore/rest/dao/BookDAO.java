package com.encore.rest.dao;

import java.util.List;

import com.encore.rest.vo.Book;

public interface BookDAO {
	List<Book> getAllBook() throws Exception;
	Book getBook(String isbn) throws Exception;
	boolean insertBook(Book book) throws Exception;
	boolean updateBook(Book book) throws Exception;
	boolean deleteBook(String isbn) throws Exception;
}
