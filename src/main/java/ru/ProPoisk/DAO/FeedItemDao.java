package ru.ProPoisk.DAO;

import ru.ProPoisk.utils.DbWrapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by apple on 01.11.16.
 */

public class FeedItemDao {
    private static FeedItemDao feedItemDao;

    public static FeedItemDao getInstance() {
        if (feedItemDao == null) {
            feedItemDao = new FeedItemDao();
        }

        return feedItemDao;
    }

    private FeedItemDao() {

    }

    public void addFeedItem(FeedItem item) throws SQLException {
        Connection connection = DbWrapper.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `pro_poisk`.`feed` (author_id, text, date_time) VALUES (?, ?, ?);");

        preparedStatement.setInt(1, item.getAuthorId());
        preparedStatement.setString(2, item.getText());
        preparedStatement.setString(3, item.getDateTime());

        preparedStatement.execute();
    }

    public FeedItem getFeedItemFromQuery(String query) throws SQLException {
        Connection connection = DbWrapper.getConnection();

        ResultSet resultSet = connection.createStatement().executeQuery(query);
        resultSet.next();

        FeedItem item = new FeedItem(
                resultSet.getInt("author_id"),
                resultSet.getString("text"),
                resultSet.getString("date_time")
        );

        item.setId(resultSet.getInt("id"));


        return item;
    }

    public void deleteFeedItem(int userId) {
        Connection connection = DbWrapper.getConnection();

        String query = "DELETE FROM `pro_poisk`.`feed` WHERE `id` = '" +
                Integer.toString(userId) + "'";
        try {
            connection.createStatement().executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    public FeedItem[] getAll() throws SQLException {
        String query = "SELECT * FROM `pro_poisk`.`feed` ORDER BY date_time DESC";

        return getUsersFromQuery(query);
    }

    public FeedItem[] getAllFeedFromUser(int userId) throws SQLException {
        String query = "SELECT * FROM `pro_poisk`.`feed` WHERE author_id=" +
                Integer.toString(userId) +
                " ORDER BY date_time DESC";
        return getUsersFromQuery(query);
    }

    private FeedItem[] getUsersFromQuery(String query) throws SQLException{
        ArrayList<FeedItem> feed = new ArrayList<>();

        Connection connection = DbWrapper.getConnection();

        ResultSet resultSet = connection.createStatement().executeQuery(query);
        while (resultSet.next()) {

            FeedItem item = new FeedItem(
                    resultSet.getInt("author_id"),
                    resultSet.getString("text"),
                    resultSet.getString("date_time")
            );
            item.setId(resultSet.getInt("id"));

            feed.add(item);
        }

        FeedItem[] feedArr = new FeedItem[feed.size()];
        for (int i = 0; i < feed.size(); i++) {
            feedArr[i] = feed.get(i);
        }

        return feedArr;
    }

}
