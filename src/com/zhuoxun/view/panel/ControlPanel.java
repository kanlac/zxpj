package com.zhuoxun.view.panel;

import com.zhuoxun.view.manageropr.ManagerOpr;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class ControlPanel extends JPanel {

    private ManagerOpr managerOpr = null;

    public ControlPanel() {
        this.setLayout(null);
        appendComponent();
    }

    private void appendComponent() {

        /*** Components ***/

        JButton operateBtn = new JButton("管理员管理");
        operateBtn.setBounds(20, 10, 100, 30);
        this.add(operateBtn);

        JButton changePasswordBtn = new JButton("更改密码");
        changePasswordBtn.setBounds(130, 10, 100, 30);
        this.add(changePasswordBtn);

        JButton exitBtn = new JButton("退出系统");
        exitBtn.setBounds(240, 10, 100, 30);
        this.add(exitBtn);

        // todo: background image


        SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JLabel timeLabel = new JLabel("登录时间：" + datef.format(System.currentTimeMillis()));
        timeLabel.setBounds(0, 510, 1000, 30);
        this.add(timeLabel);

        /*** Listeners ***/

        operateBtn.addActionListener(e -> {
            if (managerOpr == null) {
                managerOpr = new ManagerOpr();
                ControlPanel.this.add(managerOpr);
            }
        });

        changePasswordBtn.addActionListener(e -> {
            // todo: display panel
        });

        exitBtn.addActionListener(e -> System.exit(-1));

    }
}
