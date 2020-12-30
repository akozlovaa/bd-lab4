package com.iot.controller;

import com.iot.model.dao.implementation.BandDAO;

import com.iot.model.entity.Band;


import java.sql.SQLException;
import java.util.List;


public class BandController implements GeneralController<Band> {

    BandDAO dao = new BandDAO();

    @Override
    public Band findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public List<Band> findAll() throws SQLException {
        return dao.findAll();
    }


    @Override
    public void create(Band entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Band entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}