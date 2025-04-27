package com.project1.contact_fetch_service.service;

import com.project1.contact_fetch_service.entity.Contact;
import com.project1.contact_fetch_service.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact getContactById(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with ID: " + id));
    }
}