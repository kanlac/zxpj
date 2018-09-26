package com.zhuoxun.frame.panel.commodity;

import com.zhuoxun.service.CommodityService;
import com.zhuoxun.service.impl.CommodityServiceImpl;

import javax.swing.*;

public class CommodityPanel extends JPanel {

    private CommodityService commodityService = new CommodityServiceImpl();

    public CommodityPanel() {
        this.setLayout(null);
        appendComponents();
    }

    private void appendComponents() {

        /*** Components ***/

        JButton addBtn = new JButton("新增");
        addBtn.setBounds(10, 10, 80, 30);
        this.add(addBtn);

        JButton delBtn = new JButton("删除");
        delBtn.setBounds(100, 10, 80, 30);
        this.add(delBtn);

        JButton editBtn = new JButton("编辑");
        editBtn.setBounds(190, 10, 80, 30);
        this.add(editBtn);

        // todo: Initialize table model

    }
}
