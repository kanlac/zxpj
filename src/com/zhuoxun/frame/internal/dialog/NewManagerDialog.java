package com.zhuoxun.frame.internal.dialog;

import com.zhuoxun.frame.internal.ManagerOpr;
import com.zhuoxun.model.Manager;
import com.zhuoxun.service.ManagerService;
import com.zhuoxun.service.impl.ManagerServiceImpl;

import javax.swing.*;

public class NewManagerDialog extends JFrame {

    private ManagerService managerService = new ManagerServiceImpl();

    public NewManagerDialog() {
        this.setTitle("添加管理员");
        this.setBounds(400, 200, 700, 350);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        appendComponents();

        this.setVisible(true);
    }

    private void appendComponents() {

        /*** Components ***/

        JLabel usernameLabel = new JLabel("用户名");
        usernameLabel.setBounds(80, 60, 80, 30);
        this.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(130, 60, 200, 30);
        this.add(usernameField);

        JLabel passwordLabel = new JLabel("密码：");
        passwordLabel.setBounds(370, 60, 80, 30);
        this.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(450, 60, 200, 30);
        this.add(passwordField);

        JLabel emailLabel = new JLabel("邮箱：");
        emailLabel.setBounds(80, 120, 80, 30);
        this.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(130, 120, 200, 30);
        this.add(emailField);

        JLabel mobileLabel = new JLabel("联系方式：");
        mobileLabel.setBounds(370, 120, 80, 30);
        this.add(mobileLabel);

        JTextField mobileField = new JTextField();
        mobileField.setBounds(450, 120, 200, 30);
        this.add(mobileField);

        JLabel statusLabel = new JLabel("状态:");
        statusLabel.setBounds(80, 180, 80, 30);
        this.add(statusLabel);

        JRadioButton tRadioBtn = new JRadioButton("正常");
        tRadioBtn.setBounds(150, 180, 130, 30);
        tRadioBtn.setSelected(true);
        JRadioButton fRadioBtn = new JRadioButton("锁定");
        fRadioBtn.setBounds(280, 180, 130, 30);

        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(tRadioBtn);
        btnGroup.add(fRadioBtn);

        this.add(tRadioBtn);
        this.add(fRadioBtn);

        JButton submitBtn = new JButton("提交");
        submitBtn.setBounds(280, 230, 100, 30);
        this.add(submitBtn);

        /*** Listeners ***/

        submitBtn.addActionListener(e -> {
            Manager m = new Manager();
            m.setUsername(usernameField.getText());
            m.setPassword(String.valueOf(passwordField.getPassword()));
            m.setMobile(mobileField.getText());
            m.setEmail(emailField.getText());
            if (tRadioBtn.isSelected()) m.setStatus(0);
            else m.setStatus(1);

            if (managerService.add(m)) {
                NewManagerDialog.this.dispose();
                new ManagerOpr();
            } else {
                System.err.println("添加管理员错误");
            }

        });
    }
}
