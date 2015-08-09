/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.report;

import com.ivanbiz.model.GLAccount;
import com.ivanbiz.model.Perusahaan;
import com.ivanbiz.service.GlobalSession;
import java.awt.Dialog.ModalExclusionType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author IW20149X
 */
public class LabaRugiReport {

    Perusahaan perusahaan;
    SimpleDateFormat simpleDateFormatFrom;
    InputStream inputStream;
    JRDataSource dataSource;
    Map map;
    JasperPrint report;
    JasperViewer jasperViewer;
    File reportFile;

    public File getReportFile() {
        return reportFile;
    }

    public void setReportFile(File reportFile) {
        this.reportFile = reportFile;
    }

    public void getLabaRugiReport(List<GLAccount> listPendapatan, List<GLAccount> listPengeluaran, double totalKredit, double totalBalance, double biayalain, String judul, String a) {
        try {
            simpleDateFormatFrom = new SimpleDateFormat("dd-MMM-yy");
            perusahaan = new Perusahaan();
            perusahaan.setAlamat(GlobalSession.getPerusahaan().getAlamat() + "\n" + "Ph  :" + GlobalSession.getPerusahaan().getTelephone() + "\n" + "Fax :" + GlobalSession.getPerusahaan().getFax());
            inputStream = JRLoader.getFileInputStream(System.getProperty("user.dir") + "/report/LabaRugiReport.jasper");

            List<GlobalReport> listGlobalReport = new ArrayList<GlobalReport>();
            GlobalReport globalReport = new GlobalReport();
            globalReport.setNoGLPendapatan("Pendapatan : ");
            listGlobalReport.add(globalReport);
            globalReport = new GlobalReport();
            globalReport.setNoGLPendapatan("No GL");
            globalReport.setNameGLPendapatan("Nama GL");
            globalReport.setJumlah("Jumlah");
            globalReport.setCashBPendapatan("Cash Balance");
            listGlobalReport.add(globalReport);
            for (GLAccount gLAccount : listPendapatan) {
                globalReport = new GlobalReport();
                globalReport.setNoGLPendapatan(gLAccount.getNoGL());
                globalReport.setNameGLPendapatan(gLAccount.getNameGL());
                globalReport.setJumlah(gLAccount.getJumlah() == 0.0 ? null : String.valueOf(gLAccount.getJumlah()));
                globalReport.setCashBPendapatan(gLAccount.getCashBalance() == 0.0 ? null : String.valueOf(gLAccount.getCashBalance()));
                listGlobalReport.add(globalReport);
            }
            globalReport = new GlobalReport();
            globalReport.setNoGLPendapatan("Pengeluaran");
            listGlobalReport.add(globalReport);
            globalReport = new GlobalReport();
            globalReport.setNoGLPendapatan("No GL");
            globalReport.setNameGLPendapatan("Nama GL");
            globalReport.setJumlah("Jumlah");
            listGlobalReport.add(globalReport);
            for (GLAccount gLAccount : listPengeluaran) {
                globalReport = new GlobalReport();
                globalReport.setNoGLPendapatan(gLAccount.getNoGL());
                globalReport.setNameGLPendapatan(gLAccount.getNameGL());
                globalReport.setJumlah(gLAccount.getJumlah() == 0.0 ? null : String.valueOf(gLAccount.getJumlah()));
                listGlobalReport.add(globalReport);
            }
            dataSource = new JRBeanCollectionDataSource(listGlobalReport);
            map = new HashMap();
            map.put(JRParameter.REPORT_DATA_SOURCE, dataSource);
            map.put("perusahaan.alamat", perusahaan.getAlamat());
            map.put("judul", judul);
            map.put("logo", System.getProperty("user.dir") + "\\image\\logo.jpg");
            report = JasperFillManager.fillReport(inputStream, map);
            jasperViewer = new JasperViewer(report, false);
            jasperViewer.setSize(800, 600);
            jasperViewer.setAlwaysOnTop(true);
            jasperViewer.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
            jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jasperViewer.setVisible(true);
//            JasperExportManager.exportReportToPdfFile(report, System.getProperty("user.dir") + "\\report\\Kelas_" + simpleDateFormatFrom.format(new Date()) + ".pdf");
        } catch (JRException ex) {
            Logger.getLogger(LabaRugiReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getLabaRugiReport(List<GLAccount> listPendapatan, List<GLAccount> listPengeluaran, double totalKredit, double totalBalance, double biayalain, String judul) {
        try {
            simpleDateFormatFrom = new SimpleDateFormat("dd-MMM-yy");
            perusahaan = new Perusahaan();
            perusahaan.setAlamat(GlobalSession.getPerusahaan().getAlamat() + "\n" + "Ph  :" + GlobalSession.getPerusahaan().getTelephone() + "\n" + "Fax :" + GlobalSession.getPerusahaan().getFax());
            inputStream = JRLoader.getFileInputStream(System.getProperty("user.dir") + "/report/LabaRugiReport.jasper");
            dataSource = new JRBeanCollectionDataSource(listPendapatan);
            map = new HashMap();
            map.put(JRParameter.REPORT_DATA_SOURCE, dataSource);
            map.put("LIST_PENDAPATAN", listPendapatan);
            map.put("SUBREPORT_DIR_PENDAPATAN", System.getProperty("user.dir") + "/report/PendapatanReport.jasper");
            map.put("LIST_PENGELUARAN", listPengeluaran);
            map.put("SUBREPORT_DIR_PENGELUARAN", System.getProperty("user.dir") + "/report/PengeluaranReport.jasper");
            map.put("perusahaan.alamat", perusahaan.getAlamat());
            map.put("judul", judul);
            map.put("logo", System.getProperty("user.dir") + "\\image\\logo.jpg");
            map.put("totalKredit", totalKredit);
            map.put("totalBalance", totalBalance);
            map.put("biayalain", biayalain);
            report = JasperFillManager.fillReport(inputStream, map);
            reportFile = File.createTempFile("Laba_Rugi_" + simpleDateFormatFrom.format(new Date()) + "_", ".pdf");
            JasperExportManager.exportReportToPdfStream(report, new FileOutputStream(reportFile));
        } catch (IOException ex) {
            Logger.getLogger(LabaRugiReport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(LabaRugiReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
