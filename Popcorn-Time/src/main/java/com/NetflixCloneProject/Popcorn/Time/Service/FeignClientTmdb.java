package com.NetflixCloneProject.Popcorn.Time.Service;


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

//
//    @GetMapping("/movie/{id}/videos")
//    Optional<Object> videoMovie(@PathVariable Long id, @RequestParam String api_key);


//  4. movie trailer
    @GetMapping(value = "/movie/{id}/videos", produces = "application/json")
    Trailer getVideos(@PathVariable Long id, @RequestParam String api_key);


}
