-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema schedule
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema schedule
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `schedule` DEFAULT CHARACTER SET utf8 ;
USE `schedule` ;

-- -----------------------------------------------------
-- Table `schedule`.`group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`group` (
  `group_id` INT NOT NULL AUTO_INCREMENT,
  `number` INT NOT NULL,
  `faculty` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`group_id`),
  UNIQUE INDEX `group_id_UNIQUE` (`group_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schedule`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `patronymic` VARCHAR(45) NULL,
  `sdo_id` BIGINT NOT NULL,
  `group_id` INT NOT NULL,
  `subgroup_number` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `sdo_id_UNIQUE` (`sdo_id` ASC),
  INDEX `group_idx` (`group_id` ASC),
  CONSTRAINT `group_s`
    FOREIGN KEY (`group_id`)
    REFERENCES `schedule`.`group` (`group_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schedule`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`user` (
  `id` VARCHAR(45) NOT NULL,
  `sdo_id` BIGINT NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  UNIQUE INDEX `sdo_id_UNIQUE` (`sdo_id` ASC),
  CONSTRAINT `user_s`
    FOREIGN KEY (`sdo_id`)
    REFERENCES `schedule`.`student` (`sdo_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schedule`.`lecture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`lecture` (
  `lecture_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `patronymic` VARCHAR(45) NULL,
  `login` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`lecture_id`),
  UNIQUE INDEX `lecture_id_UNIQUE` (`lecture_id` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  CONSTRAINT `user_l`
    FOREIGN KEY (`login`)
    REFERENCES `schedule`.`user` (`login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schedule`.`lesson`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`lesson` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `subject_name` VARCHAR(45) NOT NULL,
  `lecture_id` INT NOT NULL,
  `group_id` INT NOT NULL,
  `day_of_week` VARCHAR(45) NOT NULL,
  `number_of_lesson` INT NOT NULL,
  `lecture_hall` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `subgroup_number` INT NOT NULL,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `group_l_idx` (`group_id` ASC),
  CONSTRAINT `group_l`
    FOREIGN KEY (`group_id`)
    REFERENCES `schedule`.`group` (`group_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `lesson`
    FOREIGN KEY (`id`)
    REFERENCES `schedule`.`lecture` (`lecture_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
