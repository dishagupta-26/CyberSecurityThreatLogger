package com.example.cybersecurity;

// Custom exception for handling database-related errors
public class DatabaseException extends Exception {
    // Constructor that accepts an error message
    public DatabaseException(String message) {
        super(message); // Pass the error message to the Exception class
    }
}
