package com.test.ContactBook.services;

import com.test.ContactBook.dto.PhoneNumberDTO;
import com.test.ContactBook.entities.*;
import com.test.ContactBook.repositories.ContactRepository;
import com.test.ContactBook.repositories.PhoneNumberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {
    @Autowired
    PhoneNumberRepository phoneNumberRepository;
    @Autowired
    ContactRepository contactRepository;

    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public List<PhoneNumber> getAllById(Long contactId) {
        return phoneNumberRepository.getAllByContactId(contactId);
    }

    @Override
    public void savePhoneNumber(PhoneNumberDTO phoneNumberDTO) {
        PhoneNumber phoneNumber = modelMapper.map(phoneNumberDTO, PhoneNumber.class);
        phoneNumber.setContactId(contactRepository.getContactById(phoneNumberDTO.getContactID()));
        phoneNumberRepository.save(phoneNumber);
    }

}
