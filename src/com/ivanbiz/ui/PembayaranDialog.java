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
import com.ivanbiz.model.AksesMatrix;
import com.ivanbiz.model.Pembayaran;
import com.ivanbiz.service.GlobalSession;
import com.ivanbiz.service.MenuAksesConstant;
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
public class PembayaranDialog extends JDialog {

    PembayaranDAO pembayaranDAO;
    List<Pembayaran> listPembayaran;
    Pembayaran pembayaran;
    NumberFormat numberFormat;

    /**
     * Creates new form PengajarDialog
     */
    public PembayaranDialog() {
        initComponents();
        pembayaranDAO = new PembayaranDAOImpl();
        renderButtonAkses(GlobalSession.getListAksesMatrix());
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
        tablePembayaran = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        buttonTambah = new javax.swing.JButton();
        buttonUbah = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();

        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Daftar Pembayaran");

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

        buttonTambah.setText("Tambah Pembayaran Baru");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });
        jPanel2.add(buttonTambah);

        buttonUbah.setText("Ubah Pembayaran Terseleksi");
        buttonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahActionPerformed(evt);
            }
        });
        jPanel2.add(buttonUbah);

        buttonHapus.setText("Hapus Pembayaran Terseleksi");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });
        jPanel2.add(buttonHapus);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(816, 638));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahActionPerformed
        if (tablePembayaran.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan diubah", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                pembayaran = listPembayaran.get(tablePembayaran.getSelectedRow());
                new PembayaranUpdateDialog(null, true, pembayaran).setVisible(true);
                refresh();
            } catch (Exception ex) {
                Logger.getLogger(PembayaranDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonUbahActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        if (tablePembayaran.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                pembayaran = listPembayaran.get(tablePembayaran.getSelectedRow());
                pembayaranDAO.delete(pembayaran);
                refresh();
            } catch (Exception ex) {
                Logger.getLogger(PembayaranDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        new PembayaranUpdateDialog(null, true).setVisible(true);
        refresh();
    }//GEN-LAST:event_buttonTambahActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePembayaran;
    // End of variables declaration//GEN-END:variables

    private void refresh() {
        try {
            listPembayaran = pembayaranDAO.getDataByEquals(Pembayaran.class, "status", "0");
            updateTablePembayaran();
        } catch (Exception ex) {
            Logger.getLogger(GLAccountDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateTablePembayaran() {
        String[] judul = {"No", "Date Posting", "No Tagihan / Invoice", "Debitur", "Kreditur", "Jumlah", "Deskripsi"};
        Object[][] isi = new Object[listPembayaran.size()][7];
        int x = 0;
        int no = 0;
        for (Pembayaran pembayaran : listPembayaran) {
//            if (pembayaran.getTransactionReference().trim().isEmpty()) {
            no += 1;
            isi[x][0] = no;
            isi[x][1] = pembayaran.getDatePosting();
            isi[x][2] = pembayaran.getInvoice().getNII();
            isi[x][3] = pembayaran.getDebitBankAccount().getNameGL() + " A/C NO. " + pembayaran.getDebitBankAccount().getNoGL();
            isi[x][4] = pembayaran.getDebitBankAccount().getNameGL() + " A/C NO. " + pembayaran.getDebitBankAccount().getNoGL();
            isi[x][5] = numberFormat.format(pembayaran.getJumlah());
            isi[x][6] = pembayaran.getDeskripsi();
//            }
            x++;
        }
        new ServiceHelper().setAutoRize(isi, judul, tablePembayaran);
    }

    private void renderButtonAkses(List<AksesMatrix> listAksesMatrix) {
        buttonTambah.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.TAMBAH_PEMBAYARAN_TAGIHAN, listAksesMatrix));
        buttonUbah.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.UBAH_PEMBAYARAN_TAGIHAN, listAksesMatrix));
        buttonHapus.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.HAPUS_PEMBAYARAN_TAGIHAN, listAksesMatrix));
    }
}
