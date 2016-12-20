package ru.ProPoisk.DAO;

import ru.ProPoisk.models.Point;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Михаил on 20.12.2016.
 */
public interface PointDao {
    void savePoint(Point point) throws SQLException;
    List<Point> getAll() throws SQLException;
    Point getPoint(int id) throws SQLException;
    Point getPoint(String name) throws SQLException;
    void deletePoint(int id) throws SQLException;
    void changePoint(Point point) throws SQLException;
}
