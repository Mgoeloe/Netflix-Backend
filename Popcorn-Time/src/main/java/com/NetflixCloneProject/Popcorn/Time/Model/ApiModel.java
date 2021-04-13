package com.NetflixCloneProject.Popcorn.Time.Model;

import javax.persistence.*;

@Entity
@Table(name="movies")

public class ApiModel {
@Column(nullable = false)
    private String MovieTitle;
    private String MovieDescription;
    private String MovieGenre;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getMovieTitle() {
        return MovieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        MovieTitle = movieTitle;
    }

    public String getMovieDescription() {
        return MovieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        MovieDescription = movieDescription;
    }

    public String getMovieGenre() {
        return MovieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        MovieGenre = movieGenre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
