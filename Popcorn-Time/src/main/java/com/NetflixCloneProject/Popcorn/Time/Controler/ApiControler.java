package com.NetflixCloneProject.Popcorn.Time.Controler;


//import com.NetflixCloneProject.Popcorn.Time.Service.MovieService;
import com.NetflixCloneProject.Popcorn.Time.Classes.*;
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

    //release_date.gte={gte}

    //80s/90s/ 00s
    @GetMapping("api/movies/discover/{era}")
    public ResponseEntity<List<Discover>> getMovieEra(@PathVariable Integer era){
        Release_Date release_date = new Release_Date();
        switch (era){
            case 80:
                release_date.setGte("1980-01-01");
                release_date.setLte("1989-12-31");
                break;
            case 90:
                release_date.setGte("1990-01-01");
                release_date.setLte("1999-12-31");
                break;
            case 00:
                release_date.setGte("2000-01-01");
                release_date.setLte("2009-12-31");
                break;
            default:
//                System.out.println("NOPE!! DEFAULT TRIGGERED!");
        }
//        System.out.println("GTE is "+ release_date.getGte() +"\n LTE is "+release_date.getLte());
        Optional<Discover> movieData = client.getEraMovies(release_date.getGte(), release_date.getLte());
//        System.out.println(movieData.get());
        try{
            return new ResponseEntity(movieData.get(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Het is niet gelukt", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//------------------------------------------------------------------------------------------------------
    //genre id
    @GetMapping("api/movies/genre/{idg}")
    public ResponseEntity <List<Genre>> getOneGenre(@PathVariable int idg) {
        OneGenre with_genres = new OneGenre();
        switch (idg) {
            case 28:
                with_genres.setGid("28");
                break;

            case 16:
                with_genres.setGid("16");
                break;

        }
        Optional<Discover> genreData = client.getIdGenre(with_genres.getGid());
        try {

            return new ResponseEntity(genreData.get(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity("het is niet gelukt", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//---------------------------------------------------------------------------------------------------------

//Actors / credits
    @GetMapping("api/movies/{id}/credits")
public ResponseEntity<List<Credits>> getActors(@PathVariable Long id, HttpServletRequest request) {
        List<Object> ActorsList = new ArrayList<>();

        try {
            Actors actorslist = client.getCredits(id, "43adde1f22cb5d9f3d7d5852fa42e5e6");
//            for (Credits item : actorslist.getResults()) {
            return new ResponseEntity(getActors(id, request), HttpStatus.OK);
        }
            catch (Exception e) {
                return new ResponseEntity("Het is niet gelukt", HttpStatus.INTERNAL_SERVER_ERROR);
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