package com.encore.test;

import com.encore.book.Book;
import com.encore.magazine.Magazine;
import com.encore.manager.BookManager;

public class Test {
	
	
	public static void printBooks(Book[] books) {
		for (Book book : books) {
			System.out.println(book.toString());
		}
	}

	public static void main(String[] args) {

		//1. BookManager객체 생성
		BookManager bookManager = new BookManager();

		Book b1 = new Book("b1", "책1", "지은이1", "출판사1", 9000, "내용1");
		Book b2 = new Book("b2", "책2", "지은이2", "출판사2", 9000, "내용2");
		Book b3 = new Book("b3", "책3", "지은이3", "출판사3", 9000, "내용3");
		Book b4 = new Book("b4", "책4", "지은이4", "출판사4", 9000, "내용4");
		Book b5 = new Book("b5", "책5", "지은이5", "출판사5", 9000, "내용5");
		Book b6 = new Book("b6", "책6", "지은이6", "출판사6", 9000, "내용6");
		Book b7 = new Magazine("M1", "메거진1", "메거진지은이1", "메거진출판사1", 10000, "내용1",2019,4);
		Book b8 = new Magazine("M2", "메거진2", "메거진지은이2", "메거진출판사2", 10000, "내용2",2019,4);
		Book b9 = new Magazine("M3", "메거진3", "메거진지은이3", "메거진출판사3", 10000, "내용3",2019,4);
		
		//2. books 라는 배열에 모두 넣기
		Book[] books = { b1, b2, b3, b4, b5, b6, b7, b8, b9 };
		
		
		System.out.println("============================= printBooks() ==============================");
		printBooks(books);
		
		System.out.println("======================= bookManager.insertBook() ========================");
		for (Book b : books) {
			bookManager.insertBook(b);
		}
		
		System.out.println("======================== bookManager.getAllBook() ========================");
		Book[] allbooks = bookManager.getAllBook();
		printBooks(allbooks);
		
		System.out.println("================ bookManager.searchBookByIsbn ==================");
		System.out.println(bookManager.searchBookByIsbn("b1").toString());
		
		System.out.println("================ bookManager.searchBookByTitle =================");
		printBooks(bookManager.searchBookByTitle("메거진1"));
		

		System.out.println("=============== bookManager.searchBookByPublisher ================");
		printBooks(bookManager.searchBookByPublisher("출판사4"));
		
		System.out.println();
		System.out.println("================ bookManager.searchBookByPrice(10000.0) =================");
		printBooks(bookManager.searchBookByPrice(10000.0));
		

		System.out.println("=================== bookManager.getSumPriceOfBooks() ====================");
		System.out.println(bookManager.getSumPriceOfBooks());
		
		System.out.println();
		System.out.println("================== bookManager.getAveragePriceOfBooks() =================");
		System.out.println(bookManager.getAveragePriceOfBooks());
		
		

		

	}

}
