package com.project1.contact_save_service.service;

import com.project1.contact_save_service.entity.Contact;

import java.util.List;

public interface ContactService {
    Contact saveContact(Contact contact);
    List<Contact> saveContacts(List<Contact> contacts);
}