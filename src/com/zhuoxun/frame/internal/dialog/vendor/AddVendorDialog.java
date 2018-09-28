package com.zhuoxun.frame.internal.dialog.vendor;

import javax.swing.*;

public class AddVendorDialog extends JFrame {

    public AddVendorDialog() {
        this.setTitle("添加供应商");
        this.setBounds(400,200,700,350);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        appendComponents();

        this.setVisible(true);
    }

    private void appendComponents() {

        /*** Components ***/

        JLabel nameLabel = new JLabel("名称:");
        nameLabel.setBounds(80,60,80,30);
        this.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(130,60,200,30);
        this.add(nameField);

        JLabel addressLabel = new JLabel("地址：");
        addressLabel.setBounds(80,120,80,30);
        this.add(addressLabel);

        JTextField addressField = new JTextField();
        addressField.setBounds(130,120,200,30);
        this.add(addressField);

        JLabel postalCodeLabel = new JLabel("邮编：");
        postalCodeLabel.setBounds(370,120,80,30);
        this.add(postalCodeLabel);

        JTextField postalCodeField = new JTextField();
        postalCodeField.setBounds(450,120,200,30);
        this.add(postalCodeField);

        JLabel emailLabel = new JLabel("邮箱：");
        // todo

        JLabel noteLabel = new JLabel("备注：");

        JLabel mobileLabel = new JLabel("电话：");

        JButton submitBtn = new JButton("提交");
    }
}
