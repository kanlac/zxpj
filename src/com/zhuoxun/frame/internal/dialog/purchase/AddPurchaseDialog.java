package com.zhuoxun.frame.internal.dialog.purchase;

import com.zhuoxun.frame.internal.PurchaseOpr;
import com.zhuoxun.model.Purchase;
import com.zhuoxun.service.PurchaseService;
import com.zhuoxun.service.impl.PurchaseServiceImpl;

import javax.swing.*;
import java.math.BigDecimal;

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
        JLabel vendorIdLabel = new JLabel("供应商");
        vendorIdLabel.setBounds(70, 40, 80, 30);
        this.add(vendorIdLabel);

        JTextField vendorIdField = new JTextField();
        vendorIdField.setBounds(120, 40, 200, 30);
        this.add(vendorIdField);

        JLabel commodityIdLabel = new JLabel("商品id");
        commodityIdLabel.setBounds(70, 40, 80, 30);
        this.add(commodityIdLabel);

        JTextField commodityIdField = new JTextField();
        commodityIdField.setBounds(120, 40, 200, 30);
        this.add(commodityIdField);

        JLabel costLabel = new JLabel("总金额");
        costLabel.setBounds(70, 40, 80, 30);
        this.add(costLabel);

        JTextField costField = new JTextField();
        costField.setBounds(120, 40, 200, 30);
        this.add(costField);

        JLabel noteLabel = new JLabel("采购备注");
        noteLabel.setBounds(70, 40, 80, 30);
        this.add(noteLabel);

        JTextField noteField = new JTextField();
        noteField.setBounds(120, 40, 200, 30);
        this.add(noteField);

        JLabel quantityLabel = new JLabel("数量");
        quantityLabel.setBounds(70, 40, 80, 30);
        this.add(quantityLabel);

        JTextField quantityField = new JTextField();
        quantityField.setBounds(120, 40, 200, 30);
        this.add(quantityField);

        JLabel statusLabel = new JLabel("状态");
        statusLabel.setBounds(70, 40, 80, 30);
        this.add(statusLabel);

        JTextField statusField = new JTextField();
        statusField.setBounds(120, 40, 200, 30);
        this.add(statusField);

        JButton submitBtn = new JButton("提交");
        submitBtn.setBounds(280, 230, 100, 30);
        this.add(submitBtn);

        submitBtn.addActionListener(e -> {
            Purchase p=new Purchase();
            p.setVendor_id(Integer.parseInt(vendorIdField.getText()));
            p.setCommodity_id(Integer.parseInt(commodityIdField.getText()));
            p.setCost(BigDecimal.valueOf(Long.parseLong(costField.getText())));
            p.setNote(noteField.getText());
            p.setQuantity(Integer.parseInt(quantityField.getText()));
            p.setStatus(Integer.parseInt(statusField.getText()));

            if(purchaseService.save(p)){
                AddPurchaseDialog.this.dispose();
                new PurchaseOpr();
            }else{
                System.out.println("添加采购订单错误");
            }
        });
    }
}
