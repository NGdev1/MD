package ru.ProPoisk.DAO;
/**
 * Created by apple on 24.08.16.
 */

import ru.ProPoisk.models.User;
import ru.ProPoisk.utils.DbWrapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao {

    private static UserDaoImpl userDao;

    public static UserDaoImpl getInstance() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }

        return userDao;
    }

    private UserDaoImpl() {

    }

    @Override
    public void saveUser(User user) throws SQLException {

        Connection connection = DbWrapper.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `pro_poisk`.`users` (login, password, gender, phone, DOB, city, image, otryad, email, surname, patronymic, dolshnost) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

        preparedStatement.setString(1, user.getName());
        preparedStatement.setInt(2, user.getPasswordHash());
        preparedStatement.setBoolean(3, user.isMale());
        preparedStatement.setString(4, user.getPhoneNumber());
        preparedStatement.setString(5, user.getDOB());
        preparedStatement.setString(6, user.getCity());
        preparedStatement.setString(7, user.getImageB64());
        preparedStatement.setString(8, user.getOtryad());
        preparedStatement.setString(9, user.getEmail());
        preparedStatement.setString(10, user.getSurname());
        preparedStatement.setString(11, user.getPatronymic());
        preparedStatement.setString(12, user.getDolshnost());

        preparedStatement.execute();
    }

    @Override
    public User getUser(int userId) {
        String query = "SELECT * FROM `pro_poisk`.`users` WHERE `id` = '" +
                Integer.toString(userId) + "'";

        return getUserFromQuery(query);
    }

    @Override
    public User getUser(String userName) {
        String query = "SELECT * FROM `pro_poisk`.`users` WHERE `login` = '" +
                userName + "'";

        return getUserFromQuery(query);
    }

    public User getUserFromQuery(String query) {
        Connection connection = DbWrapper.getConnection();

        User user = null;
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            resultSet.next();

            user = new User(
                    resultSet.getString("login"),
                    resultSet.getInt("password"),
                    stringToBoolean(resultSet.getString("gender")),
                    resultSet.getString("phone"),
                    resultSet.getString("DOB"),
                    resultSet.getString("city"),
                    resultSet.getString("image"),
                    resultSet.getString("otryad"),
                    resultSet.getString("email"),
                    resultSet.getString("surname"),
                    resultSet.getString("patronymic"),
                    resultSet.getString("dolshnost")
            );
            user.setId(resultSet.getInt("id"));

        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
        }

        return user;
    }

    @Override
    public User[] getAll() throws SQLException {
        String query = "SELECT * FROM `pro_poisk`.`users`";
        Connection connection = DbWrapper.getConnection();

        return getUsersFromResultSet(connection.prepareStatement(query).executeQuery());
    }

    private User[] getUsersFromResultSet(ResultSet resultSet) throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        User user;
        while (resultSet.next()) {
            user = new User(
                    resultSet.getString("login"),
                    resultSet.getInt("password"),
                    stringToBoolean(resultSet.getString("gender")),
                    resultSet.getString("phone"),
                    resultSet.getString("DOB"),
                    resultSet.getString("city"),
                    resultSet.getString("image"),
                    resultSet.getString("otryad"),
                    resultSet.getString("email"),
                    resultSet.getString("surname"),
                    resultSet.getString("patronymic"),
                    resultSet.getString("dolshnost")
            );
            user.setId(resultSet.getInt("id"));

            users.add(user);
        }

        User[] usersArr = new User[users.size()];
        for (int i = 0; i < users.size(); i++) {
            usersArr[i] = users.get(i);
        }

        return usersArr;
    }

    @Override
    public void deleteUser(int userId) {
        Connection connection = DbWrapper.getConnection();

        String query = "DELETE FROM `pro_poisk`.`users` WHERE `id` = '" +
                Integer.toString(userId) + "'";
        try {
            connection.createStatement().executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    @Override
    public void printAll() throws SQLException {
        User[] users = getAll();
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i].toString());
        }
    }

    @Override
    public void changeUser(User user) throws SQLException {
        Connection connection = DbWrapper.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `pro_poisk`.`users` SET login=?, surname=?, patronymic=?, phone=?, email=?, dolshnost=? WHERE id=?;");

        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getSurname());
        preparedStatement.setString(3, user.getPatronymic());
        preparedStatement.setString(4, user.getPhoneNumber());
        preparedStatement.setString(5, user.getEmail());
        preparedStatement.setString(6, user.getDolshnost());

        preparedStatement.setInt(7, user.getId());

        preparedStatement.execute();
    }

    @Override
    public User[] getFriends(int userId) throws SQLException {
        Connection connection = DbWrapper.getConnection();

        String query = "SELECT * FROM pro_poisk.users WHERE id = (SELECT friend_id FROM pro_poisk.friends WHERE user_id = ?);";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, userId);

        ResultSet resultSet = statement.executeQuery();

        return getUsersFromResultSet(resultSet);
    }

    private boolean stringToBoolean(String s) {
        return !s.equals("0");
    }

    private String booleanToString(Boolean b) {
        if (b) return "1";
        else return "0";
    }
}
