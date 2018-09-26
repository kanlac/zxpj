package com.zhuoxun.frame;

import com.zhuoxun.frame.panel.commodity.CommodityPanel;
import com.zhuoxun.frame.panel.controll.ControlPanel;
import com.zhuoxun.frame.panel.purchase.PurchasePanel;
import com.zhuoxun.frame.panel.sale.SalePanel;

import javax.swing.*;

public class Home extends JFrame {
    public Home() {
        this.setTitle("进销存管理 - 主界面");
        this.setBounds(0, 0, 1000, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        appendComponents();

        this.setVisible(true);
    }

    private void appendComponents() {
        // Append tabs
        JTabbedPane pane = new JTabbedPane();
        pane.add(new CommodityPanel(), "商品管理");
        pane.add(new PurchasePanel(), "采购管理"); // constraints -> pane name
        pane.add(new SalePanel(), "销售管理");
        pane.add(new ControlPanel(), "系统控制");
        this.add(pane);
    }

}
