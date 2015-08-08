/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LabaRugiReportDialog.java
 *
 * Created on Aug 7, 2015, 1:53:25 PM
 */
package com.ivanbiz.ui;

import com.ivanbiz.dao.CashBalanceDAO;
import com.ivanbiz.dao.GLAccountDAO;
import com.ivanbiz.dao.JurnalDAO;
import com.ivanbiz.dao.impl.CashBalanceDAOImpl;
import com.ivanbiz.dao.impl.GLAccountDAOImpl;
import com.ivanbiz.dao.impl.JurnalDAOImpl;
import com.ivanbiz.model.CashBalance;
import com.ivanbiz.model.GLAccount;
import com.ivanbiz.model.Pengguna;
import com.ivanbiz.model.Perusahaan;
import com.ivanbiz.service.Email;
import com.ivanbiz.service.GlobalSession;
import com.ivanbiz.service.ServiceHelper;
import java.io.File;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;

/**
 *
 * @author IW20149X
 */
public class LabaRugiReportDialog extends javax.swing.JDialog {

    JurnalDAO jurnalDAO;
    List<GLAccount> listGLAccountKreditur;
    List<GLAccount> listGLAccountBiayaLain;
    NumberFormat numberFormat;
    GLAccountDAO gLAccountDAO;
    SimpleDateFormat dateFormat;
    SimpleDateFormat formatDate;
    Date dariTanggal;
    Date sampaiTanggal;
    CashBalanceDAO cashBalanceDAO;
    CashBalance cashBalance;

    LabaRugiReportDialog(Date dariTanggal, Date sampaiTanggal) {
        try {
            initComponents();
            listGLAccountBiayaLain = new ArrayList<GLAccount>();
            this.dariTanggal = dariTanggal;
            this.sampaiTanggal = sampaiTanggal;
            jurnalDAO = new JurnalDAOImpl();
            cashBalanceDAO = new CashBalanceDAOImpl();
            gLAccountDAO = new GLAccountDAOImpl();
            dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
            formatDate = new SimpleDateFormat("yyyy-MM-dd");
            numberFormat = NumberFormat.getNumberInstance();
            jLabelJudul.setText("Dari tanggal " + dateFormat.format(dariTanggal) + " sampai tanggal " + dateFormat.format(sampaiTanggal));
            listGLAccountBiayaLain = gLAccountDAO.getDataByEquals(GLAccount.class, "groupACC", "BiayaLain");
            listGLAccountKreditur = gLAccountDAO.getDataByEquals(GLAccount.class, "groupACC", "Kreditur");
            updateTablePendapatan();
            updateTablePengeluaran();
        } catch (Exception ex) {
            Logger.getLogger(LabaRugiReportDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabelJudul = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePendapatan = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePengeluaran = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        textTotalPendapatan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        textTotalCashBalance = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        buttonEmail = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        textTotalCashBalanceAndPendapatan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textTotalPengeluaran = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel3.setText("Laporan Laba Rugi");

        jLabelJudul.setText("Dari Tanggal {} Sampai {}");

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        tablePendapatan.setAutoCreateRowSorter(true);
        tablePendapatan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablePendapatan);

        jPanel2.add(jScrollPane1);

        tablePengeluaran.setAutoCreateRowSorter(true);
        tablePengeluaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablePengeluaran);

        jPanel2.add(jScrollPane3);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setText("Pendapatan :");
        jPanel3.add(jLabel1);

        jLabel2.setText("Pengeluaran :");
        jPanel3.add(jLabel2);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jLabel4.setText("Total Pendapatan :");
        jPanel1.add(jLabel4);
        jPanel1.add(textTotalPendapatan);
        jPanel1.add(jLabel7);
        jPanel1.add(jLabel8);

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jLabel6.setText("Total Cash Balance :");
        jPanel4.add(jLabel6);
        jPanel4.add(textTotalCashBalance);
        jPanel4.add(jLabel11);
        jPanel4.add(jLabel10);

        buttonEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/transfer.jpg"))); // NOI18N
        buttonEmail.setText("Email");
        buttonEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEmailActionPerformed(evt);
            }
        });
        jPanel6.add(buttonEmail);

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(new java.awt.GridLayout());

        jLabel5.setText("Total Cash Balance + Pendapatan :");
        jPanel5.add(jLabel5);
        jPanel5.add(textTotalCashBalanceAndPendapatan);

        jLabel9.setText("Total Pengeluaran");
        jPanel5.add(jLabel9);
        jPanel5.add(textTotalPengeluaran);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(jLabelJudul, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelJudul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-816)/2, (screenSize.height-638)/2, 816, 638);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEmailActionPerformed
        List<Pengguna> listGroups = GlobalSession.getListGroups();
        String emails = "";
        String nama = "";
        for (Pengguna pengguna : listGroups) {
            if (pengguna.getEmail() != null) {
                emails += pengguna.getEmail() + ",";
                nama += pengguna.getUserName() + ",";
            }
        }
        Perusahaan perusahaan = GlobalSession.getPerusahaan();
        dateFormat = new SimpleDateFormat("dd-MMM-yy");
        laporan();
        File file = new File(System.getProperty("user.dir") + "\\report\\Kelas_" + dateFormat.format(new Date()) + ".pdf");
        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "file gagal dibuat");
        } else if (perusahaan.getEmail().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Email Perusahaan kosong");
        } else if (emails.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Email Pengajar kosong");
        } else {
            try {
                Email email = new Email();
                String password = perusahaan.getPassEmail();
                String from = perusahaan.getEmail();
                String to = emails;
                String subject = "Daftar Kelas " + jLabelJudul.getText();
                String message = "Kepada Yth " + nama + "\n\n" + "Laporan Laba Rugi anda " + jLabelJudul.getText() + " terlampir. \n\n\n" + "Terimakasih\n\n" + perusahaan.getNama();
                String[] attachments = {file.getAbsolutePath()};
                email.sendMail(from, password, from, to, subject, message, attachments);
                file.delete();
                JOptionPane.showMessageDialog(rootPane, "Laporan sudah dikirim");
            } catch (MessagingException ex) {
                Logger.getLogger(DaftarKelasReportDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonEmailActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelJudul;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablePendapatan;
    private javax.swing.JTable tablePengeluaran;
    private javax.swing.JTextField textTotalCashBalance;
    private javax.swing.JTextField textTotalCashBalanceAndPendapatan;
    private javax.swing.JTextField textTotalPendapatan;
    private javax.swing.JTextField textTotalPengeluaran;
    // End of variables declaration//GEN-END:variables

    private void updateTablePendapatan() throws Exception {
        String[] judul = {"No", "No GL", "Nama GL", "Jumlah", "Cash Balance"};
        Object[][] isi = new Object[listGLAccountKreditur.size()][5];
        int x = 0;
        int no = 0;
        double totalKredit = 0;
        double totalBalance = 0;
        for (GLAccount gLAccount : listGLAccountKreditur) {
            if (!gLAccount.getNameGL().startsWith("KAS")) {
                no += 1;
                isi[x][0] = no;
                isi[x][1] = gLAccount.getNoGL();
                isi[x][2] = gLAccount.getNameGL();
                isi[x][3] = numberFormat.format(jurnalDAO.getSumCreditGLAccount(formatDate.format(dariTanggal), formatDate.format(sampaiTanggal), gLAccount.getNoGL()));
                cashBalance = cashBalanceDAO.getBalanceByOrderDate(gLAccount.getId());
                isi[x][4] = numberFormat.format(cashBalance == null ? new Double("0") : cashBalance.getBalance());
                totalKredit += jurnalDAO.getSumCreditGLAccount(formatDate.format(dariTanggal), formatDate.format(sampaiTanggal), gLAccount.getNoGL());
                totalBalance += cashBalance.getBalance();
            } else {
                listGLAccountBiayaLain.add(gLAccount);
            }
            x++;
        }
        textTotalPendapatan.setText(numberFormat.format(totalKredit));
        textTotalCashBalance.setText(numberFormat.format(totalBalance));
        textTotalCashBalanceAndPendapatan.setText(numberFormat.format(totalBalance + totalKredit));
        new ServiceHelper().setAutoRize(isi, judul, tablePendapatan);
    }

    private void updateTablePengeluaran() throws Exception {
        String[] judul = {"No", "No GL", "Nama GL", "Jumlah"};
        Object[][] isi = new Object[listGLAccountBiayaLain.size()][4];
        int x = 0;
        int no = 0;
        double biayalain = 0;
        for (GLAccount gLAccount : listGLAccountBiayaLain) {
            no += 1;
            isi[x][0] = no;
            isi[x][1] = gLAccount.getNoGL();
            isi[x][2] = gLAccount.getNameGL();
            isi[x][3] = numberFormat.format(jurnalDAO.getSumCreditGLAccount(formatDate.format(dariTanggal), formatDate.format(sampaiTanggal), gLAccount.getNoGL()));
            biayalain += jurnalDAO.getSumCreditGLAccount(formatDate.format(dariTanggal), formatDate.format(sampaiTanggal), gLAccount.getNoGL());
            x++;
        }
        textTotalPengeluaran.setText(numberFormat.format(biayalain));
        new ServiceHelper().setAutoRize(isi, judul, tablePengeluaran);
    }

    private void laporan() {
        
    }
}
