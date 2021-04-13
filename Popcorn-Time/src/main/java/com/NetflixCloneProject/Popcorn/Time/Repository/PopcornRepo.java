package com.NetflixCloneProject.Popcorn.Time.Repository;

import com.NetflixCloneProject.Popcorn.Time.Model.ApiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopcornRepo extends JpaRepository<ApiModel, Long> {
}
