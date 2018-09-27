package com.zhuoxun.model.table;

import com.zhuoxun.model.Vendor;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class VendorTableModel extends AbstractTableModel {

    private String[] head = { "编号", "地址", "邮编", "邮箱", "名称","备注","电话" };
    private List<Vendor> rows;

    public VendorTableModel(List<Vendor> rows) {
        this.rows = rows;
    }

    public void setDataModel(List<Vendor> rows) {
        this.rows.clear();
        this.rows = rows;
    }

    public Vendor getObjectByRow(int row) {
        return rows.get(row);
    }

    @Override
    public String getColumnName(int column) {
        return head[column];
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return head.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vendor res = rows.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return res.getVendor_id();
            case 1:
                return res.getAddress();
            case 2:
                return res.getPostal_code();
            case 3:
                return res.getEmail();
            case 4:
                return res.getName();
            case 5:
                return res.getNote();
            case 6:
                return res.getMobile();
            default:
                return null;
        }
    }
}