package ru.ProPoisk.DAO;

import ru.ProPoisk.models.Squad;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Михаил on 14.12.2016.
 */

public interface SquadsDao {
    List<Squad> getListBySearch(String q) throws SQLException;
}
