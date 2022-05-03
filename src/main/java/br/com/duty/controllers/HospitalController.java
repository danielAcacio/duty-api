package br.com.duty.controllers;

import br.com.duty.models.Hospital;
import br.com.duty.repositories.HospitalRepository;
import br.com.duty.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class HospitalController {
    @Autowired
    HospitalService hospitalService;

    @PostMapping(path="/register/hospital", produces = MediaType.APPLICATION_JSON_VALUE)
    public Hospital resgisterHospital(@RequestParam("name") String hospitalName){
        return hospitalService.createHospital(hospitalName);
    }

    @GetMapping(path="/hospital/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Hospital> getHospitalData(@RequestParam(value = "hospitalId", required = false) Integer hospitalId){
        return hospitalService.getHospitalData(Optional.ofNullable(hospitalId));
    }

}
