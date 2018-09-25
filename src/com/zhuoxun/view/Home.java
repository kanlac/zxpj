package com.zhuoxun.view;

import com.zhuoxun.view.panel.PurchaseManager;
import com.zhuoxun.view.panel.SystemManager;

import javax.swing.*;

public class Home extends JFrame {
    public Home() {
        this.setTitle("进销存管理主界面");
        this.setBounds(200, 100, 1000, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appendComponents();
        this.setVisible(true);
    }

    public void appendComponents() {
        // append tabs
        JTabbedPane pane = new JTabbedPane();
        pane.add(new PurchaseManager(), "采购管理"); // constraints -> pane name
        pane.add(new SystemManager(), "系统管理");
        this.add(pane);
    }

}
