package ru.ProPoisk.DAO;
/**

 */

import ru.ProPoisk.models.User;
import ru.ProPoisk.utils.DbWrapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `pro_poisk`.`users` (login, password, gender, phone, DOB, city, image, squad, email, surname, patronymic, dolshnost) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

        preparedStatement.setString(1, user.getName());
        preparedStatement.setInt(2, user.getPasswordHash());
        preparedStatement.setBoolean(3, user.isMale());
        preparedStatement.setString(4, user.getPhoneNumber());
        preparedStatement.setString(5, user.getDOB());
        preparedStatement.setString(6, user.getCity());
        preparedStatement.setString(7, user.getImage());
        preparedStatement.setInt(8, user.getSquad());
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
                    resultSet.getBoolean("gender"),
                    resultSet.getString("phone"),
                    resultSet.getString("DOB"),
                    resultSet.getString("city"),
                    resultSet.getString("image"),
                    resultSet.getInt("squad"),
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
    public List<User> getAllNoFriends(int userId) throws SQLException {
        String query = "SELECT * FROM pro_poisk.users WHERE id NOT IN (SELECT friend_id FROM pro_poisk.friends WHERE user_id = ?);";

        Connection connection = DbWrapper.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, userId);

        return getUsersFromResultSet(statement.executeQuery());
    }

    @Override
    public List<User> getAll() throws SQLException {
        String query = "SELECT * FROM `pro_poisk`.`users`";
        Connection connection = DbWrapper.getConnection();

        return getUsersFromResultSet(connection.prepareStatement(query).executeQuery());
    }

    public static List<User> getUsersFromResultSet(ResultSet resultSet) throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        User user;
        while (resultSet.next()) {
            user = new User(
                    resultSet.getString("login"),
                    resultSet.getInt("password"),
                    resultSet.getBoolean("gender"),
                    resultSet.getString("phone"),
                    resultSet.getString("DOB"),
                    resultSet.getString("city"),
                    resultSet.getString("image"),
                    resultSet.getInt("squad"),
                    resultSet.getString("email"),
                    resultSet.getString("surname"),
                    resultSet.getString("patronymic"),
                    resultSet.getString("dolshnost")
            );
            user.setId(resultSet.getInt("id"));

            users.add(user);
        }

        return users;
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
    public List<User> getFriends(int userId) throws SQLException {
        Connection connection = DbWrapper.getConnection();

        String query = "SELECT * FROM pro_poisk.users WHERE id IN (SELECT friend_id FROM pro_poisk.friends WHERE user_id = ?);";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, userId);

        ResultSet resultSet = statement.executeQuery();

        return getUsersFromResultSet(resultSet);
    }

    @Override
    public void addFriend(int userId, int friendId) throws SQLException {
        Connection connection = DbWrapper.getConnection();
        String query = "INSERT INTO pro_poisk.friends (user_id, friend_id) VALUES (?, ?)";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, userId);
        statement.setInt(2, friendId);

        statement.executeUpdate();
    }

    @Override
    public void removeFriend(int userId, int friendId) throws SQLException {
        Connection connection = DbWrapper.getConnection();
        String query = "DELETE FROM pro_poisk.friends WHERE user_id = ? AND friend_id = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, userId);
        statement.setInt(2, friendId);

        statement.executeUpdate();
    }

    @Override
    public List<User> getArrayBySearch(String q) throws SQLException {
        Connection connection = DbWrapper.getConnection();
        String query = "SELECT * FROM pro_poisk.users WHERE login LIKE '%" + q + "%' OR surname LIKE '%" + q + "%' OR patronymic LIKE '%" + q + "%';";
        return getUsersFromResultSet(connection.createStatement().executeQuery(query));
    }

    public void setUserImage(String imageName , int id) {
        Connection connection = DbWrapper.getConnection();
        String query = "UPDATE pro_poisk.users SET image='" + imageName + "' WHERE id='" + id + "'";
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
