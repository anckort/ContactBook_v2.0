package com.test.ContactBook.controllers;

import com.test.ContactBook.dto.ContactDTO;
import com.test.ContactBook.dto.PhoneNumberDTO;
import com.test.ContactBook.entities.Contact;
import com.test.ContactBook.services.ContactService;
import com.test.ContactBook.entities.PhoneNumber;
import com.test.ContactBook.services.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "phoneNumber")
public class PhoneNumberController {
    @Autowired
    private PhoneNumberService phoneNumberService;
    private PhoneNumber phoneNumber;

    @Autowired
    ContactService contactService;

    @RequestMapping(value = "/savePhoneNumber", method = RequestMethod.POST)
    public @ResponseBody String savePhoneNumber(@Validated(PhoneNumberDTO.New.class) @RequestBody PhoneNumberDTO dto){
//        ContactDTO contactDTO = contactService.getContactById(dto.getContact().getId());

        phoneNumberService.savePhoneNumber(dto);
        return "ok";
    }

    @RequestMapping(value = "/updatePhoneNumber", method = RequestMethod.PATCH)
    public @ResponseBody String updatePhoneNumber(@Validated(PhoneNumberDTO.New.class) @RequestBody PhoneNumberDTO dto){
        phoneNumberService.savePhoneNumber(dto);
        return "ok";
    }

    @RequestMapping(value = "/getAllPhoneNumbers", method = RequestMethod.GET)
    public @ResponseBody
    String getAllPhoneNumbers(@RequestParam(name = "id") Long id){
        return phoneNumberService.getAllById(id).toString();
    }
}

