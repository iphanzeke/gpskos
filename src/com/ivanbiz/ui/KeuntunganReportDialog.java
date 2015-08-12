/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LaporanJurnalFrame.java
 *
 * Created on Aug 26, 2014, 9:16:34 PM
 */
package com.ivanbiz.ui;

import com.ivanbiz.dao.CashBalanceDAO;
import com.ivanbiz.dao.ReconDAO;
import com.ivanbiz.dao.impl.CashBalanceDAOImpl;
import com.ivanbiz.dao.impl.ReconDAOImpl;
import com.ivanbiz.model.AksesMatrix;
import com.ivanbiz.model.CashBalance;
import com.ivanbiz.model.GLAccount;
import com.ivanbiz.model.Jurnal;
import com.ivanbiz.service.GlobalSession;
import com.ivanbiz.service.MenuAksesConstant;
import com.ivanbiz.service.RenderingKanan;
import com.ivanbiz.service.ServiceHelper;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Shbt Peterpan
 */
public class KeuntunganReportDialog extends javax.swing.JDialog {

    List<Jurnal> listJurnal;
    SimpleDateFormat dateFormat;
    SimpleDateFormat dateFormat1;
    NumberFormat numberFormat;
    CashBalance cashBalance;
    CashBalance cashBalanceSave;
    GLAccount glAccount;

    public KeuntunganReportDialog(GLAccount gLAccount, Date dari, Date sampai) {
        try {
            initComponents();
            renderButtonAkses(GlobalSession.getListAksesMatrix());
            this.glAccount = gLAccount;
            CashBalanceDAO cashBalanceDAO = new CashBalanceDAOImpl();
            cashBalance = cashBalanceDAO.getBalanceByOrderDate(gLAccount.getId());
            numberFormat = NumberFormat.getNumberInstance();
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat1 = new SimpleDateFormat("dd-MMMM-yyyy");
            labelLaporan.setText("Laporan Account " + glAccount.getNameGL());
            jLabelJudul.setText("Dari tanggal " + dateFormat1.format(dari) + " sampai tanggal " + dateFormat1.format(sampai));
            ReconDAO reconDAO = new ReconDAOImpl();
            listJurnal = reconDAO.getDataByDateAndGLAccount(dateFormat.format(dari), dateFormat.format(sampai), gLAccount.getNoGL());
            updateTableKeuntungan();
        } catch (Exception ex) {
            Logger.getLogger(KeuntunganReportDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelLaporan = new javax.swing.JLabel();
        jLabelJudul = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableJurnal = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textFieldKredit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textFieldDebet = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        textFieldKeuntungan = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        textCashBalance = new javax.swing.JTextField();
        buttonTutup = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        textJumlah = new javax.swing.JTextField();

        setAlwaysOnTop(true);
        setModal(true);

        labelLaporan.setFont(new java.awt.Font("Tahoma", 1, 24));
        labelLaporan.setText("Laporan Keuntugan");

        jLabelJudul.setText("Dari Tanggal {} Sampai {}");

        tableJurnal.setAutoCreateRowSorter(true);
        tableJurnal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableJurnal);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Total  Kredit         :");

        textFieldKredit.setEditable(false);
        textFieldKredit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel4.setText("Total Debet          :");

        textFieldDebet.setEditable(false);
        textFieldDebet.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel1.setText("Total Keuntungan :");

        textFieldKeuntungan.setEditable(false);
        textFieldKeuntungan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldKeuntungan, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(textFieldKredit, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(textFieldDebet, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldKredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldDebet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldKeuntungan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(37, 37, 37))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("Saldo Kas              :");

        textCashBalance.setEditable(false);
        textCashBalance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textCashBalance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textCashBalanceKeyReleased(evt);
            }
        });

        buttonTutup.setText("Tutup Saldo Kas");
        buttonTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTutupActionPerformed(evt);
            }
        });

        jLabel6.setText("Jumlah                  :");

        textJumlah.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textJumlahKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textCashBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonTutup)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCashBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonTutup)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
                    .addComponent(jLabelJudul, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
                    .addComponent(labelLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 455, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, 0, 317, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelLaporan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelJudul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-808)/2, (screenSize.height-627)/2, 808, 627);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTutupActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Apakah Tutup Cash Balance ingin diproses ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            if (cashBalanceSave == null) {
                cashBalanceSave = new CashBalance();
            }
            cashBalanceSave.setGlAccount(glAccount);
            cashBalanceSave.setDateBalance(new Date());

            if (textJumlah.getText().contains(",")) {
                textJumlah.setText(textJumlah.getText().replace(",", ""));
            }
            cashBalanceSave.setBalance(textJumlah.getText().isEmpty() ? (double) 0 : new Double(textJumlah.getText()));
            cashBalanceSave.setStatus("0");
            validate(cashBalanceSave);
        }
    }//GEN-LAST:event_buttonTutupActionPerformed

    private void textCashBalanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCashBalanceKeyReleased
        try {
            Long.parseLong(textCashBalance.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Format salah, harus angka", "warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_textCashBalanceKeyReleased

    private void textJumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textJumlahKeyReleased
        try {
            Long.parseLong(textJumlah.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Format salah, harus angka", "warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_textJumlahKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonTutup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelJudul;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelLaporan;
    private javax.swing.JTable tableJurnal;
    private javax.swing.JTextField textCashBalance;
    private javax.swing.JTextField textFieldDebet;
    private javax.swing.JTextField textFieldKeuntungan;
    private javax.swing.JTextField textFieldKredit;
    private javax.swing.JTextField textJumlah;
    // End of variables declaration//GEN-END:variables

    private void updateTableKeuntungan() {
        String[] judul = {"No", "Date Reference", "GL Account", "Currency", "Debet", "Credit"};
        Object[][] isi = new Object[listJurnal.size()][6];
        int x = 0;
        int no = 0;
        double totalDebet = 0;
        double totalKredit = 0;
        double totalKeuntungan;
        double jumlah;
        for (Jurnal jurnal : listJurnal) {
            no += 1;
            isi[x][0] = no;
            isi[x][1] = dateFormat.format(jurnal.getDateReference());
            isi[x][2] = jurnal.getGLAccount();
            isi[x][3] = jurnal.getCurrency();
            isi[x][4] = numberFormat.format(jurnal.getDebit());
            isi[x][5] = numberFormat.format(jurnal.getCredit());
            totalDebet += jurnal.getDebit();
            totalKredit += jurnal.getCredit();
            x++;
        }
        textFieldKredit.setText(numberFormat.format(totalKredit));
        textFieldDebet.setText(numberFormat.format(totalDebet));
        totalKeuntungan = totalKredit - totalDebet;
        textFieldKeuntungan.setText(numberFormat.format(totalKeuntungan));
        textCashBalance.setText(numberFormat.format(cashBalance == null ? new Double("0") : cashBalance.getBalance()));
        jumlah = totalKeuntungan + (cashBalance == null ? new Double("0") : cashBalance.getBalance());
//        textJumlah.setText(String.valueOf(new Double(jumlah).intValue()));
        textJumlah.setText(numberFormat.format(jumlah));
        new ServiceHelper().setAutoRize(isi, judul, tableJurnal);
        tableJurnal.getColumnModel().getColumn(4).setCellRenderer(new RenderingKanan());
        tableJurnal.getColumnModel().getColumn(5).setCellRenderer(new RenderingKanan());
        tableJurnal.getColumnModel().getColumn(4).setWidth(250);
    }

    private void validate(CashBalance cashBalanceSave) {
        if (cashBalanceSave == null) {
            JOptionPane.showMessageDialog(this, "Murid tidak boleh null");
        } else if (cashBalanceSave.getGlAccount() == null) {
            JOptionPane.showMessageDialog(this, "Kreditur tidak boleh kosong");
        } else if (cashBalanceSave.getBalance() == ((double) 0)) {
            JOptionPane.showMessageDialog(this, "Jumlah Tagihan tidak boleh kosong");
        } else {
            try {
                CashBalanceDAO cashBalanceDAO = new CashBalanceDAOImpl();
                if (cashBalanceDAO.validateSameDate(cashBalanceSave.getGlAccount().getId(), cashBalanceSave.getDateBalance())) {
                    JOptionPane.showMessageDialog(this, "Close Balance suda dilakukan untuk tanggal " + dateFormat1.format(cashBalanceSave.getDateBalance()));
                } else {
                    cashBalanceDAO.saveOrUpdate(cashBalanceSave);
                    dispose();
                }
            } catch (Exception ex) {
                Logger.getLogger(KeuntunganReportDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void renderButtonAkses(List<AksesMatrix> listAksesMatrix) {
        buttonTutup.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.TUTUP_SALDO_KAS, listAksesMatrix));
    }
}
