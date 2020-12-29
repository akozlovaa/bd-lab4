package com.iot.model.dao.implementation;

import com.iot.DataBaseConnector;
import com.iot.model.dao.GeneralDAO;
import com.iot.model.entity.Label;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LabelDAO implements GeneralDAO<Label> {

    private static final String GET_ALL = "SELECT * FROM spotify.label ORDER BY id";
    private static final String GET_ONE = "SELECT * FROM FROM spotify.label WHERE id=?";
    private static final String CREATE = "INSERT  FROM spotify.label "
            + "(name) VALUES (?)";
    private static final String UPDATE = "UPDATE FROM spotify.label"
            + " SET name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM FROM spotify.label WHERE id=?";

    @Override
    public List<Label> findAll() {
        List<Label> labels = new ArrayList<>();
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Label label = new Label(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                labels.add(label);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return labels;
    }

    @Override
    public Label findOne(Integer id) {
        Label label = null;
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                label = new Label(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return label;
    }

    @Override
    public void create(Label label) throws SQLException {
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(label.getName()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Integer id, Label label) throws SQLException {
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(UPDATE)) {
            statement.setString(2, label.getName());
            statement.setInt(1, label.getId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}



