package com.example.cybersecurity;

import com.example.cybersecurity.DatabaseConnector;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDatabaseConnection {
    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnector.connect();
            System.out.println("Connection Successful!");
        } catch (SQLException e) {
            System.out.println("Connection Failed: " + e.getMessage());
        }
    }
}
