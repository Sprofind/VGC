package vgc.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vgc.com.entities.Room;

public interface iRoomRepository extends JpaRepository< Room , Integer> {

}
