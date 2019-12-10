package vgc.com.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class Info {
    @JsonProperty("cinema_id")
    private int cinemaId;
    @JsonProperty("cinema_name")
    private String cinemaName;
    @JsonProperty("cinema_address")
    private String cinemaAddress;
    @JsonProperty("cinema_data")
    private ArrayList<CinemaData> cinemaData;

    public  Info() {

    }

    public Info(int cinemaId, String cinemaName, String cinemaAddress, Object cinemaData) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.cinemaAddress = cinemaAddress;
        if (cinemaData != null) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                this.cinemaData = mapper.readValue((String) cinemaData, new TypeReference<ArrayList<CinemaData>>(){});
            } catch (IOException e) {
                this.cinemaData = null;
            }
        }

    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaAddress() {
        return cinemaAddress;
    }

    public void setCinemaAddress(String cinemaAddress) {
        this.cinemaAddress = cinemaAddress;
    }

    public ArrayList<CinemaData> getCinemaData() {
        return cinemaData;
    }

    public void setCinemaData(ArrayList<CinemaData> cinemaData) {
        this.cinemaData = cinemaData;
    }
}
