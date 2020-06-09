package com.aneesh.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aneesh.hibernate.demo.entity.Course;
import com.aneesh.hibernate.demo.entity.Instructor;
import com.aneesh.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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
			
			//get instructor from db
			int id = 1;
			Instructor tempInstructor = session.get(Instructor.class,id);
			
			System.out.println("aneesh: instructor: " + tempInstructor);
			System.out.println("aneesh: instructor courses: " + tempInstructor.getCourses());
			session.getTransaction().commit();

			session.close();

			System.out.println("aneesh: Instructor courses: " + tempInstructor.getCourses());
			
			//get courses
			//commit instructor
			

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
