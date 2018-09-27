package com.zhuoxun.frame;

import com.zhuoxun.model.Manager;
import com.zhuoxun.service.ManagerService;
import com.zhuoxun.service.impl.ManagerServiceImpl;

import javax.swing.*;

import static com.zhuoxun.frame.Home.createAndShowGUI;

public class Welcome extends JFrame {
    public static Manager manager = null;

    public Welcome() {
        this.setTitle("欢迎进入进销存管理系统");
        this.setBounds(0, 0, 500, 350);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        appendComponents();

        this.setVisible(true);
    }

    // 登录界面控件
    private void appendComponents() {

        /*** Components ***/

        // todo: image


        JLabel usernameLabel = new JLabel("用户名：");
        usernameLabel.setBounds(120, 140, 80, 30);
        this.add(usernameLabel);

        JTextField username_field = new JTextField();
        username_field.setBounds(200, 140, 200, 30);
        this.add(username_field);

        JLabel passwordLabel = new JLabel("密码：");
        passwordLabel.setBounds(120, 180, 80, 30);
        this.add(passwordLabel);

        JPasswordField password_field = new JPasswordField();
        password_field.setBounds(200, 180, 200, 30);
        this.add(password_field);

        JButton loginBtn = new JButton("登录");
        loginBtn.setBounds(140, 240, 100, 30);
        this.add(loginBtn);

        JButton resetBtn = new JButton("重置");
        resetBtn.setBounds(260, 240, 100, 30);
        this.add(resetBtn);

        /*** Listeners ***/

        loginBtn.addActionListener(e -> {
            String username = username_field.getText();
            char[] password = password_field.getPassword();

            ManagerService managerService = new ManagerServiceImpl();
            Manager manager = managerService.findByUsername(username);

            if (manager == null) {
                JOptionPane.showMessageDialog(null, "该用户不存在");
            } else if (!String.valueOf(password).equals(manager.getPassword())) {
                JOptionPane.showMessageDialog(null, "密码错误");
            } else {
                javax.swing.SwingUtilities.invokeLater((new Runnable() {
                    @Override
                    public void run() {
                        createAndShowGUI();
                    }
                }));
                Welcome.this.dispose(); // clear resource
            }
        });

        resetBtn.addActionListener(e -> {
            username_field.setText("");
            password_field.setText("");
        });
    }
}
