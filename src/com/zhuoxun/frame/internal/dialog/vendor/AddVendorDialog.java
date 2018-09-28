package com.zhuoxun.frame.internal.dialog.vendor;

import com.zhuoxun.frame.internal.VendorOpr;
import com.zhuoxun.model.Vendor;
import com.zhuoxun.service.VendorService;
import com.zhuoxun.service.impl.VendorServiceImpl;

import javax.swing.*;

public class AddVendorDialog extends JFrame {

    private VendorService vendorService = new VendorServiceImpl();

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

        JLabel addressLabel = new JLabel("地址");
        addressLabel.setBounds(70, 40, 80, 30);
        this.add(addressLabel);

        JTextField addressField = new JTextField();
        addressField.setBounds(120, 40, 200, 30);
        this.add(addressField);

        JLabel postal_codeLabel = new JLabel("邮编");
        postal_codeLabel.setBounds(360, 40, 80, 30);
        this.add(postal_codeLabel);

        JTextField postal_codeField = new JTextField();
        postal_codeField.setBounds(440, 40, 200, 30);
        this.add(postal_codeField);

        JLabel emailLabel = new JLabel("邮箱");
        emailLabel.setBounds(70, 80, 80, 30);
        this.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(120, 80, 200, 30);
        this.add(emailField);

        JLabel nameLabel = new JLabel("供应商名称");
        nameLabel.setBounds(360, 80, 80, 30);
        this.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(440, 80, 200, 30);
        this.add(nameField);

        JLabel noteLabel = new JLabel("备注");
        noteLabel.setBounds(70, 120, 80, 30);
        this.add(noteLabel);

        JTextField noteField = new JTextField();
        noteField.setBounds(120, 120, 200, 30);
        this.add(noteField);

        JLabel mobileLabel = new JLabel("手机号");
        mobileLabel.setBounds(360, 120, 80, 30);
        this.add(mobileLabel);

        JTextField mobileField = new JTextField();
        mobileField.setBounds(440, 120, 200, 30);
        this.add(mobileField);

        JButton submitBtn = new JButton("提交");
        submitBtn.setBounds(280, 230, 100, 30);
        this.add(submitBtn);

        /*** Listeners ***/

        submitBtn.addActionListener(e -> {
            Vendor v = new Vendor();
            v.setAddress(addressField.getText());
            v.setPostal_code(postal_codeField.getText());
            v.setEmail(emailField.getText());
            v.setName(nameField.getText());
            v.setNote(noteField.getText());
            v.setMobile(mobileField.getText());

            if (vendorService.add(v)) {
                AddVendorDialog.this.dispose();
                new VendorOpr();
            } else {
                System.err.println("添加供应商错误");
            }
        });
    }
}
