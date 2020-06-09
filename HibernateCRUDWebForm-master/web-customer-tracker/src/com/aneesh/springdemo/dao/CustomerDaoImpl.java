package com.aneesh.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aneesh.springdemo.entity.Customer;

@Repository //this is applied to DAO implementations for scanning
public class CustomerDaoImpl implements CustomerDao{

	//need to inject session factory dependency
	@Autowired
	private SessionFactory sessionFactory;

	//need to inject 
	
	@Override
	public List<Customer> getCustomers() {

		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create query
		Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//get customer list from the query
		List<Customer> customerList = query.getResultList();
		
		//return customers from the query
		return customerList;
	}

	@Override
	public void saveCustomer(Customer modelCustomer) {

		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		//save the customer to database
		currentSession.saveOrUpdate(modelCustomer);
	}

	@Override
	public Customer getCustomer(int id) {

		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(int id) {

		Session currentSession = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = currentSession.createQuery("delete from Customer where id=: customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
	}

}
