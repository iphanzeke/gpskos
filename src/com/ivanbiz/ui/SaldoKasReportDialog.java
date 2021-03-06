/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.ui;

import com.ivanbiz.dao.CashBalanceDAO;
import com.ivanbiz.dao.impl.CashBalanceDAOImpl;
import com.ivanbiz.model.CashBalance;
import com.ivanbiz.service.RenderingKanan;
import com.ivanbiz.service.ServiceHelper;
import java.text.NumberFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shbt Peterpan
 */
public class SaldoKasReportDialog extends javax.swing.JDialog {

    CashBalance cashBalance;
    CashBalanceDAO cashBalanceDAO;
    List<CashBalance> listCashBalance;
    NumberFormat numberFormat;

    public SaldoKasReportDialog() {
        initComponents();
        cashBalanceDAO = new CashBalanceDAOImpl();
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
        tableSaldoKas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("Laporan Saldo Kas");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-816)/2, (screenSize.height-638)/2, 816, 638);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSaldoKas;
    // End of variables declaration//GEN-END:variables

    private void refresh() {
        try {
            listCashBalance = cashBalanceDAO.getAll(CashBalance.class);
            updateTableSaldoKas();
        } catch (Exception ex) {
            Logger.getLogger(SaldoKasReportDialog.class.getName()).log(Level.SEVERE, null, ex);
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
            isi[x][3] = numberFormat.format(cashBalances.getBalance());
            x++;
        }
        new ServiceHelper().setAutoRize(isi, judul, tableSaldoKas);
        tableSaldoKas.getColumnModel().getColumn(3).setCellRenderer(new RenderingKanan());

    }
}
