package com.NetflixCloneProject.Popcorn.Time;

import com.NetflixCloneProject.Popcorn.Time.Model.ApiModel;
import com.NetflixCloneProject.Popcorn.Time.Repository.PopcornRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class PopcornRepoTest {
    @Autowired
    private PopcornRepo repo;
    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void TestCreateMovie(){
        ApiModel movieModel = new ApiModel();
        movieModel.setMovieTitle("The intruder");
        movieModel.setMovieGenre("Horror");
        movieModel.setMovieDescription("Omschrijving");
        ApiModel saveMovies = repo.save(movieModel);
        ApiModel existMovies = entityManager.find(ApiModel.class, saveMovies.getId());
        assertThat(existMovies.getId()).isEqualTo(movieModel.getId());
    }

}


