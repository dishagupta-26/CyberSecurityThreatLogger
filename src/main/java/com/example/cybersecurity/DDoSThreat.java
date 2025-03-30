package com.example.cybersecurity;

public class DDoSThreat extends Threat {
    private final String severity;

    public DDoSThreat(int id, String timestamp, String severity) {
        super(id, timestamp);
        this.severity = severity;
    }

    @Override
    public String getType() {
        return "DDoS";
    }

    @Override
    public String getSeverity() {
        return severity;
    }
}
