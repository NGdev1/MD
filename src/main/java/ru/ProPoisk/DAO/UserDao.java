package ru.ProPoisk.DAO;

import ru.ProPoisk.models.User;

import java.sql.SQLException;

/**
 * Created by apple on 18.08.16.
 */
public interface UserDao {
    void saveUser(User user) throws SQLException;
    User getUser(int userId);
    User getUser(String userName);
    User[] getAll() throws SQLException;
    void deleteUser(int userId);
    void printAll() throws SQLException;
    void changeUser(User user) throws SQLException;
    User[] getFriends(int userId) throws SQLException;
}
