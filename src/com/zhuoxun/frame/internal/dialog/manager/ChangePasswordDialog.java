package com.zhuoxun.frame.internal.dialog.manager;

import com.zhuoxun.frame.Welcome;
import com.zhuoxun.jdbc.SQLQuery;
import com.zhuoxun.model.Manager;
import com.zhuoxun.service.ManagerService;
import com.zhuoxun.service.impl.ManagerServiceImpl;

import javax.swing.*;

public class ChangePasswordDialog extends JFrame {

    public ChangePasswordDialog() {
        this.setTitle("修改密码");
        this.setBounds(400,200,700,350);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        appendComponents();

        this.setVisible(true);
    }

    private void appendComponents(){

        /*** Components ***/

        JLabel oldpwdLabel = new JLabel("旧密码：");
        oldpwdLabel.setBounds(150,40,80,30);
        this.add(oldpwdLabel);

        JTextField oldpwdField = new JTextField();
        oldpwdField.setBounds(280,40,200,30);
        this.add(oldpwdField);

        JLabel newpwdLabel = new JLabel("新密码：");
        newpwdLabel.setBounds(150,80,80,30);
        this.add(newpwdLabel);

        JTextField newpwdField = new JTextField();
        newpwdField.setBounds(280,80,200,30);
        this.add(newpwdField);

        JLabel pwdckLabel = new JLabel("确认新密码：");
        pwdckLabel.setBounds(150,120,80,30);
        this.add(pwdckLabel);

        JTextField pwdckField = new JTextField();
        pwdckField.setBounds(280,120,200,30);
        this.add(pwdckField);

        JButton submitBtn = new JButton("提交");
        submitBtn.setBounds(280,230,100,30);
        submitBtn.setBounds(280,230,100,30);
        this.add(submitBtn);

        submitBtn.addActionListener(e -> {

            // check legitimacy
            if (oldpwdField.getText().equals(Welcome.manager.getPassword())) {
                if (pwdckField.getText().equals(newpwdField.getText())) {
                    Manager res = Welcome.manager;
                    res.setPassword(newpwdField.getText());
                    ManagerService managerService = new ManagerServiceImpl();
                    if (managerService.changePwd(res)) {
                        JOptionPane.showMessageDialog(null,"更新成功");
                    } else {
                        System.err.println("更改密码失败");
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"两次密码输入不正确");
                }
            } else {
                JOptionPane.showMessageDialog(null,"旧密码输入不正确");
            }



        });

    }

}
