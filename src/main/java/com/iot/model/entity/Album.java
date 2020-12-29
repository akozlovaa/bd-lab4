package com.iot.model.entity;

public class Album {
    private Integer id;
    private Integer artist_id;
    private String name;


    public Album(Integer id, Integer artist_id, String name) {
        this.id = id;
        this.artist_id = artist_id;
        this.name = name;
    }

    public Integer getArtistId() {
        return artist_id;
    }

    public void setArtistId(Integer artist_id) {
        this.artist_id = artist_id;
    }

    public Album(Integer artist_id, String name) {
        this.artist_id = artist_id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String link) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Website{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist_id=" + artist_id +
                '}';
    }
}
