package com.encore.rest.service;

import java.util.List;

import com.encore.rest.vo.Book;

public interface BookService {
	List<Book> getAllBook() throws Exception;
	Book getBook(String isbn) throws Exception;
	boolean insertBook(Book book) throws Exception;
	boolean updateBook(Book book) throws Exception;
	boolean deleteBook(String isbn) throws Exception;
}
