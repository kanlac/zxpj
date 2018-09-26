package com.zhuoxun.jdbc;

public class SQLQuery {

    public class Manager {
        public static final String FIND_ALL = "SELECT * FROM Manager";
        public static final String FIND_BY_USERNAME = "SELECT * FROM Manager WHERE username = ?";
        public static final String ADD = "INSERT INTO Manager (`username`, `password`, `mobile`, `email`, `status`) VALUE (?, ?, ?, ?, ?)";
        public static final String REVOKE = "DELETE FROM Manager WHERE manager_id = ?";
    }
}
