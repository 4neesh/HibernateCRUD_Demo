package com.aneesh.springdemo.dao;

import java.util.List;

import com.aneesh.springdemo.entity.Customer;

public interface CustomerDao {

	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer modelCustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
}
