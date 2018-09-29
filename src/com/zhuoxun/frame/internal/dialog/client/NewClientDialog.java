package com.zhuoxun.frame.internal.dialog.client;

import com.zhuoxun.frame.internal.ClientOpr;
import com.zhuoxun.model.Client;
import com.zhuoxun.service.impl.ClientServiceImpl;

import javax.swing.*;

public class NewClientDialog extends JFrame {

    private com.zhuoxun.service.ClientService ClientService = new ClientServiceImpl();

    public NewClientDialog() {
        this.setTitle("添加客户");
        this.setBounds(400, 200, 700, 350);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        appendComponents();

        this.setVisible(true);
    }

    private void appendComponents() {

        /*** Components ***/

        JLabel nameLabel = new JLabel("客户名");
        nameLabel.setBounds(80, 60, 80, 30);
        this.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(130, 60, 200, 30);
        this.add(nameField);

        JLabel addressLabel = new JLabel("地址：");
        addressLabel.setBounds(370, 60, 80, 30);
        this.add(addressLabel);

        JTextField addressField = new JTextField();
        addressField.setBounds(450, 60, 200, 30);
        this.add(addressField);

        JLabel postalLabel = new JLabel("邮编：");
        postalLabel.setBounds(370, 120, 80, 30);
        this.add(postalLabel);

        JTextField postalField = new JTextField();
        postalField.setBounds(450, 120, 200, 30);
        this.add(postalField);

        JLabel emailLabel = new JLabel("电子邮箱：");
        emailLabel.setBounds(80, 120, 80, 30);
        this.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(130, 120, 200, 30);
        this.add(emailField);

        JLabel mobileLabel = new JLabel("联系电话：");
        mobileLabel.setBounds(370, 120, 80, 30);
        this.add(mobileLabel);

        JTextField mobileField = new JTextField();
        mobileField.setBounds(450, 120, 200, 30);
        this.add(mobileField);

        JLabel noteLabel = new JLabel("注解:");
        noteLabel.setBounds(80, 180, 80, 30);
        this.add(noteLabel);

        JTextField noteField = new JTextField();
        noteField.setBounds(450, 120, 200, 30);
        this.add(noteField);


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
            Client m = new Client();
            m.setName(nameField.getText());
            m.setAddress(String.valueOf(addressField.getText()));
            m.setMobile(mobileField.getText());
            m.setEmail(emailField.getText());
            m.setNote(noteField.getText());
            m.setPostal_code(postalField.getText());/*
            if (tRadioBtn.isSelected()) m.setnote(0);
            else m.setnote(1);*/

            if (ClientService.add(m)) {
                NewClientDialog.this.dispose();
                new ClientOpr();
            } else {
                System.err.println("添加客户错误");
            }

        });
    }
}
