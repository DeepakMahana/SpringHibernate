package com.deepak.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	// Need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// Need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// Need a controller method to read form data and add data to model
	@RequestMapping("/processFormV2")
	public String addData(HttpServletRequest request, Model model) {
		
		// Read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		// Convert the data to all caps
		theName = theName.toUpperCase();
		
		// Create the message
		String result = "Yo ! " + theName;
		
		// Add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	// Need a controller method to read form data and add data to model
	@RequestMapping("/processFormV3")
	public String processForm(
			@RequestParam("studentName") String theName, 
			Model model) {
		
		// Convert the data to all caps
		theName = theName.toUpperCase();
		
		// Create the message
		String result = "Hey dude " + theName;
		
		// Add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
}
