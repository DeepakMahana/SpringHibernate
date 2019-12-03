package com.deepak.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.deepak.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			
			// Now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Retrieve student based on the id: Primary Key
			System.out.println("\nGetting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating Student");
			myStudent.setFirstName("Scooby");
			
			// commit transaction
			session.getTransaction().commit();
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Update email for all students
			System.out.println("Update email for all students");
			session.createQuery("Update Student set email='foo@gmail.com'")
				   .executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			
						
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}

	}

}
