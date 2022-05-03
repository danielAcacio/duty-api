package br.com.duty.services;

import br.com.duty.models.Addres;
import br.com.duty.models.Hospital;
import br.com.duty.repositories.AddressRepository;
import br.com.duty.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserService userService;

    @Autowired
    HospitalService hospitalService;


    public Addres createAddress(Integer zipCode, String street, Integer number, Optional<Integer> hospitalId, Optional<Integer> userId){

        if(!(hospitalId.isPresent() || userId.isPresent()))
            return null;
        Addres add = new Addres(0,zipCode,street,number);
        add = addressRepository.save(add);
        if(hospitalId.isPresent())
            hospitalService.addAddress(hospitalId.get(), add);

        if(userId.isPresent())
            userService.addAddress(hospitalId.get(), add);

        return add;
    }

}
