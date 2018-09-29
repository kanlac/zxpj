package com.zhuoxun.service.impl;

import com.zhuoxun.jdbc.MySQLHelper;
import com.zhuoxun.jdbc.SQLQuery;
import com.zhuoxun.model.Manager;
import com.zhuoxun.service.ManagerService;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("Duplicates")
public class ManagerServiceImpl implements ManagerService {

    private Object[] params;
    private QueryRunner qr = new QueryRunner();
    private Connection conn;

    @Override
    public List<Manager> findAll() {
        List<Manager> r = null;
        ResultSetHandler<List<Manager>> resultSetHandler = new BeanListHandler<>(Manager.class);

        try {
            conn = MySQLHelper.getConn();
            r = qr.query(conn, SQLQuery.Manager.FIND_ALL, resultSetHandler);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return r;
    }

    @Override
    public Manager findByUsername(String username) {
        params = new Object[] { username };
        ResultSetHandler<Manager> resultSetHandler = new BeanHandler<>(Manager.class);
        Manager r = null;

        try {
            conn = MySQLHelper.getConn();
            r = qr.query(conn, SQLQuery.Manager.FIND_BY_USERNAME, resultSetHandler, params);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return r;
    }

    @Override
    public boolean add(Manager m) {
        params = new Object[] { m.getUsername(), m.getPassword(), m.getMobile(), m.getEmail(), m.getStatus() };
        int rows = 0;

        try {
            conn = MySQLHelper.getConn();
            rows = qr.update(conn, SQLQuery.Manager.INSERT, params);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows != 0;
    }

    @Override
    public boolean revoke(int id) {
        int rows = 0;

        try {
            conn = MySQLHelper.getConn();
            rows = qr.update(conn, SQLQuery.Manager.DELETE, id);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows != 0;
    }

    @Override
    public List<Manager> Search(String managername) {
        qr = new QueryRunner();
        List<Manager> r = null;
        ResultSetHandler<List<Manager>> resultSetHandler = new BeanListHandler<>(Manager.class);

        try {
            conn = MySQLHelper.getConn();
            r = qr.query(conn, SQLQuery.Manager.SEARCH, resultSetHandler,"%"+managername+"%");
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return r;
    }
}
