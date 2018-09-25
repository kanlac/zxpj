package com.zhuoxun.view.subview;

import javax.swing.*;

public class ManagerOpr extends JInternalFrame {
    public ManagerOpr() {
        this.setTitle("管理员管理");
        this.setBounds(0, 50, 800, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setClosable(true);
        this.setResizable(false);

        appendComponent();

        this.setVisible(true);
    }

    private void appendComponent() {
        JButton operateBtn = new JButton("aaa");
        operateBtn.setBounds(20, 20, 100, 30);
        this.add(operateBtn);
    }
}
