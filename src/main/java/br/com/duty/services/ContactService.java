package br.com.duty.services;

import br.com.duty.models.Contact;
import br.com.duty.models.Hospital;
import br.com.duty.models.User;
import br.com.duty.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public Contact createContact(Long cellPhoneNumber, Optional<Integer> hospitalId, Optional<Integer> userId){
        if(!(hospitalId.isPresent() || userId.isPresent()))
            return null;

        Contact contact = new Contact(0, cellPhoneNumber, null, null);
        if(hospitalId.isPresent())
            contact.setHospital(new Hospital(hospitalId.get()));
        if(userId.isPresent())
            contact.setUser(new User(userId.get()));

        contact = contactRepository.save(contact);
        return contact;


    }

}
