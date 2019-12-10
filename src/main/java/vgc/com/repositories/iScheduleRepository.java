package vgc.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vgc.com.entities.Schedule;

public interface iScheduleRepository extends JpaRepository<Schedule, Integer> {

}
