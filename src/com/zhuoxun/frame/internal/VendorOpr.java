package com.zhuoxun.frame.internal;

import com.zhuoxun.model.Vendor;
import com.zhuoxun.model.table.VendorTableModel;
import com.zhuoxun.service.VendorService;
import com.zhuoxun.service.impl.VendorServiceImpl;

import javax.swing.*;

import java.util.List;

import static com.zhuoxun.Constants.internalBounds;

public class VendorOpr extends JInternalFrame {

    private VendorService vendorService = new VendorServiceImpl();
    private JTable table;
    private VendorTableModel vendorTableModel;

    public VendorOpr() {
        this.setTitle("供应商管理");
        this.setBounds(internalBounds);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setClosable(false);
        this.setResizable(false);

        appendComponents();

        this.setVisible(true);
    }

    private void appendComponents() {

        /*** Components ***/

        JButton refreshBtn = new JButton("刷新");
        refreshBtn.setBounds(20, 10, 100, 30);
        this.add(refreshBtn);

        JButton addBtn = new JButton("添加");
        addBtn.setBounds(130, 10, 100, 30);
        this.add(addBtn);

        JButton delBtn = new JButton("删除");
        delBtn.setBounds(240, 10, 100, 30);
        this.add(delBtn);

        JButton editBtn = new JButton("编辑");
        editBtn.setBounds(350, 10, 100, 30);
        this.add(editBtn);

        List<Vendor> vendors = vendorService.findAll();
        if (vendors == null) {
            JOptionPane.showMessageDialog(null, "未获取到供应商数据");
        } else {
            // Initialize table model
            vendorTableModel = new VendorTableModel(vendors);

            // Initialize table
            table = new JTable();
            table.setModel(vendorTableModel);
            table.setRowHeight(30);
            table.setEnabled(true);

            // Append to UI
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setBounds(0, 50, 970, 360);
            scrollPane.getViewport().add(table);
            scrollPane.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
            this.getContentPane().add(scrollPane);
        }
    }

    private void refreshData() {
        List<Vendor> commodities = vendorService.findAll();
        vendorTableModel.setDataModel(commodities);
        table.setModel(vendorTableModel);
        table.updateUI();
    }

}
