package com.iot.controller;

import com.iot.model.dao.implementation.ArtistDAO;
import com.iot.model.entity.Artist;

import java.sql.SQLException;
import java.util.List;

public class ArtistController implements GeneralController<Artist> {
    ArtistDAO dao = new ArtistDAO();

    @Override
    public List<Artist> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Artist findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(Artist entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Artist entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}
