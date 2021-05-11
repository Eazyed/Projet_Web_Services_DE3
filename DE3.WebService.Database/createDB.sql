CREATE DATABASE WebServiceDb;

USE WebServiceDb;

CREATE TABLE Users (
	IdUser INT PRIMARY KEY AUTO_INCREMENT,
	Firstname VARCHAR(50) NOT NULL,
	Lastname VARCHAR(50) NOT NULL,
	Username VARCHAR(50) NOT NULL,
	Password VARCHAR(255) NOT NULL,
	Salt CHAR(8) NOT NULL,
	Role ENUM('manager','developer') NOT NULL
);
	
CREATE TABLE Projects (
	IdProject INT PRIMARY KEY AUTO_INCREMENT,
	Label VARCHAR(50) NOT NULL
);

CREATE TABLE Dates (
	`Date` DATE PRIMARY KEY,
	MonthNum INT NOT NULL,
	WeekNum INT NOT NULL
);

CREATE TABLE TimeSlots (
	IdSlot INT PRIMARY KEY AUTO_INCREMENT,
	HourCount INT NOT NULL,
	IdUser INT NOT NULL,
	IdProject INT NOT NULL,
	ReferredDate DATE NOT NULL,
	FOREIGN KEY (IdUser) REFERENCES users(id_user),
	FOREIGN KEY (IdProject) REFERENCES projects(IdProject),
	FOREIGN KEY (ReferredDate) REFERENCES dates(ReferredDate)
);


DELIMITER $$

CREATE PROCEDURE InsertDate(dt DATE)
BEGIN
    INSERT INTO Dates
    VALUES(
        dt, 
        EXTRACT(MONTH FROM dt),
        WEEK(dt)+1
    );
END$$

CREATE PROCEDURE LoadDates(
    startDate DATE, 
    endDate DATE
)
BEGIN
    DECLARE dt DATE DEFAULT startDate;

    WHILE DATEDIFF(endDate, dt) > 0 DO
        CALL InsertDate(dt);
        SET dt = DATE_ADD(dt,INTERVAL 1 day);
    END WHILE;

END$$

DELIMITER ;

CALL LoadDates('2020-01-01', '2025-01-01');