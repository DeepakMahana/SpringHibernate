package com.deepak.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.deepak.hibernate.entity.Course;
import com.deepak.hibernate.entity.Instructor;
import com.deepak.hibernate.entity.InstructorDetail;
import com.deepak.hibernate.entity.Review;
import com.deepak.hibernate.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Review.class)
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// get the student mary from database
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			System.out.println("\nLoading student: " + tempStudent);
			System.out.println("Courses: " + tempStudent.getCourses());
			
			// Create more resources
			Course tempCourse1 = new Course("Rubik's cube - How to Speed Cube");
			Course tempCourse2 = new Course("Atari 2600 - Game Development");
			
			// Add student to Courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			// Save the courses
			System.out.println("\nSaving the courses ...");
			
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
