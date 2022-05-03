package br.com.duty.services;

import br.com.duty.models.Duty;
import br.com.duty.models.Hospital;
import br.com.duty.models.Schedule;
import br.com.duty.models.User;
import br.com.duty.repositories.DutyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DutyService {

    @Autowired
    DutyRepository dutyRepository;
    private final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");


    public Duty createDuty(Integer userId, Optional<Integer> hospitalId, String date, Integer schedule) throws ParseException {

        Duty duty = new Duty();
        duty.setUser(new User(userId));
        if(hospitalId.isPresent())
            duty.setHospital(new Hospital(hospitalId.get()));
        else
            duty.setHospital(null);

        duty.setDate(format.parse(date));
        duty.setSchedule(Schedule.getScheduleByID(schedule));

        duty =  dutyRepository.save(duty);
        return duty;

    }

    public List<Duty> getDutyData(Optional<Integer> dutyId){
        List<Duty> duties = new ArrayList<Duty>();
        if(dutyId.isPresent())
            duties.add(dutyRepository.findById(dutyId.get()).get());
        else
            duties = dutyRepository.findAll();

        return duties;

    }


    public Duty rateDuty(Integer dutyId, Integer rate) throws ParseException {
        return this.updateDuty(dutyId,
                                Optional.ofNullable(null),
                                Optional.ofNullable(null),
                                Optional.ofNullable(null),
                                Optional.of(rate));
    }


    public Duty updateDuty(Integer dutyId, Optional<Integer> hospitalId, Optional<String> date,Optional<Integer> schedule, Optional<Integer> rate) throws ParseException {

        Duty duty = dutyRepository.findById(dutyId).get();

        if(hospitalId.isPresent())
            duty.setHospital(new Hospital(hospitalId.get()));
        if(date.isPresent())
            duty.setDate(format.parse(date.get()));
        if(schedule.isPresent())
            duty.setSchedule(Schedule.getScheduleByID(schedule.get()));
        if(rate.isPresent())
            duty.setRatingHappynes(rate.get());

        duty = dutyRepository.save(duty);
        return duty;
    }

    public Duty updateDuty(Integer dutyId, Optional<Integer> hospitalId, Optional<String> date, Optional<Integer> schedule) throws ParseException {
        return this.updateDuty(dutyId,hospitalId, date, schedule, Optional.ofNullable(null));
    }
}
