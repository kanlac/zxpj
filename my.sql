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

CREATE TABLE Commodity (
  `commodity_id` INT(11) NOT NULL AUTO_INCREMENT,
  `isbn` VARCHAR(32) NOT NULL,
  `name` VARCHAR(32) NOT NULL,
  `purchase_price` DECIMAL(17, 2),
  `unit` VARCHAR(32),
  PRIMARY KEY (`commodity_id`)
);

CREATE TABLE Vendor (
  `vendor_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(32),
  `postal_code` VARCHAR(6),
  `email` VARCHAR(32),
  `note` INT(11),
  `mobile` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`vendor_id`)
);

CREATE TABLE Purchase (
  --purchase_id
  `manager_id` INT(11) NOT NULL,
  --quantity
  --total_price
  --date
)




INSERT INTO Manager (`username`, `password`, `mobile`, `email`, `status`) VALUE ('Zimmerman', 23444, 18022258888, 'abc@gmail.com', 1);

INSERT INTO `Commodity` (`commodity_id`, `isbn`, `name`, `purchase_price`, `unit`) VALUES ('1', '11', '牛奶', '3', '250毫升');
INSERT INTO `Commodity` (`commodity_id`, `isbn`, `name`, `purchase_price`, `unit`) VALUES ('2', '12', '燕麦', '50', '300克');
INSERT INTO `Commodity` (`commodity_id`, `isbn`, `name`, `purchase_price`, `unit`) VALUES ('3', '13', '矿泉水', '2.5', '250毫升');
INSERT INTO `Commodity` (`commodity_id`, `isbn`, `name`, `purchase_price`, `unit`) VALUES ('4', '14', '酸奶', '6', '200毫升');

SELECT * FROM Manager;