package com.zhuoxun.frame.internal.dialog.vendor;

import com.zhuoxun.model.Vendor;

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

    }
}
