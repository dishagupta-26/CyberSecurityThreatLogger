package com.example.cybersecurity;

public class CybersecurityApp {
    public static void main(String[] args) {
        try {
            // Sample log data for testing
            String[] logs = {
                    "User clicked on a suspicious link: http://login-security-fail.com",  // Phishing - Low
                    "Email received: password-reset-link",                                // Phishing - Medium
                    "Detected malware: virus-detected",                                  // Malware - High
                    "Server under flood-attack causing denial-of-service",               // DDoS - High
                    "Suspicious activity: multiple-login-failures detected",             // Brute Force - Medium
                    "Ransom note detected: All files encrypted by ransomware",           // No threat
                    "Email received: urgent-update.com",                                 // No threat
                    "Executable found: unauthorized-access malware detected"             // Malware - Medium
            };



            // Initialize the real-time monitor and analyze the logs
            RealTimeMonitor monitor = new RealTimeMonitor();
            monitor.monitorLogs(logs);

            // Display logged threats using the dashboard
            Dashboard dashboard = new Dashboard();
            dashboard.displayThreats();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
