package com.zhuoxun.service;

import com.zhuoxun.model.Client;

import java.util.List;

public interface ClientService {

    boolean add(Client client);

    boolean update(Client client);

    boolean delete(int id);
    
    List<Client> findAll();

    Client findById (int id);
}
