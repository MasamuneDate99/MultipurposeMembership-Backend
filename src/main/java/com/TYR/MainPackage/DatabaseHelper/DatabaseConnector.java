package com.TYR.MainPackage.DatabaseHelper;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Deprecated
public class DatabaseConnector {
//    @Value("${app.variable.database-url}")
    // Hardcode karena ga ke detect di application properties
    private final String databaseUrl = "jdbc:postgresql://localhost:5432/MembershipDatabase";
//    @Value("${app.variable.database-username}")
    private final String databaseUsername = "postgres";
//    @Value("${app.variable.database-password}")
    private final String databasePassword = "ThisIsPassword";

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