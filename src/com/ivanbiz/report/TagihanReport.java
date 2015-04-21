/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.report;

import com.ivanbiz.dao.GLAccountDAO;
import com.ivanbiz.dao.impl.GLAccountDAOImpl;
import com.ivanbiz.model.DaftarKelas;
import com.ivanbiz.model.GLAccount;
import com.ivanbiz.model.Invoice;
import com.ivanbiz.model.Kelas;
import com.ivanbiz.model.Murid;
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

    GLAccountDAO gLAccountDAO;
    NumberFormat numberFormat;
    Perusahaan perusahaan;
    GLAccount gLAccountKepada;
    GLAccount gLAccountDitransferKe;
    String[] kepada;
    String[] ditransferUntuk;
    GlobalReport globalReport;
    List<GlobalReport> listReport;
    JRDataSource dataSource;
    JasperPrint report;
    Map map;
    JasperViewer jasperViewer;
    InputStream inputStream;
    InputStream inputStreamSubReport;
    Murid murid;
    Kelas kelas;
    List<DaftarKelas> listDaftarKelases;

    public void previewAndCetakTagihan(Invoice invoice, List<DaftarKelas> listDaftarKelas, String previeworCetak) {
        gLAccountDAO = new GLAccountDAOImpl();
        numberFormat = NumberFormat.getNumberInstance();
        try {
            perusahaan = new Perusahaan();
            perusahaan.setAlamat(GlobalSession.getPerusahaan().getAlamat() + "\n" + "Ph  :" + GlobalSession.getPerusahaan().getTelephone() + "\n" + "Fax :" + GlobalSession.getPerusahaan().getFax());
            invoice.setNII("NO. INV : " + invoice.getNII());
            kepada = invoice.getDeskripsiKepada().split("#");
            gLAccountKepada = (GLAccount) gLAccountDAO.getDataByEqual(GLAccount.class, "noGL", kepada[0]);
            invoice.setDeskripsiKepada(gLAccountKepada.getDeskripsi());
            ditransferUntuk = invoice.getDeskripsiUntuk().split("#");
            gLAccountDitransferKe = (GLAccount) gLAccountDAO.getDataByEqual(GLAccount.class, "noGL", ditransferUntuk[0]);
            invoice.setDeskripsiUntuk(gLAccountDitransferKe.getDeskripsi() + "\nA/C No. " + gLAccountDitransferKe.getNoGL());
            invoice.setDeskripsiJumlahPeserta(invoice.getDeskripsiJumlahPeserta() + " Orang Peserta, yaitu :\n \n ( absensi terlampir )");
            invoice.setTerbilang(ServiceHelper.bilang(Integer.parseInt(String.valueOf(new Double(invoice.getJumlahTagihan()).intValue()))) + " rupiah");
            invoice.setJatuhTempo(invoice.getJatuhTempo() + " hari");

            globalReport = new GlobalReport();
            globalReport.setPerusahaan(perusahaan);
            globalReport.setInvoice(invoice);
            globalReport.setNamaGLDebitur(gLAccountKepada.getNameGL());
            globalReport.setNamaGLKreditur(gLAccountDitransferKe.getNameGL());
//            globalReport.setLogo("http://" + System.getProperty("ip") + ":" + System.getProperty("port") + "/GPS/image/logo.jpg");
            globalReport.setLogo(System.getProperty("user.dir") + "\\image\\logo.jpg");
            globalReport.setJumlah("Rp " + numberFormat.format(invoice.getJumlahTagihan()) + ",00");

            listReport = new ArrayList<GlobalReport>();
            listReport.add(globalReport);

            listDaftarKelases = new ArrayList<DaftarKelas>();
            for (DaftarKelas daftarKelas : listDaftarKelas) {
                murid = daftarKelas.getMurid();
                murid.setTelp("Telp : " + murid.getTelp() + "\n" + " HP   : " + murid.getHandphone());
                daftarKelas.setMurid(murid);
                kelas = daftarKelas.getKelas();
                listDaftarKelases.add(daftarKelas);
            }

            inputStream = JRLoader.getFileInputStream(System.getProperty("user.dir") + "/report/TagihanReport.jasper");
//            inputStream = JRLoader.getFileInputStream("http://" + System.getProperty("ip") + ":" + System.getProperty("port") + "/GPS/report/TagihanReport.jasper");
            inputStreamSubReport = JRLoader.getFileInputStream(System.getProperty("user.dir") + "/report/DaftarKelasReport.jasper");
//            inputStreamSubReport = JRLoader.getFileInputStream("http://" + System.getProperty("ip") + ":" + System.getProperty("port") + "/GPS/report/DaftarKelasReport.jasper");
            dataSource = new JRBeanCollectionDataSource(listReport);
            map = new HashMap();
            map.put(JRParameter.REPORT_DATA_SOURCE, dataSource);
            map.put("SUBREPORT_DIR", inputStreamSubReport);
            map.put("PRM_DETAIL_VALUE", listDaftarKelases);
            map.put("logo", globalReport.getLogo());
            map.put("perusahaan.alamat", globalReport.getPerusahaan().getAlamat());
            map.put("kelas.alamatKelas", globalReport.getInvoice().getKelas().getAlamatKelas() + "\n" + "bertempat di : " + globalReport.getInvoice().getKelas().getTempatKelas());
            map.put("peserta", listDaftarKelas.size());

            report = JasperFillManager.fillReport(inputStream, map);
            if (previeworCetak.equals("preview")) {
                jasperViewer = new JasperViewer(report, false);
                jasperViewer.setSize(800, 600);
                jasperViewer.setAlwaysOnTop(true);
                jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
                new DaftarKelasReport().previewAndCetakTagihan(listDaftarKelas, "preview", "daftarKelas");
                jasperViewer.setVisible(true);
            } else {
                new DaftarKelasReport().previewAndCetakTagihan(listDaftarKelas, "print", "daftarKelas");
                JasperPrintManager.printReport(report, false);
            }
        } catch (Exception ex) {
            Logger.getLogger(TagihanReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
