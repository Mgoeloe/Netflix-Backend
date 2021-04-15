package com.NetflixCloneProject.Popcorn.Time.Controler;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
public interface apiMovieService {

//    @GetMapping("")
//    public default String homePage()
//    {
//        return "https://competent-neumann-d15cc7.netlify.app/";
//    }

    @GetMapping("/api/movies")
    public default List<Object> getMovies() {
        return null;
    }


}
