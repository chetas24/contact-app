package com.project1.contact_save_service.service.impl;

import com.project1.contact_save_service.entity.Contact;
import com.project1.contact_save_service.repository.ContactRepository;
import com.project1.contact_save_service.service.ContactService;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }
}