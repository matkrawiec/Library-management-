package com.mk.service;

import java.util.List;

import com.mk.entity.Book;
import com.mk.entity.Customer;
import com.mk.entity.Rental;

public interface RentalService {
	
	public List<Rental> getRentals();

	public void saveRental(Rental rental);

	public void createNewEntry(Customer theCustomer, Book theBook);

	public Rental getRental(int theId);

	public void update(Book theBook, Rental theRental);

	public List<Rental> getAllRentals();



}









