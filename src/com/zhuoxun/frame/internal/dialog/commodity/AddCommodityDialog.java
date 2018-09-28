package com.zhuoxun.frame.internal.dialog.commodity;

import com.zhuoxun.model.Commodity;
import com.zhuoxun.service.CommodityService;
import com.zhuoxun.service.impl.CommodityServiceImpl;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.UUID;

public class AddCommodityDialog extends JFrame {

    public AddCommodityDialog() {
        this.setTitle("添加商品");
        this.setBounds(400,200,700,350);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        appendComponents();

        this.setVisible(true);
    }

    public void appendComponents() {

        /*** Components ***/

        JLabel isbnLabel = new JLabel("商品码：");
        isbnLabel.setBounds(80,60,80,30);
        this.add(isbnLabel);

        JTextField isbnField = new JTextField();
        UUID id = UUID.randomUUID();
        String isbn = id.toString().replaceAll("[^0-9]", "");
        isbnField.setBounds(130,60,200,30);
        isbnField.setText(isbn);
        this.add(isbnField);

        JLabel nameLabel = new JLabel("商品名称：");
        nameLabel.setBounds(370,60,80,30);
        this.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(450,60,200,30);
        this.add(nameField);

        JLabel priceLabel = new JLabel("单价：");
        priceLabel.setBounds(80,120,80,30);
        this.add(priceLabel);

        JTextField priceField = new JTextField();
        priceField.setBounds(130,120,200,30);
        this.add(priceField);

        JLabel unitLabel = new JLabel("单位：");
        unitLabel.setBounds(370,120,80,30);
        this.add(unitLabel);

        JTextField unitField = new JTextField();
        unitField.setBounds(450,120,200,30);
        this.add(unitField);

        JButton submitBtn = new JButton("提交");
        submitBtn.setBounds(280,230,100,30);
        this.add(submitBtn);

        /*** Listeners ***/

        submitBtn.addActionListener(e -> {

            Commodity commodity = new Commodity();
            commodity.setIsbn(isbnField.getText());
            commodity.setName(nameField.getText());
            commodity.setPurchase_price(new BigDecimal(priceField.getText()));
            commodity.setUnit(unitField.getText());

            CommodityService commodityService = new CommodityServiceImpl();
            if (commodityService.save(commodity)) {
                AddCommodityDialog.this.dispose();
            } else {
                System.err.println("添加商品错误");
            }
        });


    }
}
