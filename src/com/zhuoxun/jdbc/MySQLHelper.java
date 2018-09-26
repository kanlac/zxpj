package com.zhuoxun.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLHelper {

    private MySQLHelper() {}

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found under classpath.");
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库的一个连接对象，注意：使用完成后，一定要关闭。
     * @return
     * @throws java.sql.SQLException
     */

    public static Connection getConn() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/zxpj?useUnicode=true&characterEncoding=UTF8&autoReconnect=true&autoReconnectForPools=true";
        String user = "root";
        String password = "tbu33p6r9";

        return DriverManager.getConnection(url, user, password);
    }

    /**
     * Close connection.
     */

    public static void close(Connection conn) {
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
