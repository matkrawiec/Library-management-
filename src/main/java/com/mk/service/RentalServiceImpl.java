package com.mk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mk.dao.RentalDAO;
import com.mk.entity.Book;
import com.mk.entity.Customer;
import com.mk.entity.Rental;

@Service
public class RentalServiceImpl implements RentalService {
	
	@Autowired
	private RentalDAO rentalDAO;

	@Override
	@Transactional
	public List<Rental> getRentals() {
		return rentalDAO.getRentals();
	}

	@Override
	@Transactional
	public void saveRental(Rental rental) {
		rentalDAO.saveRental(rental);
	}

	@Override
	@Transactional
	public void createNewEntry(Customer theCustomer, Book theBook) {
		rentalDAO.createNewEntry(theCustomer, theBook);
	}


	@Override
	@Transactional
	public Rental getRental(int theId) {
		return rentalDAO.getRental(theId);
	}

	@Override
	@Transactional
	public void update(Book theBook, Rental theRental) {
		rentalDAO.update(theBook, theRental);
	}

	@Override
	@Transactional
	public List<Rental> getAllRentals() {
		return rentalDAO.getAllRentals();
	}

	



	
	
	
	
	
	
	
	
	
	
	
	
	
	

}







