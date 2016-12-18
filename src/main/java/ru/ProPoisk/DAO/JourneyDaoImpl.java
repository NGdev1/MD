package ru.ProPoisk.DAO;

import ru.ProPoisk.models.Journey;
import ru.ProPoisk.models.User;
import ru.ProPoisk.utils.DbWrapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by apple on 18.12.16.
 */
public class JourneyDaoImpl implements JourneyDao {
    @Override
    public void saveJourney(Journey journey) throws SQLException {
        Connection connection = DbWrapper.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pro_poisk.journey (name, status, place) VALUES (?, ?, ?);");

        preparedStatement.setString(1, journey.getName());
        preparedStatement.setBoolean(2, journey.getStatus());
        preparedStatement.setString(3, journey.getPlace());

        preparedStatement.execute();
    }

    @Override
    public void addParticipantsToJourney(List<Integer> participantsIds, Journey journey) throws SQLException {
        Connection connection = DbWrapper.getConnection();
        PreparedStatement preparedStatement;

        for (Integer participantsId : participantsIds) {
            preparedStatement = connection.prepareStatement("INSERT INTO pro_poisk.participants (user_id, journey_id) VALUES (?,?)");

            preparedStatement.setInt(1, participantsId);
            preparedStatement.setInt(2, journey.getId());

            preparedStatement.execute();
        }
    }

    @Override
    public void addSquadsToJourney(List<Integer> squadsIds, Journey journey) throws SQLException {
        Connection connection = DbWrapper.getConnection();
        PreparedStatement preparedStatement;

        for (Integer squadsId : squadsIds) {
            preparedStatement = connection.prepareStatement("INSERT INTO pro_poisk.squads_in_journey (squad_id, journey_id) VALUES (?,?)");

            preparedStatement.setInt(1, squadsId);
            preparedStatement.setInt(2, journey.getId());

            preparedStatement.execute();
        }
    }

    @Override
    public List<Journey> getAll() throws SQLException {
        return null;
    }

    @Override
    public Journey getJourney(int id) throws SQLException {
        return null;
    }

    @Override
    public void deleteJourney(int id) throws SQLException {

    }

    @Override
    public void changeJourney(Journey journey) throws SQLException {

    }
}
