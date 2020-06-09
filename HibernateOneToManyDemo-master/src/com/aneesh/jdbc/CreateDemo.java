package com.aneesh.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aneesh.hibernate.demo.entity.Instructor;
import com.aneesh.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
								
				
		Session session = factory.getCurrentSession();
		
		try {
			
			//create objects
			Instructor tempInstructor = new Instructor("Bill", "Murray", "bill@test.com");
			
			InstructorDetail tempDetail = new InstructorDetail("http://youtube.com", "Acting");
			
			//associate objects
			tempInstructor.setInstructorDetail(tempDetail);
			
			
			//start transaction			
			session.beginTransaction();
			
			//save the instructor (and also the details due to relationship
			System.out.println("Saving");
			session.save(tempInstructor);

			//commit instructor
			session.getTransaction().commit();
			

			System.out.println("Done!");
		}
		finally {
			factory.close();
			
		}
		
	}
	
}
