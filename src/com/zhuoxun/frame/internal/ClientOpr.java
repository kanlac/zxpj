package com.zhuoxun.frame.internal;

import com.zhuoxun.Constants;
import com.zhuoxun.frame.internal.dialog.client.NewClientDialog;
import com.zhuoxun.model.Client;
import com.zhuoxun.model.table.ClientTableModel;
import com.zhuoxun.service.ClientService;
import com.zhuoxun.service.impl.ClientServiceImpl;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.util.List;

public class ClientOpr extends JInternalFrame {

    private ClientService service = new ClientServiceImpl();
    private JTable table;
    private ClientTableModel tableModel;

    public ClientOpr() {
        this.setTitle("客户管理");
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

        JButton newClientBtn = new JButton("添加");
        newClientBtn.setBounds(130, 10, 100, 30);
        this.add(newClientBtn);

        JButton revokeClientBtn = new JButton("删除");
        revokeClientBtn.setBounds(240, 10, 100, 30);
        this.add(revokeClientBtn);

        JButton changePwBtn = new JButton("更改密码");
        changePwBtn.setBounds(350, 10, 100, 30);
        this.add(changePwBtn);

        JButton nullBtn = new JButton("");
        nullBtn.setVisible(false);
        this.add(nullBtn);

        List<Client> clients = service.findAll();
        if (clients == null || clients.size() == 0) {
            JOptionPane.showMessageDialog(null, "未获取到客户数据");
        } else {
            // Initialize table model
            tableModel = new ClientTableModel(clients);

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

        newClientBtn.addActionListener(e -> new NewClientDialog());

        revokeClientBtn.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null, "确认删除？", "客户删除", JOptionPane.YES_OPTION);
            if (result == 0) {
                // confirm deletion
                int r = table.getSelectedRow();
                if (r < 0) {
                    JOptionPane.showMessageDialog(null, "请选择要删除的数据！");
                } else {
                    Client m = tableModel.getObjectByRow(r);
                    if (service.delete(m.getClient_id())) {
                        JOptionPane.showMessageDialog(null,"删除成功！");
                        refreshData();
                    } else {
                        System.err.println("删除客户错误");
                    }
                }

            }
        });

    }

    private void refreshData() {
        List<Client> Clients = service.findAll();
        tableModel.setDataModel(Clients);
        table.setModel(tableModel);
        table.updateUI();
    }
}
