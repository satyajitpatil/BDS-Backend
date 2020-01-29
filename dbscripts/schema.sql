CREATE SCHEMA IF NOT EXISTS `bloodbank` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `bloodbank` ;

-- -----------state table

CREATE TABLE IF NOT EXISTS `bloodbank`.`state`(
	`state_id` INT NOT NULL AUTO_INCREMENT,
	`state` VARCHAR(50) NULL,
PRIMARY KEY (`state_id`))
ENGINE = InnoDB;

-- -----------city table

CREATE TABLE IF NOT EXISTS `bloodbank`.`city`(
	`city_id` INT NOT NULL AUTO_INCREMENT,
	`city` VARCHAR(50) NULL,
	`state_id` INT NULL,
PRIMARY KEY (`city_id`))
ENGINE = InnoDB;


-- -----------user table

CREATE TABLE IF NOT EXISTS `bloodbank`.`user` (
	`user_id` INT NOT NULL AUTO_INCREMENT,
	`user_name` VARCHAR(50) NOT NULL,
	`first_name` VARCHAR(50) NULL,
	`last_name` VARCHAR(50) NULL,
	`age` INT(3) NULL,
	`gender` VARCHAR(6),
	`contact_number` BIGINT(10) NULL,
	`email` VARCHAR(15) NULL,
	`password` VARCHAR(300) NULL,
	`weight` DECIMAL(3,1) NULL,
	`state_id` INT(2) NULL,
	`area` VARCHAR(20) NULL,
	`pincode` INT(6) NULL,
	`blood_group` VARCHAR(4),
PRIMARY KEY (`user_id`))
ENGINE = InnoDB;

-- -----------feedback table

CREATE TABLE IF NOT EXISTS `bloodbank`.`feedback` (
    `feedback_id` INT NOT NULL AUTO_INCREMENT,
    `hospital_name` VARCHAR(15) NULL,
	`city_id` INT NULL,
	`comments` TEXT(500) NULL,
	`user_id` INT NOT NULL,
	PRIMARY KEY (`feedback_id`))
ENGINE = InnoDB;



-- -----------available_blood table

CREATE TABLE IF NOT EXISTS `bloodbank`.`available_blood` (
	`blood_id` INT NOT NULL AUTO_INCREMENT,
	`blood_group` VARCHAR(4) NULL,
	`blood_bank_name` VARCHAR(50) NULL,
	`state_id` INT(2) NULL,
	`area` VARCHAR(20) NULL,
	`pincode` INT(6) NULL,
	`contact_number` BIGINT(10) NULL,
	`units` INT NOT NULL,
PRIMARY KEY (`blood_id`),
CONSTRAINT `state_id_available_fk`
    FOREIGN KEY (`state_id`)
    REFERENCES `bloodbank`.`state` (`state_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `bloodbank`.`blood_requirement` (
	`req_id` INT NOT NULL AUTO_INCREMENT,
	`blood_group` VARCHAR(4) NULL,
	`state_id` INT(2) NULL,
	`area` VARCHAR(20) NULL,
	`pincode` INT(6) NULL,
	`contact_number` BIGINT(10) NULL,
	`user_id` INT NULL,
PRIMARY KEY (`req_id`),
CONSTRAINT `state_id_blood_requirement_fk`
    FOREIGN KEY (`state_id`)
    REFERENCES `bloodbank`.`state` (`state_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------slot table

CREATE TABLE `bloodbank`.`slot` (
  `slot_id` INT NOT NULL AUTO_INCREMENT,
`hospital_name` varchar(50),
  `city_id` INT NOT NULL,
  `date` DATE NULL,
  `time` TIME NULL,
  `donor_id` INT NOT NULL,
  PRIMARY KEY (`slot_id`),
   CONSTRAINT `city_id_slot_fk`
    FOREIGN KEY (`city_id`)
    REFERENCES `bloodbank`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `donor_id_slot_fk`
    FOREIGN KEY (`donor_id`)
    REFERENCES `bloodbank`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    )
ENGINE = InnoDB;


-- -----------Blood bank tables
CREATE TABLE IF NOT EXISTS `bloodbank`.`blood_bank`(
	`blood_bank_id` INT NOT NULL AUTO_INCREMENT,
    `blood_bank_name` VARCHAR(50) NULL,
    `state_id` INT NOT NULL,
    `area` VARCHAR(50) NULL,
    `pincode` INT NOT NULL,
    `contact_number` BIGINT(10) NOT NULL,
PRIMARY KEY (`blood_bank_id`),
CONSTRAINT `state_id_of_hospital_table_fk`
    FOREIGN KEY (`state_id`)
    REFERENCES `bloodbank`.`state` (`state_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- ----------- blood_request_from_bank_mapping --its remaining
create table if not exists `bloodbank`.`blood_request_from_bank_mapping`(
	`mapping_id` INT NOT NULL AUTO_INCREMENT,
	`available_blood_id` INT NOT NULL,
    `requestor_id` INT NOT NULL,
    `blood_bank_id` INT NOT NULL,
    `is_approved` BOOLEAN NOT NULL DEFAULT 0,
    `is_rejected` BOOLEAN NOT NULL DEFAULT 0,
PRIMARY KEY (`mapping_id`),
CONSTRAINT `available_blood_id_of_mapping_table_fk`
    FOREIGN KEY (`available_blood_id`)
    REFERENCES `bloodbank`.`available_blood` (`blood_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `requestor_id_of_mapping_table_fk`
    FOREIGN KEY (`requestor_id`)
    REFERENCES `bloodbank`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `blood_bank_id_of_mapping_table_fk`
    FOREIGN KEY (`blood_bank_id`)
    REFERENCES `bloodbank`.`blood_bank` (`blood_bank_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------FAQ table

create table if not exists `bloodbank`.`faq`(
	`faq_id` int not null auto_increment,
    `question` varchar(100) null,
    `answer` varchar(300) null,
    `is_answered` boolean default 0,
    `user_id` int not null,
PRIMARY KEY (`faq_id`),
CONSTRAINT `user_id_of_faq_table_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `bloodbank`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;




CREATE TABLE `bloodbank`.`role` (
  `role_id` INT NOT NULL,
  `role_name` VARCHAR(45) NULL,
  PRIMARY KEY (`role_id`));


CREATE TABLE `bloodbank`.`user_role` (
  `ur_id` INT NOT NULL AUTO_INCREMENT,
  `ur_us_id` INT NULL,
  `ur_ro_id` INT NOT NULL,
  PRIMARY KEY (`ur_id`),
  INDEX `us_us_fk_idx` (`ur_us_id` ASC),
  INDEX `ur_ro_fk_idx` (`ur_ro_id` ASC),
  CONSTRAINT `ur_us_fk`
    FOREIGN KEY (`ur_us_id`)
    REFERENCES `bloodbank`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ur_ro_fk`
    FOREIGN KEY (`ur_ro_id`)
    REFERENCES `bloodbank`.`role` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);







