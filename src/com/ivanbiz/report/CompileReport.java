/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.report;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

/**
 *
 * @author Shbt Peterpan
 */
public class CompileReport {

    public static void main(String[] args) {
        File folder = new File(System.getProperty("user.dir") + "/src/com/ivanbiz/report/");
        File[] listFile = folder.listFiles();
        for (File listFile1 : listFile) {
            if (listFile1.isFile()) {
                String filesJrxml = listFile1.getName();
                if (filesJrxml.endsWith(".jrxml")) {
                    String filesJasper = filesJrxml.replaceAll(".jrxml", "");
                    try {
                        JasperCompileManager.compileReportToFile(folder.getAbsolutePath() + "/" + filesJrxml, System.getProperty("user.dir") + "/report/" + filesJasper + ".jasper");
                    } catch (JRException ex) {
                        Logger.getLogger(CompileReport.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}
