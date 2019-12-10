package vgc.com.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.client.HttpStatusCodeException;
import vgc.com.entities.Movie;

import vgc.com.model.ResponseData;
import vgc.com.service.MovieService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RestController
@Api("Movie's API")
public class MovieController {
    @Autowired
    MovieService movieService;


    @ApiOperation(value = "Get movies list", response = Movie.class, responseContainer = "List")
    @GetMapping("/movies")
    public ResponseEntity<?> getListMovie() {
        return ResponseEntity.ok(new ResponseData(HttpStatus.OK, "succes", movieService.getMovies()));
    }

    @ApiOperation(value = "Get a movie by id", response = Movie.class)
    @ApiResponses({@ApiResponse(code = 404, message = "Không tìm thấy movie"),})
    @GetMapping("/movies/{id}")
    public ResponseEntity<?> getMovie(@PathVariable int id) {

        return ResponseEntity.ok(new ResponseData(HttpStatus.OK,"sucess", movieService.getAMovie(id)));
    }

    @ApiOperation(value = "get movie name")
    @GetMapping("/movies/{id}/name")
    public ResponseEntity<?> getMovieName(@PathVariable int id) {
        return ResponseEntity.ok(movieService.getMovieName(id));
    }

//    public ResponseEntity<?> getOngoingMovie(){
//        LocalDate today = LocalDate.now();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String str = formatter.format(today);
//        List<Movie> list = movieService.getMovies();
//        for (Movie movie: list) {
//
//        }
//    }

//    @ApiOperation(value = "Get a moivie gens")
//    @GetMapping("/movies/{id}/genr")
//    public ResponseEntity<?> getMovieGenr(@PathVariable int id) {
//
//        return movieService.getMovieGenr(id);
//    }
//
//
//    @ApiOperation(value = "Get a movie description")
//    @GetMapping("/movies/{id}/des")
//    public ResponseEntity<?> getMovieDes(@PathVariable int id) {
//        return movieService.getMovieDes(id);
//    }
//
//
//    @ApiOperation(value = "Get a movie trailer link")
//    @GetMapping("/movies/{id}/trailer")
//    public ResponseEntity<?> getMovieTrailer(@PathVariable int id) {
//        return movieService.getMovieTrailer(id);
//    }
//
//
//    @ApiOperation(value = "Get a movie censorship")
//    @GetMapping("/movies/{id}/cens")
//    public ResponseEntity<?> getMovieCens(@PathVariable int id) {
//        return movieService.getMovieCens(id);
//    }
//
//    @ApiOperation(value = "Get a movie release date")
//    @GetMapping("/movies/{id}/release")
//    public ResponseEntity<?> getMovieRelease(@PathVariable int id) {
//        return movieService.getMovieRelease(id);
//    }
//
//    @ApiOperation(value = "Get a movie lenght")
//    @GetMapping("/movies/{id}/lenght")
//    public ResponseEntity<?> getMovieLenght(@PathVariable int id) {
//        return movieService.getMovieLenght(id);
//    }
//
//    @ApiOperation(value = "Get a movie format")
//    @GetMapping("/movies/{id}/format")
//    public String getMovieFormat(@PathVariable int id) {
//        return movieService.getMovieFormat(id);
//    }
//
//    @ApiOperation(value = "Get a movie poster")
//    @GetMapping("/movies/{id}/poster")
//    public ResponseEntity<?> getMoviePoster(int id) {
//        return movieService.getMoviePoster(id);
//    }

//    public ResponseEntity<?> creatMovie(Movie movie){
//        return ResponseEntity.ok(movieService.createMovie(movie));
//    }


}
