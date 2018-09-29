package com.zhuoxun.service;

import com.zhuoxun.model.Purchase;

import java.util.List;

public interface PurchaseService {

    boolean save(Purchase p);

    boolean delete(int id);

    boolean update(Purchase p);

    List<Purchase> findAll();

    List<Purchase> Search(String purchasename);
}
