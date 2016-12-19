CREATE DATABASE schedule CHARACTER SET utf8;
CREATE USER 'schedule_user'@'localhost' IDENTIFIED BY '1234';
USE schedule;
GRANT ALL PRIVILEGES ON schedule.* TO 'schedule_user'@'localhost';
FLUSH PRIVILEGES;