package com.zhuoxun.frame.internal;

import com.zhuoxun.frame.internal.dialog.commodity.AddCommodityDialog;
import com.zhuoxun.frame.internal.dialog.commodity.EditCommodityDialog;
import com.zhuoxun.model.Commodity;
import com.zhuoxun.model.table.CommodityTableModel;
import com.zhuoxun.service.CommodityService;
import com.zhuoxun.service.impl.CommodityServiceImpl;

import javax.swing.*;

import java.util.List;

import static com.zhuoxun.Constants.internalBounds;

public class CommodityOpr extends JInternalFrame {

    private CommodityService service = new CommodityServiceImpl();
    private JTable table;
    private CommodityTableModel tableModel;

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

        List<Commodity> commodities = service.findAll();
        if (commodities == null) {
            JOptionPane.showMessageDialog(null, "未获取到商品数据");
        } else {
            // Initialize table model
            tableModel = new CommodityTableModel(commodities);

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

        addBtn.addActionListener(e -> new AddCommodityDialog());

        delBtn.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null, "确认删除？", "商品删除", JOptionPane.YES_OPTION);
            if (result == 0) {
                // check row number legitimacy
                int r = table.getSelectedRow();
                if (r < 0 || r >= service.findAll().size()) {
                    JOptionPane.showMessageDialog(null, "请选择要删除的数据！");
                } else {
                    // confirm deletion
                    Commodity m = tableModel.getObjectByRow(r);
                    if (service.delete(m.getCommodity_id())) {
                        JOptionPane.showMessageDialog(null,"删除成功！");
                        refreshData();
                    } else {
                        System.err.println("删除商品错误");
                    }
                }

            }
        });

        editBtn.addActionListener(e -> {
            int r = table.getSelectedRow();
            if (r < 0) {
                JOptionPane.showMessageDialog(null, "请选择要编辑的商品！");
            } else {
                Commodity m = tableModel.getObjectByRow(r);
                new EditCommodityDialog(m);
            }
        });
    }

    private void refreshData() {
        List<Commodity> commodities = service.findAll();
        tableModel.setDataModel(commodities);
        table.setModel(tableModel);
        table.updateUI();
    }
}
