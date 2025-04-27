package com.project1.contact_save_service.repository;

import com.project1.contact_save_service.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}