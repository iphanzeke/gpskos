package com.ivanbiz.test;

import com.ivanbiz.dao.KelasDAO;
import com.ivanbiz.dao.impl.KelasDAOImpl;
import com.ivanbiz.model.Kelas;
import com.ivanbiz.report.DaftarKelasReport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author IW20149X
 */
public class KirimJadwalKelas {

    KelasDAO kelasDAO;
    SimpleDateFormat sdf;
    List<Kelas> listKelas;

    private KirimJadwalKelas() {
    }

    public KirimJadwalKelas(Date dari, Date sampai) {
        try {
            kelasDAO = new KelasDAOImpl();
            sdf = new SimpleDateFormat("dd-MMMM-yyyy");
            listKelas = kelasDAO.getData(dari, sampai);
            String judul = "Dari tanggal " + sdf.format(dari) + " sampai tanggal " + sdf.format(sampai);
            if (!listKelas.isEmpty()) {
                new DaftarKelasReport().previewKelas(listKelas, judul);
            }
        } catch (Exception ex) {
            Logger.getLogger(KirimJadwalKelas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Date dari = new Date();
        Date sampai = new Date();
        sampai.setDate(dari.getDate() + 7);
        KirimJadwalKelas kirimJadwalKelas = new KirimJadwalKelas(dari, sampai);
        System.out.println(kirimJadwalKelas);
    }
}
