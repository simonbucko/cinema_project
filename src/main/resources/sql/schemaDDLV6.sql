-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema cinemav6
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cinemav6
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cinemav6` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `cinemav6` ;

-- -----------------------------------------------------
-- Table `cinemav6`.`actors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemav6`.`actors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `First_Name` VARCHAR(45) NOT NULL,
  `Last_Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cinemav6`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemav6`.`categories` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cinemav6`.`theaters`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemav6`.`theaters` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Street` VARCHAR(45) NOT NULL,
  `City` VARCHAR(45) NOT NULL,
  `Zipcode` SMALLINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cinemav6`.`halls`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemav6`.`halls` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Tag` VARCHAR(45) NOT NULL,
  `Rows` SMALLINT NOT NULL,
  `Columns` SMALLINT NOT NULL,
  `Theaters_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Halls_Theaters1_idx` (`Theaters_id` ASC),
  CONSTRAINT `fk_Halls_Theaters1`
    FOREIGN KEY (`Theaters_id`)
    REFERENCES `cinemav6`.`theaters` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cinemav6`.`movies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemav6`.`movies` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(45) NOT NULL,
  `Rating` FLOAT NOT NULL,
  `Min_Age` SMALLINT NOT NULL,
  `Description` VARCHAR(255) NOT NULL,
  `Image` VARCHAR(180) NULL DEFAULT NULL,
  `Trailer` VARCHAR(180) NULL DEFAULT NULL,
  `Category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Movies_Category1_idx` (`Category_id` ASC),
  CONSTRAINT `fk_Movies_Category1`
    FOREIGN KEY (`Category_id`)
    REFERENCES `cinemav6`.`categories` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cinemav6`.`movie_actors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemav6`.`movie_actors` (
  `Movies_id` INT NOT NULL,
  `Actors_id` INT NOT NULL,
  PRIMARY KEY (`Movies_id`, `Actors_id`),
  INDEX `fk_Movies_has_Actors_Actors1_idx` (`Actors_id` ASC),
  INDEX `fk_Movies_has_Actors_Movies_idx` (`Movies_id` ASC),
  CONSTRAINT `fk_Movies_has_Actors_Actors1`
    FOREIGN KEY (`Actors_id`)
    REFERENCES `cinemav6`.`actors` (`id`),
  CONSTRAINT `fk_Movies_has_Actors_Movies`
    FOREIGN KEY (`Movies_id`)
    REFERENCES `cinemav6`.`movies` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cinemav6`.`movies_playing`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemav6`.`movies_playing` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Date_Starts` DATE NOT NULL,
  `Date_Ends` DATE NOT NULL,
  `Theaters_id` INT NOT NULL,
  `movies_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Movies_Playing_Theaters1_idx` (`Theaters_id` ASC),
  INDEX `fk_movies_playing_movies1_idx` (`movies_id` ASC),
  CONSTRAINT `fk_Movies_Playing_Theaters1`
    FOREIGN KEY (`Theaters_id`)
    REFERENCES `cinemav6`.`theaters` (`id`),
  CONSTRAINT `fk_movies_playing_movies1`
    FOREIGN KEY (`movies_id`)
    REFERENCES `cinemav6`.`movies` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cinemav6`.`seats`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemav6`.`seats` (
  `Number` INT NOT NULL AUTO_INCREMENT,
  `Row` SMALLINT NOT NULL,
  `Column` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Number`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cinemav6`.`shows`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemav6`.`shows` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `Date` DATE NOT NULL,
  `Time` TIME NOT NULL,
  `Movies_Playing_id` INT NOT NULL,
  `halls_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Shows_Movies_Playing1_idx` (`Movies_Playing_id` ASC),
  INDEX `fk_shows_halls1_idx` (`halls_id` ASC),
  CONSTRAINT `fk_Shows_Movies_Playing1`
    FOREIGN KEY (`Movies_Playing_id`)
    REFERENCES `cinemav6`.`movies_playing` (`id`),
  CONSTRAINT `fk_shows_halls1`
    FOREIGN KEY (`halls_id`)
    REFERENCES `cinemav6`.`halls` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cinemav6`.`tickets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemav6`.`tickets` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `Price` DOUBLE NOT NULL,
  `shows_id` BIGINT NOT NULL,
  `seats_Number` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tickets_shows1_idx` (`shows_id` ASC),
  INDEX `fk_tickets_seats1_idx` (`seats_Number` ASC),
  CONSTRAINT `fk_tickets_shows1`
    FOREIGN KEY (`shows_id`)
    REFERENCES `cinemav6`.`shows` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tickets_seats1`
    FOREIGN KEY (`seats_Number`)
    REFERENCES `cinemav6`.`seats` (`Number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
