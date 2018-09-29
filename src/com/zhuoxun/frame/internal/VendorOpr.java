package com.zhuoxun.frame.internal;

import com.zhuoxun.frame.internal.dialog.vendor.AddVendorDialog;
import com.zhuoxun.frame.internal.dialog.vendor.EditVendorDialog;
import com.zhuoxun.model.Vendor;
import com.zhuoxun.model.table.VendorTableModel;
import com.zhuoxun.service.VendorService;
import com.zhuoxun.service.impl.VendorServiceImpl;

import javax.swing.*;

import java.util.List;

import static com.zhuoxun.Constants.internalBounds;

public class VendorOpr extends JInternalFrame {

    private VendorService service = new VendorServiceImpl();
    private JTable table;
    private VendorTableModel tableModel;

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

        List<Vendor> vendors = service.findAll();
        if (vendors == null ||vendors.size() == 0) {
            JOptionPane.showMessageDialog(null, "未获取到供应商数据");
        } else {
            // Initialize table model
            tableModel = new VendorTableModel(vendors);

            // Initialize table
            table = new JTable();
            table.setModel(tableModel);
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

        /*** Listeners ***/

        refreshBtn.addActionListener(e -> refreshData());

        addBtn.addActionListener(e -> new AddVendorDialog());

        delBtn.addActionListener(e -> {

            int result = JOptionPane.showConfirmDialog(null, "确认删除？", "供应商删除", JOptionPane.YES_OPTION);
            if (result == 0) {
                // check row number legitimacy
                int r = table.getSelectedRow();
                if (r < 0 || r >= service.findAll().size()) {
                    JOptionPane.showMessageDialog(null, "请选择要删除的数据！");
                } else {
                    // confirm deletion
                    Vendor v = tableModel.getObjectByRow(r);
                    if (service.delete(v.getVendor_id())) {
                        JOptionPane.showMessageDialog(null,"删除成功！");
                        refreshData();
                    } else {
                        System.err.println("删除供应商错误");
                    }
                }

            }
        });

        editBtn.addActionListener(e -> {
            int r = table.getSelectedRow();
            if (r < 0) {
                JOptionPane.showMessageDialog(null, "请选择要编辑的供应商！");
            } else {
                Vendor v = tableModel.getObjectByRow(r);
                new EditVendorDialog(v);
            }
        });
    }

    private void refreshData() {
        List<Vendor> commodities = service.findAll();
        tableModel.setDataModel(commodities);
        table.setModel(tableModel);
        table.updateUI();
    }

}
