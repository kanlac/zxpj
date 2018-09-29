package com.zhuoxun.service.impl;

import com.zhuoxun.jdbc.MySQLHelper;
import com.zhuoxun.jdbc.SQLQuery;
import com.zhuoxun.model.Commodity;
import com.zhuoxun.service.CommodityService;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("Duplicates")
public class CommodityServiceImpl implements CommodityService {

    private Object[] params;
    private QueryRunner qr = new QueryRunner();
    private Connection conn;

    // TODO

    @Override
    public boolean save(Commodity c) {
        params = new Object[] { c.getIsbn(), c.getName(), c.getPurchase_price(), c.getUnit() };
        int rows = 0;

        try {
            conn = MySQLHelper.getConn();
            rows = qr.update(conn, SQLQuery.Commodity.INSERT, params);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows != 0;
    }

    @Override
    public boolean update(Commodity c) {
        params = new Object[] { c.getIsbn(), c.getName(), c.getPurchase_price(), c.getUnit(), c.getCommodity_id() };
        int rows = 0;

        try {
            conn = MySQLHelper.getConn();
            rows = qr.update(conn, SQLQuery.Commodity.UPDATE, params);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows != 0;
    }

    @Override
    public boolean delete(int id) {
        int rows = 0;

        try {
            conn = MySQLHelper.getConn();
            rows = qr.update(conn, SQLQuery.Commodity.DELETE, id);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows != 0;
    }

    @Override
    public List<Commodity> findAll() {
        List<Commodity> r = null;
        ResultSetHandler<List<Commodity>> resultSetHandler = new BeanListHandler<>(Commodity.class);

        try {
            conn = MySQLHelper.getConn();
            r = qr.query(conn, SQLQuery.Commodity.FIND_ALL, resultSetHandler);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return r;
    }

    @Override
    public Commodity findById(int id) {
        return null;
    }

    @Override
    public List<Commodity> Search(String commodityname) {
        qr = new QueryRunner();
        List<Commodity> r = null;
        ResultSetHandler<List<Commodity>> resultSetHandler = new BeanListHandler<>(Commodity.class);

        try {
            conn = MySQLHelper.getConn();
            r = qr.query(conn, SQLQuery.Commodity.SEARCH, resultSetHandler,"%"+commodityname+"%");
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return r;
    }
}
