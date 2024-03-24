package com.TYR.MainPackage.DatabaseHelper;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    @Value("${app.variable.database-url}")
    private String databaseUrl;
    @Value("${app.variable.database-username}")
    private String databaseUsername;
    @Value("${app.variable.database-password}")
    private String databasePassword;

    public Connection connectToDb(){
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
        } catch (SQLException e){
            System.out.printf("Exception : " + e);
        }
        return connect;
    }
}