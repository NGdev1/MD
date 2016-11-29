package ru.ProPoisk.DAO;

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
    private String imageB64;
    private String otryad;
    private String email;
    private String surname;
    private String patronymic;


    public User(String name, String password, boolean isMale, String phoneNumber, String DOB, String city, String imageB64, String otryad, String email, String surname, String patronymic){
        this.name = name;
        this.password = password.hashCode();
        this.isMale = isMale;
        this.phoneNumber = phoneNumber;
        this.DOB = DOB;
        this.city = city;
        this.imageB64 = imageB64;
        this.otryad = otryad;
        this.email = email;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public User(String name, int passwordHash, boolean isMale, String phoneNumber, String DOB, String city, String imageB64, String otryad, String email, String surname, String patronymic){
        this.name = name;
        this.password = passwordHash;
        this.isMale = isMale;
        this.phoneNumber = phoneNumber;
        this.DOB = DOB;
        this.city = city;
        this.imageB64 = imageB64;
        this.otryad = otryad;
        this.email = email;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public boolean confirmPassword(String password){
        return this.password == password.hashCode();
    }

    public String getName() {return name;}

    public boolean isMale() {return isMale;}

    public int getPasswordHash(){return password;}

    public String getPhoneNumber(){return phoneNumber;}

    public String getDOB(){return DOB;}

    public String getCity(){
        return city;
    }

    public String getOtryad(){
        return otryad;
    }

    public String getEmail(){
        return email;
    }

    public String getSurname() {return surname;}

    public String getPatronymic() {return patronymic;}

    public String getImageB64(){return imageB64;}

    public int getId() {return id;}

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {this.city = city;}

    public void setOtryad(String otryad) {this.otryad = otryad;}

    public void setEmail(String email) {
        this.otryad = email;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setImageB64(String imageB64) {
        this.imageB64 = imageB64;
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
                "; number: " + getPhoneNumber() + "; город: " + city + "; Дата рождения: " + DOB + "; Отряд: " + otryad
                + "; email " + email + "; Фамилия " + surname + "; Отчество " + patronymic;
    }
}
