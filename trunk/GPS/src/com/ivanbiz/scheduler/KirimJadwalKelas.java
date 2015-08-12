package com.ivanbiz.scheduler;

import com.ivanbiz.dao.KelasDAO;
import com.ivanbiz.dao.PenggunaDAO;
import com.ivanbiz.dao.PerusahaanDAO;
import com.ivanbiz.dao.impl.KelasDAOImpl;
import com.ivanbiz.dao.impl.PenggunaDAOImpl;
import com.ivanbiz.dao.impl.PerusahaanDAOImpl;
import com.ivanbiz.model.Kelas;
import com.ivanbiz.model.Pengguna;
import com.ivanbiz.model.Perusahaan;
import com.ivanbiz.report.DaftarKelasReport;
import com.ivanbiz.service.Email;
import com.ivanbiz.service.GlobalSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

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
    PerusahaanDAO perusahaanDAO;
    PenggunaDAO penggunaDAO;

    public static void main(String[] args) {
        Date dari = new Date();
        Date sampai = new Date();
        sampai.setDate(dari.getDate() + 7);
        KirimJadwalKelas kirimJadwalKelas = new KirimJadwalKelas(dari, sampai);
    }

    public KirimJadwalKelas(Date dari, Date sampai) {
        try {
            kelasDAO = new KelasDAOImpl();
            sdf = new SimpleDateFormat("dd-MMMM-yyyy");
            listKelas = kelasDAO.getData(dari, sampai);
            String judul = "Dari tanggal " + sdf.format(dari) + " sampai tanggal " + sdf.format(sampai);
            if (!listKelas.isEmpty()) {
                perusahaanDAO = new PerusahaanDAOImpl();
                penggunaDAO = new PenggunaDAOImpl();
                List<Perusahaan> listPerusahaan = perusahaanDAO.getAll(Perusahaan.class);
                for (Perusahaan perusahaan : listPerusahaan) {
                    GlobalSession.setPerusahaan(perusahaan);
                    List<Pengguna> listGroups = penggunaDAO.getDataByGroups("Admin");
                    String emails = "";
                    String namas = "";
                    for (Pengguna pengguna : listGroups) {
                        if (pengguna.getEmail() != null) {
                            emails += pengguna.getEmail() + ",";
                            namas += pengguna.getUserName() + ",";
                        }
                    }
                    DaftarKelasReport daftarKelasReport = new DaftarKelasReport();
                    daftarKelasReport.previewKelas(listKelas, judul);
                    File file = daftarKelasReport.getReportFile();
                    if (!file.exists()) {
                        Logger.getLogger(KirimJadwalKelas.class.getName()).log(Level.SEVERE, null, "File gagal dibuat");
                    } else if (perusahaan.getEmail().isEmpty()) {
                        Logger.getLogger(KirimJadwalKelas.class.getName()).log(Level.SEVERE, null, "Email Perusahaan kosong");
                    } else if (emails.isEmpty()) {
                        Logger.getLogger(KirimJadwalKelas.class.getName()).log(Level.SEVERE, null, "Email Pengajar kosong");
                    } else {
                        try {
                            Email email = new Email();
                            String password = perusahaan.getPassEmail();
                            String from = perusahaan.getEmail();
                            String to = emails;
                            String subject = "Daftar Kelas " + judul;
                            String message = "Kepada Yth " + namas + "\n\n" + "Detail Kelas " + judul + " terlampir. \n\n\n" + "Terimakasih\n\n" + perusahaan.getNama();
                            String[] attachments = {file.getAbsolutePath()};
                            email.sendMail(from, password, from, to, subject, message, attachments);
                            Logger.getLogger(KirimJadwalKelas.class.getName()).log(Level.SEVERE, null, "Jadwal sudah dikirim");
                        } catch (MessagingException ex) {
                            Logger.getLogger(KirimJadwalKelas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(KirimJadwalKelas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
