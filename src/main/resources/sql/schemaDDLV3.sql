-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema cinemaV2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cinemaV2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cinemaV2` DEFAULT CHARACTER SET utf8 ;
USE `cinemaV2` ;

-- -----------------------------------------------------
-- Table `cinemaV2`.`Categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaV2`.`Categories` (
  `id` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaV2`.`Movies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaV2`.`Movies` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(45) NOT NULL,
  `Rating` FLOAT NOT NULL,
  `Min_Age` SMALLINT NOT NULL,
  `Description` VARCHAR(255) NOT NULL,
  `Category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Movies_Category1_idx` (`Category_id` ASC),
  CONSTRAINT `fk_Movies_Category1`
    FOREIGN KEY (`Category_id`)
    REFERENCES `cinemaV2`.`Categories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaV2`.`Actors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaV2`.`Actors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `First_Name` VARCHAR(45) NOT NULL,
  `Last_Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaV2`.`Movie_Actors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaV2`.`Movie_Actors` (
  `Movies_id` INT NOT NULL,
  `Actors_id` INT NOT NULL,
  PRIMARY KEY (`Movies_id`, `Actors_id`),
  INDEX `fk_Movies_has_Actors_Actors1_idx` (`Actors_id` ASC),
  INDEX `fk_Movies_has_Actors_Movies_idx` (`Movies_id` ASC),
  CONSTRAINT `fk_Movies_has_Actors_Movies`
    FOREIGN KEY (`Movies_id`)
    REFERENCES `cinemaV2`.`Movies` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Movies_has_Actors_Actors1`
    FOREIGN KEY (`Actors_id`)
    REFERENCES `cinemaV2`.`Actors` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaV2`.`Theaters`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaV2`.`Theaters` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Street` VARCHAR(45) NOT NULL,
  `City` VARCHAR(45) NOT NULL,
  `Zipcode` SMALLINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaV2`.`Halls`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaV2`.`Halls` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Tag` VARCHAR(45) NOT NULL,
  `Theaters_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Halls_Theaters1_idx` (`Theaters_id` ASC),
  CONSTRAINT `fk_Halls_Theaters1`
    FOREIGN KEY (`Theaters_id`)
    REFERENCES `cinemaV2`.`Theaters` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaV2`.`Shows`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaV2`.`Shows` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Date` DATE NOT NULL,
  `Time` TIME NOT NULL,
  `Halls_id` INT NOT NULL,
  `Movies_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Shows_Movies1_idx` (`Movies_id` ASC),
  INDEX `fk_Shows_Halls1_idx` (`Halls_id` ASC),
  CONSTRAINT `fk_Shows_Movies1`
    FOREIGN KEY (`Movies_id`)
    REFERENCES `cinemaV2`.`Movies` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Shows_Halls1`
    FOREIGN KEY (`Halls_id`)
    REFERENCES `cinemaV2`.`Halls` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaV2`.`seat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaV2`.`seat` (
  `row` INT NOT NULL,
  `col` VARCHAR(45) NOT NULL,
  `Halls_id` INT NOT NULL,
  INDEX `fk_seat_Halls1_idx` (`Halls_id` ASC),
  CONSTRAINT `fk_seat_Halls1`
    FOREIGN KEY (`Halls_id`)
    REFERENCES `cinemaV2`.`Halls` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemaV2`.`Movies_Playing`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemaV2`.`Movies_Playing` (
  `Movies_id` INT NOT NULL,
  `Theaters_id` INT NOT NULL,
  `Date_Starts` DATE NOT NULL,
  `Date_Ends` DATE NOT NULL,
  PRIMARY KEY (`Movies_id`, `Theaters_id`),
  INDEX `fk_Movies_in_Theater_Theaters1_idx` (`Theaters_id` ASC),
  CONSTRAINT `fk_Movies_in_Theater_Movies1`
    FOREIGN KEY (`Movies_id`)
    REFERENCES `cinemaV2`.`Movies` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Movies_in_Theater_Theaters1`
    FOREIGN KEY (`Theaters_id`)
    REFERENCES `cinemaV2`.`Theaters` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
