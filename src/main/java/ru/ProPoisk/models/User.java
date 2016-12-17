package ru.ProPoisk.models;

import ru.ProPoisk.DAO.SquadsDaoImpl;

import java.sql.SQLException;

/**
 * Created by apple on 18.08.16.
 */

public class User {
    private String name;
    private int password;
    private int id;
    private boolean isMale;
    private String phoneNumber;
    private String DOB;
    private String city;
    private String image;
    private int squad;
    private String email;
    private String surname;
    private String patronymic;
    private String dolshnost;

    public User(String name, String password, boolean isMale, String phoneNumber, String DOB, String city, String image, int squad, String email, String surname, String patronymic, String dolshnost) {
        this.name = name;
        this.password = password.hashCode();
        this.isMale = isMale;
        this.phoneNumber = phoneNumber;
        this.DOB = DOB;
        this.city = city;
        this.image = image;
        this.squad = squad;
        this.email = email;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dolshnost = dolshnost;
    }

    public User(String name, int passwordHash, boolean isMale, String phoneNumber, String DOB, String city, String image, int squad, String email, String surname, String patronymic, String dolshnost) {
        this.name = name;
        this.password = passwordHash;
        this.isMale = isMale;
        this.phoneNumber = phoneNumber;
        this.DOB = DOB;
        this.city = city;
        this.image = image;
        this.squad = squad;
        this.email = email;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dolshnost = dolshnost;
    }

    public boolean confirmPassword(String password) {return this.password == password.hashCode();}

    public String getName() {return name;}

    public boolean isMale() {return isMale;}

    public int getPasswordHash() {return password;}

    public String getPhoneNumber() {return phoneNumber;}

    public String getDOB() {
        return DOB;
    }

    public String getCity() {return city;}

    public int getSquad() {return squad;}

    public String getEmail() {
        return email;
    }

    public String getOtryad(){
        try {
            return SquadsDaoImpl.getInstance().getSquadName(this.getSquad());
        } catch (SQLException e) {
            return "";
        }
    }

    public String getSurname() {return surname;}

    public String getPatronymic() {return patronymic;}

    public String getDolshnost() {return dolshnost;}

    public String getImage() {return image;}

    public int getId() {return id;}

    public void setName(String name) {this.name = name;}

    public void setCity(String city) {this.city = city;}

    public void setSquad(int squad) {this.squad = squad;}

    public void setEmail(String email) {this.email = email;}

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setDolshnost(String dolshnost) {
        this.dolshnost = dolshnost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    @Override
    public String toString() {
        return "Имя: " + name + "; id: " + Integer.toString(id) + "; Пол: " + Boolean.toString(isMale) +
                "; number: " + getPhoneNumber() + "; город: " + city + "; Дата рождения: " + DOB + "; Отряд: " + squad
                + "; email " + email + "; Фамилия " + surname + "; Отчество " + patronymic + "; Должность " + dolshnost;
    }
}
