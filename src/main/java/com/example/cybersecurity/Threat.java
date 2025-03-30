package com.example.cybersecurity;

public abstract class Threat {
    private int id;
    private String timestamp;

    public Threat(int id, String timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public abstract String getType(); // Force subclasses to define their type

    public abstract String getSeverity(); // Force subclasses to define their severity
}
