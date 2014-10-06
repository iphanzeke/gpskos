/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BankUpdateDialog.java
 *
 * Created on 10 Sep 14, 20:18:30
 */
package com.ivanbiz.ui;

import com.ivanbiz.dao.BankDAO;
import com.ivanbiz.dao.impl.BankDAOImpl;
import com.ivanbiz.model.Bank;
import com.ivanbiz.service.JTextFieldLimit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Shbt Peterpan
 */
public class BankUpdateDialog extends javax.swing.JDialog {

    Bank bank;
    BankDAO bankDAO = new BankDAOImpl();

    /**
     * Creates new form BankUpdateDialog
     *
     * @param parent
     * @param modal
     */
    public BankUpdateDialog(MainFrame parent, boolean modal) {
        initComponents();
    }

    public BankUpdateDialog(MainFrame parent, boolean modal, Bank bank) {
        initComponents();
        this.bank = bank;
        textNama.setText(bank.getNama());
        textDeskripsi.setText(bank.getDeskripsi());
        labelBank.setText("Ubah Data Bank");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelBank = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textDeskripsi = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        buttonSimpan = new javax.swing.JButton();
        buttonBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        labelBank.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelBank.setText("Tambah Bank Baru");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Nama :");

        textNama.setDocument(new JTextFieldLimit(100));

        jLabel3.setText("Deskripsi :");

        textDeskripsi.setDocument(new JTextFieldLimit(100));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(textNama, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(textDeskripsi, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        buttonSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/simpan.jpg"))); // NOI18N
        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });
        jPanel8.add(buttonSimpan);

        buttonBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/batal.jpg"))); // NOI18N
        buttonBatal.setText("Batal");
        buttonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBatalActionPerformed(evt);
            }
        });
        jPanel8.add(buttonBatal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelBank, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelBank)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(408, 240));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        if (bank == null) {
            bank = new Bank();
        }
        bank.setNama(textNama.getText());
        bank.setDeskripsi(textDeskripsi.getText());
        validate(bank);
}//GEN-LAST:event_buttonSimpanActionPerformed

    private void buttonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBatalActionPerformed
        dispose();
}//GEN-LAST:event_buttonBatalActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBatal;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel labelBank;
    private javax.swing.JTextField textDeskripsi;
    private javax.swing.JTextField textNama;
    // End of variables declaration//GEN-END:variables

    private void validate(Bank bank) {
        if (bank == null) {
            JOptionPane.showMessageDialog(this, "Bank tidak boleh null");
        } else if (bank.getNama() == null) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh null");
        } else if (bank.getNama().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong");
        } else if (bank.getDeskripsi() == null) {
            JOptionPane.showMessageDialog(this, "Deskripsi tidak boleh null");
        } else if (bank.getDeskripsi().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Deskripsi tidak boleh kosong");
        } else {
            try {
                bankDAO.saveOrUpdate(bank);
                dispose();
            } catch (Exception ex) {
                Logger.getLogger(BankUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
