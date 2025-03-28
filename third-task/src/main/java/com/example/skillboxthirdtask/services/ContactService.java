package com.example.skillboxthirdtask.services;

import com.example.skillboxthirdtask.contact.Contact;
import com.example.skillboxthirdtask.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;


    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public void addContact(Contact contact) {
        this.contactRepository.save(contact);
    }

    public Contact findById(Long id) {
        return this.contactRepository.findById(id).orElseThrow();
    }

    public Contact update(Long id, Contact contact) {
        Contact existingContact = contactRepository.findById(id).orElseThrow();
        System.out.println(existingContact);
        return contactRepository.save(existingContact);
    }


    public void delete(Long id) {
        Contact contact = contactRepository.findById(id).orElseThrow();
        contactRepository.delete(contact);
    }
}

