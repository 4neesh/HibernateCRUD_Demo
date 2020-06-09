package com.aneesh.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.aneesh.hibernate.demo.entity.Course;
import com.aneesh.hibernate.demo.entity.Instructor;
import com.aneesh.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
								
				
		Session session = factory.getCurrentSession();
		
		try {		
			
			//start transaction			
			session.beginTransaction();
			
			//id of instructor
			int id = 1;

			//hibernate query with HQL
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
							+ "JOIN FETCH i.courses where"
							+ " i.id = :theInstructorId", Instructor.class);
			
			//set parameter used in query
			query.setParameter("theInstructorId",id);
			
			Instructor instructor = query.getSingleResult();
			
			System.out.println("instructor: " + instructor);
			
			session.getTransaction().commit();

			session.close();

			System.out.println("aneesh: Done!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
			
		}
		
	}
	
}
