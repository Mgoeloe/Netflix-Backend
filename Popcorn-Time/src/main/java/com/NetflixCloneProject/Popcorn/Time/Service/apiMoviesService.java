package com.NetflixCloneProject.Popcorn.Time.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
public interface apiMoviesService {

    @GetMapping("/api/movies")
    public List<Object> getMovies();

}

