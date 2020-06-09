package com.aneesh.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aneesh.hibernate.demo.entity.Course;
import com.aneesh.hibernate.demo.entity.Instructor;
import com.aneesh.hibernate.demo.entity.InstructorDetail;
import com.aneesh.hibernate.demo.entity.Review;
import com.aneesh.hibernate.demo.entity.Student;

public class DeleteStudent {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
								
				
		Session session = factory.getCurrentSession();
		
		try {		
			
			//start transaction			
			session.beginTransaction();
			
			//get student from database
			Student a = session.get(Student	.class,4);

			session.delete(a);
			
		
			session.getTransaction().commit();
			

			System.out.println("Done!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
			
		}
		
	}
	
}
