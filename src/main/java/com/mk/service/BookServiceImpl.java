package com.mk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mk.dao.BookDAO;
import com.mk.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;
	
	@Override
	@Transactional
	public List<Book> getAllBooks() {
		return bookDAO.getAllBooks();
	}

	@Override
	@Transactional
	public List<Book> getAllAvailableBooks() {
		return bookDAO.getAllAvailableBooks();
	}

	@Override
	@Transactional
	public List<Book> getAllIssuedBooks() {
		return bookDAO.getAllIssuedBooks();
	}

	@Override
	@Transactional
	public List<Book> getAllLostBooks() {
		return bookDAO.getAllLostBooks();
	}

	@Override
	@Transactional
	public void saveBook(Book theBook) {
		bookDAO.saveBook(theBook);
		
	}

	@Override
	@Transactional
	public Book getBook(int theId) {
		return bookDAO.getBook(theId);	}

	@Override
	@Transactional
	public void updateBook(Book theBook) {
		bookDAO.updateBook(theBook);
	}

	@Override
	@Transactional
	public List<Book> searchBooks(String theSearchName) {
		return bookDAO.searchBooks(theSearchName);
	}


}














