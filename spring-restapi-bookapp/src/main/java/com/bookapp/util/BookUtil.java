package com.bookapp.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookapp.model.Book;

@Component
public class BookUtil {
	
	public List<Book> showBooks(){
		
		return Arrays.asList(
				new Book("Java in Action", "Kathy", 1),
				new Book("Seven Habits", "Ram", 2),
				new Book("Java", "Sai", 3),
				new Book("Spring", "Jeshu", 4),
				new Book("SQL", "Achu", 5)
				
				
				);
				
		
	}

}
