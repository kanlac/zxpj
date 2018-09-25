package com.zhuoxun.view;

import com.zhuoxun.view.panel.ControlPanel;
import com.zhuoxun.view.panel.PurchasePanel;

import javax.swing.*;

public class Home extends JFrame {
    public Home() {
        this.setTitle("进销存管理 - 主界面");
        this.setBounds(200, 100, 1000, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appendComponents();
        this.setVisible(true);
    }

    public void appendComponents() {
        // append tabs
        JTabbedPane pane = new JTabbedPane();
        pane.add(new PurchasePanel(), "采购管理"); // constraints -> pane name
        pane.add(new ControlPanel(), "系统控制");
        this.add(pane);
    }

}
