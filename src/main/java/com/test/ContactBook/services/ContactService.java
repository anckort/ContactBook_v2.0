package com.test.ContactBook.services;

import com.test.ContactBook.dto.ContactDTO;

public interface ContactService {
    String getAll();
    void saveContact(ContactDTO contactDTO);
    ContactDTO getContactById(Long id);
}
