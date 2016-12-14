package ru.ProPoisk.DAO;

import ru.ProPoisk.models.Squad;
import ru.ProPoisk.utils.DbWrapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Михаил on 14.12.2016.
 */
public class SquadsDaoImpl implements SquadsDao {
    private SquadsDaoImpl(){

    }
    private static SquadsDaoImpl instance;

    public static SquadsDaoImpl getInstance(){
        if(instance == null){
            instance = new SquadsDaoImpl();
        }

        return instance;
    }

    @Override
    public List<Squad> getListBySearch(String q) throws SQLException {
        Connection connection = DbWrapper.getConnection();
        String query = "SELECT * FROM pro_poisk.squads WHERE name LIKE '%" + q + "%';";
        return getSquadsFromResultSet(connection.createStatement().executeQuery(query));
    }

    private List<Squad> getSquadsFromResultSet(ResultSet resultSet) throws SQLException {
        ArrayList<Squad> squads = new ArrayList<>();
        Squad squad;
        while (resultSet.next()) {
            squad = new Squad(
                    resultSet.getInt("id"),
                    resultSet.getString("name")
            );

            squads.add(squad);
        }

        return squads;
    }
}
