package com.NetflixCloneProject.Popcorn.Time.Classes;

import java.util.List;

public class Actors {
    private Integer id;
    private List<Credits> results;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Credits> getResults() {
        return results;
    }

    public void setResults(List<Credits> results) {
        this.results = results;
    }
}
