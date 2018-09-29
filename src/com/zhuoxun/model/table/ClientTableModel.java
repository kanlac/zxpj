package com.zhuoxun.model.table;

import com.zhuoxun.model.Client;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ClientTableModel extends AbstractTableModel {

    private String[] head = {"id", "姓名", "地址", "邮编", "电子邮件","注解","联系电话"};
    private List<Client> rows;

    public ClientTableModel(List<Client> rows) {
        this.rows = rows;
    }

    public void setDataModel(List<Client> rows) {
        this.rows.clear();
        this.rows = rows;
    }

    public Client getObjectByRow(int row) {
        return rows.get(row);
    }

    /*** Override methods ***/

    public String getColumnName(int column) {
        return head[column];
    }


    public int getRowCount() {
        return rows.size();
    }


    public int getColumnCount() {
        return head.length;
    }


    public Object getValueAt(int rowIndex, int columnIndex){
        Client res = rows.get(rowIndex);

        switch (columnIndex){
            case 0:
                return res.getClient_id();
            case 1:
                return res.getName();
            case 2:
                return res.getAddress();
            case 3:
                return res.getPostal_code();
            case 4:
                return res.getEmail();
            case 5:
                return res.getNote();
            case 6:
                return res.getMobile();
            default:
                return null;
        }

    }
}
