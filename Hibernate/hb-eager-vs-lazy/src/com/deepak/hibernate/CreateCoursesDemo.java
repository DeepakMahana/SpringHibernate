package com.deepak.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.deepak.hibernate.entity.Course;
import com.deepak.hibernate.entity.Instructor;
import com.deepak.hibernate.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// Get the instructor from DB
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			// Create some courses
			Course tempCourse1 = new Course("Air Guitar");
			Course tempCourse2 = new Course("Pinball Masterclass");
			
			// Add courses to instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			// Save the Courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			
			// handle connection leak issue
			session.close();
			factory.close();
		}

	}

}
