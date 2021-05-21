package com.NetflixCloneProject.Popcorn.Time.Classes;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ResultSearchActor {

    private int page;
private List<ActorInfo> results;

    public List<ActorInfo> getResults() {
        return results;
    }

    public void setResults(List<ActorInfo> results) {
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
