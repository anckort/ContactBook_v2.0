package com.test.ContactBook.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.ContactBook.dto.ContactDTO;
import com.test.ContactBook.entities.Contact;
import com.test.ContactBook.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/getAllContacts", method = RequestMethod.GET)
    public @ResponseBody
    String getAllContacts(){
        return contactService.getAll();
    }

    @RequestMapping(value = "/saveContact", method = RequestMethod.POST)
    @ResponseBody
    public String saveContact(@Validated(ContactDTO.New.class) @RequestBody ContactDTO dto){
        contactService.saveContact(dto);
        return "ok";
    }
    @RequestMapping(value = "/updateContact", method = RequestMethod.PATCH)
    @ResponseBody
    public String updateContact(@Validated(ContactDTO.Update.class) @RequestBody ContactDTO dto){
        contactService.saveContact(dto);
        return "ok";
    }
}
