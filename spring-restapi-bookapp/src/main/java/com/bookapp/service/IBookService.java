package com.bookapp.service;

import java.util.List;

import com.bookapp.model.Book;

public interface IBookService {
	
	List<Book> getAll();
	List<Book> getByAuthor(String author);
	Book getById(int bookId);
	

}
