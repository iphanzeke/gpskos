/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.report;

import com.ivanbiz.model.DaftarKelas;
import com.ivanbiz.model.Kelas;
import com.ivanbiz.model.Murid;
import com.ivanbiz.model.Perusahaan;
import com.ivanbiz.service.GlobalSession;
import java.awt.Dialog.ModalExclusionType;
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
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Shbt Peterpan
 */
public class DaftarKelasReport {

    GlobalReport globalReport;
    Perusahaan perusahaan;
    Murid murid;
    Kelas kelas;
    InputStream inputStream;
    List<GlobalReport> listReport;
    JRDataSource dataSource;
    Map map;
    JasperPrint report;
    JasperViewer jasperViewer;
    List<DaftarKelas> listDaftarKelases;
    SimpleDateFormat simpleDateFormat;
    SimpleDateFormat simpleDateFormatFrom;

    public void previewAndCetakDaftarKelas(List<DaftarKelas> listDaftarKelas, String previewOrCetak, String kelulusan) {
        try {
            listDaftarKelases = new ArrayList<DaftarKelas>();
            simpleDateFormat = new SimpleDateFormat("dd MMMMM yyyy");
            simpleDateFormatFrom = new SimpleDateFormat("dd-MMM-yy");
            for (DaftarKelas daftarKelas : listDaftarKelas) {
                murid = daftarKelas.getMurid();
                murid.setTelp("Telp : " + murid.getTelp() + "\n" + " HP   : " + murid.getHandphone());
                daftarKelas.setMurid(murid);
                kelas = daftarKelas.getKelas();
                listDaftarKelases.add(daftarKelas);
            }

            perusahaan = new Perusahaan();
            perusahaan.setAlamat(GlobalSession.getPerusahaan().getAlamat() + "\n" + "Ph  :" + GlobalSession.getPerusahaan().getTelephone() + "\n" + "Fax :" + GlobalSession.getPerusahaan().getFax());

            if (kelulusan.contentEquals("kelulusan")) {
                inputStream = JRLoader.getFileInputStream(System.getProperty("user.dir") + "/report/DaftarKelasKelulusanReport.jasper");
//                inputStream = JRLoader.getURLInputStream("http://" + System.getProperty("ip") + ":" + System.getProperty("port") + "/GPS/report/DaftarKelasKelulusanReport.jasper");
            } else {
                if (kelas.getTanggalKelas2() == null) {
                    inputStream = JRLoader.getFileInputStream(System.getProperty("user.dir") + "/report/DaftarKelasReport.jasper");
//                inputStream = JRLoader.getURLInputStream("http://" + System.getProperty("ip") + ":" + System.getProperty("port") + "/GPS/report/DaftarKelasReport.jasper");
                } else {
                    inputStream = JRLoader.getFileInputStream(System.getProperty("user.dir") + "/report/DaftarKelasReport2.jasper");
//                inputStream = JRLoader.getURLInputStream("http://" + System.getProperty("ip") + ":" + System.getProperty("port") + "/GPS/report/DaftarKelasReport2.jasper");
                }
            }

            dataSource = new JRBeanCollectionDataSource(listDaftarKelases);
            map = new HashMap();
            map.put(JRParameter.REPORT_DATA_SOURCE, dataSource);
            map.put("perusahaan.alamat", perusahaan.getAlamat());
//            map.put("logo", "http://" + System.getProperty("ip") + ":" + System.getProperty("port") + "/GPS/image/logo.jpg");
            map.put("logo", System.getProperty("user.dir") + "\\image\\logo.jpg");
            map.put("kelas.alamatKelas", kelas.getAlamatKelas() + "\n" + "bertempat di : " + kelas.getTempatKelas());
            map.put("kelas.tempatKelas", kelas.getTempatKelas() + " , " + simpleDateFormat.format(kelas.getTanggalKelas()));
            map.put("kelas.tanggalFrom", simpleDateFormatFrom.format(kelas.getTanggalKelas()));
            map.put("kelas.tanggalTo", kelas.getTanggalKelas2() == null ? "" : kelas.getTanggalKelas2());
            map.put("peserta", listDaftarKelases.size());

            report = JasperFillManager.fillReport(inputStream, map);
            if (previewOrCetak.equals("preview")) {
                jasperViewer = new JasperViewer(report, false);
                jasperViewer.setSize(800, 600);
                jasperViewer.setAlwaysOnTop(true);
                jasperViewer.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
                jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
                jasperViewer.setVisible(true);
            } else if (previewOrCetak.equals("cetak")) {
                JasperPrintManager.printReport(report, false);
            } else {
                JasperExportManager.exportReportToPdfFile(report, System.getProperty("user.dir") + "\\report\\" + kelas.getTransactionReference() + ".pdf");
            }
        } catch (JRException ex) {
            Logger.getLogger(DaftarKelasReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void previewKelas(List<Kelas> listKelas, String judul) {
        try {
            simpleDateFormatFrom = new SimpleDateFormat("dd-MMM-yy");
            perusahaan = new Perusahaan();
            perusahaan.setAlamat(GlobalSession.getPerusahaan().getAlamat() + "\n" + "Ph  :" + GlobalSession.getPerusahaan().getTelephone() + "\n" + "Fax :" + GlobalSession.getPerusahaan().getFax());
            inputStream = JRLoader.getFileInputStream(System.getProperty("user.dir") + "/report/KelasReport.jasper");
            dataSource = new JRBeanCollectionDataSource(listKelas);
            map = new HashMap();
            map.put(JRParameter.REPORT_DATA_SOURCE, dataSource);
            map.put("perusahaan.alamat", perusahaan.getAlamat());
            map.put("judul", judul);
            map.put("logo", System.getProperty("user.dir") + "\\image\\logo.jpg");            
            report = JasperFillManager.fillReport(inputStream, map);
            JasperExportManager.exportReportToPdfFile(report, System.getProperty("user.dir") + "\\report\\Kelas_" + simpleDateFormatFrom.format(new Date())+ ".pdf");
        } catch (JRException ex) {
            Logger.getLogger(DaftarKelasReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
