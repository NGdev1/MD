package ru.ProPoisk.models;

/**
 * Created by Михаил on 20.12.2016.
 */
public class Point {
    int id;
    int idExpedition;
    double longitude;
    double latitude;
    String name;
    String description;
    String dateTime;
    String image;

    public Point(int id, int idExpedition, double longitude, double latitude, String name, String description, String dateTime, String image) {
        this.id = id;
        this.idExpedition = idExpedition;
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.description = description;
        this.dateTime = dateTime;
        this.image = image;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getImage() {
        return image;
    }

    public int getId() {
        return id;
    }

    public int getIdExpedition() {
        return idExpedition;
    }
}
