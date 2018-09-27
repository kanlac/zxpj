package com.zhuoxun.service.impl;

import com.zhuoxun.jdbc.MySQLHelper;
import com.zhuoxun.model.Vendor;
import com.zhuoxun.service.VendorService;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("Duplicates")
public class VendorServiceImpl implements VendorService {

    // todo: ref SQLQuery
    private static String sql;
    private static Object[] params;
    private static QueryRunner qr;
    private static Connection conn;

    @Override
    public List<Vendor> findAll() {
        qr = new QueryRunner();
        sql = "SELECT * FROM Vendor";
        List<Vendor> r = null;
        ResultSetHandler<List<Vendor>> resultSetHandler = new BeanListHandler<>(Vendor.class);

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
    public Vendor findByVendorName(String vendorname) {
        qr = new QueryRunner();
        sql = "SELECT * FROM Vendor WHERE username = ?";
        params = new Object[] { vendorname };
        ResultSetHandler<Vendor> resultSetHandler = new BeanHandler<>(Vendor.class);
        Vendor r = null;

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
    public Vendor findById(Integer id){
        qr = new QueryRunner();
        sql = "SELECT * FROM Vendor WHERE vendor_id = ?";
        params = new Object[] { id };
        ResultSetHandler<Vendor> resultSetHandler = new BeanHandler<>(Vendor.class);
        Vendor r = null;

        try{
            conn  = MySQLHelper.getConn();
            r =  qr.query(conn,sql,resultSetHandler,params);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  r;

    }

    @Override
    public boolean append(Vendor v) {
        qr = new QueryRunner();
        sql = "INSERT INTO Vendor (`address`, `postal_code`, `contact`, `email`, `name`,`note`,`mobile`) VALUE (?, ?, ?, ?, ?, ?, ?);";
        params = new Object[] { v.getAddress(),v.getPostal_code(),v.getContact(),v.getEmail(),v.getName(),v.getNote(),v.getMobile() };
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
    public boolean delete(Integer id) {
        qr = new QueryRunner();
        sql = "DELETE FROM Vendor WHERE vendor_id = ?";
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
