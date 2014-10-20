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
import java.io.InputStream;
import java.text.SimpleDateFormat;
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

    public void previewAndCetakTagihan(List<DaftarKelas> listDaftarKelas, String previewOrCetak, String kelulusan) {
        try {
            listDaftarKelases = new ArrayList<DaftarKelas>();
            simpleDateFormat = new SimpleDateFormat("dd MMMMM yyyy");
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
            } else {
                inputStream = JRLoader.getFileInputStream(System.getProperty("user.dir") + "/report/DaftarKelasReport.jasper");
            }

            dataSource = new JRBeanCollectionDataSource(listDaftarKelases);
            map = new HashMap();
            map.put(JRParameter.REPORT_DATA_SOURCE, dataSource);
            map.put("perusahaan.alamat", perusahaan.getAlamat());
            map.put("logo", System.getProperty("user.dir") + "\\\\image\\\\logo.jpg");
            map.put("kelas.alamatKelas", kelas.getAlamatKelas() + "\n" + "bertempat di : " + kelas.getTempatKelas());
            map.put("kelas.tempatKelas", kelas.getTempatKelas() + " , " + simpleDateFormat.format(kelas.getTanggalKelas()));
            map.put("peserta", listDaftarKelases.size());

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
            Logger.getLogger(DaftarKelasReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
