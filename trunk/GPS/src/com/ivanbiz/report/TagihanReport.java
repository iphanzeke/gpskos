/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.report;

import com.ivanbiz.dao.GLAccountDAO;
import com.ivanbiz.dao.impl.GLAccountDAOImpl;
import com.ivanbiz.model.GLAccount;
import com.ivanbiz.model.Invoice;
import com.ivanbiz.service.GlobalSession;
import com.ivanbiz.service.ServiceHelper;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Shbt Peterpan
 */
public class TagihanReport {

    GLAccountDAO gLAccountDAO = new GLAccountDAOImpl();

    public void previewAndCetakTagihan(List<Invoice> listInvoice, String previeworCetak) {
        InputStream inputStream = null;
        String[] kepada = null;
        String[] ditransferUntuk = null;
        try {
            for (Invoice invoices : listInvoice) {
                invoices.setNII("NO. INV : " + invoices.getNII());
                kepada = invoices.getDeskripsiKepada().split("#");
                GLAccount gLAccountKepada = (GLAccount) gLAccountDAO.getDataByEqual(GLAccount.class, "noGL", kepada[0]);
                invoices.setDeskripsiKepada(gLAccountKepada.getDeskripsi());
                ditransferUntuk = invoices.getDeskripsiUntuk().split("#");
                GLAccount gLAccountDitransferKe = (GLAccount) gLAccountDAO.getDataByEqual(GLAccount.class, "noGL", ditransferUntuk[0]);
                invoices.setDeskripsiUntuk(gLAccountDitransferKe.getDeskripsi() + "\n A/C No. " + gLAccountDitransferKe.getNoGL());
                invoices.setDeskripsiJumlahPeserta(invoices.getDeskripsiJumlahPeserta() + " Orang Peserta, yaitu :\n \n ( absensi terlampir )");
                invoices.setTerbilang(ServiceHelper.bilang(Long.parseLong(invoices.getJumlahTagihan().toBigInteger().toString())) + " rupiah");
                invoices.setJatuhTempo(invoices.getJatuhTempo() + " hari");
                listInvoice.set(0, invoices);
            }
            inputStream = JRLoader.getFileInputStream(System.getProperty("user.dir") + "/report/TagihanReport.jasper");
            JRDataSource dataSource = new JRBeanCollectionDataSource(listInvoice);
            Map map = new HashMap();
            map.put(JRParameter.REPORT_DATA_SOURCE, dataSource);
            map.put("kepada", kepada[1]);
            map.put("untuk", ditransferUntuk[1]);
            map.put("logo", System.getProperty("user.dir") + "\\\\image\\\\logo.jpg");
            map.put("alamat", GlobalSession.getPerusahaan().getAlamat() + "\n" + "Ph  :" + GlobalSession.getPerusahaan().getTelephone() + "\n" + "Fax :" + GlobalSession.getPerusahaan().getFax());
            JasperPrint report = JasperFillManager.fillReport(inputStream, map);
            if (previeworCetak.equals("preview")) {
                JasperViewer jasperViewer = new JasperViewer(report, false);
                jasperViewer.setSize(800, 600);
                jasperViewer.setAlwaysOnTop(true);
                jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
                jasperViewer.setVisible(true);
            } else {
                JasperPrintManager.printReport(report, false);
            }
        } catch (JRException ex) {
            Logger.getLogger(TagihanReport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
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
