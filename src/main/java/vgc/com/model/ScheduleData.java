package vgc.com.model;


import vgc.com.entities.Movie;

public class ScheduleData {

    private int schedule_id;
    private String schedule_date;
    private String schedule_start;
    private String schedule_end;

    public ScheduleData() {
    }

    public ScheduleData(int schedule_id, String schedule_date, String schedule_start, String schedule_end) {
        this.schedule_id = schedule_id;
        this.schedule_date = schedule_date;
        this.schedule_start = schedule_start;
        this.schedule_end = schedule_end;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
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
