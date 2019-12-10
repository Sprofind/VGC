package vgc.com.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vgc.com.service.RoomService;

@RestController
@Api("Room API")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/room")
    public ResponseEntity<?> getRoom(){
        return roomService.getRoom();
    }


    @GetMapping("/room/{id}/cinema")
    public ResponseEntity<?> getRoomCinema(@PathVariable int id){
        return ResponseEntity.ok(roomService.getRomCinema(id));
    }

    @GetMapping("/room/{id}")
    public  ResponseEntity<?> getRoomById(@PathVariable int id){
        return ResponseEntity.ok(roomService.getRoomById(id));
    }


}
