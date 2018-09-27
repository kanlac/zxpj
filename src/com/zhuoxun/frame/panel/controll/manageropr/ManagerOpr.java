package com.zhuoxun.frame.panel.controll.manageropr;

import com.zhuoxun.model.Manager;
import com.zhuoxun.model.table.ManagerTableModel;
import com.zhuoxun.service.ManagerService;
import com.zhuoxun.service.impl.ManagerServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ManagerOpr extends JInternalFrame {

    private ManagerService managerService = new ManagerServiceImpl();
    private JTable table;
    private ManagerTableModel managerTableModel;

    public ManagerOpr() {
        this.setTitle("管理员管理");
        this.setBounds(0, 50, 950, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setClosable(false);
        this.setResizable(false);

        appendComponent();

        this.setVisible(true);
    }

    private void appendComponent() {

        /*** Components ***/

        JButton refreshBtn = new JButton("刷新");
        refreshBtn.setBounds(20, 10, 100, 30);
        this.add(refreshBtn);

        JButton newManagerBtn = new JButton("添加");
        newManagerBtn.setBounds(130, 10, 100, 30);
        this.add(newManagerBtn);

        JButton revokeManagerBtn = new JButton("删除");
        revokeManagerBtn.setBounds(240, 10, 100, 30);
        this.add(revokeManagerBtn);

        JButton changePwBtn = new JButton("更改密码");
        changePwBtn.setBounds(350, 10, 100, 30);
        this.add(changePwBtn);

        // Initialize table model
        List<Manager> managerList = managerService.findAll();
        managerTableModel = new ManagerTableModel(managerList);

        // Initialize table
        table = new JTable();
        table.setModel(managerTableModel);
        table.setRowHeight(30);
        table.setEnabled(true);

        // Append to UI
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 50, 970, 360);
        scrollPane.getViewport().add(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
        this.getContentPane().add(scrollPane);

        /*** Listeners ***/

        refreshBtn.addActionListener(e -> refreshData());

        newManagerBtn.addActionListener(e -> new NewManagerDialog());

        revokeManagerBtn.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null, "确认删除？", "管理员删除", JOptionPane.YES_OPTION);
            if (result == 0) {
                // confirm deletion
                int r = table.getSelectedRow();
                if (r < 0) {
                    JOptionPane.showMessageDialog(null, "请选择要删除的数据！");
                } else {
                    Manager m = managerTableModel.getObjectByRow(r);
                    if (managerService.revoke(m.getManager_id())) {
                        JOptionPane.showMessageDialog(null,"删除成功！");
                        refreshData();
                    } else {
                        System.err.println("删除管理员错误");
                    }
                }

            }
        });

    }

    public void refreshData() {
        List<Manager> managerList = managerService.findAll();
        managerTableModel.setDataModel(managerList);
        table.setModel(managerTableModel);
        table.updateUI();
    }
}
