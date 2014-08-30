/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author Aprisma
 */
public class ServiceHelper {

    public Object[] getPropertyClass(Class claz) {
        List listData = new ArrayList();
        Field[] fields = claz.getDeclaredFields();
        for (int x = 0; x < fields.length; x++) {
            Field field = (Field) fields[x];
            listData.add(field.getName());
        }
        Object[] data = new Object[listData.size()];
        for (int x = 1; x < listData.size(); x++) {
            data[x] = listData.get(x);
        }
        return data;
    }

    public void setAutoRize(Object[][] isi, String[] judul, JTable jTable) {
        jTable.setModel(new DefaultTableModel(isi, judul) {

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                if (columnIdentifiers.get(columnIndex).equals("Choose")) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public Class getColumnClass(int columnIndex) {
                if (columnIdentifiers.get(columnIndex).equals("Choose")) {
                    return Boolean.class;
                } else {
                    return columnIdentifiers.get(columnIndex).getClass();
                }
            }
        });
        JTableHeader header = jTable.getTableHeader();
        int rowCount = jTable.getRowCount();
        final Enumeration columns = jTable.getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            TableColumn column = (TableColumn) columns.nextElement();
            int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
            int width = (int) jTable.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(jTable, column.getIdentifier(), false, false, -1, col).getPreferredSize().getWidth();
            for (int row = 0; row < rowCount; row++) {
                int preferedWidth = (int) jTable.getCellRenderer(row, col).getTableCellRendererComponent(jTable, jTable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);
            }
            header.setResizingColumn(column); // this line is very important
            column.setWidth(width + jTable.getIntercellSpacing().width);
        }
    }
}
