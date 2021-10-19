-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cinemav5
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cinemav5
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cinemav5` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `cinemav5` ;

-- -----------------------------------------------------
-- Table `cinemav5`.`actors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemav5`.`actors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `First_Name` VARCHAR(45) NOT NULL,
  `Last_Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cinemav5`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemav5`.`categories` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cinemav5`.`theaters`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemav5`.`theaters` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Street` VARCHAR(45) NOT NULL,
  `City` VARCHAR(45) NOT NULL,
  `Zipcode` SMALLINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cinemav5`.`halls`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemav5`.`halls` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Tag` VARCHAR(45) NOT NULL,
  `Theaters_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Halls_Theaters1_idx` (`Theaters_id` ASC) VISIBLE,
  CONSTRAINT `fk_Halls_Theaters1`
    FOREIGN KEY (`Theaters_id`)
    REFERENCES `cinemav5`.`theaters` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cinemav5`.`movies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemav5`.`movies` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(45) NOT NULL,
  `Rating` FLOAT NOT NULL,
  `Min_Age` SMALLINT NOT NULL,
  `Description` VARCHAR(255) NOT NULL,
  `Image` VARCHAR(180) NULL DEFAULT NULL,
  `Trailer` VARCHAR(180) NULL DEFAULT NULL,
  `Category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Movies_Category1_idx` (`Category_id` ASC) VISIBLE,
  CONSTRAINT `fk_Movies_Category1`
    FOREIGN KEY (`Category_id`)
    REFERENCES `cinemav5`.`categories` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cinemav5`.`movie_actors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemav5`.`movie_actors` (
  `Movies_id` INT NOT NULL,
  `Actors_id` INT NOT NULL,
  PRIMARY KEY (`Movies_id`, `Actors_id`),
  INDEX `fk_Movies_has_Actors_Actors1_idx` (`Actors_id` ASC) VISIBLE,
  INDEX `fk_Movies_has_Actors_Movies_idx` (`Movies_id` ASC) VISIBLE,
  CONSTRAINT `fk_Movies_has_Actors_Actors1`
    FOREIGN KEY (`Actors_id`)
    REFERENCES `cinemav5`.`actors` (`id`),
  CONSTRAINT `fk_Movies_has_Actors_Movies`
    FOREIGN KEY (`Movies_id`)
    REFERENCES `cinemav5`.`movies` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cinemav5`.`movies_playing`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemav5`.`movies_playing` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Date_Starts` DATE NOT NULL,
  `Date_Ends` DATE NOT NULL,
  `Movies_id` INT NOT NULL,
  `Theaters_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Movies_Playing_Theaters1_idx` (`Theaters_id` ASC) VISIBLE,
  INDEX `fk_Movies_in_Theater_Movies1` (`Movies_id` ASC) VISIBLE,
  CONSTRAINT `fk_Movies_in_Theater_Movies1`
    FOREIGN KEY (`Movies_id`)
    REFERENCES `cinemav5`.`movies` (`id`),
  CONSTRAINT `fk_Movies_Playing_Theaters1`
    FOREIGN KEY (`Theaters_id`)
    REFERENCES `cinemav5`.`theaters` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cinemav5`.`seats`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemav5`.`seats` (
  `Number` VARCHAR(45) NOT NULL,
  `row` SMALLINT NOT NULL,
  `column` SMALLINT NOT NULL,
  PRIMARY KEY (`Number`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cinemav5`.`shows`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemav5`.`shows` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `Date` DATE NOT NULL,
  `Time` TIME NOT NULL,
  `Halls_id` INT NOT NULL,
  `Movies_Playing_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Shows_Halls1_idx` (`Halls_id` ASC) VISIBLE,
  INDEX `fk_Shows_Movies_Playing1_idx` (`Movies_Playing_id` ASC) VISIBLE,
  CONSTRAINT `fk_Shows_Halls1`
    FOREIGN KEY (`Halls_id`)
    REFERENCES `cinemav5`.`halls` (`id`),
  CONSTRAINT `fk_Shows_Movies_Playing1`
    FOREIGN KEY (`Movies_Playing_id`)
    REFERENCES `cinemav5`.`movies_playing` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cinemav5`.`tickets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemav5`.`tickets` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `Price` DOUBLE NOT NULL,
  `Shows_id` BIGINT NOT NULL,
  `Seats_Number` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Tickets_Shows1_idx` (`Shows_id` ASC) VISIBLE,
  INDEX `fk_Tickets_Seats1_idx` (`Seats_Number` ASC) VISIBLE,
  CONSTRAINT `fk_Tickets_Seats1`
    FOREIGN KEY (`Seats_Number`)
    REFERENCES `cinemav5`.`seats` (`Number`),
  CONSTRAINT `fk_Tickets_Shows1`
    FOREIGN KEY (`Shows_id`)
    REFERENCES `cinemav5`.`shows` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
