package com.example.cybersecurity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ThreatLogger {
    // Log the detected threat with dynamic severity
    public void logThreat(String type, String logData) throws DatabaseException {
        try (Connection connection = DatabaseConnector.connect()) {
            // Directly calculate severity
            String severity = calculateSeverity(type, logData);

            // Debugging logs
            System.out.println("Original Type: " + type);
            System.out.println("Original Severity: " + severity);

            // SQL query for inserting data
            String query = "INSERT INTO Threats (type, severity, timestamp) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, type);
            statement.setString(2, severity);
            statement.setString(3, new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));

            // Execute the query
            statement.executeUpdate();
            System.out.println("Threat logged successfully!");
        } catch (SQLException e) {
            throw new DatabaseException("Failed to log threat to the database: " + e.getMessage());
        }
    }

    // Method to dynamically calculate the severity based on threat type and log data
    private String calculateSeverity(String type, String logData) {
        if (type.equals("Phishing")) {
            if (logData.contains("password-reset-link") || logData.contains("urgent-update")) {
                return "Medium";
            } else {
                return "Low";
            }
        } else if (type.equals("Malware")) {
            if (logData.contains("virus-detected") || logData.contains("unauthorized-access")) {
                return "High";
            } else {
                return "Medium";
            }
        } else if (type.equals("Ransomware")) {
            return "High"; // Always high severity for ransomware
        } else if (type.equals("DDoS")) {
            if (logData.contains("flood-attack")) {
                return "High";
            } else {
                return "Medium";
            }
        } else if (type.equals("Brute Force")) {
            if (logData.contains("multiple-login-failures")) {
                return "Medium";
            } else {
                return "Low";
            }
        }
        return "Low"; // Default to low severity if not specified
    }
}
