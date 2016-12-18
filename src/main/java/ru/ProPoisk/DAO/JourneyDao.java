package ru.ProPoisk.DAO;

import ru.ProPoisk.models.Journey;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by apple on 18.12.16.
 */
public interface JourneyDao {
    void saveJourney(Journey journey) throws SQLException;
    List<Journey> getAll() throws SQLException;
    Journey getJourney(int id) throws SQLException;
    void deleteJourney(int id) throws SQLException;
    void changeJourney(Journey journey) throws SQLException;

    void addParticipantsToJourney(List<Integer> participantsIds, Journey journey) throws SQLException;
    void addSquadsToJourney(List<Integer> squadsIds, Journey journey) throws SQLException;
}
