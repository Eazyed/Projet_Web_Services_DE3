CREATE DATABASE web_service_db;

USE web_service_db;

CREATE TABLE users (
	id_user INT PRIMARY KEY AUTO_INCREMENT,
	firstname VARCHAR(50) NOT NULL,
	lastname VARCHAR(50) NOT NULL,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(255) NOT NULL,
	role ENUM('manager','developer') NOT NULL
);
	
CREATE TABLE projects (
	id_project INT PRIMARY KEY AUTO_INCREMENT,
	label VARCHAR(50) NOT NULL
);

CREATE TABLE dates (
	`date` DATE PRIMARY KEY,
	month_num INT NOT NULL,
	week_num INT NOT NULL
);

CREATE TABLE time_slots (
	id_slot INT PRIMARY KEY AUTO_INCREMENT,
	hour_count INT NOT NULL,
	id_user INT NOT NULL,
	id_project INT NOT NULL,
	referred_date DATE NOT NULL,
	FOREIGN KEY (id_user) REFERENCES users(id_user),
	FOREIGN KEY (id_project) REFERENCES projects(id_project),
	FOREIGN KEY (referred_date) REFERENCES dates(referred_date)
);


DELIMITER $$

CREATE PROCEDURE insertDate(dt DATE)
BEGIN
    INSERT INTO dates
    VALUES(
        dt, 
        EXTRACT(MONTH FROM dt),
        WEEK(dt)
    );
END$$

CREATE PROCEDURE loadDates(
    startDate DATE, 
    endDate DATE
)
BEGIN
    DECLARE dt DATE DEFAULT startDate;

    WHILE DATEDIFF(endDate, dt) > 0 DO
        CALL insertDate(dt);
        SET dt = DATE_ADD(dt,INTERVAL 1 day);
    END WHILE;

END$$

DELIMITER ;

CALL loadDates('2020-01-01', '2025-01-01');