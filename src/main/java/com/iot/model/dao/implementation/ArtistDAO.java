package com.iot.model.dao.implementation;

import com.iot.DataBaseConnector;
import com.iot.model.dao.GeneralDAO;
import com.iot.model.entity.Artist;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ArtistDAO implements GeneralDAO<Artist> {

    private static final String GET_ALL = "SELECT * FROM spotify.artist ORDER BY id";
    private static final String GET_ONE = "SELECT * FROM spotify.artist WHERE id=?";
    private static final String CREATE = "INSERT  spotify.artist "
            + "(label_id,band_id,name) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE spotify.artist"
            + " SET label_id=?,band_id=?,name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM spotify.artist WHERE id=?";

    @Override
    public List<Artist> findAll() {
        List<Artist> programs = new ArrayList<>();
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Artist program = new Artist(
                        resultSet.getInt("id"),
                        resultSet.getInt("label_id"),
                        resultSet.getString("band_id"),
                        resultSet.getString("name")
                );
                programs.add(program);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return programs;
    }

    @Override
    public Artist findOne(Integer id) {
        Artist artist = null;
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                artist = new Artist(
                        resultSet.getInt("id"),
                        resultSet.getInt("label_id"),
                        resultSet.getString("band_id"),
                        resultSet.getString("name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return artist;
    }

    @Override
    public void create(Artist artist) throws SQLException {
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, Integer.valueOf(artist.getLabel_id()));
            statement.setString(2, String.valueOf(artist.getBand_id()));
            statement.setString(3, String.valueOf(artist.getName()));

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Integer id, Artist artist) throws SQLException {
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, artist.getLabel_id());
            statement.setString(2, artist.getBand_id());
            statement.setString(3, artist.getName());
            statement.setInt(4, artist.getId());
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



