CREATE DATABASE zxpj;
USE zxpj;

CREATE TABLE Manager(
  `manager_id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(32) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `mobile` VARCHAR(32) NOT NULL,
  `email` VARCHAR(128) DEFAULT NULL,
  `note` VARCHAR(255) DEFAULT NULL,
  `status` INT(1) DEFAULT 0,
  PRIMARY KEY (`manager_id`)
);

INSERT INTO Manager (`username`, `password`, `mobile`)
VALUE ('Dawson', 123321, 13022253334);

SELECT * FROM Manager;