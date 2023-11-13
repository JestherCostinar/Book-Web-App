package com.jes.service;

import java.util.List;
import com.jes.model.Book;

public interface BookService {
	void createBook(Book book);
	void updateBook(Book book);
	List<Book> getAllBooks();
	void deleteBook(int id);
	Book findBookById(int id);
}