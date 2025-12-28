package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@RestController
public class BookController {
	
	@Autowired
	private IBookService bookService;

	//http://localhost:8080/books
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return bookService.getAll();
		
		
	}
	
	//http://localhost:8080/books/bookid/1
	@GetMapping("/books/bookid/{bookId}")
	public Book getById( @PathVariable int bookId) {
		return bookService.getById(bookId);
		
	}
	
	//http://localhost:8080/books/author?authour=Kathy
	@GetMapping("/books/author")
	public List<Book> getBooksByAuthor(@RequestParam String author){
		return bookService.getByAuthor(author);
		
	}
}
