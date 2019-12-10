package vgc.com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vgc.com.entities.*;
import vgc.com.model.MovieData;
import vgc.com.model.ScheduleData;
import vgc.com.model.SeatDetails;
import vgc.com.repositories.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService {

    @Autowired
    iSeatRepository seatRepository;
    @Autowired
    iScheduleRepository scheduleRepository;
    @Autowired
    iRoomRepository roomRepository;

    @Autowired
    iBookingRepository bookingRepository;

    @Autowired
    iMovieRepository movieRepository;

    public ResponseEntity<?> getSeat() {
        return ResponseEntity.ok(seatRepository.findAll());
    }

    public ResponseEntity<?> getRoomBySeat(int id) {
        return ResponseEntity.ok(seatRepository.getOne(id).getRoom_id());

    }

    public ResponseEntity<?> getSeatType(int id) {
        return ResponseEntity.ok(seatRepository.getOne(id).getSeat_type());
    }

    public ResponseEntity<String> getSeatName(int id) {
        Seat seat = seatRepository.getOne(id);
        String s1 = String.valueOf(seat.getSeat_row());
        String s2 = String.valueOf(seat.getSeat_num());
        return ResponseEntity.ok(s1.concat(s2));
    }


    public ArrayList<Seat> getSeatinBooking(int schedule_id) {
        ArrayList<Booking> list = (ArrayList<Booking>) bookingRepository.findAll();
        ArrayList<Seat> seats = new ArrayList<Seat>();
        for (Booking booking : list) {
            if (booking.getSchedule_id() == schedule_id) {
                System.out.println("zzzzzz");
                seats.add(seatRepository.getOne(booking.getSeat_id()));
            }
        }
        return seats;
    }


    public Room getRoombybSchedule(int schedule_id) {
        Schedule schedule = scheduleRepository.getOne(schedule_id);
        return roomRepository.getOne(schedule.getRoom_id());
    }

    public ArrayList<Seat> getSeatInRoom(int room_id) {
        ArrayList<Seat> seats = new ArrayList<Seat>();
        System.out.println("ccccccccc");
        ArrayList<Seat> list = (ArrayList<Seat>) seatRepository.findAll();
        for (Seat seat : list) {
            if (seat.getRoom_id() == room_id) {
                seats.add(seat);
                System.out.println("vvvvvv");
            }
        }
        return seats;
    }

    public ArrayList<Seat> getFreeSeat(int schedule_id) {
       ArrayList<Seat> seatsInBook = getSeatinBooking(schedule_id);
        Room room = getRoombybSchedule(schedule_id);
        ArrayList<Seat> seats = getSeatInRoom(room.getRoom_id());
        System.out.println("xxxxxxxx");
        for (int i = 0; i <= seats.size(); i++) {
            for (int j = 0; j <= seatsInBook.size(); j++) {
                if (seats.get(i).getSeat_id() == seatsInBook.get(j).getSeat_id()) {
                    seats.remove(seats.get(i));

                }
            }

        }
        return seats;
    }


    //////new////////


    public MovieData setMovieData(int schedule_id){
        Movie movie = movieRepository.getOne( scheduleRepository.getOne(schedule_id).getMovie_id());
        MovieData data = new MovieData(movie.getMovie_id(), movie.getMovie_name());
        return data;
    }

    public ScheduleData getScheduleData(int schedule_id){
        Schedule schedule = scheduleRepository.getOne(schedule_id);
        ScheduleData data = new ScheduleData(schedule.getSchedule_id(),schedule.getSchedule_date(),schedule.getSchedule_start(),schedule.getSchedule_end());
        return data;
    }


    public double setSeatPrice(int seat_id){
        double price = 0;
        Seat seat = seatRepository.getOne(seat_id);
        if(seat.getSeat_type().equalsIgnoreCase("vip")){
            price = 80000;
        }else {
            price = 50000;
        }
        return price;
    }


    public void getSeatInfor(int schedule_id){
        ArrayList<Seat> seatInRoom = getSeatInRoom(schedule_id);
        ArrayList<Seat> seatInBooking = getSeatinBooking(schedule_id);
        ArrayList<SeatDetails> details = new ArrayList<SeatDetails>();
        for(Seat seat : seatInRoom){
            SeatDetails seatDetails = new SeatDetails();
            seatDetails.setSeat_id(seat.getSeat_id());
            seatDetails.setSeat_type(seat.getSeat_type());
            seatDetails.setSeat_number(seat.getSeat_num());
            for(Seat seat1 : seatInBooking){
                if(seat1.getSeat_id() == seat.getSeat_id()){
                    seatDetails.setSeat_status(true);
                } else {
                    seatDetails.setSeat_status(false);
                }

            }
            if(seat.getSeat_type().equalsIgnoreCase("vip")){
                seatDetails.setSeat_price(80000);
            } else {
                seatDetails.setSeat_price(50000);
            }

            details.add(seatDetails);
        }


    }

}
