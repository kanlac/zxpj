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

CREATE TABLE Product (
  `product_id` INT(11) NOT NULL AUTO_INCREMENT,
  `isbn` VARCHAR(32) NOT NULL,
  `name` VARCHAR(32) NOT NULL,
  `sale_price` DECIMAL(17, 2) NOT NULL ,
  `unit` VARCHAR(32),
  PRIMARY KEY (`product_id`)
);

INSERT INTO Manager (`username`, `password`, `mobile`)
VALUE ('Dawson', 123321, 13022253334);

INSERT INTO Manager (`username`, `password`, `mobile`, `email`, `status`) VALUE ('Zimmerman', 23444, 18022258888, 'abc@gmail.com', 1);

SELECT * FROM Manager;