package com.zhuoxun.model.table;

import com.zhuoxun.model.Commodity;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CommodityTableModel extends AbstractTableModel {

    private String[] head = {"编号", "条形码", "名称", "购价", "单位"};
    private List<Commodity> rows;

    public CommodityTableModel(List<Commodity> rows){
        this.rows = rows;
    }

    public void setDataModel(List<Commodity> rows){
        this.rows.clear();
        this.rows=rows;
    }

    public Commodity getObjectByRow(int row){
        return rows.get(row);
    }

    /*** Override methods ***/

    @Override
    public String getColumnName(int column){
        return head[column];
    }

    @Override
    public int getRowCount(){
        return rows.size();
    }

    @Override
    public int getColumnCount(){
        return head.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        Commodity res=rows.get(rowIndex);
        switch (columnIndex){
            case 0:
                return res.getCommodity_id();
            case 1:
                return res.getIsbn();
            case 2:
                return res.getName();
            case 3:
                return res.getPurchase_price();
            case 4:
                return res.getUnit();
            default:
                return null;
        }

    }
}
