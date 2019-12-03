package com.deepak.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.deepak.hibernate.entity.Course;
import com.deepak.hibernate.entity.Instructor;
import com.deepak.hibernate.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			// Hibernate Query with HQL
			
			// Get the instructor from DB
			int theId = 1;
			
			Query<Instructor> query = session.createQuery("SELECT i from Instructor i "
											  			 + "JOIN FETCH i.courses "
											  			 + "where i.id=:theInstructorId",
											  			 	Instructor.class);
			
			// Set Parameter on Query
			query.setParameter("theInstructorId", theId);
			
			// Execute Query and Get Instructor
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("Hello: Instructor: " + tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();
			factory.close();
		}

	}

}
