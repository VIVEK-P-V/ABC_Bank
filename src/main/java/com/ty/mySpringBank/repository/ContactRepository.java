package com.ty.mySpringBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ty.mySpringBank.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
