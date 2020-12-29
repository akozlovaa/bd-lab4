package com.iot.controller;

import com.iot.model.dao.implementation.AlbumDAO;

import com.iot.model.entity.Album;


import java.sql.SQLException;
import java.util.List;


public class AlbumController implements GeneralController<Album> {

    AlbumDAO dao = new AlbumDAO();

    @Override
    public Album findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public List<Album> findAll() throws SQLException {
        return dao.findAll();
    }


    @Override
    public void create(Album entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Album entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}