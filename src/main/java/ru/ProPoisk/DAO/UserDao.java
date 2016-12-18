package ru.ProPoisk.DAO;

import ru.ProPoisk.models.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by apple on 18.08.16.
 */
public interface UserDao {
    void saveUser(User user) throws SQLException;
    User getUser(int userId);
    User getUser(String userName);
    List<User> getAllNoFriends(int userId) throws SQLException;
    List<User> getAll() throws SQLException;
    void deleteUser(int userId);

    void changeUser(User user) throws SQLException;
    List<User> getFriends(int userId) throws SQLException;
    void addFriend(int userId, int friendId) throws SQLException;
    void removeFriend(int userId, int friendId) throws SQLException;
    List<User> getArrayBySearch(String q) throws SQLException;
}
