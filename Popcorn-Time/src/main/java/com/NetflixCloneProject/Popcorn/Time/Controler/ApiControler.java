package com.NetflixCloneProject.Popcorn.Time.Controler;

import com.NetflixCloneProject.Popcorn.Time.Model.ApiModel;
import com.NetflixCloneProject.Popcorn.Time.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RequestMapping
@Controller
public class ApiControler {



    @Autowired
    MovieService service;

    @GetMapping("")
    public String homePage() {

        return "homepage";
    }

    @GetMapping("/api/movies/{id}")
    public ResponseEntity OneMovie(@PathVariable Long id, HttpServletRequest request) {
        try {
            Optional<ApiModel> movieDetail = service.findProduct(id);
            return new ResponseEntity<>(movieDetail, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Het is niet gelukt", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }













}
