package com.iot.model.dao.implementation;

import com.iot.DataBaseConnector;
import com.iot.model.dao.GeneralDAO;
import com.iot.model.entity.Album;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AlbumDAO implements GeneralDAO<Album> {

    private static final String GET_ALL = "SELECT * FROM spotify.album ORDER BY id";
    private static final String GET_ONE = "SELECT * FROM spotify.album WHERE id=?";
    private static final String CREATE = "INSERT  spotify.album "
            + "(artist_id,name) VALUES (?,?)";
    private static final String UPDATE = "UPDATE spotify.album"
            + " SET artist_id=?,name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM spotify.album WHERE id=?";

    @Override
    public List<Album> findAll() {
        List<Album> albums = new ArrayList<>();
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Album album = new Album(
                        resultSet.getInt("id"),
                        resultSet.getInt("artist_id"),
                        resultSet.getString("name")
                );
                albums.add(album);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return albums;
    }

    @Override
    public Album findOne(Integer id) {
        Album album = null;
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                album = new Album(
                        resultSet.getInt("id"),
                        resultSet.getInt("artist_id"),
                        resultSet.getString("name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return album;
    }

    @Override
    public void create(Album album) throws SQLException {
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(CREATE)) {
            statement.setString(2, String.valueOf(album.getName()));
            statement.setInt(1, Integer.valueOf(album.getArtistId()));

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Integer id, Album album) throws SQLException {
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, album.getArtistId());
            statement.setString(2, album.getName());
            statement.setInt(3, album.getId());
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



