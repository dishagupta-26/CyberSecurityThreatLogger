package com.example.cybersecurity;

import java.util.Arrays;
import java.util.List;

public class RealTimeMonitor {
    private final ThreatLogger logger;

    public RealTimeMonitor() {
        this.logger = new ThreatLogger();
    }

    public void monitorLogs(String[] logs) {
        // Define dynamic threat indicators
        List<String> phishingIndicators = Arrays.asList(
                "login-security-fail.com", "verify-account.com", "password-reset-link"
        );
        List<String> malwareIndicators = Arrays.asList(
                "malicious-software.exe", "unauthorized-access", "virus-detected"
        );
        List<String> ransomwareIndicators = Arrays.asList(
                "encrypted-files", "ransom-note", "decrypt-tool"
        );
        List<String> ddosIndicators = Arrays.asList(
                "unusual-traffic", "denial-of-service", "flood-attack"
        );
        List<String> bruteForceIndicators = Arrays.asList(
                "multiple-login-failures", "account-locked", "password-guessing"
        );

        // Create detectors dynamically
        ThreatDetector phishingDetector = new GenericThreatDetector(phishingIndicators);
        ThreatDetector malwareDetector = new GenericThreatDetector(malwareIndicators);
        ThreatDetector ransomwareDetector = new GenericThreatDetector(ransomwareIndicators);
        ThreatDetector ddosDetector = new GenericThreatDetector(ddosIndicators);
        ThreatDetector bruteForceDetector = new GenericThreatDetector(bruteForceIndicators);

        // Analyze each log
        for (String logData : logs) {
            try {
                System.out.println("Analyzing log: " + logData);

                if (phishingDetector.detectThreat(logData)) {
                    logger.logThreat("Phishing", logData);
                } else if (malwareDetector.detectThreat(logData)) {
                    logger.logThreat("Malware", logData);
                } else if (ransomwareDetector.detectThreat(logData)) {
                    logger.logThreat("Ransomware", logData);
                } else if (ddosDetector.detectThreat(logData)) {
                    logger.logThreat("DDoS", logData);
                } else if (bruteForceDetector.detectThreat(logData)) {
                    logger.logThreat("Brute Force", logData);
                } else {
                    System.out.println("No threat detected.");
                }
            } catch (Exception e) {
                System.out.println("Error during real-time monitoring: " + e.getMessage());
            }
        }

        System.out.println("Real-time monitoring completed.");
    }
}
