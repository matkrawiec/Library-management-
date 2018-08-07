package com.mk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mk.entity.Book;

@Repository
public class BookDAOImpl implements BookDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Book> getAllBooks() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Book> theQuery = currentSession.createQuery("from Book", Book.class);
		List<Book> books = theQuery.getResultList();
		return books;
	}


	@Override
	public List<Book> getAllAvailableBooks() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Book> theQuery = currentSession.createQuery("FROM Book WHERE availability LIKE 'yes'", Book.class);
		List<Book> books = theQuery.getResultList();
		return books;
	}


	@Override
	public List<Book> getAllIssuedBooks() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Book> theQuery = currentSession.createQuery("FROM Book WHERE availability LIKE 'no'", Book.class);
		List<Book> books = theQuery.getResultList();
		return books;
	}


	@Override
	public List<Book> getAllLostBooks() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Book> theQuery = currentSession.createQuery("FROM Book WHERE availability LIKE 'lost'", Book.class);
		List<Book> books = theQuery.getResultList();
		return books;
	}


	@Override
	public void saveBook(Book theBook) {
		Session currentSession = sessionFactory.getCurrentSession();
		theBook.setAvailability("yes");
		currentSession.saveOrUpdate(theBook);
		
	}


	@Override
	public Book getBook(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Book theBook = currentSession.get(Book.class, theId);
		return theBook;
	}


	@Override
	public void updateBook(Book theBook) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theBook);
	
	}


	@Override
	public List<Book> searchBooks(String theSearchName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Book> theQuery = null;
		if (theSearchName != null && theSearchName.trim().length() > 0) {
			theQuery = currentSession.createQuery("FROM Book WHERE"
					+ " lower(author) like :theName or lower(title) like :theName", Book.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		} else {
			theQuery = currentSession.createQuery("FROM Book WHERE availability LIKE 'yes'", Book.class);
		}
		List<Book> theBooks = theQuery.getResultList();
		return theBooks;
	}



}

















