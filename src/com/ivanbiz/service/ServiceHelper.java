/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    public static String bilang(long uang) {
        String nama[] = {"nol", "satu", "dua", "tiga", "empat", "lima", "enam", "tujuh", "delapan", "sembilan"};
        String besar[] = {"triliun", "milyar", "juta", "ribu", ""};
        if (uang == 0) {
            return nama[0];
        }
        long p = 1000000000000l;
        String hasil = "";
        for (int i = 0; i < besar.length; i++, p /= 1000) {
            if (uang < p) {
                continue;
            }
            long temp = uang / p;
            boolean seribu = p == 1000;
            if (temp >= 100) {
                hasil += nama[(int) temp / 100] + " ratus ";
                temp %= 100;
                seribu = false;
            }
            if (temp >= 11 && temp <= 19) {
                hasil += nama[(int) temp - 10] + " belas ";
                temp = 0;
                seribu = false;
            }
            if (temp >= 10) {
                hasil += nama[(int) temp / 10] + " puluh ";
                temp %= 10;
            }
            if (temp > 0) {
                if (seribu && temp == 1) {
                    hasil += "se";
                } else {
                    hasil += nama[(int) temp] + " ";
                }
            }
            uang %= p;
            hasil += besar[i] + " ";
        }
        hasil = hasil.replaceAll("satu ratus", "seratus");
        hasil = hasil.replaceAll("satu belas", "sebelas");
        hasil = hasil.replaceAll("satu puluh", "sepuluh");
        return hasil.trim();
    }

    public boolean validateEmail(String email) {
        Pattern regexp = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
        Matcher matcher = regexp.matcher(email);
        if (matcher.matches()) {
            return false;
        }
        return true;
    }
}
