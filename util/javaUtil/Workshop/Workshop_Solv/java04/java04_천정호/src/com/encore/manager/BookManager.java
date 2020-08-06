package com.encore.manager;

import com.encore.vo.Book;

/**
 * 
 * @author JungHo Cheon
 *
 */
public class BookManager {
	private int numberOfBooks;//0
	private Book[] books;
	private int idx;//0


	public BookManager() {
		/*numberOfBooks = 0;
		idx = 0;*/
		books = new Book[100];
	}
	
	public int getNumberOfBooks() {
		return numberOfBooks;
	}
	
	/**
	 * 
	 * @param book
	 * Book 객체를 추가함. 
	 */
	public void insertBook(Book book) {
		books[numberOfBooks++] = book;
	}
	
	/**
	 * 
	 * @return : 추가된 모든 Book 객체를 반환함.
	 */
	public Book[] getAllBook() {
		Book[] ret_books = new Book[idx];
		for(int i = 0; i < idx; i++) {
			ret_books[i] = books[i];
		}
		return ret_books;
	}
	
	/**
	 * 
	 * @param isbn : 찾고자 하는 책의 isbn
	 * @return : 입력된 isdn과 일치하는 책을 반환. 찾지 못할 경우 null 반환
	 */
	public Book searchBookByIsbn(String isbn) {
		for(int i = 0; i < idx; i++) {
			if (books[i].getIsbn().equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param title : 찾고자 하는 책들의 제목
	 * @return : title과 일치하는 책들을 반환. 찾지 못할 경우 null 반환
	 */
	public Book[] searchBookByTitle(String title) {
		Book[] search_books = new Book[idx];
		int ret_idx = 0;
		int count = 0;
		for(int i = 0; i < idx; i++) {
			if (books[i].getTitle().equals(title)) {
				search_books[ret_idx++] = books[i];
				count++;
			}
		}
		if (0 < count) {
			Book[] ret_books = new Book[count];
			System.arraycopy(search_books, 0, ret_books, 0, count);
			return ret_books;
		}
		return null;
	}
	
	
	/**
	 * 
	 * @param publisher : 찾고자 하는 책들의 출판사 
	 * @return : 출판사가 일치하는 책들을 반환. 없는 경우 null 반환
	 */
	public Book[] searchBookByPublisher(String publisher) {
		Book[] search_books = new Book[idx];
		int ret_idx = 0;
		int count = 0;
		for(int i = 0; i < idx; i++) {
			if (books[i].getPublisher().equals(publisher)) {
				search_books[ret_idx++] = books[i];
				count++;
			}
		}
		if (0 < count) {
			Book[] ret_books = new Book[count];
			System.arraycopy(search_books, 0, ret_books, 0, count);
			return ret_books;
		}
		return null;
	}
	
	/**
	 * 
	 * @param price : 찾고자 하는 책들의 가격
	 * @return : 가격이 일치하는 책들을 반환. 없는 경우 null 반환
	 */
	public Book[] searchBookByPrice(double price) {
		Book[] search_books = new Book[idx];
		int ret_idx = 0;
		int count = 0;
		for(int i = 0; i < idx; i++) {
			if (books[i].getPrice() == price) {
				search_books[ret_idx++] = books[i];
				count++;
			}
		}
		if (0 < count) {
			Book[] ret_books = new Book[count];
			System.arraycopy(search_books, 0, ret_books, 0, count);
			return ret_books;
		}
		return null;
	}
	
	/**
	 * 
	 * @return : 추가된 모든 책들의 가격의 합을 반환.
	 */
	public double getSumPriceOfBooks() {
		int total = 0;
		for(int i = 0; i < idx; i++) {
			total += books[i].getPrice();
		}
		return total;
	}
		
	/**
	 * 
	 * @return : 추가된 모든 책들의 평균 가격을 반환.
	 */
	public double getAveragePriceOfBooks() {
		return getSumPriceOfBooks() / idx;
	}
	
}
