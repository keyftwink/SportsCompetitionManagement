package com.example.sportsCompetitionManagement.utils;

import java.sql.*;

public class DataBaseUtils {

    //метод для редактирования базы данных
    public static void dataBaseEdit(String s){
        DataBaseConnection connectionNow = new DataBaseConnection();
        Connection connectDB = connectionNow.getDBConnection();

        try {
            Statement statement = connectDB.createStatement();
            int rows = statement.executeUpdate(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Метод для создания таблицы в базе данных для участников
    public static void createDataBaseTable(int id) throws SQLException {


            String table = "create table IF NOT EXISTS " + id + "members (id INT PRIMARY KEY AUTO_INCREMENT, surname varchar(50) not null, name varchar(50) not null, patronymic varchar(50) not null);";
            dataBaseEdit(table);

    }

}
