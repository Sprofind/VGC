package vgc.com.controller;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vgc.com.entities.Cinema;
import vgc.com.entities.Schedule;
import vgc.com.model.CinemaData;
import vgc.com.model.FormatData;
import vgc.com.model.Info;
import vgc.com.service.CinemaService;
import vgc.com.service.RoomService;
import vgc.com.service.ScheduleService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

@RestController
@Api("Cinema's API")
public class CinemaController {
    @Autowired
    CinemaService cinemaService;
    @Autowired
    ScheduleService scheduleService;

    @Autowired
    RoomService roomService;

    public int getCinemaIDbySchedule(int id) {
        int roomId = scheduleService.getScheduleRoom(id);
        return roomService.getRomCinema(roomId);
    }

//    public ArrayList<Info> getFormatData(String date, int movie_id) {
////        ArrayList<FormatData> data2D = new ArrayList<>();
////        ArrayList<FormatData> data3D = new ArrayList<>();
////        List<Schedule> schedules = scheduleService.findScheduleByMovie(id);
////
////        CinemaData cinema2D = new CinemaData();
////        cinema2D.setFormatFilm("2D");
////        CinemaData cinema3D = new CinemaData();
////        cinema3D.setFormatFilm("3D");
////        for (Schedule format : schedules) {
////            if (format.getSchedule_desc().equalsIgnoreCase("2D")) {
////                FormatData formatData = new FormatData(format.getSchedule_id(), format.getSchedule_start());
////                data2D.add(formatData);
////            } else {
////                FormatData formatData = new FormatData(format.getSchedule_id(), format.getSchedule_start());
////                data3D.add(formatData);
////            }
////        }
////        cinema2D.setFormatData(data2D);
////        cinema3D.setFormatData(data3D);
////        ArrayList<CinemaData> cinemaData = new ArrayList<>();
////        cinemaData.add(cinema2D);
////        cinemaData.add(cinema3D);
////        ArrayList<Info> infoList = new ArrayList<>();
////
////        for (Schedule schedule : schedules) {
////            Info info = new Info();
////            int cinemaId = getCinemaIDbySchedule(schedule.getSchedule_id());
////            info.setCinemaId(cinemaId);
////            info.setCinemaAddress(cinemaService.getCinemaAddress(cinemaId));
////            info.setCinemaName(cinemaService.getCinemaName(cinemaId));
////            infoList.add(info);
////
////
////        }
////
////
//////        for (Schedule schedule : schedules){
//////            FormatData formatData = new FormatData(schedule.getSchedule_id(), schedule.getSchedule_start());
//////            data.add(formatData);
//////        }
//
//        ArrayList<Schedule> schedules = getSchedulebyDatenMovie(date,movie_id);
//
//        ArrayList<Cinema> cinemaBySchedule = getCinemabySchedule(schedules);
//
//        for (Cinema cinema : cinemaBySchedule){
//
//        }
//
//
//    }

    public ArrayList<Schedule> getSchedulebyDatenMovie(String date, int movie_id) {
        ArrayList<Schedule> schedules = (ArrayList<Schedule>) scheduleService.findScheduleByMovie(movie_id);
        ArrayList<Schedule> list = new ArrayList<>();
        for (Schedule schedule : schedules) {
            if (schedule.getSchedule_date().equals(date)) {
                list.add(schedule);
            }

        }
        return list;
    }

    public Info setInfor(Cinema cinema) {
        Info info = new Info();
        info.setCinemaName(cinema.getCinema_name());
        info.setCinemaAddress(cinema.getCinema_address());
        info.setCinemaId(cinema.getCinema_id());

        return info;

    }

    public FormatData setFormatData(Schedule schedule){
        FormatData formatData = new FormatData();
        formatData.setScheduleId(schedule.getSchedule_id());
        formatData.setStart(schedule.getSchedule_start());
        return formatData;
    }

    public ArrayList<Schedule> findScheduleinCinema(int cinema_id, ArrayList<Schedule> list){
        ArrayList<Schedule> schedules = new ArrayList<>();
        for (Schedule schedule : list){
            if(roomService.getRomCinema(schedule.getRoom_id())== cinema_id){
                schedules.add(schedule);
            }
        }
        return schedules;
    }
    public ArrayList<Cinema> getCinemabySchedule(ArrayList<Schedule> schedule) {
        ArrayList<Cinema> cinemas = new ArrayList<>();
        for (Schedule schedule1 : schedule) {
            int cinemaId = roomService.getRomCinema(schedule1.getRoom_id());
            Cinema cinema = cinemaService.getCinema(cinemaId);
            if (!cinemas.contains(cinema)) {
                cinemas.add(cinema);
            }

        }
        return cinemas;
    }

    public void getScheduleinACinema(int id){

    }
//    public ArrayList<CinemaData> getCinemaData(int id) {
//        ArrayList<FormatData> data = getFormatData(id);
//        ArrayList<CinemaData> cinemaData = new ArrayList<>();
//        CinemaData cinema2D = new CinemaData();
//        CinemaData cinema3D = new CinemaData();
//        for (FormatData formatData : data) {
//            if (scheduleService.getScheduleDesc(formatData.getScheduleId()) == "2D") {
//                cinema2D.setFormatData(data);
//            }
//        }
//    }



    @GetMapping("/get-schedule/{id}")
    public ResponseEntity<?> getSchedule(@PathVariable int id) {


//        return ResponseEntity.ok(cinemaService.getSchedule(date,cinema_id));


        return ResponseEntity.ok("a");
    }

//    @GetMapping("/cinema/{id}/city")
//    public ResponseEntity<?> getCinemaCity(@PathVariable String id){
//
//        return cinemaService.getCinemaCity(id);
//    }
}
