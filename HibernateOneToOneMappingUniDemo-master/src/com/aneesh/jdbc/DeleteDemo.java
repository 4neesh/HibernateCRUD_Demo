package com.aneesh.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aneesh.hibernate.demo.entity.Instructor;
import com.aneesh.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
								
				
		Session session = factory.getCurrentSession();
		
		try {
					
			
			//start transaction			
			session.beginTransaction();
			

			//get instructor by primary key
			int theId = 1;
			Instructor instructorToDelete = session.get(Instructor.class,theId);
			System.out.println("Found instructor: " + instructorToDelete);
			//delete the instructor
			
			if(instructorToDelete != null) {
				System.out.println("About to delete");
				session.delete(instructorToDelete);
			}
			else {
				System.out.println("No one to delete");
			}
			
			//commit instructor
			session.getTransaction().commit();
			

			System.out.println("Done!");
		}
		finally {
			factory.close();
			
		}
		
	}
	
}
