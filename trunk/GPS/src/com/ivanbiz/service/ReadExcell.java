/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;

/**
 *
 * @author City_Z
 */
public class ReadExcell {

    public List readExcell(String inputFile) {
        List list = new ArrayList();
        File inputWorkbook = new File(inputFile);
        Workbook w;

        try {
            w = Workbook.getWorkbook(inputWorkbook);
            Sheet sheet = w.getSheet(0);
            StringBuffer objDataColumn = new StringBuffer();
            for (int j = 1; j < sheet.getColumns(); j++) {
                for (int i = 0; i < sheet.getRows(); i++) {
                    Cell cell = sheet.getCell(j, i);
                    CellType type = cell.getType();
                    objDataColumn.append(cell.getContents()+"^");
                    System.out.println(cell.getContents() + "===");
                    list.add(objDataColumn);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
