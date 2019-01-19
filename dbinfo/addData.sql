DROP SCHEMA IF EXISTS `carservice`;

CREATE SCHEMA IF NOT EXISTS `carservice` DEFAULT CHARACTER SET utf8;
USE `carservice`;

CREATE TABLE IF NOT EXISTS `carservice`.`Roles`
(
  `idRole` BIGINT(4)   NOT NULL AUTO_INCREMENT,
  `role`   VARCHAR(45) NULL,
  PRIMARY KEY (`idRole`)
)
  ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `carservice`.`Users`
(
  `idUsers`  BIGINT(4)    NOT NULL AUTO_INCREMENT,
  `login`    VARCHAR(45)  NULL,
  `password` VARCHAR(120) NULL,
  `Roles_id` BIGINT(4)    NOT NULL,
  PRIMARY KEY (`idUsers`),
  INDEX `fk_Users_Roles_idx` (`Roles_id` ASC),
  CONSTRAINT `fk_Users_Roles`
    FOREIGN KEY (`Roles_id`)
      REFERENCES `carservice`.`Roles` (`idRole`)
      ON DELETE CASCADE
      ON UPDATE CASCADE
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `carservice`.`UserDetails`
(
  `idUserDetail` BIGINT(4)   NOT NULL AUTO_INCREMENT,
  `name`         VARCHAR(45) NULL,
  `phone`        VARCHAR(90) NULL,
  `email`        VARCHAR(45) NULL,
  `Users_id`     BIGINT(4)   NOT NULL,
  PRIMARY KEY (`idUserDetail`),
  INDEX `fk_UserDetails_Users1_idx` (`Users_id` ASC),
  CONSTRAINT `fk_UserDetails_Users1`
    FOREIGN KEY (`Users_id`)
      REFERENCES `carservice`.`Users` (`idUsers`)
      ON DELETE CASCADE
      ON UPDATE CASCADE
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `carservice`.`Departments`
(
  `idDepartment`   BIGINT(4)   NOT NULL AUTO_INCREMENT,
  `nameDepartment` VARCHAR(45) NULL,
  PRIMARY KEY (`idDepartment`)
)
  ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `carservice`.`Cars`
(
  `idCars`   BIGINT(4)   NOT NULL AUTO_INCREMENT,
  `brand`    VARCHAR(45) NULL,
  `model`    VARCHAR(45) NULL,
  `year`     INT         NULL,
  `codeVIN`  VARCHAR(45) NULL,
  `fuel`     VARCHAR(45) NULL,
  `Users_id` BIGINT(4)   NOT NULL,
  PRIMARY KEY (`idCars`),
  INDEX `fk_Cars_Users1_idx` (`Users_id` ASC),
  CONSTRAINT `fk_Cars_Users1`
    FOREIGN KEY (`Users_id`)
      REFERENCES `carservice`.`Users` (`idUsers`)
      ON DELETE CASCADE
      ON UPDATE CASCADE
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `carservice`.`Orders`
(
  `idOrder`        BIGINT(4)    NOT NULL AUTO_INCREMENT,
  `timeRegister`   TIMESTAMP    NULL,
  `Description`    VARCHAR(120) NULL,
  `status`         VARCHAR(50)  NULL,
  `Users_id`       BIGINT(4)    NOT NULL,
  `Departments_id` BIGINT(4)    NOT NULL,
  `Cars_id`        BIGINT(4)    NOT NULL,
  PRIMARY KEY (`idOrder`),
  INDEX `fk_Orders_Users1_idx` (`Users_id` ASC),
  INDEX `fk_Orders_Departments1_idx` (`Departments_id` ASC),
  INDEX `fk_Orders_Cars1_idx` (`Cars_id` ASC),
  CONSTRAINT `fk_Orders_Users1`
    FOREIGN KEY (`Users_id`)
      REFERENCES `carservice`.`Users` (`idUsers`)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  CONSTRAINT `fk_Orders_Departments1`
    FOREIGN KEY (`Departments_id`)
      REFERENCES `carservice`.`Departments` (`idDepartment`)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  CONSTRAINT `fk_Orders_Cars1`
    FOREIGN KEY (`Cars_id`)
      REFERENCES `carservice`.`Cars` (`idCars`)
      ON DELETE CASCADE
      ON UPDATE CASCADE
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `carservice`.`Invoices`
(
  `idInvoice`     BIGINT(4)     NOT NULL AUTO_INCREMENT,
  `numberInvoice` BIGINT(4)     NULL,
  `cost`          DECIMAL(8, 2) NULL,
  `Orders_id`     BIGINT(4)     NOT NULL,
  PRIMARY KEY (`idInvoice`),
  INDEX `fk_Invoices_Orders1_idx` (`Orders_id` ASC),
  CONSTRAINT `fk_Invoices_Orders1`
    FOREIGN KEY (`Orders_id`)
      REFERENCES `carservice`.`Orders` (`idOrder`)
      ON DELETE CASCADE
      ON UPDATE CASCADE
)
  ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `carservice`.`Comments`
(
  `idComment`   BIGINT(4)    NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(120) NULL,
  `Users_id`    BIGINT(4)    NOT NULL,
  PRIMARY KEY (`idComment`),
  INDEX `fk_Comments_Users1_idx` (`Users_id` ASC),
  CONSTRAINT `fk_Comments_Users1`
    FOREIGN KEY (`Users_id`)
      REFERENCES `carservice`.`Users` (`idUsers`)
      ON DELETE CASCADE
      ON UPDATE CASCADE
)
  ENGINE = InnoDB;


START TRANSACTION;
USE `carservice`;
INSERT INTO `carservice`.`Roles` (`idRole`, `role`)
VALUES (Default, 'admin');
INSERT INTO `carservice`.`Roles` (`idRole`, `role`)
VALUES (Default, 'user');
COMMIT;


START TRANSACTION;
USE `carservice`;
INSERT INTO `carservice`.`Users` (`idUsers`, `login`, `password`, `Roles_id`)
VALUES (Default, 'admin', 'de3741539c32d367f6556addbdca97dfca2002317fbb03c00ac308e2703a8ab3', 1);
INSERT INTO `carservice`.`Users` (`idUsers`, `login`, `password`, `Roles_id`)
VALUES (Default, 'user', 'de3741539c32d367f6556addbdca97dfca2002317fbb03c00ac308e2703a8ab3', 2);
COMMIT;


START TRANSACTION;
USE `carservice`;
INSERT INTO carservice.Departments (idDepartment, nameDepartment)
VALUES (Default, 'Technical inspection');
INSERT INTO carservice.Departments (idDepartment, nameDepartment)
VALUES (Default, 'Replacement of technical fluids');
INSERT INTO carservice.Departments (idDepartment, nameDepartment)
VALUES (Default, 'Engine repair');
INSERT INTO carservice.Departments (idDepartment, nameDepartment)
VALUES (Default, 'Suspension repair');
INSERT INTO carservice.Departments (idDepartment, nameDepartment)
VALUES (Default, 'Body repair');
INSERT INTO carservice.Departments (idDepartment, nameDepartment)
VALUES (Default, 'Tire fitting');
INSERT INTO carservice.Departments (idDepartment, nameDepartment)
VALUES (Default, 'Transmission repair');
INSERT INTO carservice.Departments (idDepartment, nameDepartment)
VALUES (Default, 'Repair of electrics');
INSERT INTO carservice.Departments (idDepartment, nameDepartment)
VALUES (Default, 'Reading engine errors');
INSERT INTO carservice.Departments (idDepartment, nameDepartment)
VALUES (Default, 'OrderTransactionImpl parts');
INSERT INTO carservice.Departments (idDepartment, nameDepartment)
VALUES (Default, 'Brake system repair');
INSERT INTO carservice.Departments (idDepartment, nameDepartment)
VALUES (Default, 'Repair the exhaust system');
COMMIT;


START TRANSACTION;
USE `carservice`;
INSERT INTO carservice.UserDetails (idUserDetail, name, phone, email, Users_id)
VALUES (Default, 'Admin', '80293255233', 'admin@admin.com',1);
INSERT INTO carservice.UserDetails (idUserDetail, name, phone, email, Users_id)
VALUES (Default, 'Sergei', '80293255233', 'sergei@mail.com',2);
COMMIT;