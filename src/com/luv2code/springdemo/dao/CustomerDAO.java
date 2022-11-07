package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public Customer getCustomer(int id);
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

}
