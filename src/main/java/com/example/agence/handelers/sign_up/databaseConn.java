package com.example.agence.handelers.sign_up;

import java.sql.*;

public class databaseConn {
    /*
     * private static final String URL = "jdbc:mysql://localhost:3306/gestion_bus";
     * private static final String USER = "root";
     * private static final String PASSWD = "";
     */

    /*
     * private static final String URL =
     * "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7755575";
     * private static final String USER = "sql7755575";
     * private static final String PASSWD = "u3PNfimbra";
     */

    private static String connectionUrl = "jdbc:sqlserver://agence-bus.database.windows.net:1433;"
            + "database=gestion_bus;"
            + "user=Zakaria@agence-bus;"
            + "password=mghili@2004;"
            + "encrypt=true;"
            + "trustServerCertificate=false;"
            + "hostNameInCertificate=*.database.windows.net;"
            + "loginTimeout=30;";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl);
    }
}
