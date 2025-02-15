
package com.ty.mySpringBank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({ "/" })
	public String showHomePage() {
		return "home";
	}

	@GetMapping("/services")
	public String showServicesPage() {
		return "services"; 
	}
	
	@GetMapping("/about")
	public String showAboutsPage() {
		return "about"; 
	}
}
