package com.encore.manager;

import com.encore.book.Book;

public class BookManager{
	private int numberOfBooks;//books 인덱스
	//book들의 배열 선언
	Book[ ] books;

	public BookManager() {
		books = new Book[100];
	}
	
	
	public int getNumberOfBooks() {
		return numberOfBooks;
	}

	public void insertBook(Book b) {
		books[numberOfBooks++] = b;
	}
	
	public Book[] getAllBook() {
		Book[] allBooks = new Book[numberOfBooks];
		for(int i=0; i<numberOfBooks; i++) {
			allBooks[i]=books[i];
		}
		return allBooks;
	}
	
	public Book searchBookByIsbn(String isbn) {
		Book bo = null;
		for(int i=0; i<numberOfBooks; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				bo=books[i];
				break;
			}
			else {
				return null;
			}
		}
		return bo;
	}
	
	//총배열크기보다 여기서 나온 배열크기는 더 작기 때문에 print할 때 주의
	public Book[] searchBookByTitle(String title) {
		Book[] searchBooks = new Book[numberOfBooks];
		int temp=0;
		for(int i=0; i<numberOfBooks; i++) {
			if(books[i].getTitle().equals(title)) {
				searchBooks[temp++]=books[i];
			}
		}
		Book[] realBooks = new Book[temp];
		for(int i=0; i<temp; i++) {
			realBooks[i] = searchBooks[i];
		}
		return realBooks;
	}
	
	//총배열크기보다 여기서 나온 배열크기는 더 작기 때문에 print할 때 주의
	public Book[] searchBookByPublisher(String publisher) {
		Book[] searchBooks = new Book[numberOfBooks];
		int temp=0;
		for(int i=0; i<numberOfBooks; i++) {
			if(books[i].getPublisher().equals(publisher)) {
				searchBooks[temp++]=books[i];
			}
		}
		Book[] realBooks = new Book[temp];
		for(int i=0; i<temp; i++) {
			realBooks[i] = searchBooks[i];
		}
		return realBooks;
	}
	
	public Book[] searchBookByPrice(double price) {
		Book[] searchBooks = new Book[numberOfBooks];
		int temp=0;
		for(int i = 0; i < numberOfBooks; i++) {
			if (books[i].getPrice() == price) {
				searchBooks[temp++]=books[i];
			}
		}
		Book[] realBooks = new Book[temp];
		for(int i=0; i<temp; i++) {
			realBooks[i] = searchBooks[i];
		}
		return realBooks;
	}
	
	public double getSumPriceOfBooks() {
		double sum = 0;
		for(int i=0; i<numberOfBooks; i++) {
			sum+=books[i].getPrice();
		}
		return sum;
	}
	
	public double getAveragePriceOfBooks() {
		
		double avg = getSumPriceOfBooks()/numberOfBooks;
		
		return avg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
