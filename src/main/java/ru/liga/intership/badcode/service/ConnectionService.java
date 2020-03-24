package ru.liga.intership.badcode.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionService {
    private String url;
    private String user;
    private String password;

    public ConnectionService(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }
    public ResultSet getResultSet(String sqlQuery) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            return statement.executeQuery(sqlQuery);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}