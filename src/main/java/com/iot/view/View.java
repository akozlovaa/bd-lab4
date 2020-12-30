package com.iot.view;

import com.iot.controller.*;
import com.iot.model.entity.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class View {
    private  final Scanner SCANNER = new Scanner(System.in);
    private final Map<String, Printable> menu = new LinkedHashMap<>();
    private final LabelController labelController = new LabelController();
    private final AlbumController albumController = new AlbumController();
    private final BandController bandController = new BandController();
    private final ArtistController artistController = new ArtistController();

    public View() {
        menu.put("11", this::getAllLabels);
        menu.put("12", this::GetLabelById);
        menu.put("13", this::createLabel);
        menu.put("14", this::updateLabel);
        menu.put("15", this::deleteLabel);

        menu.put("21", this::getAllAlbums);
        menu.put("22", this::getAlbumById);
        menu.put("23", this::createAlbum);
        menu.put("24", this::updateAlbum);
        menu.put("25", this::deleteAlbum);

        menu.put("31", this::getAllBands);
        menu.put("32", this::getBandById);
        menu.put("33", this::createBAnd);
        menu.put("34", this::updateBand);
        menu.put("35", this::deleteBand);

        menu.put("41", this::getAllArtists);
        menu.put("42", this::getArtistById);
        menu.put("43", this::createArtist);
        menu.put("44", this::updateArtist);
        menu.put("45", this::deleteArtist);

    }

    //Labels
    private void getAllLabels() throws SQLException {
        System.out.println("\ngetting all labels...");
        System.out.println(labelController.findAll() + "\n");
    }

    private void GetLabelById() throws SQLException {
        System.out.println("\nto get label enter id: ");
        Integer id = SCANNER.nextInt();
        System.out.println(labelController.findOne(id) + "\n");
    }

    private Label getLabelsInputs() {
        System.out.println("\nenter label name: ");
        String name = SCANNER.next();
        return new Label(name);
    }

    private void createLabel() throws SQLException {
        System.out.println("\ncreating new label");
        Label label = getLabelsInputs();
        labelController.create(label);
        System.out.println("new label created\n");
    }

    private void updateLabel() throws SQLException {
        System.out.println("\nto update label enter id: ");
        Integer id = SCANNER.nextInt();
        Label label = getLabelsInputs();
        label.setId(id);
        labelController.update(label.getId(), label);
        System.out.println("updated label with id = " + id + "\n");
    }

    private void deleteLabel() throws SQLException {
        System.out.println("\nto delete label enter id: ");
        int id = SCANNER.nextInt();
        labelController.delete(id);
        System.out.println("deleted label with id = " + id + "\n");
    }



    //album
    private void getAllAlbums() throws SQLException {
        System.out.println("\ngetting all albums...");
        System.out.println(albumController.findAll() + "\n");
    }

    private void getAlbumById() throws SQLException {
        System.out.println("\nto get album enter id: ");
        Integer id = SCANNER.nextInt();
        System.out.println(albumController.findOne(id) + "\n");
    }

    private Album getAlbumInputs() {
        System.out.println("\nenter artist id: ");
        Integer artist_id = Integer.valueOf(SCANNER.next());
        System.out.println("\nenter album name: ");
        String name = SCANNER.next();
        return new Album(artist_id, name);
    }

    private void createAlbum() throws SQLException {
        System.out.println("\ncreating album");
        Album album = getAlbumInputs();
        albumController.create(album);
        System.out.println("album created\n");
    }

    private void updateAlbum() throws SQLException {
        System.out.println("\nto update album enter id: ");
        Integer id = SCANNER.nextInt();
        Album album = getAlbumInputs();
        album.setId(id);

        albumController.update(album.getId(), album);
        System.out.println("updated album with id = " + id + "\n");
    }

    private void deleteAlbum() throws SQLException {
        System.out.println("\nto delete album enter id:");
        int id = SCANNER.nextInt();

        albumController.delete(id);
        System.out.println("deleted album with id = " + id + "\n");
    }

    //band
    private void getAllBands() throws SQLException {
        System.out.println("\ngetting all bands...");
        System.out.println(bandController.findAll() + "\n");
    }

    private void getBandById() throws SQLException {
        System.out.println("\nto get band enter id: ");
        Integer id = SCANNER.nextInt();
        System.out.println(bandController.findOne(id) + "\n");
    }

    private Band getBandInputs() {
        System.out.println("\nenter num_of_artists:");
        Integer num_of_artists = Integer.valueOf(SCANNER.next());
        System.out.println("\nenter name:");
        String name = SCANNER.next();

        return new Band(name, num_of_artists);
    }

    private void createBAnd() throws SQLException {
        System.out.println("\ncreating band");
        Band band = getBandInputs();
        bandController.create(band);
        System.out.println("band created\n");
    }

    private void updateBand() throws SQLException {
        System.out.println("\nto update band enter id: ");
        Integer id = SCANNER.nextInt();
        Band band = getBandInputs();
        band.setId(id);

        bandController.update(band.getId(), band);
        System.out.println("updated band with id = " + id + "\n");
    }

    private void deleteBand() throws SQLException {
        System.out.println("\nto delete band enter id: ");
        int id = SCANNER.nextInt();
        bandController.delete(id);
        System.out.println("deleted band with id = " + id + "\n");
    }


    //artists
    private void getAllArtists() throws SQLException {
        System.out.println("\ngettimg all artists...");
        System.out.println(artistController.findAll() + "\n");
    }

    private void getArtistById() throws SQLException {
        System.out.println("\nto get artist enter id: ");
        Integer id = SCANNER.nextInt();
        System.out.println(artistController.findOne(id) + "\n");
    }

    private Artist getArtistsInputs() {
        System.out.println("\nEnter name:");
        String name = SCANNER.next();
        System.out.println("\nEnter label_id:");
        Integer label_id = Integer.valueOf(SCANNER.next());
        System.out.println("\nEnter band_id:");
        String band_id = SCANNER.next();
        return new Artist(label_id, band_id, name);
    }

    private void createArtist() throws SQLException {
        System.out.println("\ncreating artist");
        Artist artist = getArtistsInputs();
        artistController.create(artist);
        System.out.println("artist created\n");
    }

    private void updateArtist() throws SQLException {
        System.out.println("\nto update artist enter id: ");
        Integer id = SCANNER.nextInt();
        Artist artist = getArtistsInputs();
        artist.setId(id);

        artistController.update(artist.getId(), artist);
        System.out.println("updated artist with id = " + id + "\n");
    }

    private void deleteArtist() throws SQLException {
        System.out.println("\nto delete artist enter id: ");
        int id = SCANNER.nextInt();
        artistController.delete(id);
        System.out.println("deleted artist with id = " + id + "\n");
    }
    public final void show() {
        String input;
        Menu showMenu = new Menu();
        showMenu.displayMenu();
        System.out.println("\nchoose wisely:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }
}