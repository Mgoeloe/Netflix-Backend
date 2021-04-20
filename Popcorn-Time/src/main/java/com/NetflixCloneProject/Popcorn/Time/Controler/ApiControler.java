package com.NetflixCloneProject.Popcorn.Time.Controler;

import com.NetflixCloneProject.Popcorn.Time.Model.ApiModel;
//import com.NetflixCloneProject.Popcorn.Time.Service.MovieService;
import com.NetflixCloneProject.Popcorn.Time.Service.apiServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.NetflixCloneProject.Popcorn.Time.Service.apiMoviesService;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

//@RequestMapping
@RestController
@EnableFeignClients(basePackageClasses = apiServiceProxy.class)
public class ApiControler implements apiMoviesService {

    @Autowired
private apiServiceProxy proxy;
//
//    @Autowired
//    MovieService service;



//    public ApiControler(apiServiceProxy proxy) {
//        this.proxy = proxy;
//    }

//    @GetMapping("")
//    public String homePage() {
//
//        return "homepage";
//    }

//    @GetMapping("/api/movies/{id}")
//    public ResponseEntity OneMovie(@PathVariable Long id, HttpServletRequest request) {
//        try {
//            Optional<ApiModel> movieDetail = service.findProduct(id);
//            return new ResponseEntity<>(movieDetail, HttpStatus.OK);
//
//        } catch (Exception e) {
//            return new ResponseEntity<>("Het is niet gelukt", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//dkdkd
//    }

    @Override
    @GetMapping("/api/movies")
    public List<Object> getMovies() {
        return proxy.getMovies();
    }



    @GetMapping("/api/discover")
    public Optional<Object> discover() {
        return proxy.discover();
}

}
