/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.report;

import com.ivanbiz.service.GlobalSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Shbt Peterpan
 */
public class TagihanReport {

    public void cetakTagihan(List listCetak) {
        InputStream inputStream = null;
        try {
            inputStream = JRLoader.getFileInputStream(System.getProperty("user.dir") + "/report/TagihanReport.jasper");
            JRDataSource dataSource = new JRBeanCollectionDataSource(listCetak);
            Map map = new HashMap();
            map.put(JRParameter.REPORT_DATA_SOURCE, dataSource);
            map.put("nama",GlobalSession.getPerusahaan().getNama());
            map.put("logo",System.getProperty("user.dir")+"\\image\\logo.jpg");
            map.put("alamat",GlobalSession.getPerusahaan().getAlamat());
            map.put("telp","Ph  :"+GlobalSession.getPerusahaan().getAlamat());
            map.put("fax","Fax :"+GlobalSession.getPerusahaan().getAlamat());
            JasperPrint report = JasperFillManager.fillReport(inputStream, map);
            JasperPrintManager.printReport(report, false);
        } catch (JRException ex) {
            Logger.getLogger(TagihanReport.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(TagihanReport.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
