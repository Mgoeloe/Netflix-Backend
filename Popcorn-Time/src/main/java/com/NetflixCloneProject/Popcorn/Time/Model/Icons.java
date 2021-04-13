package com.NetflixCloneProject.Popcorn.Time.Model;

import javax.persistence.*;

@Entity
@Table(name="icons")

public class Icons {
    @Column(nullable = false)
    private String IconTitle;
   private String IconUrl;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getIconTitle() {
        return IconTitle;
    }

    public void setIconTitle(String iconTitle) {
        IconTitle = iconTitle;
    }

    public String getIconUrl() {
        return IconUrl;
    }

    public void setIconUrl(String iconUrl) {
        IconUrl = iconUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
