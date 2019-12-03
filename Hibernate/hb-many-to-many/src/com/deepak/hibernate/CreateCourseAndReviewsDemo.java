package com.deepak.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.deepak.hibernate.entity.Course;
import com.deepak.hibernate.entity.Instructor;
import com.deepak.hibernate.entity.InstructorDetail;
import com.deepak.hibernate.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Review.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course tempCourse = new Course("Pacman - How to score one million points");
			
			// add some reviews
			tempCourse.addReview(new Review("Great Course... Loved It !"));
			tempCourse.addReview(new Review("Great Course... Loved It !"));
			tempCourse.addReview(new Review("Great Course... Loved It !"));
			
			// save the course ... and leverage the cascade all
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);
			
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
