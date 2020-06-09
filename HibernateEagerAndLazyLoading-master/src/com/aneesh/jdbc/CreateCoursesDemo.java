package com.aneesh.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aneesh.hibernate.demo.entity.Course;
import com.aneesh.hibernate.demo.entity.Instructor;
import com.aneesh.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			
			//create courses
			Course tempCourse1 = new Course("Computer Science");
			Course tempCourse2 = new Course("Java");
			Course tempCourse3 = new Course("Artificial Intelligence");
			
			
			//add the course to the instructor
			tempInstructor.addCourse(tempCourse1);
			tempInstructor.addCourse(tempCourse2);
			tempInstructor.addCourse(tempCourse3);

			//save the courses to the database
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);
			
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
