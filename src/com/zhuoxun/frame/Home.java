package com.zhuoxun.frame;

import com.zhuoxun.frame.internal.CommodityOpr;
import com.zhuoxun.frame.internal.ManagerOpr;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Home extends JFrame implements ActionListener {
    JDesktopPane desktop;

    public Home() {
        this.setTitle("进销存管理");
        this.setBounds(0, 0, 600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // center

        desktop = new JDesktopPane(); //a specialized layered pane
        //createDefaultInternalFrame();

        setContentPane(desktop);
        setJMenuBar(createMenuBar());
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        /** 1. 系统 **/

        JMenu systemMenu = new JMenu("系统");
        systemMenu.setMnemonic(KeyEvent.VK_D); // test
        menuBar.add(systemMenu);

        JMenuItem exitItem = new JMenuItem("关闭程序");
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.SHIFT_MASK));
        exitItem.setActionCommand("quit");
        exitItem.addActionListener(this);

        systemMenu.add(exitItem);

        /** 2. 管理项 **/

        JMenu manageMenu = new JMenu("管理项");
        menuBar.add(manageMenu);

        /** 2.1 商品管理 **/

        JMenuItem commodityItem = new JMenuItem("商品管理");
        commodityItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.SHIFT_MASK));
        commodityItem.setActionCommand("displayCommodityOpr");
        commodityItem.addActionListener(this);

        manageMenu.add(commodityItem);

        /** 2.2 采购管理 **/

        JMenu purchaseSubMenu = new JMenu("采购管理");

        /** 2.2.1 **/
        JMenuItem vendorItem = new JMenuItem("供应商");
        vendorItem.setActionCommand("vendorOpr");
        vendorItem.addActionListener(this);
        purchaseSubMenu.add(vendorItem);

        /** 2.2.2 **/
        JMenuItem purchaseItem = new JMenuItem("采购订单");
        purchaseItem.setActionCommand("purchaseOpr");
        purchaseItem.addActionListener(this);
        purchaseSubMenu.add(purchaseItem);

        manageMenu.add(purchaseSubMenu);

        /** 2.3 销售管理 **/

        JMenu saleSubMenu = new JMenu("销售管理");

        /** 2.3.1 **/
        JMenuItem saleItem = new JMenuItem("销售订单");
        saleItem.setActionCommand("saleOpr");
        saleItem.addActionListener(this);
        saleSubMenu.add(saleItem);

        /** 2.3.2 **/
        JMenuItem clientItem = new JMenuItem("客户管理");
        clientItem.setActionCommand("clientOpr");
        clientItem.addActionListener(this);
        saleSubMenu.add(clientItem);

        manageMenu.add(saleSubMenu);

        /** 2.4 管理员管理 **/

        JMenuItem managerItem = new JMenuItem("管理员管理");
        managerItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.SHIFT_MASK));
        managerItem.setActionCommand("displayManagerOpr");
        managerItem.addActionListener(this);

        manageMenu.add(managerItem);


        return menuBar;
    }

    private void createDefaultInternalFrame() {
        // set default frame to ManagerOpr
        ManagerOpr defaultFrame = new ManagerOpr();
        defaultFrame.setVisible(true);
        desktop.add(defaultFrame);

        // ??
        try {
            defaultFrame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    /*** Actions ***/

    protected void quit() {
        System.exit(0);
    }

    protected void displayCommodityOpr() {
        desktop.removeAll();

        CommodityOpr commodityOpr = new CommodityOpr();
        commodityOpr.setVisible(true);
        desktop.add(commodityOpr);

        try {
            commodityOpr.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    protected void displayManagerOpr() {
        desktop.removeAll();

        ManagerOpr managerOpr = new ManagerOpr();
        managerOpr.setVisible(true);
        desktop.add(managerOpr);

        // ??
        try {
            managerOpr.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    /*** Override Listener ***/

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("quit".equals(e.getActionCommand())) {
            quit();
        } else if ("displayManagerOpr".equals(e.getActionCommand())) {
            displayManagerOpr();
        } else if ("displayCommodityOpr".equals(e.getActionCommand())) {
            displayCommodityOpr();
        } else {
            System.err.println("Unhandled ActionEvent: " + e.getActionCommand());
        }
    }
}
