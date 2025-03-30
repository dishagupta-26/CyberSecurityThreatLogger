package com.example.cybersecurity;

public class RansomwareThreat extends Threat {
    private final String severity;

    public RansomwareThreat(int id, String timestamp, String severity) {
        super(id, timestamp);
        this.severity = severity;
    }

    @Override
    public String getType() {
        return "Ransomware";
    }

    @Override
    public String getSeverity() {
        return severity;
    }
}
