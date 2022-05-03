package br.com.duty.controllers;

import br.com.duty.models.Duty;
import br.com.duty.models.Hospital;
import br.com.duty.models.Schedule;
import br.com.duty.models.User;
import br.com.duty.repositories.DutyRepository;
import br.com.duty.services.DutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class DutyController {
    @Autowired
    DutyService dutyService;

    @PostMapping(path="/register/duty", produces = MediaType.APPLICATION_JSON_VALUE)
    public Duty resgisterDuty(@RequestParam("userId") Integer userId,
                                   @RequestParam("hospitalId") Integer hospitalId,
                                   @RequestParam("date") String date,
                                   @RequestParam("schedule") Integer schedule) throws ParseException {
        return dutyService.createDuty(userId, Optional.ofNullable(hospitalId), date, schedule);

    }

    @PostMapping(path="/update/duty", produces= MediaType.APPLICATION_JSON_VALUE)
    public Duty updateDuty(@RequestParam("dutyId") Integer dutyId,
                                @RequestParam("hospitalId") Integer hospitalId,
                                @RequestParam("date") String date,
                                @RequestParam("schedule") Integer schedule) throws ParseException {
        return dutyService.updateDuty(dutyId, Optional.ofNullable(hospitalId), Optional.ofNullable(date), Optional.ofNullable(schedule));
    }

    @PostMapping(path="/rate/duty", produces = MediaType.APPLICATION_JSON_VALUE)
    public Duty rateDuty(@RequestParam("dutyId") Integer dutyId,
                              @RequestParam("rate") Integer rate) throws ParseException {

        return dutyService.rateDuty(dutyId,rate);
    }

    @GetMapping(path="/duty/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Duty> getDuty(@RequestParam(value = "dutyId", required = false) Integer dutyId){
        return dutyService.getDutyData(Optional.ofNullable(dutyId));
    }


}
