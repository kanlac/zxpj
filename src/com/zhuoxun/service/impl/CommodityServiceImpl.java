package com.zhuoxun.service.impl;

import com.zhuoxun.model.Commodity;
import com.zhuoxun.service.CommodityService;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.util.List;

@SuppressWarnings("Duplicates")
public class CommodityServiceImpl implements CommodityService {
    private static String sql;
    private static Object[] params;
    private static QueryRunner qr;
    private static Connection conn;

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
        return null;
    }

    @Override
    public Commodity findById(int id) {
        return null;
    }
}
