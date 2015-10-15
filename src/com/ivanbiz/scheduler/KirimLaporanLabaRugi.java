/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.scheduler;

import com.ivanbiz.dao.CashBalanceDAO;
import com.ivanbiz.dao.GLAccountDAO;
import com.ivanbiz.dao.JurnalDAO;
import com.ivanbiz.dao.PenggunaDAO;
import com.ivanbiz.dao.PerusahaanDAO;
import com.ivanbiz.dao.impl.CashBalanceDAOImpl;
import com.ivanbiz.dao.impl.GLAccountDAOImpl;
import com.ivanbiz.dao.impl.JurnalDAOImpl;
import com.ivanbiz.dao.impl.PenggunaDAOImpl;
import com.ivanbiz.dao.impl.PerusahaanDAOImpl;
import com.ivanbiz.model.CashBalance;
import com.ivanbiz.model.GLAccount;
import com.ivanbiz.model.Pengguna;
import com.ivanbiz.model.Perusahaan;
import com.ivanbiz.report.LabaRugiReport;
import com.ivanbiz.service.Email;
import com.ivanbiz.service.GlobalSession;
import com.ivanbiz.ui.DaftarKelasReportDialog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author IW20149X
 */
public class KirimLaporanLabaRugi {

    PenggunaDAO penggunaDAO;
    PerusahaanDAO perusahaanDAO;
    SimpleDateFormat dateFormat;
    List<GLAccount> listGLAccountKreditur;
    List<GLAccount> listGLAccountBiayaLain;
    List<GLAccount> listPendapatan;
    GLAccountDAO gLAccountDAO;
    double totalKredit;
    double totalBalance;
    double biayalain;
    CashBalance cashBalance;
    CashBalanceDAO cashBalanceDAO;
    JurnalDAO jurnalDAO;
    SimpleDateFormat formatDate;

    public static void main(String[] args) {
        Date dari = new Date();
        dari.setDate(dari.getDate() - 7);
        Date sampai = new Date();
        KirimLaporanLabaRugi kirimLaporanLabaRugi = new KirimLaporanLabaRugi(dari, sampai);
    }

    private KirimLaporanLabaRugi(Date dari, Date sampai) {
        try {
            jurnalDAO = new JurnalDAOImpl();
            cashBalanceDAO = new CashBalanceDAOImpl();
            gLAccountDAO = new GLAccountDAOImpl();
            formatDate = new SimpleDateFormat("yyyy-MM-dd");
            listGLAccountBiayaLain = gLAccountDAO.getDataByEquals(GLAccount.class, "groupACC", "BiayaLain");
            listGLAccountKreditur = gLAccountDAO.getDataByEquals(GLAccount.class, "groupACC", "Kreditur");
            updateTablePendapatan(dari, sampai);
            updateTablePengeluaran(dari, sampai);
            sentEmail(dari, sampai);
        } catch (Exception ex) {
            Logger.getLogger(KirimLaporanLabaRugi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateTablePendapatan(Date dariTanggal, Date sampaiTanggal) throws Exception {
        totalKredit = 0;
        totalBalance = 0;
        for (GLAccount gLAccount : listGLAccountKreditur) {
            if (!gLAccount.getNameGL().startsWith("KAS")) {
                cashBalance = cashBalanceDAO.getBalanceByOrderDate(gLAccount.getId());
                totalKredit += jurnalDAO.getSumCreditGLAccount(formatDate.format(dariTanggal), formatDate.format(sampaiTanggal), gLAccount.getNoGL());
                totalBalance += cashBalance == null ? new Double("0") : cashBalance.getBalance();
                GLAccount glAccount = new GLAccount();
                glAccount = gLAccount;
                glAccount.setCashBalance(cashBalance == null ? new Double("0") : cashBalance.getBalance());
                glAccount.setJumlah(jurnalDAO.getSumCreditGLAccount(formatDate.format(dariTanggal), formatDate.format(sampaiTanggal), gLAccount.getNoGL()));
                listPendapatan.add(glAccount);
            } else {
                listGLAccountBiayaLain.add(gLAccount);
            }
        }
    }

    private void updateTablePengeluaran(Date dariTanggal, Date sampaiTanggal) throws Exception {
        biayalain = 0;
        for (GLAccount gLAccount : listGLAccountBiayaLain) {
            gLAccount.setJumlah(jurnalDAO.getSumCreditGLAccount(formatDate.format(dariTanggal), formatDate.format(sampaiTanggal), gLAccount.getNoGL()));
            biayalain += jurnalDAO.getSumCreditGLAccount(formatDate.format(dariTanggal), formatDate.format(sampaiTanggal), gLAccount.getNoGL());
        }
    }

    private void sentEmail(Date dariTanggal, Date sampaiTanggal) {
        try {
            penggunaDAO = new PenggunaDAOImpl();
            List<Pengguna> listGroups = penggunaDAO.getDataByGroups("Admin");
            String emails = "";
            String nama = "";
            for (Pengguna pengguna : listGroups) {
                if (pengguna.getEmail() != null) {
                    emails += pengguna.getEmail() + ",";
                    nama += pengguna.getUserName() + ",";
                }
            }
            perusahaanDAO = new PerusahaanDAOImpl();
            List<Perusahaan> listPerusahaan = perusahaanDAO.getAll(Perusahaan.class);
            for (Perusahaan perusahaan : listPerusahaan) {
                GlobalSession.setPerusahaan(perusahaan);
            }
            Perusahaan perusahaan = GlobalSession.getPerusahaan();
            dateFormat = new SimpleDateFormat("dd-MMM-yy");
            LabaRugiReport labaRugiReport = new LabaRugiReport();
            String judul = "Dari tanggal " + dateFormat.format(dariTanggal) + " sampai tanggal " + dateFormat.format(sampaiTanggal);
            labaRugiReport.getLabaRugiReport(listPendapatan, listGLAccountBiayaLain, totalKredit, totalBalance, biayalain, judul);
            File file = labaRugiReport.getReportFile();
            if (!file.exists()) {
                Logger.getLogger(DaftarKelasReportDialog.class.getName()).log(Level.SEVERE, null, "File gagal dibuat");
            } else if (perusahaan.getEmail().isEmpty()) {
                Logger.getLogger(DaftarKelasReportDialog.class.getName()).log(Level.SEVERE, null, "Email Perusahaan kosong");
            } else if (emails.isEmpty()) {
                Logger.getLogger(DaftarKelasReportDialog.class.getName()).log(Level.SEVERE, null, "Email Pengajar kosong");
            } else {
                try {
                    Email email = new Email();
                    String password = perusahaan.getPassEmail();
                    String from = perusahaan.getEmail();
                    String to = emails;
                    String subject = "Laporan Laba Rugi " + judul;
                    String message = "Kepada Yth " + nama + "\n\n" + "Laporan Laba Rugi anda " + judul + " terlampir. \n\n\n" + "Terimakasih\n\n" + perusahaan.getNama();
                    String[] attachments = {file.getAbsolutePath()};
                    email.sendMail(from, password, from, to, subject, message, attachments);
                    Logger.getLogger(KirimLaporanLabaRugi.class.getName()).log(Level.SEVERE, null, "Laporan sudah dikirim");
                } catch (MessagingException ex) {
                    Logger.getLogger(DaftarKelasReportDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(KirimLaporanLabaRugi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
