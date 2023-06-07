package com.example.sportsCompetitionManagement.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

    public Connection databaseLink;

    public Connection getDBConnection(){

        String databaseName = "eventsdb";
        String databaseUser = "root";
        String databasePassword = "LODSF4ihg2pj4gpoJSPhj3h3hdsf";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaseLink;

    }
}
