-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Taller_Mecanico
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Taller_Mecanico
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Taller_Mecanico` DEFAULT CHARACTER SET utf8 ;
USE `Taller_Mecanico` ;

-- -----------------------------------------------------
-- Table `Taller_Mecanico`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Taller_Mecanico`.`Clientes` (
  `DNI` VARCHAR(9) NOT NULL,
  `nombre` CHAR(20) NULL,
  `Apellido1` VARCHAR(30) NULL,
  `Apellido2` VARCHAR(30) NULL,
  `Telefono` INT NULL,
  PRIMARY KEY (`DNI`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Taller_Mecanico`.`Vehiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Taller_Mecanico`.`Vehiculo` (
  `bastidor` VARCHAR(17) NOT NULL,
  `modelo` VARCHAR(45) NULL,
  `matricula` VARCHAR(45) NULL,
  `Combustible` VARCHAR(10) NULL,
  PRIMARY KEY (`bastidor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Taller_Mecanico`.`tipos_trabajadores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Taller_Mecanico`.`tipos_trabajadores` (
  `idtipos_trabajadores` INT NOT NULL,
  `nombre_tipo` VARCHAR(45) NULL,
  PRIMARY KEY (`idtipos_trabajadores`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Taller_Mecanico`.`Trabajadores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Taller_Mecanico`.`Trabajadores` (
  `idTrabajador` INT NOT NULL,
  `Nombre` VARCHAR(45) NULL,
  `tipo_Trabajador` VARCHAR(45) NULL,
  `apellidos` VARCHAR(45) NULL,
  `dni` VARCHAR(9) NOT NULL,
  `telefono` INT NULL,
  `tipos_trabajadores_idtipos_trabajadores` INT NOT NULL,
  PRIMARY KEY (`idTrabajador`, `tipos_trabajadores_idtipos_trabajadores`),
  INDEX `fk_Trabajadores_tipos_trabajadores1_idx` (`tipos_trabajadores_idtipos_trabajadores` ASC),
  CONSTRAINT `fk_Trabajadores_tipos_trabajadores1`
    FOREIGN KEY (`tipos_trabajadores_idtipos_trabajadores`)
    REFERENCES `Taller_Mecanico`.`tipos_trabajadores` (`idtipos_trabajadores`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Taller_Mecanico`.`Clientes_has_Vehiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Taller_Mecanico`.`Clientes_has_Vehiculo` (
  `Clientes_DNI` VARCHAR(9) NOT NULL,
  `Vehiculo_bastidor` VARCHAR(17) NOT NULL,
  PRIMARY KEY (`Clientes_DNI`, `Vehiculo_bastidor`),
  INDEX `fk_Clientes_has_Vehiculo_Vehiculo1_idx` (`Vehiculo_bastidor` ASC),
  INDEX `fk_Clientes_has_Vehiculo_Clientes1_idx` (`Clientes_DNI` ASC),
  CONSTRAINT `fk_Clientes_has_Vehiculo_Clientes1`
    FOREIGN KEY (`Clientes_DNI`)
    REFERENCES `Taller_Mecanico`.`Clientes` (`DNI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Clientes_has_Vehiculo_Vehiculo1`
    FOREIGN KEY (`Vehiculo_bastidor`)
    REFERENCES `Taller_Mecanico`.`Vehiculo` (`bastidor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Taller_Mecanico`.`Reparaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Taller_Mecanico`.`Reparaciones` (
  `idReparaciones` INT NOT NULL,
  `NombreReparacion` VARCHAR(45) NULL,
  `Comentarios` TEXT(100) NULL,
  `Vehiculo_bastidor` VARCHAR(17) NOT NULL,
  `Fecha` DATETIME NULL,
  `Precio` DECIMAL(4,2) NULL,
  `Observaciones` TEXT(200) NULL,
  PRIMARY KEY (`idReparaciones`, `Vehiculo_bastidor`),
  INDEX `fk_Reparaciones_Vehiculo1_idx` (`Vehiculo_bastidor` ASC),
  CONSTRAINT `fk_Reparaciones_Vehiculo1`
    FOREIGN KEY (`Vehiculo_bastidor`)
    REFERENCES `Taller_Mecanico`.`Vehiculo` (`bastidor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Taller_Mecanico`.`Vehiculo_has_Trabajadores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Taller_Mecanico`.`Vehiculo_has_Trabajadores` (
  `Vehiculo_bastidor` VARCHAR(17) NOT NULL,
  `Trabajadores_idTrabajador` INT NOT NULL,
  `Trabajadores_tipos_trabajadores_idtipos_trabajadores` INT NOT NULL,
  PRIMARY KEY (`Vehiculo_bastidor`, `Trabajadores_idTrabajador`, `Trabajadores_tipos_trabajadores_idtipos_trabajadores`),
  INDEX `fk_Vehiculo_has_Trabajadores_Trabajadores1_idx` (`Trabajadores_idTrabajador` ASC, `Trabajadores_tipos_trabajadores_idtipos_trabajadores` ASC),
  INDEX `fk_Vehiculo_has_Trabajadores_Vehiculo1_idx` (`Vehiculo_bastidor` ASC),
  CONSTRAINT `fk_Vehiculo_has_Trabajadores_Vehiculo1`
    FOREIGN KEY (`Vehiculo_bastidor`)
    REFERENCES `Taller_Mecanico`.`Vehiculo` (`bastidor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehiculo_has_Trabajadores_Trabajadores1`
    FOREIGN KEY (`Trabajadores_idTrabajador` , `Trabajadores_tipos_trabajadores_idtipos_trabajadores`)
    REFERENCES `Taller_Mecanico`.`Trabajadores` (`idTrabajador` , `tipos_trabajadores_idtipos_trabajadores`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Taller_Mecanico`.`Reparaciones_has_Vehiculo_has_Trabajadores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Taller_Mecanico`.`Reparaciones_has_Vehiculo_has_Trabajadores` (
  `Reparaciones_idReparaciones` INT NOT NULL,
  `Reparaciones_Vehiculo_bastidor` VARCHAR(17) NOT NULL,
  `Vehiculo_has_Trabajadores_Vehiculo_bastidor` VARCHAR(17) NOT NULL,
  `Vehiculo_has_Trabajadores_Trabajadores_idTrabajador` INT NOT NULL,
  `Vehiculo_has_Trabajadores_Trabajadores_dni` VARCHAR(9) NOT NULL,
  `Vehiculo_has_Trabajadores_Trabajadores_tipos_trabajadores_idtipos_trabajadores` INT NOT NULL,
  PRIMARY KEY (`Reparaciones_idReparaciones`, `Reparaciones_Vehiculo_bastidor`, `Vehiculo_has_Trabajadores_Vehiculo_bastidor`, `Vehiculo_has_Trabajadores_Trabajadores_idTrabajador`, `Vehiculo_has_Trabajadores_Trabajadores_dni`, `Vehiculo_has_Trabajadores_Trabajadores_tipos_trabajadores_idtipos_trabajadores`),
  INDEX `fk_Reparaciones_has_Vehiculo_has_Trabajadores_Vehiculo_has__idx` (`Vehiculo_has_Trabajadores_Vehiculo_bastidor` ASC, `Vehiculo_has_Trabajadores_Trabajadores_idTrabajador` ASC, `Vehiculo_has_Trabajadores_Trabajadores_dni` ASC, `Vehiculo_has_Trabajadores_Trabajadores_tipos_trabajadores_idtipos_trabajadores` ASC),
  INDEX `fk_Reparaciones_has_Vehiculo_has_Trabajadores_Reparaciones1_idx` (`Reparaciones_idReparaciones` ASC, `Reparaciones_Vehiculo_bastidor` ASC),
  CONSTRAINT `fk_Reparaciones_has_Vehiculo_has_Trabajadores_Reparaciones1`
    FOREIGN KEY (`Reparaciones_idReparaciones` , `Reparaciones_Vehiculo_bastidor`)
    REFERENCES `Taller_Mecanico`.`Reparaciones` (`idReparaciones` , `Vehiculo_bastidor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reparaciones_has_Vehiculo_has_Trabajadores_Vehiculo_has_Tr1`
    FOREIGN KEY (`Vehiculo_has_Trabajadores_Vehiculo_bastidor` , `Vehiculo_has_Trabajadores_Trabajadores_idTrabajador` , `Vehiculo_has_Trabajadores_Trabajadores_tipos_trabajadores_idtipos_trabajadores`)
    REFERENCES `Taller_Mecanico`.`Vehiculo_has_Trabajadores` (`Vehiculo_bastidor` , `Trabajadores_idTrabajador` , `Trabajadores_tipos_trabajadores_idtipos_trabajadores`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
