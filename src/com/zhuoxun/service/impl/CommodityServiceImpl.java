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
        return false;
    }

    @Override
    public boolean update(Commodity c) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Commodity> findAll() {
        List<Commodity> r = null;
        ResultSetHandler<List<Commodity>> resultSetHandler = new BeanListHandler<>(Commodity.class);

        try {
            conn = MySQLHelper.getConn();
            r = qr.query(conn, SQLQuery.Commodity.FINDALL, resultSetHandler);
            // test
            if (r == null) System.out.println("is null");
            else System.out.println("not null");
            for (Commodity c : r) {
                System.out.println("c = " + c);
            }
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
}
