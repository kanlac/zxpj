package com.zhuoxun.frame.internal;

import com.zhuoxun.model.Commodity;
import com.zhuoxun.model.table.CommodityTableModel;
import com.zhuoxun.service.CommodityService;
import com.zhuoxun.service.impl.CommodityServiceImpl;

import javax.swing.*;

import java.util.List;

import static com.zhuoxun.Constants.internalBounds;

public class CommodityOpr extends JInternalFrame {

    private CommodityService commodityService = new CommodityServiceImpl();
    private JTable table;
    private CommodityTableModel commodityTableModel;

    public CommodityOpr() {
        this.setTitle("商品管理");
        this.setBounds(internalBounds);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setClosable(false);
        this.setResizable(false);

        appendComponents();

        this.setVisible(true);
    }

    private void appendComponents() {

        /*** Components ***/

        JButton addBtn = new JButton("新增");
        addBtn.setBounds(20, 10, 100, 30);
        this.add(addBtn);

        JButton delBtn = new JButton("删除");
        delBtn.setBounds(130, 10, 100, 30);
        this.add(delBtn);

        JButton editBtn = new JButton("编辑");
        editBtn.setBounds(240, 10, 100, 30);
        this.add(editBtn);

        // Initialize table model
        List<Commodity> commodities = commodityService.findAll();
        //test
        for (Commodity c : commodities) {
            System.out.println("c = " + c);
        }
        commodityTableModel = new CommodityTableModel(commodities);

        // Initialize table
        table = new JTable();
        table.setModel(commodityTableModel);
        table.setRowHeight(30);
        table.setEnabled(true);

        // Append to UI
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 50, 970, 360);
        scrollPane.getViewport().add(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
        this.getContentPane().add(scrollPane);

        /*** Listeners ***/

        delBtn.addActionListener(e -> {

        });
    }

    private void refreshData() {
        List<Commodity> commodities = commodityService.findAll();
        commodityTableModel.setDataModel(commodities);
        table.setModel(commodityTableModel);
        table.updateUI();
    }
}
