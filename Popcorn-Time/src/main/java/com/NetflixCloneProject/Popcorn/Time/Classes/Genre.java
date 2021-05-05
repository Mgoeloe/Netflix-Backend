package com.NetflixCloneProject.Popcorn.Time.Classes;

//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "genres")

public class Genre {


    private String name;
    private Integer id;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
