package vgc.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vgc.com.entities.Movie;
import vgc.com.repositories.iMovieRepository;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    iMovieRepository movieRepository;



    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }


    public String getMovieName(int id) {
        return movieRepository.getOne(id).getMovie_name();
    }


    public Movie getAMovie(int id){
        return movieRepository.getOne(id);
    }

    public ResponseEntity<?> getMovieDes(int id){
        return ResponseEntity.ok(movieRepository.getOne(id).getMovie_desc());

    }

    public ResponseEntity<?> getMovieTrailer(int id){
        return ResponseEntity.ok(movieRepository.getOne(id).getMovie_trailer());
    }

    public ResponseEntity<?> getMovieCens(int id){
        return ResponseEntity.ok(movieRepository.getOne(id).getMovie_cens());
    }

    public ResponseEntity<?> getMovieGenr(int id){
        return ResponseEntity.ok(movieRepository.getOne(id).getMovie_genr());
    }

    public ResponseEntity<?> getMovieRelease(int id){
        return ResponseEntity.ok(movieRepository.getOne(id).getMovie_rele());
    }

    public ResponseEntity<?> getMovieLenght(int id){
        return ResponseEntity.ok(movieRepository.getOne(id).getMovie_leng());
    }

    public String getMovieFormat(int id){
        return  movieRepository.getOne(id).getMovie_form();
    }
    public ResponseEntity<?> getMoviePoster(int id){
        return ResponseEntity.ok(movieRepository.getOne(id).getMovie_poster());
    }

    public ResponseEntity<?> createMovie(Movie movie){
        return ResponseEntity.ok( movieRepository.save(movie));
    }
}
