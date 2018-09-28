package com.zhuoxun.service.impl;

import com.zhuoxun.jdbc.MySQLHelper;
import com.zhuoxun.jdbc.SQLQuery;
import com.zhuoxun.model.Purchase;
import com.zhuoxun.service.PurchaseService;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("Duplicates")
public class PurchaseServiceImpl implements PurchaseService {

    private Object[] params;
    private QueryRunner qr = new QueryRunner();
    private Connection conn;

    @Override
    public boolean save(Purchase p) {
        params = new Object[]{ p.getNumber(), p.getDate(), p.getCost(), p.getNote(), p.getQuantity(), p.getStatus(), p.getCommodity_id(), p.getVendor_id(), p.getManager_id() };
        int rows = 0;

        try {
            conn = MySQLHelper.getConn();
            rows = qr.update(conn, SQLQuery.Purchase.INSERT, params);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows != 0;
    }

    @Override
    public boolean  delete(int id){
        int rows = 0;
        try {
            conn = MySQLHelper.getConn();
            rows = qr.update(conn, SQLQuery.Purchase.DELETE, id);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows != 0;
    }
    @Override
    public boolean update(Purchase purchase){
        int rows = 0;

        try {
            conn = MySQLHelper.getConn();
            rows = qr.update(conn, SQLQuery.Purchase.UPDATE, params);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows != 0;
    }

    @Override
    public List<Purchase> findAll() {
        List<Purchase> r = null;
        ResultSetHandler<List<Purchase>> resultSetHandler = new BeanListHandler<>(Purchase.class);

        try {
            conn = MySQLHelper.getConn();
            r = qr.query(conn, SQLQuery.Purchase.FIND_ALL, resultSetHandler);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

}