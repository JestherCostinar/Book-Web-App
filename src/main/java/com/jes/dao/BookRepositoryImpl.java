package com.jes.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jes.model.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository("book_repository")
public class BookRepositoryImpl implements BookRepository{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void addBook(Book book) {
		entityManager.persist(book);
	}

	@Override
	public void updateBook(Book book) {
		Book existingBook = entityManager.find(Book.class, book.getId());
		existingBook.setTitle(book.getTitle());
	}

	@Override
	public List<Book> selectAll() {
		TypedQuery<Book> query = entityManager.createQuery("SELECT b from Book b", Book.class);
		return query.getResultList();	
	}

	@Override
	public void delete(int id) {
		Book existingBook = entityManager.find(Book.class, id);
		entityManager.remove(existingBook);
		
	}

	@Override
	public Book selectOne(int id) {
		return entityManager.find(Book.class, id);		
	}
}
