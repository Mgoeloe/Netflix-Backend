package com.NetflixCloneProject.Popcorn.Time.Repository;

import com.NetflixCloneProject.Popcorn.Time.Model.Icons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IconsRepo extends JpaRepository<Icons, Long> {

    Optional<Icons> findById();
}
