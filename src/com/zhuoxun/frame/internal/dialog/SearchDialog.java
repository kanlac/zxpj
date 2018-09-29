package com.zhuoxun.frame.internal.dialog;

import com.zhuoxun.model.*;
import com.zhuoxun.model.table.*;
import com.zhuoxun.service.*;
import com.zhuoxun.service.impl.*;

import javax.swing.*;
import java.util.List;

public class SearchDialog extends JFrame {
    private VendorService vendorService = new VendorServiceImpl();
    private JTable table;
    private VendorTableModel vendorTableModel;

    private PurchaseService purchaseService = new PurchaseServiceImpl();
    private PurchaseTableModel purchaseTableModel;

    private ManagerService managerService = new ManagerServiceImpl();
    private ManagerTableModel managerTableModel;

    private CommodityService commodityService = new CommodityServiceImpl();
    private CommodityTableModel commodityTableModel;

    private ClientService clientService = new ClientServiceImpl();
    private ClientTableModel clientTableModel;

    public SearchDialog(String obj,int num) {
        switch (num){
            case 1:
                List<Vendor> list = vendorService.Search(obj);
                if (list == null) {
                    JOptionPane.showMessageDialog(null, "未获取到供应商数据");
                } else {
                    this.setTitle("供应商搜索");
                    this.setBounds(200,200,900,300);
                    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    this.setResizable(false);
                    this.setVisible(true);

                    vendorTableModel = new VendorTableModel(list);
                    table = new JTable();
                    table.setModel(vendorTableModel);
                    table.setRowHeight(30);
                    table.setEnabled(true);

                    JScrollPane scrollPane = new JScrollPane(table);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    scrollPane.setBounds(0, 50, 970, 360);
                    scrollPane.getViewport().add(table);
                    scrollPane.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
                    this.getContentPane().add(scrollPane);
                }
                break;
            case 2:
                List<Purchase> list_2 = purchaseService.Search(obj);
                if (list_2 == null) {
                    JOptionPane.showMessageDialog(null, "未获取到采购订单数据");
                } else {
                    this.setTitle("采购订单搜索");
                    this.setBounds(200,200,900,300);
                    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    this.setResizable(false);
                    this.setVisible(true);

                    purchaseTableModel = new PurchaseTableModel(list_2);
                    table = new JTable();
                    table.setModel(purchaseTableModel);
                    table.setRowHeight(30);
                    table.setEnabled(true);

                    JScrollPane scrollPane = new JScrollPane(table);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    scrollPane.setBounds(0, 50, 970, 360);
                    scrollPane.getViewport().add(table);
                    scrollPane.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
                    this.getContentPane().add(scrollPane);
                }
                break;
            case 3:
                List<Manager> list_3 = managerService.Search(obj);
                if (list_3 == null) {
                    JOptionPane.showMessageDialog(null, "未获取到管理员数据");
                } else {
                    this.setTitle("管理员搜索");
                    this.setBounds(200,200,900,300);
                    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    this.setResizable(false);
                    this.setVisible(true);

                    managerTableModel = new ManagerTableModel(list_3);
                    table = new JTable();
                    table.setModel(managerTableModel);
                    table.setRowHeight(30);
                    table.setEnabled(true);

                    JScrollPane scrollPane = new JScrollPane(table);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    scrollPane.setBounds(0, 50, 970, 360);
                    scrollPane.getViewport().add(table);
                    scrollPane.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
                    this.getContentPane().add(scrollPane);
                }
                break;
            case 4:
                List<Commodity> list_4 = commodityService.Search(obj);
                if (list_4 == null) {
                    JOptionPane.showMessageDialog(null, "未获取到商品数据");
                } else {
                    this.setTitle("商品搜索");
                    this.setBounds(200,200,900,300);
                    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    this.setResizable(false);
                    this.setVisible(true);

                    commodityTableModel = new CommodityTableModel(list_4);
                    table = new JTable();
                    table.setModel(commodityTableModel);
                    table.setRowHeight(30);
                    table.setEnabled(true);

                    JScrollPane scrollPane = new JScrollPane(table);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    scrollPane.setBounds(0, 50, 970, 360);
                    scrollPane.getViewport().add(table);
                    scrollPane.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
                    this.getContentPane().add(scrollPane);
                }
                break;
            case 5:
                List<Client> list_5 = clientService.Search(obj);
                if (list_5 == null) {
                    JOptionPane.showMessageDialog(null, "未获取到客户数据");
                } else {
                    this.setTitle("客户搜索");
                    this.setBounds(200,200,900,300);
                    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    this.setResizable(false);
                    this.setVisible(true);

                    clientTableModel = new ClientTableModel(list_5);
                    table = new JTable();
                    table.setModel(clientTableModel);
                    table.setRowHeight(30);
                    table.setEnabled(true);

                    JScrollPane scrollPane = new JScrollPane(table);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    scrollPane.setBounds(0, 50, 970, 360);
                    scrollPane.getViewport().add(table);
                    scrollPane.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
                    this.getContentPane().add(scrollPane);
                }
                break;
            default:break;
        }
    }
}
