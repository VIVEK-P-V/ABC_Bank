package com.ty.mySpringBank.service;

import com.ty.mySpringBank.model.Contact;
import com.ty.mySpringBank.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    // Save contact inquiry
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    // Get all contact inquiries
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    // Get a single contact inquiry by ID
    public Contact getContactById(int id) {
        return contactRepository.findById(id).orElse(null);
    }

    // Delete a contact inquiry by ID
    public void deleteContact(int id) {
        contactRepository.deleteById(id);
    }
}
