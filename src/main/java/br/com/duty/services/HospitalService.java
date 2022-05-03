package br.com.duty.services;

import br.com.duty.models.Addres;
import br.com.duty.models.Contact;
import br.com.duty.models.Hospital;
import br.com.duty.repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

    @Autowired
    HospitalRepository hospitalRepository;


    public Hospital createHospital(String hospitalName){
        Hospital hospital = new Hospital(hospitalName);
        hospital = hospitalRepository.save(hospital);
        return hospital;
    }

    public List<Hospital> getHospitalData(Optional<Integer> hospitalId){
        List<Hospital> hospitals = new ArrayList<Hospital>();
        if(hospitalId.isPresent())
            hospitals.add(hospitalRepository.findById(hospitalId.get()).get());
        else
            hospitals = hospitalRepository.findAll();

        return hospitals;
    }


    public Hospital addAddress(Integer hospitalId, Addres add) {
        Hospital hospital = hospitalRepository.getById(hospitalId);
       hospital.setAddres(add);
       hospitalRepository.save(hospital);
       return hospital;

    }


}
