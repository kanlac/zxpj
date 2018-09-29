package com.zhuoxun.frame.internal;

import com.zhuoxun.frame.internal.dialog.SearchDialog;
import com.zhuoxun.frame.internal.dialog.purchase.AddPurchaseDialog;
import com.zhuoxun.model.Purchase;
import com.zhuoxun.model.table.PurchaseTableModel;
import com.zhuoxun.service.PurchaseService;
import com.zhuoxun.service.impl.PurchaseServiceImpl;

import javax.swing.*;

import java.util.List;

import static com.zhuoxun.Constants.internalBounds;

public class PurchaseOpr extends JInternalFrame {

    private PurchaseService service = new PurchaseServiceImpl();
    private JTable table;
    private PurchaseTableModel tableModel;

    public PurchaseOpr() {
        this.setTitle("采购订单管理");
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

        JButton nullBtn = new JButton("");
        nullBtn.setVisible(false);
        this.add(nullBtn);

        List<Purchase> purchases = service.findAll();
        if (purchases == null || purchases.size() == 0) {
            JOptionPane.showMessageDialog(null, "未获取到采购订单数据");
        } else {
            // Initialize table model
            tableModel = new PurchaseTableModel(purchases);

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

        addBtn.addActionListener(e -> new AddPurchaseDialog());
    }

    private void refreshData() {
        List<Purchase> purchases = service.findAll();
        tableModel.setDataModel(purchases);
        table.setModel(tableModel);
        table.updateUI();
    }
}
