/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.report;

import com.ivanbiz.dao.GLAccountDAO;
import com.ivanbiz.dao.impl.GLAccountDAOImpl;
import com.ivanbiz.model.GLAccount;
import com.ivanbiz.model.Invoice;
import com.ivanbiz.model.Pembayaran;
import com.ivanbiz.model.Perusahaan;
import com.ivanbiz.service.GlobalSession;
import com.ivanbiz.service.ServiceHelper;
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
 * @author IW20149X
 */
public class PembayaranReport {

    Invoice invoice;
    NumberFormat numberFormat;
    Perusahaan perusahaan;
    GLAccount gLAccountKepada;
    GLAccount gLAccountDitransferKe;
    GLAccountDAO gLAccountDAO;
    GlobalReport globalReport;
    List<GlobalReport> listReport;
    JRDataSource dataSource;
    Map map;
    JasperPrint report;
    JasperViewer jasperViewer;
    InputStream inputStream;

    public void previewAndCetakTagihan(Pembayaran pembayaran, String previewOrCetak) {
        try {
            numberFormat = NumberFormat.getCurrencyInstance();
            gLAccountDAO = new GLAccountDAOImpl();

            perusahaan = new Perusahaan();
            perusahaan.setAlamat(GlobalSession.getPerusahaan().getAlamat() + "\n" + "Ph  :" + GlobalSession.getPerusahaan().getTelephone() + "\n" + "Fax :" + GlobalSession.getPerusahaan().getFax());

            invoice = pembayaran.getInvoice();
            invoice.setTerbilang("## " + ServiceHelper.bilang(Integer.parseInt(String.valueOf(new Double(pembayaran.getJumlah()).intValue()))) + " rupiah ##");
            pembayaran.setInvoice(invoice);

            globalReport = new GlobalReport();
            globalReport.setPerusahaan(perusahaan);
            globalReport.setPembayaran(pembayaran);
            globalReport.setLogo("http://" + System.getProperty("ip") + ":" + System.getProperty("port") + "/GPS/image/logo.jpg");
            globalReport.setJumlah(numberFormat.format(pembayaran.getJumlah()));

            listReport = new ArrayList<GlobalReport>();
            listReport.add(globalReport);

            inputStream = JRLoader.getURLInputStream("http://" + System.getProperty("ip") + ":" + System.getProperty("port") + "/GPS/report/PembayaranReport.jasper");
            dataSource = new JRBeanCollectionDataSource(listReport);
            map = new HashMap();
            map.put(JRParameter.REPORT_DATA_SOURCE, dataSource);

            report = JasperFillManager.fillReport(inputStream, map);
            if (previewOrCetak.equals("preview")) {
                jasperViewer = new JasperViewer(report, false);
                jasperViewer.setSize(800, 600);
                jasperViewer.setAlwaysOnTop(true);
                jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
                jasperViewer.setVisible(true);
            } else {
                JasperPrintManager.printReport(report, false);
            }
        } catch (JRException ex) {
            Logger.getLogger(PembayaranReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
