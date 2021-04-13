package com.NetflixCloneProject.Popcorn.Time.Service;

import com.NetflixCloneProject.Popcorn.Time.Model.Icons;
import com.NetflixCloneProject.Popcorn.Time.Repository.IconsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IconService {

    @Autowired
    private IconsRepo repo;

    public Optional<Icons> findIcon(Long id) {
        return repo.findById(id);
    }
}
