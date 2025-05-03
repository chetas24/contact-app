package com.project1.contact_save_service.controller;

import com.project1.contact_save_service.entity.Contact;
import com.project1.contact_save_service.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<?> saveContact(@Valid @RequestBody Contact contact) {
        Contact savedContact = contactService.saveContact(contact);
        return ResponseEntity.ok().body(
                new ResponseMessage(savedContact.getId(), "Contact saved successfully")
        );
    }

    @PostMapping("/bulk")
    public ResponseEntity<?> saveContacts(@Valid @RequestBody List<Contact> contacts) {
        List<Contact> savedContacts = contactService.saveContacts(contacts);
        return ResponseEntity.ok().body(
                savedContacts.stream()
                        .map(c -> new ResponseMessage(c.getId(), "Contact saved successfully"))
                        .toList()
        );
    }

    private static class ResponseMessage {
        private Long id;
        private String message;

        public ResponseMessage(Long id, String message) {
            this.id = id;
            this.message = message;
        }

        public Long getId() {
            return id;
        }

        public String getMessage() {
            return message;
        }
    }
}