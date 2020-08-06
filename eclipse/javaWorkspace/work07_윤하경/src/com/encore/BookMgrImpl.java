package com.encore;

import java.util.ArrayList;
import com.encore.Magazine;
import com.encore.Book;

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
		boolean find = false;
		for(Book book :books) {
			if(b.getIsbn().equals(book.getIsbn())) { //이미 그런책이 있다면.
				find = true;
				System.out.println(b.getIsbn()+"책은 이미 등록되어있습니다..");
				return;
			}
		}
		if(find==false) {	//추가하고자 하는 사람ㅇ느 기존의 리스트에는 없다
			books.add(b);
			System.out.println(b.getIsbn()+"책이 등록되었습니다.");

		}
	}

	@Override
	public ArrayList<Book> getAllBook() {
		
		return books;
	}

	@Override
	public Book searchBookByIsbn(String isbn) {
		boolean find = false;
		Book book = null;
		for(Book b : books) {
			if(b.getIsbn().equals(isbn)){
				find = true;
				book = b;
			}
		}
		if(find==false) {
			System.out.println("그런책은 없습니다");
		}
		return book;
	}

	@Override
	public ArrayList<Book> searchBookByTitle(String title) {
		boolean find = false;
		ArrayList<Book> searchList= new ArrayList<>();
		for(Book b : books) {
			if(b.getIsbn().equals(title)){
				find = true;
				searchList.add(b);
			}
		}
		if(find==false) {
			System.out.println("그런책은 없습니다");
		}
		return searchList;
	}

	@Override
	public ArrayList<Book> onlySearchBook() {
		ArrayList<Book> onlyBook= new ArrayList<>();
		for(Book b : books) {
			if (b instanceof Magazine) {
				continue;
			}
			else
				onlyBook.add(b);
		}
		return onlyBook;
	}

	@Override
	public ArrayList<Book> onlySearchMagazin() {
		ArrayList<Book> onlyMagazin= new ArrayList<>();
		for(Book m : books) {
			if (m instanceof Magazine) {
				onlyMagazin.add(m);
			}
		}
		return onlyMagazin;
	}

	@Override
	public ArrayList<Book> magazineOfThisYearInfo(int year) {
		boolean find = false;
		ArrayList<Book> magazineYear= new ArrayList<>();
		for(Book m : books) {
			if (m instanceof Magazine) {
				if(((Magazine) m).getYear()==year) {
					find = true;
					magazineYear.add(m);
				}
				
			}
		}
		if(find==false) {
			System.out.println("그런잡지는 없습니다");
		}
		return magazineYear;
	}

	@Override
	public ArrayList<Book> searchBookByPublish(String publish) {
		boolean find = false;
		ArrayList<Book> bookPublish= new ArrayList<>();
		for(Book b : books) {
			if(b.getPublisher().equals(publish)){
				find = true;
				bookPublish.add(b);
			}
		}
		if(find==false) {
			System.out.println("그런책은 없습니다");
		}
		return bookPublish;
	}

	@Override
	public ArrayList<Book> searchBookByPrice(int price) {
		boolean find = false;
		ArrayList<Book> bookPrice= new ArrayList<>();
		for(Book b : books) {
			if(b.getPrice()<=price){
				find = true;
				bookPrice.add(b);
			}
		}
		if(find==false) {
			System.out.println("그런책은 없습니다");
		}
		return bookPrice;
	}

	@Override
	public int getTotalPrice() {
		int total = 0;
		for(Book b : books) {
			total += b.getPrice();
		}
		return total;
	}
	
	
	@Override
	public int getAvgPrice() {	
		
		return getTotalPrice()/books.size();
	}
}
