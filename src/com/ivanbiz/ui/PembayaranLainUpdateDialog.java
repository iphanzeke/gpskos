/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PengajarUpdateDialog.java
 *
 * Created on 27 Agu 14, 18:59:19
 */
package com.ivanbiz.ui;

import com.ivanbiz.dao.GLAccountDAO;
import com.ivanbiz.dao.PembayaranDAO;
import com.ivanbiz.dao.impl.GLAccountDAOImpl;
import com.ivanbiz.dao.impl.PembayaranDAOImpl;
import com.ivanbiz.model.GLAccount;
import com.ivanbiz.model.Pembayaran;
import com.ivanbiz.service.GlobalSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Shbt Peterpan
 */
public class PembayaranLainUpdateDialog extends JDialog {

    Pembayaran pembayaran;
    GLAccountDAO gLAccountDAO = new GLAccountDAOImpl();
    PembayaranDAO pembayaranDAO = new PembayaranDAOImpl();
    List<GLAccount> listKreditur;
    List<GLAccount> listBiayaLain;
    SimpleDateFormat sdf;

    /**
     * Creates new form PengajarUpdateDialog
     *
     * @param mainFrame
     * @param modal
     */
    public PembayaranLainUpdateDialog(MainFrame mainFrame, boolean modal) {
        initComponents();
        sdf = new SimpleDateFormat("yyMMdd");
        textTransaksiReference.setText(getTransaksiReference());
        renderDebitur();
        renderKreditur();
    }

    public PembayaranLainUpdateDialog(MainFrame mainFrame, boolean modal, Pembayaran pembayaran) {
        initComponents();
        this.pembayaran = pembayaran;
        labelPembayaran.setText("Ubah Pembayaran Lain - Lain");
        renderDebitur();
        comboBoxDebitur.setSelectedItem(pembayaran.getDebitBankAccount().getNameGL() + " A/C No " + pembayaran.getDebitBankAccount().getNoGL());
        renderKreditur();
        comboBoxKreditur.setSelectedItem(pembayaran.getKreditBankAccount().getNameGL() + " A/C No " + pembayaran.getKreditBankAccount().getNoGL());
        textJumlah.setText(String.valueOf(new Double(pembayaran.getJumlah()).intValue()));
        textDeskripsi.setText(pembayaran.getDeskripsi());
        textTransaksiReference.setText(pembayaran.getTransactionReference());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelPembayaran = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        textTransaksiReference = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dateChooserPosting = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textJumlah = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textDeskripsi = new javax.swing.JTextArea();
        comboBoxDebitur = new javax.swing.JComboBox();
        comboBoxKreditur = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        buttonSimpan = new javax.swing.JButton();
        buttonBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        labelPembayaran.setFont(new java.awt.Font("Tahoma", 1, 24));
        labelPembayaran.setText("Tambah Pembayaran Lain - Lain");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setText("Transaksi Reference :");

        textTransaksiReference.setEditable(false);

        jLabel8.setText("Tanggal Pembayaran :");

        dateChooserPosting.setDate(new Date());
        dateChooserPosting.setDateFormatString("dd MMM yyyy");
        dateChooserPosting.setEnabled(false);

        jLabel2.setText("Debitur :");

        jLabel3.setText("Kreditur :");

        jLabel4.setText("Jumlah :");

        textJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textJumlahKeyReleased(evt);
            }
        });

        jLabel5.setText("Deskripsi :");

        textDeskripsi.setColumns(20);
        textDeskripsi.setRows(5);
        jScrollPane1.setViewportView(textDeskripsi);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChooserPosting, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addComponent(textJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addComponent(comboBoxDebitur, 0, 404, Short.MAX_VALUE)
                    .addComponent(comboBoxKreditur, javax.swing.GroupLayout.Alignment.TRAILING, 0, 404, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGap(0, 296, Short.MAX_VALUE))
                    .addComponent(textTransaksiReference, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textTransaksiReference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateChooserPosting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxDebitur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(comboBoxKreditur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        buttonSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/simpan.jpg"))); // NOI18N
        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });
        jPanel2.add(buttonSimpan);

        buttonBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/batal.jpg"))); // NOI18N
        buttonBatal.setText("Batal");
        buttonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionButton(evt);
            }
        });
        jPanel2.add(buttonBatal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPembayaran)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPembayaran)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-466)/2, (screenSize.height-504)/2, 466, 504);
    }// </editor-fold>//GEN-END:initComponents

    private void actionButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionButton
        dispose();
    }//GEN-LAST:event_actionButton

    private void textJumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textJumlahKeyReleased
        try {
            Long.parseLong(textJumlah.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Format salah, harus angka", "warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_textJumlahKeyReleased

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        if (pembayaran == null) {
            pembayaran = new Pembayaran();
        }
        pembayaran.setDateCreated(new Date());
        pembayaran.setStatus("2");
        pembayaran.setPathImage("");
        pembayaran.setTransactionReference(textTransaksiReference.getText());
        pembayaran.setDatePosting(new Date());
        pembayaran.setDebitBankAccount(listKreditur.get(comboBoxDebitur.getSelectedIndex()));
        pembayaran.setKreditBankAccount(listBiayaLain.get(comboBoxKreditur.getSelectedIndex()));
        pembayaran.setJumlah(textJumlah.getText().isEmpty() ? (double) 0 : new Double(textJumlah.getText()));
        pembayaran.setDeskripsi(textDeskripsi.getText());
        validate(pembayaran);
    }//GEN-LAST:event_buttonSimpanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBatal;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JComboBox comboBoxDebitur;
    private javax.swing.JComboBox comboBoxKreditur;
    private com.toedter.calendar.JDateChooser dateChooserPosting;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPembayaran;
    private javax.swing.JTextArea textDeskripsi;
    private javax.swing.JTextField textJumlah;
    private javax.swing.JTextField textTransaksiReference;
    // End of variables declaration//GEN-END:variables

    private void validate(Pembayaran pembayaran) {
        if (pembayaran == null) {
            JOptionPane.showMessageDialog(this, "Pembayaran tidak boleh null");
        } else if (pembayaran.getDebitBankAccount() == null) {
            JOptionPane.showMessageDialog(this, "Debitur tidak boleh kosong");
        } else if (pembayaran.getKreditBankAccount() == null) {
            JOptionPane.showMessageDialog(this, "Kreditur tidak boleh null");
        } else if (pembayaran.getJumlah() == (double) 0) {
            JOptionPane.showMessageDialog(this, "Jumlah tidak boleh kosong");
        } else if (pembayaran.getDeskripsi().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Deskripsi tidak boleh kosong");
        } else {
            try {
                pembayaranDAO.saveOrUpdate(pembayaran);
                dispose();
            } catch (Exception ex) {
                Logger.getLogger(PembayaranLainUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void renderDebitur() {
        try {
            listKreditur = gLAccountDAO.getDataByEquals(GLAccount.class, "groupACC", "Kreditur");
            updateComboKreditur();
        } catch (Exception ex) {
            Logger.getLogger(PembayaranLainUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void renderKreditur() {
        try {
            listBiayaLain = gLAccountDAO.getDataByEquals(GLAccount.class, "groupACC", "BiayaLain");
            updateComboBiayaLain();
        } catch (Exception ex) {
            Logger.getLogger(PembayaranLainUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateComboKreditur() {
        Object data[] = new Object[listKreditur.size()];
        int x = 0;
        for (GLAccount gLAccount : listKreditur) {
            data[x] = gLAccount.getNameGL() + " A/C No " + gLAccount.getNoGL();
            x++;
        }
        comboBoxDebitur.setModel(new DefaultComboBoxModel(data));
    }

    private void updateComboBiayaLain() {
        Object data[] = new Object[listBiayaLain.size()];
        int x = 0;
        for (GLAccount gLAccount : listBiayaLain) {
            data[x] = gLAccount.getNameGL() + " A/C No " + gLAccount.getNoGL();
            x++;
        }
        comboBoxKreditur.setModel(new DefaultComboBoxModel(data));
    }

    private String getTransaksiReference() {
        String noTransaksi = null;
        try {
            noTransaksi = pembayaranDAO.getLastNoTransaksi();
            if (!"".equals(noTransaksi)) {
                String[] splitNoTransaksi = noTransaksi.split("-");
                int count = Integer.parseInt(splitNoTransaksi[2]);
                count += 1;
                if (count > 99999) {
                    noTransaksi = sdf.format(new Date()) + "-PL" + GlobalSession.getPengguna().getKode() + "-" + String.format("%05d", 1);
                } else {
                    noTransaksi = sdf.format(new Date()) + "-PL" + GlobalSession.getPengguna().getKode() + "-" + String.format("%05d", count);
                }
            } else {
                noTransaksi = sdf.format(new Date()) + "-PL" + GlobalSession.getPengguna().getKode() + "-" + String.format("%05d", 1);
            }
        } catch (Exception ex) {
            Logger.getLogger(KelasUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return noTransaksi;
    }
}