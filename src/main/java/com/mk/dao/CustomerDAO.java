package com.mk.dao;

import java.util.List;

import com.mk.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getAllCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

}
