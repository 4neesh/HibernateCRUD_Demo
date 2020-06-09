package com.aneesh.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aneesh.hibernate.demo.entity.Course;
import com.aneesh.hibernate.demo.entity.Instructor;
import com.aneesh.hibernate.demo.entity.InstructorDetail;
import com.aneesh.hibernate.demo.entity.Review;

public class GetCourseAndReviewsDemo {

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
			
			
			//create a course
			Course myCourse = new Course("Economics of the financial system");
			
			
			//add some reviews
			myCourse.addReview(new Review("Great course!"));
			myCourse.addReview(new Review("Really interesting!"));
			myCourse.addReview(new Review("Amazing"));
			
			
			//save course (cascade all will save reviews)
			session.save(myCourse);
			
			
			//commit transaction
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
