package com.NetflixCloneProject.Popcorn.Time.Service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "apiMovieService")
public interface apiServiceProxy extends apiMoviesService {


}
