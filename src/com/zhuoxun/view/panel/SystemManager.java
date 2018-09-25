package com.zhuoxun.view.panel;

import com.zhuoxun.view.OperatorManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class SystemManager extends JPanel {
    public SystemManager() {
        this.setLayout(null);
        appendComponent();
    }

    public void appendComponent() {

        /*** Components ***/

        JButton operateBtn = new JButton("操作员管理");
        operateBtn.setBounds(20, 20, 100, 30);
        this.add(operateBtn);

        JButton changePasswordBtn = new JButton("更改密码");
        changePasswordBtn.setBounds(130, 20, 100, 30);
        this.add(changePasswordBtn);

        JButton exitBtn = new JButton("退出系统");
        exitBtn.setBounds(240, 20, 100, 30);
        this.add(exitBtn);

        // todo: background image


        SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JLabel timeLabel = new JLabel("登录时间：" + datef.format(System.currentTimeMillis()));
        timeLabel.setBounds(0, 510, 1000, 30);
        this.add(timeLabel);

        /*** Listeners ***/

        operateBtn.addActionListener(e -> {
            OperatorManager operatorManager = new OperatorManager();
        });

        changePasswordBtn.addActionListener(e -> {
            // todo: display panel
        });

        exitBtn.addActionListener(e -> System.exit(-1));

    }
}
