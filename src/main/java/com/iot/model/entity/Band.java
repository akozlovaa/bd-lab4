package com.iot.model.entity;

public class Band {

    private Integer id;
    private String name;
    private Integer num_of_artists;


    public Band(Integer id, String name, Integer num_of_artists) {
        this.id = id;
        this.name = name;
        this.num_of_artists = num_of_artists;
    }

    public Band(String name, Integer num_of_artists) {
        this.name = name;
        this.num_of_artists = num_of_artists;
    }

    public Integer getNum_of_artists() {
        return num_of_artists;
    }
    public void setNum_of_artists(Integer num_of_artists) {
        this.num_of_artists = num_of_artists;
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
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Program{" +
                "id=" + id +
                ", num_of_artists=" + num_of_artists +
                ", name='" + name + '\'' +
                '}';
    }

}
