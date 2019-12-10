package vgc.com.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vgc.com.entities.Cinema;
import vgc.com.entities.Movie;
import vgc.com.entities.Schedule;
import vgc.com.model.*;
import vgc.com.service.CinemaService;
import vgc.com.service.MovieService;
import vgc.com.service.RoomService;
import vgc.com.service.ScheduleService;


import java.util.*;

@RestController
@Api("Schedule's API")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private RoomService roomService;

    @Autowired
    CinemaService cinemaService;

    @ApiOperation(value = "Get schedule list", response = Schedule.class, responseContainer = "List")
    @GetMapping("/schedule")
    public ResponseEntity<?> getSchedule() {
        return ResponseEntity.ok(scheduleService.showSchedule());
    }


    @ApiOperation(value = "get schedule of a movie")
    @GetMapping("/schedule/movie/{id}")
    public ResponseEntity<?> getMovieSchedule(@PathVariable int id) {

        List<Schedule> list = scheduleService.showSchedule();

        for (Schedule schedule : list)
            if (schedule.getMovie_id() != id) {

                list.remove(schedule);
            }


        return ResponseEntity.ok(list);
    }

    @GetMapping("/schedule/{id}/room")
    public ResponseEntity<?> getScheduleRoom(@PathVariable int id) {
        return ResponseEntity.ok(scheduleService.getScheduleRoom(id));
    }


    @GetMapping("/schedule/{date}")
    public ResponseEntity<?> getScheduleByDate(@PathVariable String date) {
        List<Schedule> list = scheduleService.showSchedule();

        for (Schedule schedule : list) {
            if (schedule.getSchedule_date().compareTo(date) != 0) {
                list.remove(schedule);
            }
        }
        return ResponseEntity.ok(list);
    }

    public FormatData setFormatData(int id, String start) {
        FormatData formatdata = new FormatData(id, start);
        return formatdata;

    }

    public CinemaData setCinemaData(String formatFilm, ArrayList<FormatData> list) {
        CinemaData data = new CinemaData(formatFilm, list);
        return data;

    }

    public Info setInfor(int cinema_id, ArrayList<CinemaData> list) {
        Info infor = new Info();
        infor.setCinemaId(cinema_id);
        infor.setCinemaAddress(cinemaService.getCinema(cinema_id).getCinema_address());
        infor.setCinemaName(cinemaService.getCinema(cinema_id).getCinema_name());
        infor.setCinemaData(list);

        return infor;

    }

    public void shoSchedule(String date, int id) {


    }

    //truyen vao list cac suat chieu trong cung mot rap

    public ArrayList<CinemaData> set(ArrayList<Schedule> list) {

        ArrayList<Schedule> data2D = new ArrayList<Schedule>();
        ArrayList<Schedule> data3D = new ArrayList<Schedule>();
        //phan loai suat chieu la 2D hay 3D
        for (Schedule schedule : list) {
            if (schedule.getSchedule_desc().equalsIgnoreCase("2D")) {
                data2D.add(schedule);
            } else {
                data3D.add(schedule);
            }
        }
        //tao CinemaData, add formatData
        ArrayList<FormatData> format2D = new ArrayList<FormatData>();
        for (Schedule schedule : data2D) {
            FormatData data = new FormatData(schedule.getSchedule_id(), schedule.getSchedule_start());
            format2D.add(data);
        }
        ArrayList<FormatData> format3D = new ArrayList<FormatData>();
        for (Schedule schedule : data3D) {
            FormatData data = new FormatData(schedule.getSchedule_id(), schedule.getSchedule_start());
            format3D.add(data);
        }
        ArrayList<CinemaData> cinemaDatalist = new ArrayList<CinemaData>();
        CinemaData cinemaData2D = new CinemaData("2D", format2D);
        CinemaData cinemaData3D = new CinemaData("3D", format3D);
        if(!cinemaData2D.getFormatData().isEmpty()){
            cinemaDatalist.add(cinemaData2D);
        }
        if(!cinemaData3D.getFormatData().isEmpty()){
            cinemaDatalist.add(cinemaData3D);
        }

        return cinemaDatalist;
        //tra ve list cinemaData cua rap day
    }

    //tim cac rap co suat chieu
    public ArrayList<Cinema> findCinemaIdbySchedule(ArrayList<Schedule> list) {

        ArrayList<Cinema> cinema = (ArrayList<Cinema>) cinemaService.getCinema();
        ArrayList<Cinema> cinemas = new ArrayList<Cinema>();
        for (Schedule schedule : list) {

            int roomid = schedule.getRoom_id();

            int cinemaid = roomService.getRomCinema(roomid);

            for (Cinema cinema1 : cinema) {
                if (cinema1.getCinema_id() == cinemaid) {
                    if (!cinemas.contains(cinema1)) {
                        cinemas.add(cinema1);
                    }
                }
            }
        }

        return cinemas;
        //tra ve danh sach cac rap co suat chieu
    }

    //tim cac suat chieu trong cung mot rap
    public ArrayList<Schedule> schedulecungrap(ArrayList<Cinema> cinemas, ArrayList<Schedule> schedules) {
        ArrayList<Schedule> list = new ArrayList<Schedule>();
        for (Schedule schedule : schedules) {
            int id = schedule.getRoom_id();
            for (Cinema cinema : cinemas) {
                if (roomService.getRomCinema(id) == cinema.getCinema_id()) {
                    list.add(schedule);
                }
            }
        }
        return list;
    }

    @GetMapping("/schedules/{date}/{id}")
    public ResponseEntity<?> scheduleDetails(@PathVariable String date, @PathVariable int id) {
        //tim suat chieu theo ngay va phim
        ArrayList<Schedule> list = getSchedulebyDateandMovie(date, id);
        System.out.println("44444");
        //dua vao cac suat chieu tim cac rap co cac suat chieu day
        ArrayList<Cinema> cinemas = findCinemaIdbySchedule(list);
        ArrayList<Info> infor = new ArrayList<Info>();

        for (Cinema cinema : cinemas) {
            Info info = new Info();
            info.setCinemaName(cinema.getCinema_name());
            info.setCinemaAddress(cinema.getCinema_address());
            info.setCinemaId(cinema.getCinema_id());
            info.setCinemaData(set(getScheduleinCinema(list, cinema.getCinema_id())));
            infor.add(info);
        }
        //new ResponseData(HttpStatus.OK,"sucess",info
        return ResponseEntity.ok(new ResponseData(HttpStatus.OK, "success", infor));
    }


    public ArrayList<Schedule> getSchedulebyDateandMovie(String date, int id) {
        ArrayList<Schedule> schedules = (ArrayList<Schedule>) scheduleService.showSchedule();
        for (Schedule schedule : schedules) {
            if (schedule.getSchedule_date().compareTo(date) != 0) {
                schedules.remove(schedule);
            }
        }
        for (Schedule schedule : schedules) {
            if (schedule.getMovie_id() != id) {
                schedules.remove(schedule);
            }
        }

        return schedules;
    }

    //tra ve cac suat chieu trong cung mot rap
    public ArrayList<Schedule> getScheduleinCinema(ArrayList<Schedule> schedules, int cinema_id) {
        ArrayList<Schedule> cinemaData = new ArrayList<Schedule>();
        for (Schedule schedule : schedules) {
            int roomId = schedule.getRoom_id();
            int cinemaid = roomService.getRomCinema(roomId);
            if (cinemaid == cinema_id) {
                cinemaData.add(schedule);
            }

        }
        return cinemaData;
    }

    public Map<String, Object> showSchedule(ArrayList<Schedule> schedules) {
        Map<String, Object> responseData = new HashMap<>();
        for (Schedule schedule : schedules) {
            if (schedule.getSchedule_desc().equals("2D")) {
                responseData.put("2D", schedule);
            } else {
                responseData.put("3D", schedule);
            }
        }

        return responseData;
    }

//    @ApiOperation(value = "Get a schedule of a movie")
//    @GetMapping("/movies/{id}/schedule")
//    public ResponseEntity<?> getScheduleMovieDetail(@PathVariable int id){
//
//
//        List<Schedule> list = scheduleService.showSchedule();
//
//        for (Schedule schedule : list)
//            if (schedule.getMovie_id() != id) {
//
//                list.remove(schedule);
//            }
//        List<Object> models = new LinkedList<>();
//        for (Schedule schedule : list){
//           ;
//            model.setRoom_id(schedule.getRoom_id());
//            model.setCinema_id(roomService.getRomCinema(schedule.getRoom_id()));
//            model.setCinema_name(cinemaService.getCinemaName(model.getCinema_id()));
//            model.setMovie_format(movieService.getMovieFormat(schedule.getMovie_id()));
//            model.setSchedule_start(schedule.getSchedule_start());
//            model.setSchedule_end(schedule.getSchedule_end());
//            model.setSchedule_date(schedule.getSchedule_date());
//            model.setSchedule_id(schedule.getSchedule_id());
//            model.setMovie_id(schedule.getMovie_id());
//            model.setMovie_name(movieService.getMovieName(schedule.getMovie_id()));
//            models.add(model);
//        }
//        ResponseData responseData = new ResponseData();
//        responseData.setStatus(HttpStatus.FOUND);
//        responseData.setMsg(HttpStatus.FOUND.toString());
//        responseData.setData(models);
//        return ResponseEntity.ok(responseData);
//
//    }

}
