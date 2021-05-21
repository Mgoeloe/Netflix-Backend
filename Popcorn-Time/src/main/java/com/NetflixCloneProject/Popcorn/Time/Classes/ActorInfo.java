package com.NetflixCloneProject.Popcorn.Time.Classes;

public class ActorInfo {
    private int id;
private String name;
private String known_for_department;

    public String getKnown_for_department() {
        return known_for_department;
    }

    public void setKnown_for_department(String known_for_department) {
        this.known_for_department = known_for_department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{name=" + getName() + ", id=" + getId() + "}";
    }
}
