package com.zhuoxun.service;

import com.zhuoxun.model.Vendor;

import java.util.List;

public interface VendorService {

    List<Vendor> findAll();

    Vendor findById(Integer id);

    Vendor findByVendorName(String vendorname);

    boolean add(Vendor v);

    boolean delete(Integer id);

    boolean update(Vendor v);

    List<Vendor> Search(String vendorname);
}
