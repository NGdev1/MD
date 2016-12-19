package ru.ProPoisk.DAO;

import ru.ProPoisk.models.Expedition;
import ru.ProPoisk.models.Squad;
import ru.ProPoisk.models.User;
import ru.ProPoisk.utils.DbWrapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 18.12.16.
 */
public class ExpeditionDaoImpl implements ExpeditionDao {

    private static ExpeditionDaoImpl ourInstance = new ExpeditionDaoImpl();

    public static ExpeditionDaoImpl getInstance() {
        return ourInstance;
    }

    private ExpeditionDaoImpl() {
    }

    @Override
    public void saveJourney(Expedition expedition) throws SQLException {
        Connection connection = DbWrapper.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pro_poisk.expedition (name, status, place) VALUES (?, ?, ?);");

        preparedStatement.setString(1, expedition.getName());
        preparedStatement.setBoolean(2, expedition.getStatus());
        preparedStatement.setString(3, expedition.getPlace());

        preparedStatement.execute();
    }

    @Override
    public void addParticipantsToJourney(List<Integer> participantsIds, Expedition expedition) throws SQLException {
        Connection connection = DbWrapper.getConnection();
        PreparedStatement preparedStatement;

        for (Integer participantsId : participantsIds) {
            preparedStatement = connection.prepareStatement("INSERT INTO pro_poisk.participants (user_id, journey_id) VALUES (?,?)");

            preparedStatement.setInt(1, participantsId);
            preparedStatement.setInt(2, expedition.getId());

            preparedStatement.execute();
        }
    }

    @Override
    public void addSquadsToJourney(List<Integer> squadsIds, Expedition expedition) throws SQLException {
        Connection connection = DbWrapper.getConnection();
        PreparedStatement preparedStatement;

        for (Integer squadsId : squadsIds) {
            preparedStatement = connection.prepareStatement("INSERT INTO pro_poisk.squads_in_journey (squad_id, journey_id) VALUES (?,?)");

            preparedStatement.setInt(1, squadsId);
            preparedStatement.setInt(2, expedition.getId());

            preparedStatement.execute();
        }
    }

    @Override
    public List<Expedition> getAll() throws SQLException {
        Connection connection = DbWrapper.getConnection();
        String query = "SELECT * FROM pro_poisk.expedition";

        return getExpeditionsFromResultSet(connection.createStatement().executeQuery(query));
    }

    @Override
    public Expedition getJourney(int id) throws SQLException {
        Connection connection = DbWrapper.getConnection();
        String query = "SELECT * FROM pro_poisk.expedition WHERE id=?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        return getExpeditionFromResultSet(preparedStatement.executeQuery());
    }

    @Override
    public Expedition getJourney(String name) throws SQLException {
        Connection connection = DbWrapper.getConnection();
        String query = "SELECT * FROM pro_poisk.expedition WHERE name=?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        return getExpeditionFromResultSet(preparedStatement.executeQuery());
    }

    @Override
    public void deleteJourney(int id) throws SQLException {
        Connection connection = DbWrapper.getConnection();
        String query = "DELETE FROM pro_poisk.expedition WHERE id=?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public void changeJourney(Expedition expedition) throws SQLException {
        Connection connection = DbWrapper.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE pro_poisk.expedition SET name=?, status=?, place=? WHERE id=?;");

        preparedStatement.setString(1, expedition.getName());
        preparedStatement.setBoolean(2, expedition.getStatus());
        preparedStatement.setString(3, expedition.getPlace());

        preparedStatement.setInt(4, expedition.getId());

        preparedStatement.execute();
    }

    private List<User> getUsersFromExpedition(Expedition expedition) throws SQLException {
        Connection connection = DbWrapper.getConnection();

        String query = "SELECT * FROM pro_poisk.users WHERE id IN (SELECT user_id FROM pro_poisk.participants WHERE journey_id = ?);";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, expedition.getId());

        ResultSet resultSet = statement.executeQuery();

        return UserDaoImpl.getUsersFromResultSet(resultSet);
    }

    private List<Squad> gertSquadsFromExpedition(Expedition expedition) throws SQLException {
        Connection connection = DbWrapper.getConnection();

        String query = "SELECT * FROM pro_poisk.squads WHERE id IN (SELECT squad_id FROM pro_poisk.squads_in_journey WHERE journey_id = ?);";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, expedition.getId());

        ResultSet resultSet = statement.executeQuery();

        return SquadsDaoImpl.getSquadsFromResultSet(resultSet);
    }

    private Expedition getExpeditionFromResultSet(ResultSet resultSet) throws SQLException {
        Expedition expedition;

        if (!resultSet.next()) return null;

        expedition = new Expedition(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getBoolean("status"),
                resultSet.getString("place")
        );
        expedition.setParticipants(getUsersFromExpedition(expedition));
        expedition.setSquads(gertSquadsFromExpedition(expedition));

        return expedition;
    }

    private List<Expedition> getExpeditionsFromResultSet(ResultSet resultSet) throws SQLException {
        ArrayList<Expedition> expeditions = new ArrayList<>();
        Expedition expedition;
        while (resultSet.next()) {
            expedition = new Expedition(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getBoolean("status"),
                    resultSet.getString("place")
            );
            expedition.setParticipants(getUsersFromExpedition(expedition));
            expedition.setSquads(gertSquadsFromExpedition(expedition));

            expeditions.add(expedition);
        }

        return expeditions;
    }
}
