package com.zhuoxun.service;

import com.zhuoxun.model.Commodity;

import java.util.List;

public interface CommodityService {

    boolean save(Commodity c);

    boolean update(Commodity c);

    boolean delete(int id);

    List<Commodity> findAll();

    Commodity findById(int id);

    List<Commodity> Search(String commodityname);
}
