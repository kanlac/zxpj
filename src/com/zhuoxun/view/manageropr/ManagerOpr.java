package com.zhuoxun.view.manageropr;

import com.zhuoxun.model.Manager;
import com.zhuoxun.model.ManagerTableModel;
import com.zhuoxun.service.ManagerService;
import com.zhuoxun.service.impl.ManagerServiceImpl;

import javax.swing.*;
import java.util.List;

public class ManagerOpr extends JInternalFrame {

    ManagerService managerService = new ManagerServiceImpl();
    JTable table;
    ManagerTableModel managerTableModel;

    public ManagerOpr() {
        this.setTitle("管理员管理");
        this.setBounds(0, 50, 800, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setClosable(true);
        this.setResizable(false);

        appendComponent();

        this.setVisible(true);
    }

    private void appendComponent() {

        // Initialize table
        List<Manager> managerList = managerService.findAll();
        table = new JTable();
        managerTableModel = new ManagerTableModel(managerList);
        table.setModel(managerTableModel);
        table.setRowHeight(30);
        table.setEnabled(true);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 80, 970, 360);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getViewport().add(table);
        this.getContentPane().add(scrollPane);

    }
}
