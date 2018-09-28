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
  sn VARCHAR(32), -- TAG
  `email` VARCHAR(32),
  `note` INT(11),
  `mobile` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`vendor_id`),
  CONSTRAINT fk FOREIGN KEY (sn) REFERENCES Commodity(isbn)
);

CREATE TABLE Purchase (
  `purchase_id` INT(11) NOT NULL AUTO_INCREMENT,
  `sn` VARCHAR(32) NOT NULL, -- 采购业务编号
  `purchase_date` DATETIME NOT NULL,
  `cost` DECIMAL(19,2) NOT NULL,
  `remark` VARCHAR(32) NOT NULL, -- 采购备注
  `quantity` INT(11) NOT NULL,
  `status` INT(1) DEFAULT 0 NOT NULL, -- 出库状态
  `commodity_id` INT(11) NOT NULL,
  `vendor_id` INT(11) NOT NULL,
  `manager_id` INT(11) NOT NULL,
  PRIMARY KEY (`purchase_id`),
  FOREIGN KEY (`commodity_id`) REFERENCES Commodity(`commodity_id`),
  FOREIGN KEY (`vendor_id`) REFERENCES Vendor(`vendor_id`),
  FOREIGN KEY (`manager_id`) REFERENCES Manager(`manager_id`)
);

CREATE TABLE Sale (
  `sale_id` INT(11) NOT NULL AUTO_INCREMENT,
  `sn` VARCHAR(32) NOT NULL , -- 销售业务编号
  `sale_date` DATETIME NOT NULL ,
  `cost` DECIMAL(19,2) NOT NULL ,
  `remark` VARCHAR(32) NOT NULL , -- 销售备注
  `quantity` INT(11) NOT NULL ,
  `status` INT(1) DEFAULT 0 NOT NULL , -- 未送达为 0
  `commodity_id` INT(11) NOT NULL,
  `manager_id` INT(11) NOT NULL,
  PRIMARY KEY (`sale_id`),
  FOREIGN KEY (`commodity_id`) REFERENCES Commodity(`commodity_id`),
  FOREIGN KEY (`manager_id`) REFERENCES Manager(`manager_id`)
);



INSERT INTO Manager (`username`, `password`, `mobile`, `email`, `status`) VALUE ('Zimmerman', 23444, 18022258888, 'abc@gmail.com', 1);

INSERT INTO `Commodity` (`commodity_id`, `isbn`, `name`, `purchase_price`, `unit`) VALUES ('1', '11', '牛奶', '3', '250毫升');
INSERT INTO `Commodity` (`commodity_id`, `isbn`, `name`, `purchase_price`, `unit`) VALUES ('2', '12', '燕麦', '50', '300克');
INSERT INTO `Commodity` (`commodity_id`, `isbn`, `name`, `purchase_price`, `unit`) VALUES ('3', '13', '矿泉水', '2.5', '250毫升');
INSERT INTO `Commodity` (`commodity_id`, `isbn`, `name`, `purchase_price`, `unit`) VALUES ('4', '14', '酸奶', '6', '200毫升');
INSERT INTO `Commodity` (`commodity_id`, `isbn`, `name`, `purchase_price`, `unit`) VALUES ('5', '15', '开心果', '20', '100克');
INSERT INTO `Commodity` (`commodity_id`, `isbn`, `name`, `purchase_price`, `unit`) VALUES ('6', '16', '巴旦木', '20', '100克');
INSERT INTO `Commodity` (`commodity_id`, `isbn`, `name`, `purchase_price`, `unit`) VALUES ('7', '17', '夏威夷果', '20', '100克');
INSERT INTO `Commodity` (`commodity_id`, `isbn`, `name`, `purchase_price`, `unit`) VALUES ('8', '18', '松子', '20', '100克');
INSERT INTO `Commodity` (`commodity_id`, `isbn`, `name`, `purchase_price`, `unit`) VALUES ('9', '19', '碧莲跟', '20', '100克');
INSERT INTO `Commodity` (`commodity_id`, `isbn`, `name`, `purchase_price`, `unit`) VALUES ('10', '20', '花生', '20', '100克');
INSERT INTO `Commodity` (`commodity_id`, `isbn`, `name`, `purchase_price`, `unit`) VALUES ('11', '19', '全麦面包', '7', '100克');
INSERT INTO `Commodity` (`commodity_id`, `isbn`, `name`, `purchase_price`, `unit`) VALUES ('12', '20', '蜂蜜面包', '7', '100克');
INSERT INTO `Commodity` (`commodity_id`, `isbn`, `name`, `purchase_price`, `unit`) VALUES ('13', '19', '早餐面包', '7', '100克');
INSERT INTO `Commodity` (`commodity_id`, `isbn`, `name`, `purchase_price`, `unit`) VALUES ('14', '20', '达利小面包', '7', '100克');

SELECT * FROM Commodity;