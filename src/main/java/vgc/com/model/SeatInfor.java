package vgc.com.model;

import java.util.ArrayList;

public class SeatInfor {

    private char seat_row;
    private ArrayList<SeatDetails> seatDetails;


    public SeatInfor() {
    }

    public SeatInfor(char seat_row, ArrayList<SeatDetails> seatDetails) {
        this.seat_row = seat_row;
        this.seatDetails = seatDetails;
    }

    public char getSeat_row() {
        return seat_row;
    }

    public void setSeat_row(char seat_row) {
        this.seat_row = seat_row;
    }

    public ArrayList<SeatDetails> getSeatDetails() {
        return seatDetails;
    }

    public void setSeatDetails(ArrayList<SeatDetails> seatDetails) {
        this.seatDetails = seatDetails;
    }
}
