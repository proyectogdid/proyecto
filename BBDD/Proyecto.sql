-- MySQL Script generated by MySQL Workbench
-- Fri May 31 18:04:47 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`campos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`campos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `ciudad` VARCHAR(45) NOT NULL,
  `calle` VARCHAR(45) NOT NULL,
  `numero` VARCHAR(45) NOT NULL,
  `cp` VARCHAR(45) NOT NULL,
  `cantidad` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`equipos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`equipos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `patrocinador` VARCHAR(45) NULL DEFAULT NULL,
  `campo` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `campo`),
  INDEX `fk_equipos_campos1_idx` (`campo` ASC) VISIBLE,
  CONSTRAINT `fk_equipos_campos1`
    FOREIGN KEY (`campo`)
    REFERENCES `mydb`.`campos` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`estados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`estados` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`posiciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`posiciones` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`jugadores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`jugadores` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido1` VARCHAR(45) NOT NULL,
  `apellido2` VARCHAR(45) NOT NULL,
  `fechaNac` DATE NOT NULL,
  `dorsal` VARCHAR(5) NOT NULL,
  `textoCamiseta` VARCHAR(45) NOT NULL,
  `equipo` INT(11) NOT NULL,
  `posicion` INT(11) NOT NULL,
  `estado` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `equipo`, `posicion`, `estado`),
  INDEX `fk_jugadores_equipos_idx` (`equipo` ASC) VISIBLE,
  INDEX `fk_jugadores_posiciones1_idx` (`posicion` ASC) VISIBLE,
  INDEX `fk_jugadores_estados1_idx` (`estado` ASC) VISIBLE,
  CONSTRAINT `fk_jugadores_equipos`
    FOREIGN KEY (`equipo`)
    REFERENCES `mydb`.`equipos` (`id`),
  CONSTRAINT `fk_jugadores_estados1`
    FOREIGN KEY (`estado`)
    REFERENCES `mydb`.`estados` (`id`),
  CONSTRAINT `fk_jugadores_posiciones1`
    FOREIGN KEY (`posicion`)
    REFERENCES `mydb`.`posiciones` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`eventos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`eventos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `jugador` INT(11) NOT NULL,
  `estadoPrevio` INT(11) NOT NULL,
  `estadoPosterior` INT(11) NOT NULL,
  `fecha` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `jugador`, `estadoPrevio`, `estadoPosterior`),
  INDEX `fk_eventos_jugadores1_idx` (`jugador` ASC) VISIBLE,
  INDEX `fk_eventos_estados1_idx` (`estadoPrevio` ASC) VISIBLE,
  INDEX `fk_eventos_estados2_idx` (`estadoPosterior` ASC) VISIBLE,
  CONSTRAINT `fk_eventos_estados1`
    FOREIGN KEY (`estadoPrevio`)
    REFERENCES `mydb`.`estados` (`id`),
  CONSTRAINT `fk_eventos_estados2`
    FOREIGN KEY (`estadoPosterior`)
    REFERENCES `mydb`.`estados` (`id`),
  CONSTRAINT `fk_eventos_jugadores1`
    FOREIGN KEY (`jugador`)
    REFERENCES `mydb`.`jugadores` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`temporadas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`temporadas` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ano` DATE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`partidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`partidos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NOT NULL,
  `ptosLocal` INT(11) NULL DEFAULT NULL,
  `ptosVisitante` INT(11) NULL DEFAULT NULL,
  `jornada` INT(11) NOT NULL,
  `local` INT(11) NOT NULL,
  `visitante` INT(11) NOT NULL,
  `temporada` INT(11) NOT NULL,
  `campo` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `local`, `visitante`, `temporada`, `campo`),
  INDEX `fk_partidos_equipos1_idx` (`local` ASC) VISIBLE,
  INDEX `fk_partidos_equipos2_idx` (`visitante` ASC) VISIBLE,
  INDEX `fk_partidos_temporadas1_idx` (`temporada` ASC) VISIBLE,
  INDEX `fk_partidos_campos1_idx` (`campo` ASC) VISIBLE,
  CONSTRAINT `fk_partidos_campos1`
    FOREIGN KEY (`campo`)
    REFERENCES `mydb`.`campos` (`id`),
  CONSTRAINT `fk_partidos_equipos1`
    FOREIGN KEY (`local`)
    REFERENCES `mydb`.`equipos` (`id`),
  CONSTRAINT `fk_partidos_equipos2`
    FOREIGN KEY (`visitante`)
    REFERENCES `mydb`.`equipos` (`id`),
  CONSTRAINT `fk_partidos_temporadas1`
    FOREIGN KEY (`temporada`)
    REFERENCES `mydb`.`temporadas` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 39
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`traspasos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`traspasos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `precio` INT(11) NOT NULL,
  `jugador` INT(11) NOT NULL,
  `equipoPosterior` INT(11) NOT NULL,
  `equipoPrevio` INT(11) NOT NULL,
  `fecha` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `jugador`, `equipoPosterior`, `equipoPrevio`),
  INDEX `fk_traspasos_jugadores1_idx` (`jugador` ASC) VISIBLE,
  INDEX `fk_traspasos_equipos2_idx` (`equipoPosterior` ASC, `equipoPrevio` ASC) VISIBLE,
  CONSTRAINT `fk_traspasos_equipos2`
    FOREIGN KEY (`equipoPosterior`)
    REFERENCES `mydb`.`equipos` (`id`),
  CONSTRAINT `fk_traspasos_jugadores1`
    FOREIGN KEY (`jugador`)
    REFERENCES `mydb`.`jugadores` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `contrasena` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `equipo_favorito` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `equipo_favorito`),
  UNIQUE INDEX `usuario_UNIQUE` (`usuario` ASC) VISIBLE,
  UNIQUE INDEX `correo_UNIQUE` (`correo` ASC) VISIBLE,
  INDEX `fk_usuario_equipos1_idx` (`equipo_favorito` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_equipos1`
    FOREIGN KEY (`equipo_favorito`)
    REFERENCES `mydb`.`equipos` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;

USE `mydb`;

DELIMITER $$
USE `mydb`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `mydb`.`generar_evento`
AFTER UPDATE ON `mydb`.`jugadores`
FOR EACH ROW
BEGIN   
if new.estado  <> old.estado then
	insert into eventos (jugador,estadoPrevio,estadoPosterior,fecha) values (new.id,old.estado,new.estado,curtime());-- SET contraseña= new.nombre; SET tas= new.dni;
end if;
  /*INSERT INTO evento values(1,2);*/
END$$

USE `mydb`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `mydb`.`generar_traspaso`
AFTER UPDATE ON `mydb`.`jugadores`
FOR EACH ROW
BEGIN   
if new.equipo  <> old.equipo then
	insert into traspasos (jugador,equipoPrevio,equipoPosterior,fecha) values (new.id,old.equipo,new.equipo,curtime());-- SET contraseña= new.nombre; SET tas= new.dni;
end if;

END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
