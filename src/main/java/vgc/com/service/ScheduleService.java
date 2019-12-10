package vgc.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import vgc.com.entities.Schedule;
import vgc.com.repositories.iScheduleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {


    @Autowired
    iScheduleRepository scheduleRepository;



    public List<Schedule> showSchedule() {
        return scheduleRepository.findAll();
    }

    public ResponseEntity<?> getSchedule(int id){
        return ResponseEntity.ok(scheduleRepository.getOne(id));
    }

    public ResponseEntity<?> getMovie(@PathVariable int id) {
        Optional<Schedule> schedule = scheduleRepository.findById(id);
        if (schedule != null) return ResponseEntity.ok(schedule);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cant find movie");
    }


    public int getScheduleRoom(int id){
        return  scheduleRepository.getOne(id).getRoom_id();

    }

    public ResponseEntity<?> getScheduleDate(int id){
        return ResponseEntity.ok(scheduleRepository.getOne(id).getSchedule_date());
    }



    public List<Schedule> findScheduleByMovie(int id) {

        List<Schedule> schedule = scheduleRepository.findAll();
        List<Schedule> list = null;
        for (Schedule schedule1 : schedule) {
            if (id == schedule1.getMovie_id() ){
                list.add(schedule1);
            }
        }
        if (list != null) {
            return list;
        }
        return list;
    }

//    public List<Schedule> findSchedulebyDate(String date){
//        List<Schedule> schedule = scheduleRepository.findAll();
//
//    }

    public String getScheduleDesc(int id){
        return scheduleRepository.getOne(id).getSchedule_desc();
    }


}
