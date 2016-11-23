package ru.ProPoisk.utils;

import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Artem Zalupa
 * Спасибо Артем!
 */

public class FormDataCheck {
    private FormDataCheck(){
    }
    public static TreeMap<String, String> checkAllFieldsAndGetErrorMessageIfFieldsAreInvalid(String fullName, String phoneNumber, String DOB, String password1, String password2, String gender, String city){
        TreeMap<String, String> errorMessage = new TreeMap<>();

        if(fullName == null){
            errorMessage.put("error", "\nНе верное имя");
        }

        if(!checkDOB(DOB)){
            errorMessage.put("error", "\nНе верная дата");
        }

        if (!checkPhoneNumber(phoneNumber)){
            errorMessage.put("error", "\nНе верный номер телефона");
        }
        if (!checkPassword(password1)){
            errorMessage.put("error", "\nНе верный пароль");
        }
        else{
            if (!password1.equals(password2)){
                errorMessage.put("error", "\nНе верный повтор пароля");
            }
        }
        if (!checkGender(gender)){
            errorMessage.put("error", "\nПол не указан");
        }
        if (!checkCity(city)){
            errorMessage.put("error", "\nГород не указан");
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
