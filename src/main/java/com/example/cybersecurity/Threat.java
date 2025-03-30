package com.example.cybersecurity;

// Updated Threat class to support dynamic threat types
public class Threat {
    private int id;
    private String type; // Dynamic threat type
    private String severity;
    private String timestamp;

    public Threat(String type, String severity, String timestamp) {
        this.type = type;
        this.severity = severity;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
