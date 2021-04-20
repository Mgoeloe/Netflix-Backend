package com.NetflixCloneProject.Popcorn.Time.Service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name = "Tmbd", url = "https://api.themoviedb.org/3")

public interface FeignClientTmdb {


    @GetMapping("/discover/movie")
    Optional<Object> discover(@RequestParam String api_key);

    @GetMapping("/movie/{id}")
    Optional<Object> oneMovie(@PathVariable Long id, @RequestParam String api_key);

    @GetMapping("/genre/movie/list")
    Optional<Object> genre(@RequestParam String api_key);


}
