package com.NetflixCloneProject.Popcorn.Time.Service;


import com.NetflixCloneProject.Popcorn.Time.Classes.Actors;
import com.NetflixCloneProject.Popcorn.Time.Classes.Discover;
import com.NetflixCloneProject.Popcorn.Time.Classes.Trailer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Tmbd", url = "https://api.themoviedb.org/3")

public interface FeignClientTmdb {

//1.  moviepagina
    @GetMapping("/discover/movie")
    Optional<Object> discover(@RequestParam String api_key);

//2.  discover
    @GetMapping("/movie/{id}")
    Optional<Object> oneMovie(@PathVariable Long id, @RequestParam String api_key);

//    3.  discover
    @GetMapping("/genre/movie/list")
    Optional<Object> genre(@RequestParam String api_key);

//@GetMapping("discover/movie/{era}")
//    List<Discover>

//
//    @GetMapping("/movie/{id}/videos")
//    Optional<Object> videoMovie(@PathVariable Long id, @RequestParam String api_key);


//  4. movie trailer
    @GetMapping(value = "/movie/{id}/videos", produces = "application/json")
    Trailer getVideos(@PathVariable Long id, @RequestParam String api_key);

//credits
    @GetMapping(value = "/movie/{id}/credits", produces = "application/json")
    Actors getCredits(@PathVariable Long id, @RequestParam String api_key);

//    @GetMapping(value = "api/movies/discover/{era}", produces = "application/json")
//    Optional<Discover> getEraMovies(String gte, String lte);

    //80s/ 90s/ 00s Movies
    @GetMapping(value = "discover/movie?api_key=43adde1f22cb5d9f3d7d5852fa42e5e6&release_date.gte={gte}&release_date.lte={lte}", produces = "application/json")
    Optional<Discover> getEraMovies(@PathVariable String gte, @PathVariable String lte);

//    @GetMapping("/genre/movie/list")
//    Optional<Object> oneGenre(@PathVariable Long id, @RequestParam String api_key);
}
