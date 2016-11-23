package ru.ProPoisk.DAO;

import java.sql.SQLException;

/**
 * Created by apple on 18.08.16.
 */
public interface UserDao {
    void saveUser(User user) throws SQLException;
    User getUser(int userId);
    User getUser(String userName);
    User[] getAll();
    void deleteUser(int userId);
    void printAll();
}
