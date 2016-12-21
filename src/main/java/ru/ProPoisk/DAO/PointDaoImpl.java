package ru.ProPoisk.DAO;

import ru.ProPoisk.models.Point;
import ru.ProPoisk.utils.DbWrapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Михаил on 20.12.2016.
 */
public class PointDaoImpl implements PointDao {
    private static PointDaoImpl ourInstance = new PointDaoImpl();

    public static PointDaoImpl getInstance() {
        return ourInstance;
    }

    private PointDaoImpl() {
    }

    @Override
    public void savePoint(Point point) throws SQLException {
        Connection connection = DbWrapper.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pro_poisk.point (name, id_expedition, text, date_time, image, longitude, latitude) VALUES (?, ?, ?, ?, ?, ?, ?);");

        preparedStatement.setString(1, point.getName());
        preparedStatement.setInt(2, point.getIdExpedition());
        preparedStatement.setString(3, point.getDescription());
        preparedStatement.setString(4, point.getDateTime());
        preparedStatement.setString(5, point.getImage());
        preparedStatement.setDouble(6, point.getLongitude());
        preparedStatement.setDouble(7, point.getLatitude());

        preparedStatement.execute();
    }

    @Override
    public List<Point> getAll() throws SQLException {
        Connection connection = DbWrapper.getConnection();
        String query = "SELECT * FROM pro_poisk.point";

        return getPointsFromResultSet(connection.createStatement().executeQuery(query));
    }

    @Override
    public Point getPoint(int id) throws SQLException {
        Connection connection = DbWrapper.getConnection();
        String query = "SELECT * FROM pro_poisk.point WHERE id=?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) return null;

        return getPointFromResultSet(resultSet);
    }

    @Override
    public Point getPoint(String name) throws SQLException {
        Connection connection = DbWrapper.getConnection();
        String query = "SELECT * FROM pro_poisk.expedition WHERE name=?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) return null;

        return getPointFromResultSet(resultSet);
    }

    @Override
    public void deletePoint(int id) throws SQLException {
        Connection connection = DbWrapper.getConnection();
        String query = "DELETE FROM pro_poisk.point WHERE id=?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public void changePoint(Point point) throws SQLException {
        Connection connection = DbWrapper.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE pro_poisk.point SET id_expedition=?, name=?, text=?, date_time=?, image=?, longitude=?, latitude=? WHERE id=?;");

        preparedStatement.setInt(1, point.getIdExpedition());
        preparedStatement.setString(2, point.getName());
        preparedStatement.setString(3, point.getDescription());
        preparedStatement.setString(4, point.getDateTime());
        preparedStatement.setString(5, point.getImage());
        preparedStatement.setDouble(6, point.getLongitude());
        preparedStatement.setDouble(7, point.getLatitude());

        preparedStatement.setInt(8, point.getId());

        preparedStatement.execute();
    }

    public static List<Point> getPointsFromResultSet(ResultSet resultSet) throws SQLException {
        ArrayList<Point> points = new ArrayList<>();

        while (resultSet.next()) {
            points.add(getPointFromResultSet(resultSet));
        }

        return points;
    }

    public static Point getPointFromResultSet(ResultSet resultSet) throws SQLException {
        Point point;

        point = new Point(
                resultSet.getInt("id"),
                resultSet.getInt("id_expedition"),
                resultSet.getDouble("longitude"),
                resultSet.getDouble("latitude"),
                resultSet.getString("name"),
                resultSet.getString("text"),
                resultSet.getString("date_time"),
                resultSet.getString("image")
        );

        return point;
    }
}
