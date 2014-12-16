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
import com.ivanbiz.service.ServiceHelper;
import java.text.NumberFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Shbt Peterpan
 */
public class TransferKrediturToKrediturReportDialog extends JDialog {

    PembayaranDAO pembayaranDAO;
    List<Pembayaran> listPembayaran;
    Pembayaran pembayaran;
    NumberFormat numberFormat;

    /**
     * Creates new form PengajarDialog
     */
    public TransferKrediturToKrediturReportDialog() {
        initComponents();
        pembayaranDAO = new PembayaranDAOImpl();
        numberFormat = NumberFormat.getCurrencyInstance();
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
        tableTransfer = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        buttonTambah = new javax.swing.JButton();
        buttonUbah = new javax.swing.JButton();

        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Daftar Transfer Kreditur ke Kreditur");

        tableTransfer.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableTransfer);

        buttonTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/tambah.jpg"))); // NOI18N
        buttonTambah.setText("Lihat Laporan Terseleksi");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });
        jPanel2.add(buttonTambah);

        buttonUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/ubah.jpg"))); // NOI18N
        buttonUbah.setText("Cetak Laporan Terseleksi");
        buttonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahActionPerformed(evt);
            }
        });
        jPanel2.add(buttonUbah);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE))
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

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-916)/2, (screenSize.height-638)/2, 916, 638);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahActionPerformed
        if (tableTransfer.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan diubah", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                pembayaran = listPembayaran.get(tableTransfer.getSelectedRow());
                new PembayaranLainUpdateDialog(null, true, pembayaran).setVisible(true);
                refresh();
            } catch (Exception ex) {
                Logger.getLogger(TransferKrediturToKrediturReportDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}//GEN-LAST:event_buttonUbahActionPerformed

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        new PembayaranLainUpdateDialog(null, true).setVisible(true);
        refresh();
}//GEN-LAST:event_buttonTambahActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonTambah;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableTransfer;
    // End of variables declaration//GEN-END:variables

    private void refresh() {
        try {
            listPembayaran = pembayaranDAO.getDataByEquals(Pembayaran.class, "status", "2");
            updateTablePembayaran();
        } catch (Exception ex) {
            Logger.getLogger(GLAccountDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateTablePembayaran() {
        String[] judul = {"No", "Date Posting", "From", "To", "Jumlah", "Deskripsi"};
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
        new ServiceHelper().setAutoRize(isi, judul, tableTransfer);
    }
}
