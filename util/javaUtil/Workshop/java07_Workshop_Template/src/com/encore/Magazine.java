package com.encore;

public class Magazine extends Book{
	private int year;
	private int month;
	
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year,
			int month) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+", year : "+year+", month : "+month;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}
}
