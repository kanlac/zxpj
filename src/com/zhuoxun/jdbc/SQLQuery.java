package com.zhuoxun.jdbc;

public class SQLQuery {

    public class Manager {
        public static final String FIND_ALL = "SELECT * FROM Manager";
        public static final String FIND_BY_USERNAME = "SELECT * FROM Manager WHERE username = ?";
        public static final String INSERT = "INSERT INTO Manager (`username`, `password`, `mobile`, `email`, `status`) VALUE (?, ?, ?, ?, ?)";
        public static final String DELETE = "DELETE FROM Manager WHERE manager_id = ?";
    }

    public class Commodity {
        public static final String FIND_ALL = "SELECT * FROM Commodity";
        public static final String FIND_BY_ID = "SELECT * FROM Commodity WHERE commodity_id = ?";
        public static final String INSERT = "INSERT INTO Commodity (`isbn`, `name`, `purchase_price`, `unit`) VALUE (?, ?, ?, ?)";
        public static final String DELETE = "DELETE FROM Commodity WHERE commodity_id = ?";
        public static final String UPDATE ="UPDATE Commodity SET isbn = ?, name = ?, purchase_price = ?, unit = ? WHERE commodity_id = ?" ;
    }

    public class Vendor {
        public static final String FIND_ALL = "SELECT * FROM Vendor";
        public static final String FIND_BY_NAME = "SELECT * FROM Vendor WHERE username = ?";
        public static final String FIND_BY_ID = "SELECT * FROM Vendor WHERE vendor_id = ?";
        public static final String INSERT = "INSERT INTO Vendor (`address`, `postal_code`, `mobile`, `email`, `name`,`note`) VALUE (?, ?, ?, ?, ?, ?);";
        public static final String DELETE = "DELETE FROM Vendor WHERE vendor_id = ?";
        public static final String UPDATE="UPDATE Vendor SET address = ?, postal_code = ?, email = ?, name = ?, note = ? , mobile = ? WHERE vendor_id = ?";
    }

    public class Purchase {
        public static final String FIND_ALL = "SELECT * FROM Purchase";
        public static final String INSERT = "INSERT INTO Purchase (`number`, `date`, `cost`, `note`, `quantity`, `status`, `commodity_id`, `vendor_id`, `manager_id`) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        public static final String DELETE = "DELETE FROM Purchase WHERE purchase_id = ?";
        public static final String UPDATE = "UPDATE Purchase SET `number` = ?, `date` = ?, `cost` = ?, `note` = ?, `quantity` = ?, `status` = ?, `commodity_id` = ?, `vendor_id` = ?, `manager_id` = ? WHERE `purchase_id` = ?";
    }
}
