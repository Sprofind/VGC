package vgc.com.model;

public class SeatDetails {
    private int seat_id;
    private String seat_type;
    private int seat_number;
    private boolean seat_status;
    private double seat_price;

    public SeatDetails(int seat_id, String seat_type, int seat_number, boolean seat_status, double seat_price) {
        this.seat_id = seat_id;
        this.seat_type = seat_type;
        this.seat_number = seat_number;
        this.seat_status = seat_status;
        this.seat_price = seat_price;
    }

    public SeatDetails() {
    }

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public String getSeat_type() {
        return seat_type;
    }

    public void setSeat_type(String seat_type) {
        this.seat_type = seat_type;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(int seat_number) {
        this.seat_number = seat_number;
    }

    public boolean isSeat_status() {
        return seat_status;
    }

    public void setSeat_status(boolean seat_status) {
        this.seat_status = seat_status;
    }

    public double getSeat_price() {
        return seat_price;
    }

    public void setSeat_price(double seat_price) {
        this.seat_price = seat_price;
    }
}
