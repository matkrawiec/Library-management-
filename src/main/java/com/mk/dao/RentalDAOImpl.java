package com.mk.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mk.entity.Book;
import com.mk.entity.Customer;
import com.mk.entity.Rental;

@Repository
public class RentalDAOImpl implements RentalDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Rental> getRentals() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Rental> theQuery = currentSession.createQuery("SELECT r FROM Rental r INNER JOIN r.customer INNER JOIN r.book WHERE return_date is null", Rental.class);
		List<Rental> rentals = theQuery.getResultList();
		return rentals;
	}

	@Override
	public void saveRental(Rental rental) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(rental);
	}


	@Override
	public void createNewEntry(Customer theCustomer, Book theBook) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
	    Session currentSession = sessionFactory.getCurrentSession();
		theBook.setAvailability("no");
	    Rental rental = new Rental();
	    rental.setBook(theBook);
	    rental.setCustomer(theCustomer);
	    rental.setIssueDate(date);
	    currentSession.saveOrUpdate(rental);

	}

	
	@Override
	public Rental getRental(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Rental theRental = currentSession.get(Rental.class, theId);
		return theRental;
	}

	@Override
	public void update(Book theBook, Rental theRental) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Session currentSession = sessionFactory.getCurrentSession();
		theBook.setAvailability("yes");
		theRental.setReturnDate(date);
		theRental.setBook(theBook);
		currentSession.update(theRental);

		
	}

	@Override
	public List<Rental> getAllRentals() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Rental> theQuery = currentSession.createQuery("SELECT r FROM Rental r INNER JOIN r.customer INNER JOIN r.book", Rental.class );
		List<Rental> allRentals = theQuery.getResultList();
		return allRentals;
	}


}






















