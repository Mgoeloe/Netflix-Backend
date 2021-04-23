package com.NetflixCloneProject.Popcorn.Time.Controler;


//import com.NetflixCloneProject.Popcorn.Time.Service.MovieService;
import com.NetflixCloneProject.Popcorn.Time.Classes.Trailer;
import com.NetflixCloneProject.Popcorn.Time.Classes.TrailerLink;
import com.NetflixCloneProject.Popcorn.Time.Classes.Video;
import com.NetflixCloneProject.Popcorn.Time.Service.FeignClientTmdb;

import javassist.ClassMap;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@RequestMapping
@RestController
@CrossOrigin
public class ApiControler {

    @Autowired
    private FeignClientTmdb client;


//discover
    @GetMapping("api/movies/{id}")
    public ResponseEntity OneMovie(@PathVariable Long id, HttpServletRequest request) {

        try {

            Optional<Object> movieDetail = client.oneMovie(id, "43adde1f22cb5d9f3d7d5852fa42e5e6");
            return new ResponseEntity<>(movieDetail.get(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Het is niet gelukt", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    moviepagina
    @GetMapping("api/movies/discover")
    public ResponseEntity discoverMovie(HttpServletRequest request) {


        try {
            Optional<Object> discovMovie = client.discover("43adde1f22cb5d9f3d7d5852fa42e5e6");
            return new ResponseEntity<>(discovMovie.get(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Het is niet gelukt", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    discoverpagina
    @GetMapping("api/movies/genre")
    public ResponseEntity genreMovie(HttpServletRequest request) {


        try {
            Optional<Object> movieGenre = client.genre("43adde1f22cb5d9f3d7d5852fa42e5e6");
            return new ResponseEntity<>(movieGenre.get(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Het is niet gelukt", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("api/movies/{id}/video")

    public ResponseEntity<List<Video>> getMovieTrailers(@PathVariable Long id, HttpServletRequest request) {

        List<Object> linksList = new ArrayList<>();
        System.out.println(request.toString());
        try {

            Trailer trailersList = client.getVideos(id, "43adde1f22cb5d9f3d7d5852fa42e5e6");
            for (Video item: trailersList.getResults()) {

                TrailerLink link = new TrailerLink();

                switch (item.getSite()){
                    case "Vimeo":
                        link.setHref(makeVimeoLink(item));
                        break;
                    default: link.setHref(makeYoutubeLink(item));
                }
                link.setRel(item.getName());

                linksList.add(link);
            }

            return new ResponseEntity(linksList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity("Het is niet gelukt", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String makeYoutubeLink(Video t) {
        final String baseUrl = "https://www.youtube.com/watch?v=";

        return baseUrl+t.getKey();
    }

    private String makeVimeoLink(Video t) {
        final String baseUrl = "https://www.vimeo.com/";

        return baseUrl+t.getKey();
    }


}