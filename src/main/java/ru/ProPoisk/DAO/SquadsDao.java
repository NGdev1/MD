package ru.ProPoisk.DAO;

import ru.ProPoisk.models.Squad;

import java.sql.SQLException;
import java.util.List;

/**

 */

public interface SquadsDao {
    List<Squad> getListBySearch(String q) throws SQLException;
    String getSquadName(int id) throws SQLException;
}
