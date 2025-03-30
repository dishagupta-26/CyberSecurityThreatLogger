package com.example.cybersecurity;

// Interface: Defines a blueprint for classes that implement threat detection
public interface ThreatDetector {
    // Method signature: Checks if threat exists in the given log data and may throw ThreatDetectionException
    boolean detectThreat(String logData) throws ThreatDetectionException;
}
