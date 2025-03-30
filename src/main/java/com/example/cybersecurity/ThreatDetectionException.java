package com.example.cybersecurity;

// Custom exception for handling errors related to threat detection
public class ThreatDetectionException extends Exception {
    // Constructor that accepts an error message
    public ThreatDetectionException(String message) {
        super(message); // Pass the error message to the Exception class
    }
}
