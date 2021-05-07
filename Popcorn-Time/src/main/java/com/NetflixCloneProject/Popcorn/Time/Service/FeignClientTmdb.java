package com.NetflixCloneProject.Popcorn.Time.Service;


import com.NetflixCloneProject.Popcorn.Time.Classes.Discover;
import com.NetflixCloneProject.Popcorn.Time.Classes.Trailer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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


//  4. movie trailer
    @GetMapping(value = "/movie/{id}/videos", produces = "application/json")
    Trailer getVideos(@PathVariable Long id, @RequestParam String api_key);

//credits
//    @GetMapping(value = "/movie/{id}/credits", produces = "application/json")
//    Actors getCredits(@PathVariable Long id, @RequestParam String api_key);


    //80s/ 90s/ 00s Movies
    @GetMapping(value = "discover/movie?api_key=43adde1f22cb5d9f3d7d5852fa42e5e6&release_date.gte={gte}&release_date.lte={lte}", produces = "application/json")
    Optional<Discover> getEraMovies(@PathVariable String gte, @PathVariable String lte);

    //one genre
    @GetMapping(value = "/discover/movie?api_key=43adde1f22cb5d9f3d7d5852fa42e5e6&with_genres={gid}", produces = "application/json")
    Optional<Discover> getIdGenre(@PathVariable String gid);

//Disney movies
//    @RequestMapping(value = "/discover/movie?api_key=43adde1f22cb5d9f3d7d5852fa42e5e6&with_companies={comp}", produces = "application/json")
//    Optional<Disney> getCompany(@PathVariable String comp);

    @GetMapping(value = "/discover/movie?api_key=43adde1f22cb5d9f3d7d5852fa42e5e6&with_companies=3475", produces = "application/json")
    Optional<Object> getCompany();

    @GetMapping(value = "/search/person?api_key=43adde1f22cb5d9f3d7d5852fa42e5e6&query=will+smith", produces = "application/json")
    Optional<Object> getWillSmith();


//https://api.themoviedb.org/3/discover/movie?api_key=43adde1f22cb5d9f3d7d5852fa42e5e6&language=en-US&sort_by=popularity.desc&with_companies=3475


//    @GetMapping("/genre/movie/list")
//    Optional<Object> oneGenre(@PathVariable Long id, @RequestParam String api_key);
}
