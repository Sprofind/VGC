package vgc.com.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name ="schedule")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Schedule {
    private static final long serialVersionUID = -297553281792804396L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int schedule_id;

    @Column(name = "movie_id")
    private int movie_id;


    @Column(name ="room_id")
    private int room_id;

    @Column(name ="schedule_date")
    private String schedule_date;

    @Column(name ="schedule_start")
    private String schedule_start;

    @Column(name ="schedule_end")
    private String schedule_end;

    private String schedule_desc;
    public Schedule() {
    }

    public Schedule(int schedule_id, int movie_id, int room_id, String schedule_date, String schedule_start, String schedule_end, String schedule_desc) {
        this.schedule_id = schedule_id;
        this.movie_id = movie_id;
        this.room_id = room_id;
        this.schedule_date = schedule_date;
        this.schedule_start = schedule_start;
        this.schedule_end = schedule_end;
        this.schedule_desc = schedule_desc;
    }

    public String getSchedule_desc() {
        return schedule_desc;
    }

    public void setSchedule_desc(String schedule_desc) {
        this.schedule_desc = schedule_desc;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getSchedule_date() {
        return schedule_date;
    }

    public void setSchedule_date(String schedule_date) {
        this.schedule_date = schedule_date;
    }

    public String getSchedule_start() {
        return schedule_start;
    }

    public void setSchedule_start(String schedule_start) {
        this.schedule_start = schedule_start;
    }

    public String getSchedule_end() {
        return schedule_end;
    }

    public void setSchedule_end(String schedule_end) {
        this.schedule_end = schedule_end;
    }
}
