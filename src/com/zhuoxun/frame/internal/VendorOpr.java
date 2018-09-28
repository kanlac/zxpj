package com.zhuoxun.frame.internal;

import com.zhuoxun.model.table.VendorTableModel;
import com.zhuoxun.service.VendorService;
import com.zhuoxun.service.impl.VendorServiceImpl;

import javax.swing.*;

public class VendorOpr extends JInternalFrame {

    private VendorService vendorService = new VendorServiceImpl();
    private JTable table;
    private VendorTableModel vendorTableModel;

    public VendorOpr() {
        this.setTitle("");
    }

}
