/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.service;

import com.ivanbiz.model.RekonBank;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;

/**
 *
 * @author City_Z
 */
public class ReadExcell {

    public List readExcell(String inputFile, Date startDate, Date endDate, String kreditur) {
        List list = new ArrayList();
        File inputWorkbook = new File(inputFile);
        Workbook w = null;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            Sheet sheet = w.getSheet(0);
            String temp = "";           
            int valCol = sheet.getColumns();
            int counterValCol = 0;
            //System.out.println(valCol);
//            for (int j = 0; j < sheet.getColumns(); j++) {
                StringBuffer objDataColumn = new StringBuffer();
                for (int i = 0; i < sheet.getRows(); i++) {
                    System.out.println(i);
                    for (int j = 0; j < sheet.getColumns(); j++) {
                         Cell cell = sheet.getCell(j, i);
                          CellType type = cell.getType();
                           temp += cell.getContents() + ";";                            
                    }                      
                    
                   objDataColumn.append(temp+"\n");                  
                  temp = "";
                  RekonBank rekonBank = new RekonBank();
                rekonBank.setStartDate(startDate);
                rekonBank.setEndDate(endDate);
                rekonBank.setKreditur(kreditur);
                rekonBank.setData(objDataColumn.substring(0, objDataColumn.length() - 2));
                list.add(rekonBank);                           
                objDataColumn = new StringBuffer();

                }          

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            w.close();
        }
        return list;
    }

    public Object readDelimiter(String value, int index,String aksara) {
        String[] val = value.split(aksara);
        return val[index];
    }

    public List readCSV(String csvFile, Date startDate, Date endDate, String kreditur) {
        List list = new ArrayList();
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            int count = 0;

            while ((line = br.readLine()) != null) {
                //  System.out.println(line);
                if (count != 0) {
                    RekonBank rekonBank = new RekonBank();
                    rekonBank.setStartDate(startDate);
                    rekonBank.setEndDate(endDate);
                    rekonBank.setKreditur(kreditur);
                    rekonBank.setData(line);
                    list.add(rekonBank);
                } else {
                    count = 1;
                    RekonBank rekonBank = new RekonBank();
                    rekonBank.setStartDate(startDate);
                    rekonBank.setEndDate(endDate);
                    rekonBank.setKreditur(kreditur);
                    rekonBank.setData(line);
                    list.add(rekonBank);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadExcell.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
}
