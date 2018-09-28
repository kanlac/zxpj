package com.zhuoxun.model.table;

import com.zhuoxun.model.Purchase;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PurchaseTableModel extends AbstractTableModel {

    private String[] head = {"编号", "采购业务号", "采购日期", "总金额", "备注", "采购商品编号", "采购数量", "出库状态", "供应商编号", "经手人编号"};
    private List<Purchase> rows;

    public PurchaseTableModel(List<Purchase> rows) {
        this.rows = rows;
    }

    public void setDataModel(List<Purchase> rows) {
        this.rows.clear();
        this.rows = rows;
    }

    public Purchase getObjectByRow(int row) {
        return rows.get(row);
    }

    /*** Override methods ***/

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
        Purchase res = rows.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return res.getPurchase_id();
            case 1:
                return res.getNumber();
            case 2:
                return res.getDate();
            case 3:
                return res.getCost();
            case 4:
                return res.getNote();
            case 5:
                return res.getCommodity_id();
            case 6:
                return res.getQuantity();
            case 7:
                return res.getStatus();
            case 8:
                return res.getManager_id();
            default:
                return null;
        }
    }
}
