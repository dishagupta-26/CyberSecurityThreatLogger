package com.example.cybersecurity;

import java.util.List;

public class GenericThreatDetector implements ThreatDetector {
    private final List<String> threatIndicators;

    public GenericThreatDetector(List<String> threatIndicators) {
        this.threatIndicators = threatIndicators;
    }

    @Override
    public boolean detectThreat(String logData) throws ThreatDetectionException {
        try {
            for (String indicator : threatIndicators) {
                if (logData.contains(indicator)) {
                    return true; // Threat detected
                }
            }
            return false; // No threat detected
        } catch (Exception e) {
            throw new ThreatDetectionException("Error detecting threats: " + e.getMessage());
        }
    }
}
