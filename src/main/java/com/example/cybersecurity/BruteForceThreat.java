package com.example.cybersecurity;

public class BruteForceThreat extends Threat {
    private final String severity;

    public BruteForceThreat(int id, String timestamp, String severity) {
        super(id, timestamp);
        this.severity = severity;
    }

    @Override
    public String getType() {
        return "Brute Force";
    }

    @Override
    public String getSeverity() {
        return severity;
    }
}
