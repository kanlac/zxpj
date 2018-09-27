package com.zhuoxun.frame.internal;

import javax.swing.*;

import static com.zhuoxun.Constants.internalBounds;

public class CommodityOpr extends JInternalFrame {

    public CommodityOpr() {
        this.setTitle("商品管理");
        this.setBounds(internalBounds);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setClosable(false);
        this.setResizable(false);

        appendComponents();

        this.setVisible(true);
    }

    private void appendComponents() {

        /*** Components ***/

        JButton addBtn = new JButton("新增");
        addBtn.setBounds(20, 10, 100, 30);
        this.add(addBtn);

        JButton delBtn = new JButton("删除");
        delBtn.setBounds(130, 10, 100, 30);
        this.add(delBtn);

        JButton editBtn = new JButton("编辑");
        editBtn.setBounds(240, 10, 100, 30);
        this.add(editBtn);
    }
}
