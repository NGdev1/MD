package ru.ProPoisk.models;

/**
 * Created by Михаил on 14.12.2016.
 */
public class Squad {
    private int id;
    private String name;

    public Squad(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
