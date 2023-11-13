package com.jes.dao;

import java.util.List;
import com.jes.model.Book;

public interface BookRepository {
	void addBook(Book book);
	void updateBook(Book book);
	List<Book> selectAll();
	void delete(int id);
	Book selectOne(int id);
}
