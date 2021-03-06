package com.deepak.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("showForm")
	public String showForm(Model theModel) {
		
		// Create a student object
		Student theStudent = new Student();
		
		// Add Student Object to the Model
		theModel.addAttribute("student", theStudent);
		
		return "student-form";
	}
	
	
	@RequestMapping("/processForm")
	public String processForm(
			@ModelAttribute("student") Student theStudent) {
		
		// Log the input data
		System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
		
		return "student-confirmation";	
	}
}
