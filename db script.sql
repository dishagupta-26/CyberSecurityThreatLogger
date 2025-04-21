SHOW databases;
USE cybersecurity;
DROP TABLE THREATS;
CREATE TABLE THREATS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(100),
    severity VARCHAR(20),
    timestamp DATETIME
);


SELECT * FROM THREATS;
TRUNCATE TABLE THREATS;
DROP TABLE  ThreatsNormalized;
DROP TABLE ThreatEvents;

CREATE TABLE ThreatsNormalized (
    id INT AUTO_INCREMENT PRIMARY KEY,
    threat_name VARCHAR(100) NOT NULL,
    severity VARCHAR(20) NOT NULL
);


CREATE TABLE ThreatEvents (
    event_id INT AUTO_INCREMENT PRIMARY KEY,
    threat_id INT NOT NULL,
    timestamp DATETIME NOT NULL,
    FOREIGN KEY (threat_id) REFERENCES ThreatsNormalized(id)
);


DELIMITER //

CREATE TRIGGER normalize_threats
AFTER INSERT ON threats
FOR EACH ROW
BEGIN
    DECLARE newThreatId INT;

    -- Step 1: Always insert into ThreatsNormalized (no uniqueness assumed)
    INSERT INTO ThreatsNormalized (threat_name, severity)
    VALUES (NEW.type, NEW.severity);
    
    -- Step 2: Capture the inserted ID
    SET newThreatId = LAST_INSERT_ID();

    -- Step 3: Log event in ThreatEvents
    INSERT INTO ThreatEvents (threat_id, timestamp)
    VALUES (newThreatId, NEW.timestamp);
END;
//

DELIMITER ;


SELECT * FROM ThreatsNormalized;
SELECT * FROM ThreatEvents;
