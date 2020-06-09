package com.aneesh.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aneesh.hibernate.demo.entity.Course;
import com.aneesh.hibernate.demo.entity.Instructor;
import com.aneesh.hibernate.demo.entity.InstructorDetail;
import com.aneesh.hibernate.demo.entity.Review;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
								
				
		Session session = factory.getCurrentSession();
		
		try {
					
			
			//start transaction			
			session.beginTransaction();
			
			
			//get instructor detail object
			int theId = 10;
			Course courseToDelete = session.get(Course.class, theId);
			
			//print instructor detail object
			System.out.println("Here is the course: " + courseToDelete);
			
			//print associated instructor item
			System.out.println("The course reviews: " + courseToDelete.getReviews());
			
			//delete the item
			System.out.println("Deleting: " + courseToDelete);
			session.delete(courseToDelete);
			
			
			//commit instructor
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
