package com.example.agence.handelers.searsh;

import java.sql.ResultSet;
import java.sql.SQLException;

public class displayResults {
    public static void display(ResultSet rs){
        try {
            if (rs.next()) {
                do{
                    System.out.println(rs.getString("depart"));
                    System.out.println(rs.getString("destination"));
                    System.out.println(rs.getString("date_debut"));
                    System.out.println(rs.getString("prix"));
                }while(rs.next());
            }else{
                System.err.println("voyage not exist ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
