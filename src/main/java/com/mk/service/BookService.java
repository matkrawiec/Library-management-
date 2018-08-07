package com.mk.service;

import java.util.List;

import com.mk.entity.Book;

public interface BookService {

	public List<Book> getAllBooks();
	
	public List<Book> getAllAvailableBooks();
	
	public List<Book> getAllIssuedBooks();
	
	public List<Book> getAllLostBooks();

	public void saveBook(Book theBook);

	public Book getBook(int bookId);

	public void updateBook(Book theBook);

	public List<Book> searchBooks(String theSearchName);

	
}






