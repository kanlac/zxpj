package com.zhuoxun.frame.internal.dialog.purchase;

import com.zhuoxun.frame.Welcome;
import com.zhuoxun.frame.internal.PurchaseOpr;
import com.zhuoxun.model.Commodity;
import com.zhuoxun.model.Manager;
import com.zhuoxun.model.Purchase;
import com.zhuoxun.model.Vendor;
import com.zhuoxun.service.CommodityService;
import com.zhuoxun.service.PurchaseService;
import com.zhuoxun.service.VendorService;
import com.zhuoxun.service.impl.CommodityServiceImpl;
import com.zhuoxun.service.impl.PurchaseServiceImpl;
import com.zhuoxun.service.impl.VendorServiceImpl;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class AddPurchaseDialog extends JFrame {
    private PurchaseService purchaseService = new PurchaseServiceImpl();

    public AddPurchaseDialog(){
        this.setTitle("添加采购订单");
        this.setBounds(400,200,700,350);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        appendComponents();

        this.setVisible(true);
    }

    // todo: 改坐标
    private void appendComponents() {
        JLabel vendorIdLabel = new JLabel("供应商：");
        vendorIdLabel.setBounds(70, 40, 80, 30);
        this.add(vendorIdLabel);

        JComboBox<Integer> vendorBox = new JComboBox<>();
        VendorService vendorService = new VendorServiceImpl();
        for (Vendor v : vendorService.findAll()) {
            vendorBox.addItem(v.getVendor_id());
        }
        vendorBox.setBounds(120, 40, 200, 30);
        this.add(vendorBox);

        JLabel commodityIdLabel = new JLabel("商品 ID：");
        commodityIdLabel.setBounds(360, 40, 80, 30);
        this.add(commodityIdLabel);

        JComboBox<Integer> commodityBox = new JComboBox<>();
        CommodityService commodityService = new CommodityServiceImpl();
        for (Commodity c : commodityService.findAll()) {
            commodityBox.addItem(c.getCommodity_id());
        }
        commodityBox.setBounds(440, 40, 200, 30);
        this.add(commodityBox);

        JLabel costLabel = new JLabel("总金额：");
        costLabel.setBounds(70, 80, 80, 30);
        this.add(costLabel);

        JTextField costField = new JTextField();
        costField.setBounds(120, 80, 200, 30);
        this.add(costField);

        JLabel noteLabel = new JLabel("采购备注：");
        noteLabel.setBounds(360, 80, 80, 30);
        this.add(noteLabel);

        JTextField noteField = new JTextField();
        noteField.setBounds(440, 80, 200, 30);
        this.add(noteField);

        JLabel quantityLabel = new JLabel("数量：");
        quantityLabel.setBounds(70, 120, 80, 30);
        this.add(quantityLabel);

        JTextField quantityField = new JTextField();
        quantityField.setBounds(120, 120, 200, 30);
        this.add(quantityField);

        JLabel statusLabel = new JLabel("状态：");
        statusLabel.setBounds(360, 120, 80, 30);
        this.add(statusLabel);

        JComboBox<String> statusBox = new JComboBox<>();
        statusBox.addItem("未出库");
        statusBox.addItem("已出库");
        statusBox.setBounds(440, 120, 200, 30);
        this.add(statusBox);

        JButton submitBtn = new JButton("提交");
        submitBtn.setBounds(280, 230, 100, 30);
        this.add(submitBtn);

        submitBtn.addActionListener(e -> {
            Purchase res = new Purchase();

            UUID id = UUID.randomUUID();
            String number = id.toString().replaceAll("[^0-9]", "");
            res.setNumber(number);
            res.setDate(new Date());
            res.setCost(BigDecimal.valueOf(Long.parseLong(costField.getText())));
            res.setNote(noteField.getText());
            res.setQuantity(Integer.parseInt(quantityField.getText()));

            String status = (String)statusBox.getSelectedItem();
            if (status.equals("未出库")) {
                res.setStatus(0);
            } else if (status.equals("已出库")) {
                res.setStatus(1);
            } else {
                System.err.println("出库状态错误");
            }

            res.setCommodity_id((Integer)commodityBox.getSelectedItem());
            res.setVendor_id((Integer)vendorBox.getSelectedItem());
            res.setManager_id(Welcome.manager.getManager_id());

            if (purchaseService.save(res)){
                AddPurchaseDialog.this.dispose();
                new PurchaseOpr();
            }else{
                System.out.println("添加采购订单错误");
            }
        });
    }
}
