package com.NetflixCloneProject.Popcorn.Time.Controler;

import com.NetflixCloneProject.Popcorn.Time.Model.Icons;
import com.NetflixCloneProject.Popcorn.Time.Service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RequestMapping
@Controller
public class IconControler {

    @Autowired
    IconService service;

    @GetMapping("/api/icons/{id}")
    public ResponseEntity oneIcon(@PathVariable Long id, HttpServletRequest request) {
        try {
            Optional<Icons> iconDetail = service.findIcon(id);
            return new ResponseEntity<>(iconDetail, HttpStatus.OK);
//
        } catch (Exception e) {
            return new ResponseEntity<>("Het is niet gelukt", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


}
