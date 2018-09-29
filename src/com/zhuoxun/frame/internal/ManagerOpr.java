package com.zhuoxun.frame.internal;

import com.zhuoxun.Constants;
import com.zhuoxun.frame.internal.dialog.SearchDialog;
import com.zhuoxun.frame.internal.dialog.manager.ChangePasswordDialog;
import com.zhuoxun.frame.internal.dialog.manager.NewManagerDialog;
import com.zhuoxun.model.Manager;
import com.zhuoxun.model.table.ManagerTableModel;
import com.zhuoxun.service.ManagerService;
import com.zhuoxun.service.impl.ManagerServiceImpl;

import javax.swing.*;
import java.util.List;

public class ManagerOpr extends JInternalFrame {

    private ManagerService service = new ManagerServiceImpl();
    private JTable table;
    private ManagerTableModel tableModel;

    public ManagerOpr() {
        this.setTitle("管理员管理");
        this.setBounds(Constants.internalBounds);
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

        JButton newManagerBtn = new JButton("添加");
        newManagerBtn.setBounds(130, 10, 100, 30);
        this.add(newManagerBtn);

        JButton revokeManagerBtn = new JButton("删除");
        revokeManagerBtn.setBounds(240, 10, 100, 30);
        this.add(revokeManagerBtn);

        JButton changePwBtn = new JButton("更改密码");
        changePwBtn.setBounds(350, 10, 100, 30);
        this.add(changePwBtn);

        JTextField searchTxet = new JTextField("请输入名称");
        searchTxet.setBounds(520,10,160,30);
        this.add(searchTxet);

        JButton searchBtn = new JButton("搜索");
        searchBtn.setBounds(690,10,100,30);
        this.add(searchBtn);

        // Initialize table model
        List<Manager> managers = service.findAll();
        tableModel = new ManagerTableModel(managers);

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

        /*** Listeners ***/

        searchBtn.addActionListener(e -> {
            new SearchDialog(searchTxet.getText(),3);
        });

        refreshBtn.addActionListener(e -> refreshData());

        newManagerBtn.addActionListener(e -> new NewManagerDialog());

        changePwBtn.addActionListener(e -> {
            new ChangePasswordDialog();
        });

        revokeManagerBtn.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null, "确认删除？", "管理员删除", JOptionPane.YES_OPTION);
            if (result == 0) {
                // check row number legitimacy
                int r = table.getSelectedRow();
                if (r < 0 || r >= service.findAll().size()) {
                    JOptionPane.showMessageDialog(null, "请选择要删除的数据！");
                } else {
                    // confirm deletion
                    Manager m = tableModel.getObjectByRow(r);
                    if (service.revoke(m.getManager_id())) {
                        JOptionPane.showMessageDialog(null,"删除成功！");
                        refreshData();
                    } else {
                        System.err.println("删除管理员错误");
                    }
                }
            }
        });

    }

    private void refreshData() {
        List<Manager> managers = service.findAll();
        tableModel.setDataModel(managers);
        table.setModel(tableModel);
        table.updateUI();
    }
}
