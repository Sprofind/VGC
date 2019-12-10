package vgc.com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class SeatFormat {

    private MovieData movie_data;
    private ScheduleData schedule_data;
    private ArrayList<SeatInfor> seat_row;

    public SeatFormat() {
    }

    public SeatFormat(MovieData movie_data, ScheduleData schedule_data, ArrayList<SeatInfor> seat_row) {
        this.movie_data = movie_data;
        this.schedule_data = schedule_data;

        this.seat_row = seat_row;

    }

    public MovieData getMovie_data() {
        return movie_data;
    }

    public void setMovie_data(MovieData movie_data) {
        this.movie_data = movie_data;
    }

    public ScheduleData getSchedule_data() {
        return schedule_data;
    }

    public void setSchedule_data(ScheduleData schedule_data) {
        this.schedule_data = schedule_data;
    }


    public ArrayList<SeatInfor> getSeat_row() {
        return seat_row;
    }

    public void setSeat_row(ArrayList<SeatInfor> seat_row) {
        this.seat_row = seat_row;
    }
}


