package com.iot.model.entity;

public class Artist {

    private Integer id;
    private Integer label_id;
    private String band_id;
    private String name;

    public Artist(Integer id, Integer label_id, String band_id, String name) {
        this.id = id;
        this.label_id = label_id;
        this.band_id = band_id;
        this.name = name;
    }

    public Artist(Integer label_id, String band_id, String name) {
        this.label_id = label_id;
        this.band_id = band_id;
        this.name = name;
    }

    public Integer getLabel_id() {
        return label_id;
    }

    public void setLabel_id(Integer label_id) {
        this.label_id = label_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBand_id() {
        return band_id;
    }

    public void setBand_id(String band_id) {
        this.band_id = band_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", label_id=" + label_id +
                ", band_id='" + band_id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
