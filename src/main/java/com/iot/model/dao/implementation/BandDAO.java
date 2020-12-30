package com.iot.model.dao.implementation;

import com.iot.DataBaseConnector;
import com.iot.model.dao.GeneralDAO;
import com.iot.model.entity.Band;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BandDAO implements GeneralDAO<Band> {

    private static final String GET_ALL = "SELECT * FROM spotify.band ORDER BY id";
    private static final String GET_ONE = "SELECT * FROM spotify.band WHERE id=?";
    private static final String CREATE = "INSERT  spotify.band " + "(name, num_of_artists) VALUES (?,?)";
    private static final String UPDATE = "UPDATE spotify.band"  + " SET num_of_artists=?, name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM spotify.band WHERE id=?";

    @Override
    public List<Band> findAll() {
        List<Band> bands = new ArrayList<>();
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Band band = new Band(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("num_of_artists")
                );
                bands.add(band);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bands;
    }

    @Override
    public Band findOne(Integer id) {
        Band band = null;
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                band = new Band(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("num_of_artists")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return band;
    }

    @Override
    public void create(Band band) throws SQLException {
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, band.getName());
            statement.setInt(2, band.getNum_of_artists());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Integer id, Band band) throws SQLException {
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, band.getId());
            statement.setString(2, band.getName());
            statement.setInt(3, band.getNum_of_artists());

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



