-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema iib2_gruppe1
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `iib2_gruppe1` ;

-- -----------------------------------------------------
-- Schema iib2_gruppe1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `iib2_gruppe1` DEFAULT CHARACTER SET utf8 ;
USE `iib2_gruppe1` ;

-- -----------------------------------------------------
-- Table `iib2_gruppe1`.`kunde`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iib2_gruppe1`.`kunde` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `vorname` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `iib2_gruppe1`.`auftrag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iib2_gruppe1`.`auftrag` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `beschreibung` TEXT NULL,
  `erledigt` TINYINT(1) NULL,
  `kunde_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Auftrag_Kunde1_idx` (`kunde_id` ASC),
  CONSTRAINT `fk_Auftrag_Kunde1`
    FOREIGN KEY (`kunde_id`)
    REFERENCES `iib2_gruppe1`.`kunde` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `iib2_gruppe1`.`adresse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iib2_gruppe1`.`adresse` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `strasse` VARCHAR(45) NULL,
  `hausnummer` VARCHAR(5) NULL,
  `plz` VARCHAR(10) NULL,
  `ort` VARCHAR(45) NULL,
  `kunde_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Adresse_Kunde1_idx` (`kunde_id` ASC),
  CONSTRAINT `fk_Adresse_Kunde1`
    FOREIGN KEY (`kunde_id`)
    REFERENCES `iib2_gruppe1`.`kunde` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `iib2_gruppe1`.`kunde`
-- -----------------------------------------------------
START TRANSACTION;
USE `iib2_gruppe1`;
INSERT INTO `iib2_gruppe1`.`kunde` (`id`, `name`, `vorname`) VALUES (DEFAULT, 'Duck', 'Donald');

COMMIT;


-- -----------------------------------------------------
-- Data for table `iib2_gruppe1`.`auftrag`
-- -----------------------------------------------------
START TRANSACTION;
USE `iib2_gruppe1`;
INSERT INTO `iib2_gruppe1`.`auftrag` (`id`, `beschreibung`, `erledigt`, `kunde_id`) VALUES (DEFAULT, '2x Blumenstrauß', false, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `iib2_gruppe1`.`adresse`
-- -----------------------------------------------------
START TRANSACTION;
USE `iib2_gruppe1`;
INSERT INTO `iib2_gruppe1`.`adresse` (`id`, `strasse`, `hausnummer`, `plz`, `ort`, `kunde_id`) VALUES (DEFAULT, 'Blumenstraße', '13', '10101', 'Entenhausen', 1);

COMMIT;
