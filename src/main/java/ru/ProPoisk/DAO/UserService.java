package ru.ProPoisk.DAO;

import java.sql.SQLException;

/**
 */
public interface UserService {
    boolean isRegistered(String userName);
}
