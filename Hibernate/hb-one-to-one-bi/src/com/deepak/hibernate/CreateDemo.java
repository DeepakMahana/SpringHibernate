package com.deepak.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.deepak.hibernate.entity.Instructor;
import com.deepak.hibernate.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create the objects
//			Instructor tempInstructor = new Instructor("Deepak", "Mahana","deepak@gmail.com");
//			
//			InstructorDetail tempInsDetail = new InstructorDetail(
//					"http://www.deepak.com/youtube",
//					"Love 2 Code");
			
			Instructor tempInstructor = new Instructor("Deep", "Makwana","deep@gmail.com");
			
			InstructorDetail tempInsDetail = new InstructorDetail(
					"http://www.deep.com/youtube",
					"Love Frontend");
					
			// associate the objects
			tempInstructor.setInstructorDetail(tempInsDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note: this will ALSO save the details object
			// Because of CascadeType.ALL
			//
			session.save(tempInstructor);
			System.out.println("Saving instructor: " + tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}

	}

}
