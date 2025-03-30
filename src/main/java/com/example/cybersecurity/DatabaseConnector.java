package com.example.cybersecurity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Class for managing database connections
public class DatabaseConnector {
    // Private fields to ensure encapsulation
    private static String URL = "jdbc:mysql://localhost:3306/cybersecurity";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Disha@26";

    // Public setter method to update the URL
    public static void setURL(String newURL) {
        URL = newURL;
    }

    // Method to establish and return a database connection
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
