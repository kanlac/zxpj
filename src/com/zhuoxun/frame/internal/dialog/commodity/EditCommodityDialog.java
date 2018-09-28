package com.zhuoxun.frame.internal.dialog.commodity;

import com.zhuoxun.model.Commodity;
import com.zhuoxun.service.CommodityService;
import com.zhuoxun.service.impl.CommodityServiceImpl;

import javax.swing.*;
import java.math.BigDecimal;

public class EditCommodityDialog extends JFrame {

    private Commodity commodity;

    public EditCommodityDialog(Commodity c) {
        this.commodity = c;
        this.setTitle("编辑商品");
        this.setBounds(400,200,700,350);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        appendComponents();

        this.setVisible(true);
    }

    private void appendComponents(){

        /*** Components ***/

        JLabel isbnLabel = new JLabel("商品码：");
        isbnLabel.setBounds(80,60,80,30);
        this.add(isbnLabel);

        JTextField isbnField = new JTextField();
        isbnField.setBounds(130,60,200,30);
        isbnField.setText(commodity.getIsbn());
        this.add(isbnField);

        JLabel nameLabel = new JLabel("商品名称：");
        nameLabel.setBounds(370,60,80,30);
        this.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(450,60,200,30);
        nameField.setText(commodity.getName());
        this.add(nameField);

        JLabel purchasePriceLabel = new JLabel("单价：");
        purchasePriceLabel.setBounds(80,120,80,30);
        this.add(purchasePriceLabel);

        JTextField purchasePriceField = new JTextField();
        purchasePriceField.setBounds(130,120,200,30);
        purchasePriceField.setText(commodity.getPurchase_price() + "");
        this.add(purchasePriceField);

        JLabel unitLabel = new JLabel("单位：");
        unitLabel.setBounds(370,120,80,30);
        this.add(unitLabel);

        JTextField unitField = new JTextField();
        unitField.setBounds(450,120,200,30);
        unitField.setText(commodity.getUnit());
        this.add(unitField);

        JButton submitBtn = new JButton("提交");
        submitBtn.setBounds(280,230,100,30);
        submitBtn.setBounds(280,230,100,30);
        this.add(submitBtn);

        submitBtn.addActionListener(e -> {

            // check legitimacy
            if (purchasePriceField.getText().contains("[^0-9]")) {
                JOptionPane.showMessageDialog(null, "请检查您填写的单价");
            } else {
                // commit update
                commodity.setIsbn(isbnField.getText());
                commodity.setName(nameField.getText());
                commodity.setPurchase_price(new BigDecimal(purchasePriceField.getText()));
                commodity.setUnit(unitField.getText());

                CommodityService commodityService = new CommodityServiceImpl();
                commodityService.update(commodity);

                EditCommodityDialog.this.dispose();
            }



        });

    }
}
