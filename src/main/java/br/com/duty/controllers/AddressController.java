package br.com.duty.controllers;

import br.com.duty.models.Addres;
import br.com.duty.repositories.AddressRepository;
import br.com.duty.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.Optional;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping(path="/register/address", produces = MediaType.APPLICATION_JSON_VALUE)
    public Addres resgisterUserAddress(@RequestParam("userId") Integer userId,
                                       @RequestParam("hospitalId") Integer hospitalId,
                                       @RequestParam("street") String street,
                                       @RequestParam("zipcode") Integer zipCode,
                                       @RequestParam("unitNumber") Integer number){

        return addressService.createAddress(zipCode, street, number, Optional.ofNullable(hospitalId), Optional.ofNullable(userId));

    }

}
