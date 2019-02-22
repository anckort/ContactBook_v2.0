package com.test.ContactBook.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.ContactBook.dto.ContactDTO;
import com.test.ContactBook.entities.Contact;
import com.test.ContactBook.repositories.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public String getAll() {
        ArrayList<Contact> contacts = (ArrayList <Contact>) contactRepository.findAll();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        StringBuilder builder = new StringBuilder();
        for(Contact contact:contacts) {
            builder.append(gson.toJson(contact));
        }
        return builder.toString();
    }

    @Override
    public void saveContact(ContactDTO contactDTO) {
        Contact contact = modelMapper.map(contactDTO, (Type) Contact.class);
        contactRepository.save(contact);
    }

    @Override
    public ContactDTO getContactById(Long id) {
        Contact contact = contactRepository.getContactById(id);
        ContactDTO contactDTO = modelMapper.map(contact, ContactDTO.class);
        return contactDTO;
    }

}
