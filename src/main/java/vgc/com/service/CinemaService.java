package vgc.com.service;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vgc.com.entities.Cinema;
import vgc.com.model.ResponseData;
import vgc.com.repositories.iCinemaRepository;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;


@Service
public class CinemaService {

    @Autowired
    private iCinemaRepository cinemaRepository;


    public List<Cinema> getCinema() {
        return cinemaRepository.findAll();
    }

    public Cinema getCinema(int id) {
        return cinemaRepository.getOne(id);
    }

    public String getCinemaName(int id){
        return cinemaRepository.getOne(id).getCinema_name();
    }

    public String getCinemaAddress(int id){
        return cinemaRepository.getOne(id).getCinema_address();
    }

//    public ResponseData<Cinema> getCinemaByScheduleId(Integer schedule_id){
//        return new ResponseData(HttpStatus.OK, "success", cinemaRepository.getCinemasByIdSchedule(schedule_id));
//    }
//
//    public ResponseData<Cinema> getSchedule(String date, int cinema_id){
//        return new ResponseData(HttpStatus.OK, "success", cinemaRepository.getSchedule(date,cinema_id));
//    }



}
