package com.NetflixCloneProject.Popcorn.Time.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@FeignClient(name = "apiMovieService", url = "https://api.themoviedb.org/3")
public interface apiServiceProxy extends apiMoviesService {


    @GetMapping("/discover/movie?api_key=43adde1f22cb5d9f3d7d5852fa42e5e6")
    Optional<Object> discover();

}



//endpoints alvast als commentaar hierin zetten voor:
//DISCOVER, GENERE, MOVIE