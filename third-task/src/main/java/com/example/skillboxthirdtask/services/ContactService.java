package com.example.skillboxthirdtask.services;

import com.example.skillboxthirdtask.contact.Contact;
import com.example.skillboxthirdtask.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact findById(Long id) {
        return contactRepository.findById(id);
    }

    public void addContact(Contact contact) {
        contactRepository.addContact(contact);
    }

    public void update(Long id, Contact contact) {
        contactRepository.updateContact(id, contact);
    }

    public void delete(Long id) {
        contactRepository.deleteContact(id);
    }
}
