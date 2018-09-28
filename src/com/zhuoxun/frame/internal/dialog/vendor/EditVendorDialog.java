package com.zhuoxun.frame.internal.dialog.vendor;

import com.zhuoxun.model.Vendor;
import com.zhuoxun.service.VendorService;
import com.zhuoxun.service.impl.VendorServiceImpl;

import javax.swing.*;

public class EditVendorDialog extends JFrame {

    private Vendor vendor;

    public EditVendorDialog(Vendor v) {
        this.vendor = v;
        this.setTitle("编辑供应商");
        this.setBounds(400,200,700,350);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        appendComponents();

        this.setVisible(true);
    }

    private void appendComponents() {
        JLabel addressLabel = new JLabel("地址");
        addressLabel.setBounds(70, 40, 80, 30);
        this.add(addressLabel);

        JTextField addressField = new JTextField();
        addressField.setBounds(120, 40, 200, 30);
        addressField.setText(vendor.getAddress());
        this.add(addressField);

        JLabel postal_codeLabel = new JLabel("邮编");
        postal_codeLabel.setBounds(360, 40, 80, 30);
        this.add(postal_codeLabel);

        JTextField postal_codeField = new JTextField();
        postal_codeField.setBounds(440, 40, 200, 30);
        postal_codeField.setText(vendor.getPostal_code());
        this.add(postal_codeField);

        JLabel emailLabel = new JLabel("邮箱");
        emailLabel.setBounds(70, 80, 80, 30);
        this.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(120, 80, 200, 30);
        emailField.setText(vendor.getEmail());
        this.add(emailField);

        JLabel nameLabel = new JLabel("供应商名称");
        nameLabel.setBounds(360, 80, 80, 30);
        this.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(440, 80, 200, 30);
        nameField.setText(vendor.getName());
        this.add(nameField);

        JLabel noteLabel = new JLabel("备注");
        noteLabel.setBounds(70, 120, 80, 30);
        this.add(noteLabel);

        JTextField noteField = new JTextField();
        noteField.setBounds(120, 120, 200, 30);
        noteField.setText(vendor.getNote());
        this.add(noteField);

        JLabel mobileLabel = new JLabel("手机号");
        mobileLabel.setBounds(360, 120, 80, 30);
        this.add(mobileLabel);

        JTextField mobileField = new JTextField();
        mobileField.setBounds(440, 120, 200, 30);
        mobileField.setText(vendor.getMobile());
        this.add(mobileField);

        JButton submitBtn = new JButton("提交");
        submitBtn.setBounds(280, 230, 100, 30);
        this.add(submitBtn);

        submitBtn.addActionListener(e -> {
            vendor.setAddress(addressField.getText());
            vendor.setPostal_code(postal_codeField.getText());
            vendor.setEmail(emailField.getText());
            vendor.setName(nameField.getText());
            vendor.setNote(noteField.getText());
            vendor.setMobile(mobileField.getText());

            VendorService vendorService = new VendorServiceImpl();
            vendorService.update(vendor);

            EditVendorDialog.this.dispose();
        });
    }
}
