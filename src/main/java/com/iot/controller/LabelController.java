package com.iot.controller;

import com.iot.model.dao.implementation.LabelDAO;
import com.iot.model.entity.Label;

import java.sql.SQLException;
import java.util.List;


public class LabelController implements GeneralController<Label> {

    LabelDAO dao = new LabelDAO();

    @Override
    public Label findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public List<Label> findAll() throws SQLException {
        return dao.findAll();
    }


    @Override
    public void create(Label entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Label entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}