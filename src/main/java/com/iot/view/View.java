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
        //CHOOSE
        menu.put("11", this::getAllLabels);
        menu.put("12", this::GetLabelById);
        menu.put("13", this::createLabel);
        menu.put("14", this::updateLabel);
        menu.put("15", this::deleteLabel);

        menu.put("21", this::getAllWebsite);
        menu.put("22", this::getWebsiteByID);
        menu.put("23", this::createWebsite);
        menu.put("24", this::updateWebsite);
        menu.put("25", this::deleteWebsite);

        menu.put("31", this::getAllPrograms);
        menu.put("32", this::getProgramsByID);
        menu.put("33", this::createProgram);
        menu.put("34", this::updateProgram);
        menu.put("35", this::deleteProgram);

        menu.put("41", this::getAllArtists);
        menu.put("42", this::getArtistById);
        menu.put("43", this::createArtist);
        menu.put("44", this::updateArtist);
        menu.put("45", this::deleteArtist);

    }

//-----------------------------------------------
//                 Labels
// ----------------------------------------------
    private void getAllLabels() throws SQLException {
        System.out.println("\n--Getting all labels--");
        System.out.println(labelController.findAll() + "\n");
    }

    private void GetLabelById() throws SQLException {
        System.out.println("\n--Getting specific label.Enter id: ");
        Integer id = SCANNER.nextInt();
        System.out.println(labelController.findOne(id) + "\n");
    }

    private Label getLabelsInputs() {
        System.out.println("\nEnter label name: ");
        String name = SCANNER.next();
        return new Label(name);
    }

    private void createLabel() throws SQLException {
        System.out.println("\n--Creating label--");
        Label label = getLabelsInputs();
        labelController.create(label);
        System.out.println("--Label created--\n");
    }

    private void updateLabel() throws SQLException {
        System.out.println("\n--Updating label.Enter id:");
        Integer id = SCANNER.nextInt();
        Label label = getLabelsInputs();
        label.setId(id);

        labelController.update(label.getId(), label);
        System.out.println("Updated label with id=" + id + "\n");
    }

    private void deleteLabel() throws SQLException {
        System.out.println("\n--Deleting label.Enter id:");
        int id = SCANNER.nextInt();

        labelController.delete(id);
        System.out.println("--Deleted label with id=" + id + "\n");
    }



//---------------------------------------
//                 Website
//---------------------------------------
    private void getAllWebsite() throws SQLException {
        System.out.println("\n--Getting all websites--");
        System.out.println(albumController.findAll() + "\n");
    }

    private void getWebsiteByID() throws SQLException {
        System.out.println("\n--Getting specific website.Enter id:");
        Integer id = SCANNER.nextInt();
        System.out.println(albumController.findOne(id) + "\n");
    }

    private Album getWebsiteInputs() {
        System.out.println("\nEnter company id:");
        Integer companyId = Integer.valueOf(SCANNER.next());
        System.out.println("\nEnter website link:");
        String link = SCANNER.next();
        return new Album(companyId,link);
    }

    private void createWebsite() throws SQLException {
        System.out.println("\n--Creating website--");
        Album album = getWebsiteInputs();
        albumController.create(album);
        System.out.println("--Website created--\n");
    }

    private void updateWebsite() throws SQLException {
        System.out.println("\n--Updating website.Enter id:");
        Integer id = SCANNER.nextInt();
        Album album = getWebsiteInputs();
        album.setId(id);

        albumController.update(album.getId(), album);
        System.out.println("Updated website with id=" + id + "\n");
    }

    private void deleteWebsite() throws SQLException {
        System.out.println("\n--Deleting website.Enter id:");
        int id = SCANNER.nextInt();

        albumController.delete(id);
        System.out.println("--Deleted website with id=" + id + "\n");
    }

    //--------------------------------------
//                 Program
//---------------------------------------
    private void getAllPrograms() throws SQLException {
        System.out.println("\n--Getting all programs--");
        System.out.println(bandController.findAll() + "\n");
    }

    private void getProgramsByID() throws SQLException {
        System.out.println("\n--Getting specific program.Enter id:");
        Integer id = SCANNER.nextInt();
        System.out.println(bandController.findOne(id) + "\n");
    }

    private Band getProgramInputs() {
        System.out.println("\nEnter name:");
        String name = SCANNER.next();
        System.out.println("\nEnter num_of_artists:");
        Integer num_of_artists = Integer.valueOf(SCANNER.next());
        return new Band(name, num_of_artists);
    }

    private void createProgram() throws SQLException {
        System.out.println("\n--Creating program--");
        Band band = getProgramInputs();
        bandController.create(band);
        System.out.println("--Program program--\n");
    }

    private void updateProgram() throws SQLException {
        System.out.println("\n--Updating program.Enter id:");
        Integer id = SCANNER.nextInt();
        Band band = getProgramInputs();
        band.setId(id);

        bandController.update(band.getId(), band);
        System.out.println("Updated program with id=" + id + "\n");
    }

    private void deleteProgram() throws SQLException {
        System.out.println("\n--Deleting program.Enter id:");
        int id = SCANNER.nextInt();
        bandController.delete(id);
        System.out.println("--Deleted program with id=" + id + "\n");
    }


//---------------------------------------
//                 Artist
//---------------------------------------
    private void getAllArtists() throws SQLException {
        System.out.println("\n--Getting all artists--");
        System.out.println(artistController.findAll() + "\n");
    }

    private void getArtistById() throws SQLException {
        System.out.println("\n--Getting specific reporter.Enter id:");
        Integer id = SCANNER.nextInt();
        System.out.println(artistController.findOne(id) + "\n");
    }

    private Artist getArtistsInputs() {
        System.out.println("\nEnter label id:");
        Integer label_id = Integer.valueOf(SCANNER.next());
        System.out.println("\nEnter band name:");
        String band_id = SCANNER.next();
        System.out.println("\nEnter name:");
        String name = SCANNER.next();
        return new Artist(label_id, band_id, name);
    }

    private void createArtist() throws SQLException {
        System.out.println("\n--Creating artist--");
        Artist artist = getArtistsInputs();
        artistController.create(artist);
        System.out.println("--Artist created--\n");
    }

    private void updateArtist() throws SQLException {
        System.out.println("\n--Updating artist. Enter id:");
        Integer id = SCANNER.nextInt();
        Artist artist = getArtistsInputs();
        artist.setId(id);

        artistController.update(artist.getId(), artist);
        System.out.println("Updated artist with id=" + id + "\n");
    }

    private void deleteArtist() throws SQLException {
        System.out.println("\n--Deleting artist. Enter id:");
        int id = SCANNER.nextInt();
        artistController.delete(id);
        System.out.println("--Deleted artist with id=" + id + "\n");
    }
    public final void show() {
        String input;
        Menu showMenu = new Menu();
        showMenu.displayMenu();
        System.out.println("\nSO what now?:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }
}