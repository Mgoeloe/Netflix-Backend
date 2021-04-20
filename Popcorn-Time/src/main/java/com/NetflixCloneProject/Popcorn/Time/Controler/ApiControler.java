package com.NetflixCloneProject.Popcorn.Time.Controler;

import com.NetflixCloneProject.Popcorn.Time.Model.ApiModel;
//import com.NetflixCloneProject.Popcorn.Time.Service.MovieService;
import com.NetflixCloneProject.Popcorn.Time.Service.FeignClientTmdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.NetflixCloneProject.Popcorn.Time.Service.apiMoviesService;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

//@RequestMapping
@RestController

public class ApiControler {

    @Autowired
    private FeignClientTmdb client;



    @GetMapping("api/movies/{id}")
    public ResponseEntity OneMovie(@PathVariable Long id, HttpServletRequest request) {

        Optional<Object> movieDetail = client.oneMovie(id, "43adde1f22cb5d9f3d7d5852fa42e5e6");
        System.out.println(request);

        try {

            return new ResponseEntity<>(movieDetail.get(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Het is niet gelukt", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("api/movies/discover")
    public ResponseEntity discoverMovie(HttpServletRequest request) {


        try {
            Optional<Object> discovMovie = client.discover("43adde1f22cb5d9f3d7d5852fa42e5e6");
            return new ResponseEntity<>(discovMovie.get(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Het is niet gelukt", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("api/movies/genre")
    public ResponseEntity genreMovie(HttpServletRequest request) {


        try {
            Optional<Object> movieGenre = client.genre("43adde1f22cb5d9f3d7d5852fa42e5e6");
            return new ResponseEntity<>(movieGenre.get(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Het is niet gelukt", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}