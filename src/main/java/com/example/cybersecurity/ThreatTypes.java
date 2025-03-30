package com.example.cybersecurity;

import java.util.Arrays;
import java.util.List;

public class ThreatTypes {
    // List of dynamic threat types
    public static List<String> getThreatTypes() {
        return Arrays.asList("Phishing", "Malware", "Ransomware", "DDoS", "Brute Force");
    }
}
