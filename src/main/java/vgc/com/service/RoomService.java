package vgc.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vgc.com.entities.Room;
import vgc.com.repositories.iRoomRepository;

@Service
public class RoomService {

    @Autowired
     iRoomRepository roomRepository;


    public ResponseEntity<?> getRoom() {
        return ResponseEntity.ok(roomRepository.findAll());
    }

    public Room getRoomById(int id) {
        return roomRepository.getOne(id);
    }

    public ResponseEntity<?> getRoomName(int id) {
        return ResponseEntity.ok(roomRepository.getOne(id).getRoom_name());
    }

    public int getRomCinema(int id) {
       Room room = roomRepository.getOne(id);
        return room.getCinema_id();
    }
}
