package com.example.agence.handelers.searsh;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.agence.handelers.sign_up.databaseConn;

public class VoyageDAO {
    public List<voyage> getVoyages(ResultSet resultSet, String passengers) {
        List<voyage> voyages = new ArrayList<>();

        try {
            while (resultSet.next()) {
                voyage voyage = new voyage();
                voyage.setArrivalcityid(resultSet.getString("destination"));
                voyage.setDeparturecityid(resultSet.getString("depart"));
                voyage.setArrivalcityid(resultSet.getString("date_arrival"));
                voyage.setDeparturecityid(resultSet.getString("date_debut"));
                voyage.setNumberpassengerid(passengers);
                voyage.setPriceid(resultSet.getString("prix"));

                voyages.add(voyage); // Ajouter à la liste d'objets
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return voyages;
    }
}

