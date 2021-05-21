package com.NetflixCloneProject.Popcorn.Time.Classes;

import java.util.List;

public class ReturnResultsActor {
    private String name;
    private Object data;
    private List<ActorInfo> suggestionsList;

    public List<ActorInfo> getSuggestionsList() {
        return suggestionsList;
    }

    public void setSuggestionsList(List<ActorInfo> suggestionsList) {
        this.suggestionsList = suggestionsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
@Override
public String toString() {
        return "{name=" + getName() + ", data=" + getData() + ", suggestions=" + getSuggestionsList() + "}";
    }
}
