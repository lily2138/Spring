package com.encore.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.rest.service.BookService;
import com.encore.rest.vo.Book;

@RestController
@RequestMapping("api")
public class BookRestController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/book")
	public ResponseEntity<List<Book>> getAllBook() throws Exception { 
		List<Book> books = bookService.getAllBook();
		if(books.isEmpty())
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@GetMapping("/book/{isbn}")
	public ResponseEntity<Book> getBook(@PathVariable String isbn) throws Exception {
		Book book = bookService.getBook(isbn);
		if(book==null)
			return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	
	@PostMapping("/book")
	public ResponseEntity<List<Book>> insertBook(@RequestBody Book book) throws Exception {
		boolean check = bookService.insertBook(book);
		System.out.println(check);
		if(!check)
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<Book>>(HttpStatus.OK);

	}
	
	@PutMapping("/book")
	public ResponseEntity<List<Book>> updateBook(@RequestBody Book book) throws Exception {
		boolean check = bookService.updateBook(book);
		System.out.println(check);
		if(!check)
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<Book>>(HttpStatus.OK);

	}
	
	@DeleteMapping("book/{isbn}")
	public ResponseEntity<List<Book>> deleteeBook(@PathVariable String isbn) throws Exception {
		boolean check = bookService.deleteBook(isbn);
		System.out.println(check);
		if(!check)
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<Book>>(HttpStatus.OK);

	}
	
}
