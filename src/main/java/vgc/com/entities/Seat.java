package vgc.com.entities;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import vgc.com.model.SeatFormat;

import javax.persistence.*;


@SqlResultSetMappings(value = {
        @SqlResultSetMapping(name = "SeatInfor", classes = @ConstructorResult(targetClass = SeatFormat.class, columns = {
                @ColumnResult(name = "seat_id"), @ColumnResult(name = "seat_row"),@ColumnResult(name="seat_num"), @ColumnResult(name = "seat_type")}))})


@NamedNativeQuery(name = "getFreeSeat",resultSetMapping = "SeatInfor", query = "SELECT seats.seat_id, seats.seat_row, seats.seat_num, seats.seat_type" +
        "FROM seats, room, schedule " +
        "WHERE schedule.schedule_id = :schedule_id AND seats.room_id = room.room_id " +
        "and room.room_id = schedule.room_id and seats.seat_id NOT IN (SELECT seat_id FROM booking)" +
        "ORDER BY seats.seat_id, seats.seat_type")

@Entity
@Table(name = "seats")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seat_id;
    @Column(name = "seat_type")
    private String seat_type;
    @Column(name = "room_id")
    private int room_id;
    @Column(name = "row")
    private char seat_row;
    @Column(name = "number")
    private int seat_num;

    public Seat() {
    }

    public Seat(int seat_id, String seat_type, int room_id, char seat_row, int seat_num) {
        this.seat_id = seat_id;
        this.seat_type = seat_type;
        this.room_id = room_id;
        this.seat_row = seat_row;
        this.seat_num = seat_num;
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

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public char getSeat_row() {
        return seat_row;
    }

    public void setSeat_row(char seat_row) {
        this.seat_row = seat_row;
    }

    public int getSeat_num() {
        return seat_num;
    }

    public void setSeat_num(int seat_num) {
        this.seat_num = seat_num;
    }
}
