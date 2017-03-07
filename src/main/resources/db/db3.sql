-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema schedule
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema schedule
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `schedule` DEFAULT CHARACTER SET utf8 ;
USE `schedule` ;

-- -----------------------------------------------------
-- Table `schedule`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `sdo_id` BIGINT(20) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  UNIQUE INDEX `sdo_id_UNIQUE` (`sdo_id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `schedule`.`lecture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`lecture` (
  `lecture_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `patronymic` VARCHAR(45) NULL DEFAULT NULL,
  `login` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`lecture_id`),
  UNIQUE INDEX `lecture_id_UNIQUE` (`lecture_id` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  CONSTRAINT `user_l`
    FOREIGN KEY (`login`)
    REFERENCES `schedule`.`user` (`login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `schedule`.`student_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`student_group` (
  `group_id` INT(11) NOT NULL AUTO_INCREMENT,
  `number` INT(11) NOT NULL,
  `faculty` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`group_id`),
  UNIQUE INDEX `group_id_UNIQUE` (`group_id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `schedule`.`lesson`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`lesson` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `subject_name` VARCHAR(45) NOT NULL,
  `group_id` INT(11) NOT NULL,
  `day_of_week` VARCHAR(45) NOT NULL,
  `number_of_lesson` INT(11) NOT NULL,
  `lecture_hall` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `subgroup_number` INT(11) NOT NULL,
  `lecturer_surname` VARCHAR(45) NOT NULL,
  `lecturer_name` VARCHAR(45) NOT NULL,
  `lecturer_patronymic` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `group_l_idx` (`group_id` ASC),
  CONSTRAINT `group_l`
    FOREIGN KEY (`group_id`)
    REFERENCES `schedule`.`student_group` (`group_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `schedule`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`student` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `patronymic` VARCHAR(45) NULL DEFAULT NULL,
  `sdo_id` BIGINT(20) NOT NULL,
  `group_id` INT(11) NOT NULL,
  `subgroup_number` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `sdo_id_UNIQUE` (`sdo_id` ASC),
  INDEX `group_idx` (`group_id` ASC),
  CONSTRAINT `group_s`
    FOREIGN KEY (`group_id`)
    REFERENCES `schedule`.`student_group` (`group_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `student_user`
    FOREIGN KEY (`sdo_id`)
    REFERENCES `schedule`.`user` (`sdo_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
