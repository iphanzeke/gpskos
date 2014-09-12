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

import com.ivanbiz.dao.BankDAO;
import com.ivanbiz.dao.MuridDAO;
import com.ivanbiz.dao.impl.BankDAOImpl;
import com.ivanbiz.dao.impl.MuridDAOImpl;
import com.ivanbiz.model.Bank;
import com.ivanbiz.model.Murid;
import com.ivanbiz.service.JTextFieldLimit;
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
public class MuridUpdateDialog extends JDialog {

    Murid murid;
    MuridDAO muridDAO = new MuridDAOImpl();
    BankDAO bankDAO = new BankDAOImpl();
    List<Bank> listBank;

    /**
     * Creates new form PengajarUpdateDialog
     *
     * @param mainFrame
     * @param modal
     */
    public MuridUpdateDialog(MainFrame mainFrame, boolean modal) {
        initComponents();
        refresh();
    }

    public MuridUpdateDialog(MainFrame mainFrame, boolean modal, Murid murid) {
        initComponents();
        refresh();
        this.murid = murid;
        labelMurid.setText("Ubah Murid");
        jTextFieldNIM.setText(murid.getNIM());
        jTextFieldNama.setText(murid.getNama());
        jTextFieldTelp.setText(murid.getTelp());
        jTextFieldHP.setText(murid.getHandphone());
        jTextFieldEmail.setText(murid.getEmail());
        jTextAreaAlamat.setText(murid.getAlamat());
        jDateChooserTanggal.setDate(murid.getDate());
        comboBoxBank.setSelectedItem(murid.getBank().getNama());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelMurid = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNIM = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldTelp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldHP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateChooserTanggal = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAlamat = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        comboBoxBank = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        buttonSimpan = new javax.swing.JButton();
        buttonBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        labelMurid.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelMurid.setText("Tambah Murid Baru");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("NIM :");

        jTextFieldNIM.setDocument(new JTextFieldLimit(10));

        jLabel3.setText("Nama :");

        jTextFieldNama.setDocument(new JTextFieldLimit(30));

        jLabel4.setText("Telp :");

        jTextFieldTelp.setDocument(new JTextFieldLimit(20));

        jLabel5.setText("Handphone :");

        jTextFieldHP.setDocument(new JTextFieldLimit(20));

        jLabel6.setText("Email :");

        jTextFieldEmail.setDocument(new JTextFieldLimit(50));

        jLabel7.setText("Tanggal Lahir :");

        jLabel8.setText("Alamat :");

        jTextAreaAlamat.setDocument(new JTextFieldLimit(100));
        jTextAreaAlamat.setRows(5);
        jScrollPane1.setViewportView(jTextAreaAlamat);

        jLabel9.setText("Bank :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNIM, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNama, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(comboBoxBank, 0, 354, Short.MAX_VALUE)
                    .addComponent(jTextFieldTelp, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldHP, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jDateChooserTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });
        jPanel2.add(buttonSimpan);

        buttonBatal.setText("Batal");
        buttonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBatalActionPerformed(evt);
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
                    .addComponent(labelMurid)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelMurid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(416, 613));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBatalActionPerformed
        dispose();
}//GEN-LAST:event_buttonBatalActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        if (murid == null) {
            murid = new Murid();
        }
        murid.setNIM(jTextFieldNIM.getText());
        murid.setNama(jTextFieldNama.getText());
        murid.setTelp(jTextFieldTelp.getText());
        murid.setHandphone(jTextFieldHP.getText());
        murid.setEmail(jTextFieldEmail.getText());
        murid.setAlamat(jTextAreaAlamat.getText());
        murid.setDate(jDateChooserTanggal.getDate());
        murid.setBank(listBank.get(comboBoxBank.getSelectedIndex()));
        validate(murid);
}//GEN-LAST:event_buttonSimpanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBatal;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JComboBox comboBoxBank;
    private com.toedter.calendar.JDateChooser jDateChooserTanggal;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaAlamat;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldHP;
    private javax.swing.JTextField jTextFieldNIM;
    private javax.swing.JTextField jTextFieldNama;
    private javax.swing.JTextField jTextFieldTelp;
    private javax.swing.JLabel labelMurid;
    // End of variables declaration//GEN-END:variables

    private void refresh() {
        try {
            listBank = bankDAO.getAll(Bank.class);
            updateComboBank();
        } catch (Exception ex) {
            Logger.getLogger(MuridUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void updateComboBank() {
        Object data[] = new Object[listBank.size()];
        int x = 0;
        for (Bank bank : listBank) {
            data[x] = bank.getNama();
            x++;
        }
        comboBoxBank.setModel(new DefaultComboBoxModel(data));
    }

    private void validate(Murid murid) {
        if (murid == null) {
            JOptionPane.showMessageDialog(this, "Murid tidak boleh null");
        } else if (murid.getNIM() == null) {
            JOptionPane.showMessageDialog(this, "NIM tidak boleh null");
        } else if (murid.getNIM().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "NIM tidak boleh kosong");
        } else if (murid.getNama() == null) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh null");
        } else if (murid.getNama().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong");
        } else if (murid.getBank() == null) {
            JOptionPane.showMessageDialog(this, "Bank tidak boleh null");
        } else if (murid.getTelp() == null) {
            JOptionPane.showMessageDialog(this, "Telp tidak boleh null");
        } else if (murid.getTelp().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Telp tidak boleh kosong");
        } else if (murid.getHandphone() == null) {
            JOptionPane.showMessageDialog(this, "HP tidak boleh null");
        } else if (murid.getHandphone().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "HP tidak boleh kosong");
        } else if (murid.getEmail() == null) {
            JOptionPane.showMessageDialog(this, "Email tidak boleh null");
        } else if (murid.getEmail().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email tidak boleh kosong");
        } else if (murid.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Tanggal Lahir tidak boleh null");
        } else if (murid.getAlamat() == null) {
            JOptionPane.showMessageDialog(this, "Alamat tidak boleh null");
        } else if (murid.getAlamat().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Alamat tidak boleh kosong");
        } else {
            try {
                muridDAO.saveOrUpdate(murid);
                dispose();
            } catch (Exception ex) {
                Logger.getLogger(MuridUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}