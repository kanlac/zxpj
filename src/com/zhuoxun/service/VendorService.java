package com.zhuoxun.service;

import com.zhuoxun.model.Vendor;

import java.util.List;

public interface VendorService {

    List<Vendor> findAll();

    Vendor findById(Integer id);

    Vendor findByVendorName(String vendorname);

    boolean append(Vendor v);

    boolean delete(Integer id);
}
