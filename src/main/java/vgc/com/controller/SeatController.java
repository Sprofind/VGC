package vgc.com.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vgc.com.model.ResponseData;
import vgc.com.service.SeatService;


@Controller
@Api("Seat API")

public class SeatController {

    @Autowired
    private SeatService seatService;

    @ApiOperation(value ="Get All Seat")
    @GetMapping("/seat")
    public ResponseEntity<?> getAllSeat(){
        return seatService.getSeat();
    }

    @ApiOperation(value = "Get Seat Name")
    @RequestMapping(value = "/seat/{id}/name" , method = RequestMethod.GET)
    public ResponseEntity<?> getSeatName(@PathVariable int id){
        return seatService.getSeatName(id);
    }

    @ApiOperation(value = "Get Seat Type")
    @GetMapping(value ="/seat/{id}/type")
    public ResponseEntity<?> getSeatType(@PathVariable int id){
        return seatService.getSeatType(id);
    }

    @ApiOperation(value = "Get Seat's Room")
    @GetMapping(value = "/seat/{id}/room")
    public ResponseEntity<?> getRoomBySeat(@PathVariable  int id){
        return seatService.getRoomBySeat(id);
    }

    @ApiOperation(value = "Get free seat of a schedule")
    @GetMapping("/seat/free/{schedule_id}")
    public ResponseEntity<?>getFreeSeat(@PathVariable int schedule_id){
        return ResponseEntity.ok(new ResponseData(HttpStatus.OK,"success", seatService.getFreeSeat(schedule_id)));
    }

}
