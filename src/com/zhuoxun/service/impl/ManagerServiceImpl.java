package com.zhuoxun.service.impl;

import com.zhuoxun.jdbc.MySQLHelper;
import com.zhuoxun.model.Manager;
import com.zhuoxun.service.ManagerService;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
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

    @Override
    public Manager findByUsername(String username) {
        qr = new QueryRunner();
        sql = "SELECT * FROM Manager WHERE username = ?";
        params = new Object[] { username };
        ResultSetHandler<Manager> resultSetHandler = new BeanHandler<>(Manager.class);
        Manager r = null;

        try {
            conn = MySQLHelper.getConn();
            r = qr.query(conn, sql, resultSetHandler, params);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return r;
    }

    @Override
    public boolean append(Manager m) {
        qr = new QueryRunner();
        sql = "INSERT INTO Manager (`username`, `password`, `mobile`, `email`, `status`) VALUE (?, ?, ?, ?, ?);";
        params = new Object[] { m.getUsername(), m.getPassword(), m.getMobile(), m.getEmail(), m.getStatus() };
        int rows = 0;

        try {
            conn = MySQLHelper.getConn();
            rows = qr.update(conn, sql, params);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows != 0;
    }

    @Override
    public boolean revoke(int id) {
        qr = new QueryRunner();
        sql = "DELETE FROM Manager WHERE manager_id = ?";
        int rows = 0;

        try {
            conn = MySQLHelper.getConn();
            rows = qr.update(conn, sql, id);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows != 0;
    }
}
