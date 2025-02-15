package com.ty.mySpringBank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.mySpringBank.model.Contact;
import com.ty.mySpringBank.service.ContactService;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    // Show Contact Page
    @GetMapping("/contact")
    public String showContactPage(Model model) {
        model.addAttribute("bankName", "ABC Bank");
        return "contact";
    }

    // Handle Contact Form Submission
    @PostMapping("/submitContact")
    public String handleContactForm(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("message") String message,
            Model model) {

        // Create Contact Object
        Contact contact = new Contact();
        contact.setName(name);
        contact.setEmail(email);
        contact.setPhone(phone);
        contact.setMessage(message);

        // Save Contact Inquiry
        contactService.saveContact(contact);

        // Success Message
        model.addAttribute("successMessage", "Your message has been sent successfully!");
        return "contact";
    }
}
