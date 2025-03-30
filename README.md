# Cybersecurity Threat Logger

A Java-based real-time system for detecting, logging, and analyzing cybersecurity threats. This application dynamically identifies various types of threats and calculates their severity to help improve security monitoring.

---

## Features
- **Dynamic Threat Detection**: Monitors logs for threats like **Phishing**, **Malware**, **Ransomware**, **DDoS**, and **Brute Force** attacks.
- **Flexible Severity Assessment**: Assigns severity levels (Low, Medium, High) based on predefined indicators.
- **Database Integration**: Stores detailed threat data, including type, severity, and timestamps, in a relational database.
- **Dashboard Overview**: Provides a summary of logged threats for easy inspection and management.

---

## Modules
- **RealTimeMonitor**: Analyzes incoming log data and identifies threats dynamically.
- **ThreatLogger**: Logs identified threats into the database with relevant details.
- **Dashboard**: Displays all logged threats, including severity and timestamps.

---

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- MySQL or compatible relational database
- IntelliJ IDEA (optional, for development)

---

### Setup
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/dishagupta-26/CybersecurityApp.git

2. **Configure Database**:
   - Create a database named `CybersecurityApp`.
   - Execute the following SQL commands to set up the `Threats` table:
   ```sql
   CREATE TABLE Threats (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(255) NOT NULL,
    severity VARCHAR(255) NOT NULL,
    timestamp DATETIME NOT NULL
   );

3. **Build and Run**:
   - Compile the project using your preferred IDE or:
   ```bash
   javac -d bin src/com/example/cybersecurity/*.java
   java -cp bin com.example.cybersecurity.CybersecurityApp

---

### Usage
1. Add logs to simulate real-time monitoring in the `CybersecurityApp` class:
   ```java
   String[] logs = {
    "User clicked on a suspicious link: http://login-security-fail.com",  // Phishing - Low
    "Detected malware: virus-detected",                                  // Malware - High
    "Ransom note detected: All files encrypted by ransomware",           // Ransomware - High
   };

2. Run the application to analyze logs and log threats to the database.
  
3. Use the `Dashboard` module to view all logged threats:
   ```bash
   java -cp bin com.example.cybersecurity.Dashboard

     



