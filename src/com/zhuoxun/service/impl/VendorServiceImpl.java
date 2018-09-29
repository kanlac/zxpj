package com.zhuoxun.service.impl;

import com.zhuoxun.jdbc.MySQLHelper;
import com.zhuoxun.jdbc.SQLQuery;
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

    private Object[] params;
    private QueryRunner qr = new QueryRunner();
    private Connection conn;

    @Override
    public List<Vendor> findAll() {
        List<Vendor> r = null;
        ResultSetHandler<List<Vendor>> resultSetHandler = new BeanListHandler<>(Vendor.class);

        try {
            conn = MySQLHelper.getConn();
            r = qr.query(conn, SQLQuery.Vendor.FIND_ALL, resultSetHandler);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return r;
    }

    @Override
    public Vendor findByVendorName(String vendorname) {
        params = new Object[] { vendorname };
        ResultSetHandler<Vendor> resultSetHandler = new BeanHandler<>(Vendor.class);
        Vendor r = null;

        try {
            conn = MySQLHelper.getConn();
            r = qr.query(conn, SQLQuery.Vendor.FIND_BY_NAME, resultSetHandler, params);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return r;
    }

    @Override
    public Vendor findById(Integer id) {
        params = new Object[] { id };
        ResultSetHandler<Vendor> resultSetHandler = new BeanHandler<>(Vendor.class);
        Vendor r = null;

        try{
            conn  = MySQLHelper.getConn();
            r =  qr.query(conn,SQLQuery.Vendor.FIND_BY_ID,resultSetHandler,params);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  r;

    }

    @Override
    public boolean add(Vendor v) {
        params = new Object[] { v.getAddress(), v.getPostal_code(), v.getMobile(), v.getEmail(), v.getName(), v.getNote() };
        int rows = 0;

        try {
            conn = MySQLHelper.getConn();
            rows = qr.update(conn, SQLQuery.Vendor.INSERT, params);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows != 0;
    }


    @Override
    public boolean delete(Integer id) {
        int rows = 0;

        try {
            conn = MySQLHelper.getConn();
            rows = qr.update(conn, SQLQuery.Vendor.DELETE, id);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows != 0;
    }

    @Override
    public boolean update(Vendor v) {
        params = new Object[] { v.getAddress(),v.getPostal_code(),v.getEmail(),v.getName(),v.getNote(), v.getMobile(), v.getVendor_id()};
        int rows = 0;

        try {
            conn = MySQLHelper.getConn();
            rows = qr.update(conn, SQLQuery.Vendor.UPDATE, params);
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows != 0;
    }

    @Override
    public List<Vendor> Search(String vendorname) {
        qr = new QueryRunner();
        List<Vendor> r = null;
        ResultSetHandler<List<Vendor>> resultSetHandler = new BeanListHandler<>(Vendor.class);

        try {
            conn = MySQLHelper.getConn();
            r = qr.query(conn, SQLQuery.Vendor.SEARCH, resultSetHandler,"%"+vendorname+"%");
            MySQLHelper.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return r;
    }
}
