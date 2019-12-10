package vgc.com.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import vgc.com.entities.Movie;

public interface iMovieRepository extends JpaRepository<Movie, Integer> {


}
