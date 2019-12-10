package vgc.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vgc.com.entities.Cinema;

public interface iCinemaRepository extends JpaRepository<Cinema, Integer> {
//    @Query(value = "SELECT `cinemas`.* FROM `cinemas`,`schedule`, `room` WHERE `schedule`.`room_id` = `room`.`room_id` AND `room`.`cinema_id`  = `cinemas`.`cinema_id` AND `schedule`.`schedule_id` = ?1", nativeQuery = true)
//    Cinema getCinemasByIdSchedule(Integer schedule_id);
//
//    @Query(nativeQuery = true, value = "SELECT `cinemas`.* FROM `cinemas`, `schedule`, `room` WHERE `schedule`.`room_id` = `room`.`room_id` AND `room`.`cinema_id` = `cinemas`.`cinema_id` AND `schedule`.`movie_id` = ?1 AND `schedule`.`schedule_date` = ?2")
//    List<Cinema> getScheduleCinema(Integer movie_id, String schedule_date);
//
//    @Query(nativeQuery = true, name = "showSchedule")
//    List<Info> getSchedule(@Param("date") String date,@Param("cinema_id") int cinema_id);
}
