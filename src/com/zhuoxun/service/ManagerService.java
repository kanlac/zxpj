package com.zhuoxun.service;

import com.zhuoxun.model.Manager;

import java.util.List;

public interface ManagerService {

    List<Manager> findAll();

    Manager findByUsername(String username);

    boolean add(Manager m);

    boolean revoke(int id);

    List<Manager> Search(String managername);
}
