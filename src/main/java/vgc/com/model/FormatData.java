package vgc.com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FormatData {
    @JsonProperty("schedule_id")
    private int scheduleId;
    @JsonProperty("start")
    private String start;

    public FormatData() {

    }

    public FormatData(int scheduleId, String start) {
        this.scheduleId = scheduleId;
        this.start = start;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
}
