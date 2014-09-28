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
import com.ivanbiz.model.Perusahaan;
import com.ivanbiz.service.GlobalSession;
import com.ivanbiz.service.ServiceHelper;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
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

    public void previewAndCetakTagihan(Invoice invoice, String previeworCetak) {
        InputStream inputStream = null;
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();;
        try {
            Perusahaan perusahaan = new Perusahaan();
            perusahaan.setAlamat(GlobalSession.getPerusahaan().getAlamat() + "\n" + "Ph  :" + GlobalSession.getPerusahaan().getTelephone() + "\n" + "Fax :" + GlobalSession.getPerusahaan().getFax());
            invoice.setNII("NO. INV : " + invoice.getNII());
            String[] kepada = invoice.getDeskripsiKepada().split("#");
            GLAccount gLAccountKepada = (GLAccount) gLAccountDAO.getDataByEqual(GLAccount.class, "noGL", kepada[0]);
            invoice.setDeskripsiKepada(gLAccountKepada.getDeskripsi());
            String[] ditransferUntuk = invoice.getDeskripsiUntuk().split("#");
            GLAccount gLAccountDitransferKe = (GLAccount) gLAccountDAO.getDataByEqual(GLAccount.class, "noGL", ditransferUntuk[0]);
            invoice.setDeskripsiUntuk(gLAccountDitransferKe.getDeskripsi() + "\nA/C No. " + gLAccountDitransferKe.getNoGL());
            invoice.setDeskripsiJumlahPeserta(invoice.getDeskripsiJumlahPeserta() + " Orang Peserta, yaitu :\n \n ( absensi terlampir )");
            invoice.setTerbilang(ServiceHelper.bilang(Integer.parseInt(String.valueOf(new Double(invoice.getJumlahTagihan()).intValue()))) + " rupiah");
            invoice.setJatuhTempo(invoice.getJatuhTempo() + " hari");

            GlobalReport globalReport = new GlobalReport();
            globalReport.setPerusahaan(perusahaan);
            globalReport.setInvoice(invoice);
            globalReport.setNamaGLDebitur(gLAccountKepada.getNameGL());
            globalReport.setNamaGLKreditur(gLAccountDitransferKe.getNameGL());
            globalReport.setLogo(System.getProperty("user.dir") + "\\\\image\\\\logo.jpg");
            globalReport.setJumlah(numberFormat.format(invoice.getJumlahTagihan()));

            List<GlobalReport> listReport = new ArrayList<GlobalReport>();
            listReport.add(globalReport);

            inputStream = JRLoader.getFileInputStream(System.getProperty("user.dir") + "/report/TagihanReport.jasper");
            JRDataSource dataSource = new JRBeanCollectionDataSource(listReport);
            Map map = new HashMap();
            map.put(JRParameter.REPORT_DATA_SOURCE, dataSource);

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
