package br.com.duty.controllers;

import br.com.duty.models.Contact;
import br.com.duty.repositories.ContactRepository;
import br.com.duty.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ContactController {
    @Autowired
    ContactService contactService;

    @PostMapping(path="/register/contact")
    public String resgisterUserContact(@RequestParam("userId") Integer userId,
                                       @RequestParam("hospitalId") Integer hospitalId,
                                       @RequestParam("cellPhoneNumber") Long cellPhoneNumber){

        contactService.createContact(cellPhoneNumber, Optional.ofNullable(hospitalId),Optional.ofNullable(userId));
        return "cadastrar Contato";
    }

}
