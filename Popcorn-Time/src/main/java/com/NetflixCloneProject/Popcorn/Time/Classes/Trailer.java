package com.NetflixCloneProject.Popcorn.Time.Classes;

import java.util.List;

public class Trailer {

    private Integer id;
    private List<Video> results;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Video> getResults() {
        return results;
    }

    public void setResults(List<Video> results) {
        this.results = results;
    }
}
