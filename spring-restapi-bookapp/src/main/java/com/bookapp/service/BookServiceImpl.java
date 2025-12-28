package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.model.Book;
import com.bookapp.util.BookUtil;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private BookUtil bookUtil;

	@Override
	public List<Book> getAll() {
		return bookUtil.showBooks();
	}

	@Override
	public List<Book> getByAuthor(String author) {
		return bookUtil.showBooks().stream()
				.filter(book -> book.getAuthor().equals(author))
				.toList();

	}

	@Override
	public Book getById(int bookId) {

		return bookUtil.showBooks().stream()
				.filter(book -> book.getBookId() == bookId)
				.findFirst()
				.get();
	}

}
