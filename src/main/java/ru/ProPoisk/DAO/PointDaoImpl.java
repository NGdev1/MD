package ru.ProPoisk.DAO;

import ru.ProPoisk.models.Point;
import ru.ProPoisk.utils.DbWrapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        return null;
    }

    @Override
    public Point getPoint(int id) throws SQLException {
        return null;
    }

    @Override
    public Point getPoint(String name) throws SQLException {
        return null;
    }

    @Override
    public void deletePoint(int id) throws SQLException {

    }

    @Override
    public void changePoint(Point point) throws SQLException {

    }
}
