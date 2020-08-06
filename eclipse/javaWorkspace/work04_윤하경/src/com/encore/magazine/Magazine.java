package com.encore.magazine;

import com.encore.book.Book;

public class Magazine extends Book {
	private int year;
	private int month;
	
	
	public Magazine(String isbn, String title, String author, String publisher, double price, String desc,int year, int month) {
		super(isbn,title,author,publisher,price,desc);
		this.year = year;
		this.month = month;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getMonth() {
		return month;
	}


	public void setMonth(int month) {
		this.month = month;
	}
	
	//toString을 하면 return 값이 객체여서 나오는 주소값?이나오지 않고 진짜 값을 나오게한다.
	public String toString() {
		return super.toString()+","+year+","+month;
	}

	
	
}
