CREATE DATABASE zxpj;
USE zxpj;

CREATE TABLE Manager (
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
  `note` TEXT, -- UPDATED
  `mobile` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`vendor_id`)
);

CREATE TABLE Purchase (
  `purchase_id` INT(11) NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(32) NOT NULL, -- 采购业务编号
  `date` DATETIME NOT NULL,
  `cost` DECIMAL(19, 2) NOT NULL,
  `note` VARCHAR(32), -- 采购备注
  `quantity` INT(11) NOT NULL,
  `status` INT(1) DEFAULT 0 NOT NULL, -- 未出库为 0
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
  `number` VARCHAR(32) NOT NULL, -- 销售业务编号
  `date` DATETIME NOT NULL,
  `cost` DECIMAL(19,2) NOT NULL,
  `note` VARCHAR(32), -- 销售备注
  `quantity` INT(11) NOT NULL,
  `status` INT(1) DEFAULT 0 NOT NULL , -- 未送达为 0
  `commodity_id` INT(11) NOT NULL,
  -- 客户外键
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

INSERT INTO `Vendor` (`vendor_id`, `name`, `address`, `postal_code`, `email`, `note`, `mobile`) VALUES ('1', '番茄酱', '佛山', '311230', '11@qq.com', '', '13011112222');
INSERT INTO `Vendor` (`vendor_id`, `name`, `address`, `postal_code`, `email`, `note`, `mobile`) VALUES ('2', '黑胡椒酱', '佛山', '322123', '22@qq.com', '', '13022223333');
INSERT INTO `Vendor` (`vendor_id`, `name`, `address`, `postal_code`, `email`, `note`, `mobile`) VALUES ('3', '挂面', '佛山', '222222', '33@qq.com', '', '13022224444');
INSERT INTO `Vendor` (`vendor_id`, `name`, `address`, `postal_code`, `email`, `note`, `mobile`) VALUES ('4', '龙须面', '广东', '333333', '44@qq.com', '', '13055554444');
INSERT INTO `Vendor` (`vendor_id`, `name`, `address`, `postal_code`, `email`, `note`, `mobile`) VALUES ('5', '意大利细面条', '广东', '222222', '12@qq.com', '', '13044444444');
INSERT INTO `Vendor` (`vendor_id`, `name`, `address`, `postal_code`, `email`, `note`, `mobile`) VALUES ('6', '意大利螺旋面', '广东', '555555', '13@qq.com', '', '13055554444');
INSERT INTO `Vendor` (`vendor_id`, `name`, `address`, `postal_code`, `email`, `note`, `mobile`) VALUES ('7', '魔芋面', '湖北', '555444', '14@qq.com', '', '13088887777');
INSERT INTO `Vendor` (`vendor_id`, `name`, `address`, `postal_code`, `email`, `note`, `mobile`) VALUES ('8', '荞麦面', '湖北', '444444', '15@qq.com', '', '13088887777');
INSERT INTO `Vendor` (`vendor_id`, `name`, `address`, `postal_code`, `email`, `note`, `mobile`) VALUES ('9', '全麦面', '湖北', '666666', '16@qq.com', '', '13055554444');

SELECT * FROM Commodity;