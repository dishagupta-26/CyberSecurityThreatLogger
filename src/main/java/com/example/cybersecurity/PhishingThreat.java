package com.example.cybersecurity;

public class PhishingThreat extends Threat {
    private final String severity;

    public PhishingThreat(int id, String timestamp, String severity) {
        super(id, timestamp);
        this.severity = severity;
    }

    @Override
    public String getType() {
        return "Phishing";
    }

    @Override
    public String getSeverity() {
        return severity;
    }
}
