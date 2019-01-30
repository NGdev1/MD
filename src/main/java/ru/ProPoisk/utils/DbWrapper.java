package ru.ProPoisk.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbWrapper {
    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private final static String CONNECTION_URI = "jdbc:mysql://127.0.0.1:3306/?characterEncoding=UTF-8";
    private final static String LOGIN = "root";
    private final static String PASSWORD = "root";

    private static Connection conn;

    public static Connection getConnection(){
        if(conn == null){
            try{
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(CONNECTION_URI, LOGIN, PASSWORD);
            }
            catch(ClassNotFoundException ex){
                System.out.println("Can't find DB driver.");
            } catch (SQLException ex) {
                System.out.println("Can't connect to DB (" + ex.getErrorCode() + ": " + ex.getMessage() + ").");
            }

        }
        return conn;
    }
}
