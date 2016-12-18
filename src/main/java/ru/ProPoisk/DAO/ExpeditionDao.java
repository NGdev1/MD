package ru.ProPoisk.DAO;

import ru.ProPoisk.models.Expedition;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by apple on 18.12.16.
 */
public interface ExpeditionDao {
    void saveJourney(Expedition expedition) throws SQLException;
    List<Expedition> getAll() throws SQLException;
    Expedition getJourney(int id) throws SQLException;
    Expedition getJourney(String name) throws SQLException;
    void deleteJourney(int id) throws SQLException;
    void changeJourney(Expedition expedition) throws SQLException;

    void addParticipantsToJourney(List<Integer> participantsIds, Expedition expedition) throws SQLException;
    void addSquadsToJourney(List<Integer> squadsIds, Expedition expedition) throws SQLException;
}
