package ru.ProPoisk.utils;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**

 */

public class FormDataCheck {
    private FormDataCheck(){
    }
    public static ArrayList<String> checkAllFields(String fullName, String phoneNumber, String DOB, String password1, String password2, String gender, String city){
        ArrayList<String> errorMessage = new ArrayList<>();

        if(fullName == null){
            errorMessage.add("Не верное имя");
        }

        if(!checkDOB(DOB)){
            errorMessage.add("Не верная дата");
        }

        if (!checkPhoneNumber(phoneNumber)){
            errorMessage.add("Не верный номер телефона");
        }
        if (!checkPassword(password1)){
            errorMessage.add("Не верный пароль");
        }
        else{
            if (!password1.equals(password2)){
                errorMessage.add("Не верный повтор пароля");
            }
        }
        if (!checkGender(gender)){
            errorMessage.add("Пол не указан");
        }
        if (!checkCity(city)){
            errorMessage.add("Город не указан");
        }

        return errorMessage;
    }

    public static boolean checkDOB(String DOB){
        if (DOB != null){
            Pattern p = Pattern.compile("^\\d\\d\\d\\d-\\d\\d-\\d\\d$");
            Matcher m = p.matcher(DOB);
            return m.matches();
        }
        else{
            return false;
        }
    }

    public static boolean checkPassword(String pass){
        if (pass != null){
            Pattern p = Pattern.compile("^[a-zA-Z0-9]{4,}$");
            Matcher m = p.matcher(pass);
            return m.matches();
        }
        else{
            return false;
        }
    }
    public static boolean checkPhoneNumber(String phoneNumber){
        if (phoneNumber != null){
            Pattern p = Pattern.compile("^[0-9]+$");
            Matcher m = p.matcher(phoneNumber);
            return m.matches();
        }
        else{
            return false;
        }
    }
    public static boolean checkGender(String gender){
        if (gender != null){
            if (gender.equals("male") || gender.equals("female")){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    public static boolean checkCity(String city) {
        return "Kazan".equals(city) || "Moscow".equals(city) || "Spb".equals(city);
    }
}
