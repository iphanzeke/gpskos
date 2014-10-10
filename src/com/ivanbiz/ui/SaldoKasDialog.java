/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.ui;

import com.ivanbiz.dao.CashBalanceDAO;
import com.ivanbiz.dao.impl.CashBalanceDAOImpl;
import com.ivanbiz.model.AksesMatrix;
import com.ivanbiz.model.CashBalance;
import com.ivanbiz.service.GlobalSession;
import com.ivanbiz.service.MenuAksesConstant;
import com.ivanbiz.service.ServiceHelper;
import java.text.NumberFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Shbt Peterpan
 */
public class SaldoKasDialog extends javax.swing.JDialog {

    CashBalance cashBalance;
    CashBalanceDAO cashBalanceDAO;
    List<CashBalance> listCashBalance;
    NumberFormat numberFormat;

    public SaldoKasDialog() {
        initComponents();
        buttonProses.setVisible(false);
        buttonUbah.setVisible(false);
        cashBalanceDAO = new CashBalanceDAOImpl();
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
        tableSaldoKas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        buttonTambah = new javax.swing.JButton();
        buttonUbah = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();
        buttonProses = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Daftar Saldo Kas");

        tableSaldoKas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableSaldoKas);

        buttonTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/tambah.jpg"))); // NOI18N
        buttonTambah.setText("Tambah Saldo Kas Baru");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });
        jPanel1.add(buttonTambah);

        buttonUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/ubah.jpg"))); // NOI18N
        buttonUbah.setText("Ubah Saldo Kas Terseleksi");
        buttonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahActionPerformed(evt);
            }
        });
        jPanel1.add(buttonUbah);

        buttonHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/hapus.jpg"))); // NOI18N
        buttonHapus.setText("Hapus Saldo Kas Terseleksi");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });
        jPanel1.add(buttonHapus);

        buttonProses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/process.jpg"))); // NOI18N
        buttonProses.setText("Proses Saldo Kas Terseleksi");
        buttonProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProsesActionPerformed(evt);
            }
        });
        jPanel1.add(buttonProses);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(808, 627));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        new SaldoKasUpdateDialog(null, true).setVisible(true);
        refresh();
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void buttonUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahActionPerformed
        if (tableSaldoKas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan diubah", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            cashBalance = listCashBalance.get(tableSaldoKas.getSelectedRow());
            new SaldoKasUpdateDialog(null, true, cashBalance).setVisible(true);
            refresh();
        }
    }//GEN-LAST:event_buttonUbahActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        if (tableSaldoKas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                cashBalance = listCashBalance.get(tableSaldoKas.getSelectedRow());
                cashBalanceDAO.delete(cashBalance);
                refresh();
            } catch (Exception ex) {
                Logger.getLogger(SaldoKasDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void buttonProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProsesActionPerformed
        if (tableSaldoKas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan diproses", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            cashBalance = listCashBalance.get(tableSaldoKas.getSelectedRow());
            refresh();
        }
    }//GEN-LAST:event_buttonProsesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonProses;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSaldoKas;
    // End of variables declaration//GEN-END:variables

    private void refresh() {
        try {
            listCashBalance = cashBalanceDAO.getDataByEquals(CashBalance.class, "status", "1");
            updateTableSaldoKas();
        } catch (Exception ex) {
            Logger.getLogger(SaldoKasDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateTableSaldoKas() {
        String[] judul = {"No", "Tanggal", "GL Account", "Jumlah"};
        Object[][] isi = new Object[listCashBalance.size()][4];
        int x = 0;
        int no = 0;
        for (CashBalance cashBalances : listCashBalance) {
            no += 1;
            isi[x][0] = no;
            isi[x][1] = cashBalances.getDateBalance();
            isi[x][2] = cashBalances.getGlAccount().getNameGL() + " A/C No. " + cashBalances.getGlAccount().getNoGL();
            isi[x][3] = cashBalances.getBalance();
            x++;
        }
        new ServiceHelper().setAutoRize(isi, judul, tableSaldoKas);

    }

    private void renderButtonAkses(List<AksesMatrix> listAksesMatrix) {
        buttonTambah.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.TAMBAH_SALDO_KAS, listAksesMatrix));
        buttonUbah.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.UBAH_SALDO_KAS, listAksesMatrix));
        buttonHapus.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.HAPUS_SALDO_KAS, listAksesMatrix));
        buttonHapus.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.PROSES_SALDO_KAS, listAksesMatrix));
    }
}
