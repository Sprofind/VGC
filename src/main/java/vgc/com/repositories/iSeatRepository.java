package vgc.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vgc.com.entities.Seat;

import java.util.List;

public interface iSeatRepository extends JpaRepository<Seat, Integer> {
    @Query(nativeQuery = true, name = "getFreeSeat")
    List<Seat> getFreeSeat(@Param("schedule_id") int schedule_id);

}
