package com.example.cybersecurity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dashboard {
    public void displayThreats() {
        try (Connection connection = DatabaseConnector.connect()) {
            String query = "SELECT id, type, severity, timestamp FROM Threats";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            System.out.println("Logged Threats:");
            System.out.println("ID | Type         | Severity | Timestamp");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String severity = resultSet.getString("severity");
                String timestamp = resultSet.getString("timestamp");

                // Display data directly (no decryption needed)
                System.out.println(id + " | " + type + " | " + severity + " | " + timestamp);
            }
        } catch (SQLException e) {
            System.out.println("Error displaying threats: " + e.getMessage());
        }
    }
}

