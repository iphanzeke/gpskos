/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PengajarDialog.java
 *
 * Created on Aug 26, 2014, 7:39:37 PM
 */
package com.ivanbiz.ui;

import com.ivanbiz.dao.PembayaranDAO;
import com.ivanbiz.dao.impl.PembayaranDAOImpl;
import com.ivanbiz.model.Pembayaran;
import com.ivanbiz.model.Perusahaan;
import com.ivanbiz.service.GlobalSession;
import com.ivanbiz.service.ServiceHelper;
import java.text.NumberFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Shbt Peterpan
 */
public class PembayaranLainReportDialog extends JDialog {

    PembayaranDAO pembayaranDAO;
    List<Pembayaran> listPembayaran;
    NumberFormat numberFormat;
    Perusahaan perusahaan = GlobalSession.getPerusahaan();
    String sb;

    /**
     * Creates new form PengajarDialog
     */
    public PembayaranLainReportDialog() {
        initComponents();
        pembayaranDAO = new PembayaranDAOImpl();
        numberFormat = NumberFormat.getNumberInstance();
        refresh();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePembayaran = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        buttonPreview = new javax.swing.JButton();

        setAlwaysOnTop(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Laporan Pembayaran Lain - Lain");

        tablePembayaran.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablePembayaran);

        buttonPreview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/preview.jpg"))); // NOI18N
        buttonPreview.setText("Lihat Bukti Pembayaran Terseleksi");
        buttonPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPreviewActionPerformed(evt);
            }
        });
        jPanel2.add(buttonPreview);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(816, 638));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPreviewActionPerformed
        if (tablePembayaran.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Data belum dipilih", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            Pembayaran pembayaran = listPembayaran.get(tablePembayaran.getSelectedRow());
            sb = "ftp://" + perusahaan.getFtpUser() + ":" + perusahaan.getFtpPass() + "@" + perusahaan.getFtpIP() + "/INBOX/" + pembayaran.getPathImage() + ";type=i";
            if (sb.contentEquals(pembayaran.getPathImage())) {
                PembayaranBuktiDialog image = new PembayaranBuktiDialog(null, true, sb, pembayaran, "lihat");
            } else {
                JOptionPane.showMessageDialog(this, "Bukti Pembayaran tidak ada", "warning", JOptionPane.WARNING_MESSAGE);
            }

        }
    }//GEN-LAST:event_buttonPreviewActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPreview;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePembayaran;
    // End of variables declaration//GEN-END:variables

    private void refresh() {
        try {
            listPembayaran = pembayaranDAO.getDataByEquals(Pembayaran.class, "status", "3");
            updateTablePembayaran();
        } catch (Exception ex) {
            Logger.getLogger(GLAccountDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateTablePembayaran() {
        String[] judul = {"No", "Date Posting", "Debitur", "Kreditur", "Jumlah", "Deskripsi"};
        Object[][] isi = new Object[listPembayaran.size()][7];
        int x = 0;
        int no = 0;
        for (Pembayaran pembayarans : listPembayaran) {
            no += 1;
            isi[x][0] = no;
            isi[x][1] = pembayarans.getDatePosting();
            isi[x][2] = pembayarans.getTransactionReference();
            isi[x][3] = pembayarans.getDebitBankAccount().getNameGL() + " A/C NO. " + pembayarans.getDebitBankAccount().getNoGL();
            isi[x][4] = pembayarans.getDebitBankAccount().getNameGL() + " A/C NO. " + pembayarans.getDebitBankAccount().getNoGL();
            isi[x][5] = numberFormat.format(pembayarans.getJumlah());
            isi[x][6] = pembayarans.getDeskripsi();
            x++;
        }
        new ServiceHelper().setAutoRize(isi, judul, tablePembayaran);
    }
}
