package com.aneesh.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aneesh.springdemo.dao.CustomerDao;
import com.aneesh.springdemo.entity.Customer;

//services will manage our transactions
@Service
public class CustomerServiceImpl implements CustomerService {

	
	//inject customer dao
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {

						
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer modelCustomer) {

		customerDao.saveCustomer(modelCustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		
		//return customer from the session
		return customerDao.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {

		customerDao.deleteCustomer(id);
		
	}

}
