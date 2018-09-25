package com.zhuoxun.service.impl;

import com.zhuoxun.jdbc.MySQLHelper;
import com.zhuoxun.model.Manager;
import com.zhuoxun.service.ManagerService;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerServiceImpl implements ManagerService {

    private static String sql;
    private static Object[] params;
    private static QueryRunner qr;
    private static Connection conn;

    @Override
    public List<Manager> findAll() {
        qr = new QueryRunner();
        sql = "SELECT * FROM Manager";
        List<Manager> r = null;
        ResultSetHandler<List<Manager>> resultSetHandler = new BeanListHandler<>(Manager.class);

        try {
            conn = MySQLHelper.getConn();
            r = qr.query(conn, sql, resultSetHandler);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return r;
    }
}
