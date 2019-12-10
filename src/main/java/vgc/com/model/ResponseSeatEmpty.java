package vgc.com.model;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.persistence.Column;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

public class ResponseSeatEmpty {
    @Column(name = "seat_id")
    private int seatId;
    @Column(name = "seat_type")
    private String seatType;
    @Column(name = "seat_row")
    private String seatRow;
    @Column(name = "seat_number")
    private int seatNumber;
    @Column(name = "seat_status")
    private String seatStatus;

    public ResponseSeatEmpty() {
    }

    public ResponseSeatEmpty(int seatId, String seatType, String seatRow, int seatNumber, String seatStatus) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.seatStatus = seatStatus;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }

    public static class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

        private static final long serialVersionUID = -7858869558953243875L;

        @Override
        public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        }
    }
}
