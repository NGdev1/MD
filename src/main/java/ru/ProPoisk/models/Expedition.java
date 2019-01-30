package ru.ProPoisk.models;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class Expedition {
    private int id;
    private String name;
    private boolean status;
    private String place;
    private List<Squad> squads;
    private List<User> participants;
    private List<Point> points;

    public Expedition(int id, String name, boolean status, String place, List<Squad> squads, List<User> participants, List<Point> points){
        this.id = id;
        this.name = name;
        this.status = status;
        this.place = place;
        this.squads = squads;
        this.participants = participants;
        this.points = points;
    }

    public Expedition(int id, String name, boolean status, String place){
        this.id = id;
        this.name = name;
        this.status = status;
        this.place = place;
        this.squads = new ArrayList<>();
        this.participants = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getStatus() {
        return status;
    }

    public String getPlace() {
        return place;
    }

    public List<Squad> getSquads() {
        return squads;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setSquads(List<Squad> squads) {
        this.squads = squads;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
