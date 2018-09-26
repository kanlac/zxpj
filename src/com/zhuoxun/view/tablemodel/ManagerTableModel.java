package com.zhuoxun.view.tablemodel;

import com.zhuoxun.model.Manager;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ManagerTableModel extends AbstractTableModel {

    private String[] head = { "编号", "登录名", "密码", "邮箱", "联系电话", "状态" };
    private List<Manager> rows;

    public ManagerTableModel(List<Manager> rows) {
        this.rows = rows;
    }

    public void setDataModel(List<Manager> rows) {
        this.rows.clear();
        this.rows = rows;
    }

    public Manager getObjectByRow(int row) {
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
        Manager res = rows.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return res.getManager_id();
            case 1:
                return res.getUsername();
            case 2:
                return res.getPassword();
            case 3:
                return res.getEmail();
            case 4:
                return res.getMobile();
            case 5:
                return res.getStatus() == 0 ? "正常" : "锁定";
            default:
                return null;
        }
    }
}
