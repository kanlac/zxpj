package com.zhuoxun.view;

import com.zhuoxun.model.Manager;
import contrib.com.blogofbug.swing.components.ImageLabel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    public static Manager manager = null;

    public LoginView() {
        this.setTitle("进销存管理系统");
        this.setBounds(200, 100, 500, 350);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appendLoginViewComponent();
        this.setVisible(true);
    }

    // 登录界面控件
    public void appendLoginViewComponent() {
        // image...


        // username
        JLabel user = new JLabel("用户名：");
        user.setBounds(120, 140, 80, 30);
        this.add(user);

        // username input field
        JTextField username_field = new JTextField();
        username_field.setBounds(200, 140, 200, 30);
        this.add(username_field);

        // password
        JLabel password = new JLabel("密码：");
        password.setBounds(120, 180, 80, 30);
        this.add(password);

        // password input field
        JPasswordField password_field = new JPasswordField();
        password_field.setBounds(200, 180, 200, 30);
        this.add(password_field);

        // login button
        JButton login_button = new JButton("登录");
        login_button.setBounds(140, 240, 100, 30);
        this.add(login_button);

        // reset button
        JButton reset_button = new JButton("重置");
        reset_button.setBounds(260, 240, 100, 30);
        this.add(reset_button);

        // reset text field
        reset_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username_field.setText("");
                password_field.setText("");
            }
        });
    }
}
