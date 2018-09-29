package com.zhuoxun.frame;

import com.zhuoxun.frame.desktop.MyJDesktop;
import com.zhuoxun.frame.internal.CommodityOpr;
import com.zhuoxun.frame.internal.ManagerOpr;
import com.zhuoxun.frame.internal.PurchaseOpr;
import com.zhuoxun.frame.internal.VendorOpr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Home extends JFrame implements ActionListener {
    JDesktopPane desktop;

    public Home() {
        this.setTitle("进销存管理");
        this.setBounds(0, 0, 800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // center
        this.setResizable(false);

        // test
        desktop = new MyJDesktop();

//        desktop = new JDesktopPane(); //a specialized layered pane
        //createDefaultInternalFrame();



        this.setContentPane(desktop);
        this.setJMenuBar(createMenuBar());
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        /** 1. 系统 **/

        JMenu systemMenu = new JMenu("系统");
        systemMenu.setMnemonic(KeyEvent.VK_D); // test
        menuBar.add(systemMenu);

        /** 1.1 **/

        JMenuItem newWindowItem = new JMenuItem("新窗口");
        newWindowItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.SHIFT_MASK));
        newWindowItem.setActionCommand("newWindow");
        newWindowItem.addActionListener(this);

        systemMenu.add(newWindowItem);

        /** 1.2 **/

        JMenuItem closeWindowsItem = new JMenuItem("关闭此窗口");
        closeWindowsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.SHIFT_MASK));
        closeWindowsItem.setActionCommand("closeWindow");
        closeWindowsItem.addActionListener(this);

        systemMenu.add(closeWindowsItem);

        /** 1.3 **/

        JMenuItem exitItem = new JMenuItem("退出系统");
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
        vendorItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.SHIFT_MASK));
        vendorItem.setActionCommand("displayVendorOpr");
        vendorItem.addActionListener(this);
        purchaseSubMenu.add(vendorItem);

        /** 2.2.2 **/
        JMenuItem purchaseItem = new JMenuItem("采购订单");
        purchaseItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.SHIFT_MASK));
        purchaseItem.setActionCommand("displayPurchaseOpr");
        purchaseItem.addActionListener(this);
        purchaseSubMenu.add(purchaseItem);

        manageMenu.add(purchaseSubMenu);

        /** 2.3 销售管理 **/

        JMenu saleSubMenu = new JMenu("销售管理");

        /** 2.3.1 **/
        JMenuItem saleItem = new JMenuItem("销售订单");
        saleItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.SHIFT_MASK));
        saleItem.setActionCommand("displaySaleOpr");
        saleItem.addActionListener(this);
        saleSubMenu.add(saleItem);

        /** 2.3.2 **/
        JMenuItem clientItem = new JMenuItem("客户管理");
        clientItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.SHIFT_MASK));
        clientItem.setActionCommand("displayClientOpr");
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

    public static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        Home frame = new Home();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    /*** Actions ***/

    protected void quit() {
        System.exit(0);
    }

    protected void newWindow() {
        javax.swing.SwingUtilities.invokeLater((new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        }));
    }

    protected void closeWindow() {
        Home.this.dispose();
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

    protected void displayVendorOpr() {
        desktop.removeAll();

        VendorOpr vendorOpr = new VendorOpr();
        vendorOpr.setVisible(true);
        desktop.add(vendorOpr);

        try {
            vendorOpr.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    protected void displayPurchaseOpr() {
        desktop.removeAll();

        PurchaseOpr purchaseOpr = new PurchaseOpr();
        purchaseOpr.setVisible(true);
        desktop.add(purchaseOpr);

        try {
            purchaseOpr.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    protected void displayClientOpr() {

    }

    protected void displaySaleOpr() {

    }

    /*** Listener ***/

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("quit".equals(e.getActionCommand())) {
            quit();
        } else if ("displayManagerOpr".equals(e.getActionCommand())) {
            displayManagerOpr();
        } else if ("displayCommodityOpr".equals(e.getActionCommand())) {
            displayCommodityOpr();
        } else if ("displayVendorOpr".equals(e.getActionCommand())) {
            displayVendorOpr();
        } else if ("displayPurchaseOpr".equals(e.getActionCommand())) {
            displayPurchaseOpr();
        } else if ("displayClientOpr".equals(e.getActionCommand())) {
            displayClientOpr();
        } else if ("displaySaleOpr".equals(e.getActionCommand())) {
            displaySaleOpr();
        } else if ("newWindow".equals(e.getActionCommand())) {
            newWindow();
        } else if ("closeWindow".equals(e.getActionCommand())) {
            closeWindow();
        } else {
            System.err.println("Unhandled ActionEvent: " + e.getActionCommand());
        }
    }
}
