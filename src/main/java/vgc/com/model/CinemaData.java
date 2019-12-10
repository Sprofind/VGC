package vgc.com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class CinemaData {
    @JsonProperty("format_film")
    private String formatFilm;
    @JsonProperty("format_data")
    private ArrayList<FormatData> formatData;

    public CinemaData() {

    }

    public CinemaData(String formatFilm, ArrayList<FormatData> formatData) {
        this.formatFilm = formatFilm;
        this.formatData = formatData;
    }

    public String getFormatFilm() {
        return formatFilm;
    }

    public void setFormatFilm(String formatFilm) {
        this.formatFilm = formatFilm;
    }

    public ArrayList<FormatData> getFormatData() {
        return formatData;
    }

    public void setFormatData(ArrayList<FormatData> formatData) {
        this.formatData = formatData;
    }
}
