package ru.ProPoisk.DAO;

import java.sql.SQLException;

/**
 * Created by apple on 22.08.16.
 */
public interface UserService {
    boolean isRegistered(String userName);
}
