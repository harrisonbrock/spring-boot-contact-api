package com.harrisonbrock.contactapi.controllers;

import com.harrisonbrock.contactapi.models.Contacts;
import com.harrisonbrock.contactapi.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public List<Contacts> getAllContacts() {
        return contactRepository.findAll();
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public Optional<Contacts> getContactById(@PathVariable("id") String id) {
        return contactRepository.findById(id);
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    public Contacts createContact(@Valid @RequestBody Contacts contacts) {
        return contactRepository.save((contacts));
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
    public Contacts updateContact(@PathVariable("id") Contacts contacts) {
        return contactRepository.save((contacts));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteContact(@PathVariable("id") String id) {
        contactRepository.deleteById(id);
    }
}
