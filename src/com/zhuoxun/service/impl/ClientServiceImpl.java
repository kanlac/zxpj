package com.zhuoxun.service.impl;

import com.zhuoxun.jdbc.MySQLHelper;
import com.zhuoxun.jdbc.SQLQuery;
import com.zhuoxun.model.Client;
import com.zhuoxun.service.ClientService;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ClientServiceImpl implements ClientService {

    private Object[] params;
    private QueryRunner qr = new QueryRunner();
    private Connection conn;

    // TODO

    @Override
    public boolean add(Client m) {
        params = new Object[] { m.getName(), m.getAddress(), m.getPostal_code(), m.getEmail(), m.getNote(),m.getMobile() };
        int rows = 0;

        try {
            conn = MySQLHelper.getConn();
            rows = qr.update(conn, SQLQuery.Client.ADD, params);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows != 0;
    }

    @Override
    public boolean update(Client c) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        qr = new QueryRunner();
        int rows = 0;

        try {
            conn = MySQLHelper.getConn();
            rows = qr.update(conn, SQLQuery.Client.DELETE, id);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows != 0;
    }

    @Override
    public List<Client> findAll() {
        List<Client> r = null;
        ResultSetHandler<List<Client>> resultSetHandler = new BeanListHandler<>(Client.class);

        try {
            conn = MySQLHelper.getConn();
            r = qr.query(conn, SQLQuery.Client.FIND_ALL, resultSetHandler);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return r;
    }

    @Override
    public Client findById(int id) {
        return null;
    }
}
