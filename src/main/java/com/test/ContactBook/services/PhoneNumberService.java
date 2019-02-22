package com.test.ContactBook.services;

import com.test.ContactBook.dto.PhoneNumberDTO;
import com.test.ContactBook.entities.*;

import java.util.List;

public interface PhoneNumberService {
    List<PhoneNumber> getAllById(Long id);
    void savePhoneNumber(PhoneNumberDTO phoneNumberDTO);

}
