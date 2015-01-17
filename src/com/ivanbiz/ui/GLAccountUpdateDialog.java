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
import com.ivanbiz.dao.GLAccountDAO;
import com.ivanbiz.dao.GroupAccDAO;
import com.ivanbiz.dao.impl.BankDAOImpl;
import com.ivanbiz.dao.impl.GLAccountDAOImpl;
import com.ivanbiz.dao.impl.GroupAccDAOImpl;
import com.ivanbiz.model.Bank;
import com.ivanbiz.model.GLAccount;
import com.ivanbiz.model.GroupAcc;
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
public class GLAccountUpdateDialog extends JDialog {

    GLAccount gLAccount;
    GLAccountDAO gLAccountDAO;
    GroupAccDAO groupAccDAO;
    List<GroupAcc> listGroupAccs;
    BankDAO bankDAO;
    List<Bank> listBank;

    /**
     * Creates new form PengajarUpdateDialog
     *
     * @param mainFrame
     * @param modal
     */
    public GLAccountUpdateDialog(MainFrame mainFrame, boolean modal) {
        initComponents();
        gLAccountDAO = new GLAccountDAOImpl();
        groupAccDAO = new GroupAccDAOImpl();
        bankDAO = new BankDAOImpl();
        refresh();
        jLabel2.setVisible(false);
        textFieldKode.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelGLAccount = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textFieldKode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textFieldNoGL = new javax.swing.JTextField();
        comboBoxBank = new javax.swing.JComboBox();
        textFieldNamaGL = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxGroupAccount = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textFieldKeterangan = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jButtonSimpan = new javax.swing.JButton();
        jButtonBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        jLabelGLAccount.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabelGLAccount.setText("Tambah GL Account Baru");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Kode :");

        textFieldKode.setDocument(new JTextFieldLimit(3));
        textFieldKode.setEnabled(false);

        jLabel3.setText("Bank :");

        jLabel4.setText("No GL :");

        textFieldNoGL.setDocument(new JTextFieldLimit(27));

        textFieldNamaGL.setDocument(new JTextFieldLimit(30));

        jLabel5.setText("Nama GL :");

        jLabel6.setText("Alamat :");

        comboBoxGroupAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxGroupAccountActionPerformed(evt);
            }
        });

        jLabel7.setText("Jenis Account :");

        textFieldKeterangan.setColumns(20);
        textFieldKeterangan.setDocument(new JTextFieldLimit(250));
        textFieldKeterangan.setRows(5);
        jScrollPane1.setViewportView(textFieldKeterangan);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(comboBoxGroupAccount, 0, 235, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldKode, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textFieldNoGL, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(comboBoxBank, 0, 354, Short.MAX_VALUE)
                    .addComponent(textFieldNamaGL, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 281, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxGroupAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldNoGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldNamaGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jButtonSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/simpan.jpg"))); // NOI18N
        jButtonSimpan.setText("Simpan");
        jButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonSimpan);

        jButtonBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/batal.jpg"))); // NOI18N
        jButtonBatal.setText("Batal");
        jButtonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBatalActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonBatal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelGLAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelGLAccount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-416)/2, (screenSize.height-456)/2, 416, 456);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBatalActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonBatalActionPerformed

    private void jButtonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanActionPerformed
        if (gLAccount == null) {
            gLAccount = new GLAccount();
        }
        gLAccount.setGroupACC(listGroupAccs.get(comboBoxGroupAccount.getSelectedIndex()).getNamaGroup());
        gLAccount.setKode(textFieldKode.getText());
        gLAccount.setNama(comboBoxBank.getSelectedItem().toString());
        gLAccount.setNoGL(textFieldNoGL.getText());
        gLAccount.setNameGL(textFieldNamaGL.getText());
        gLAccount.setDeskripsi(textFieldKeterangan.getText());
        validate(gLAccount);
    }//GEN-LAST:event_jButtonSimpanActionPerformed

    private void comboBoxGroupAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxGroupAccountActionPerformed
        if (comboBoxGroupAccount.getSelectedItem().equals("Kreditur")) {
            jLabel2.setVisible(true);
            textFieldKode.setVisible(true);
            textFieldKode.setText(getGenereateKode());
        } else if (comboBoxGroupAccount.getSelectedItem().equals("BiayaLain")) {
            jLabel2.setVisible(false);
            textFieldKode.setVisible(false);
            textFieldKode.setText("XXX");
            textFieldNoGL.setText("KASKECIL#");
        } else {
            jLabel2.setVisible(false);
            textFieldKode.setVisible(false);
            textFieldKode.setText("XXX");
        }
    }//GEN-LAST:event_comboBoxGroupAccountActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboBoxBank;
    private javax.swing.JComboBox comboBoxGroupAccount;
    private javax.swing.JButton jButtonBatal;
    private javax.swing.JButton jButtonSimpan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelGLAccount;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textFieldKeterangan;
    private javax.swing.JTextField textFieldKode;
    private javax.swing.JTextField textFieldNamaGL;
    private javax.swing.JTextField textFieldNoGL;
    // End of variables declaration//GEN-END:variables

    private void refresh() {
        try {
            listGroupAccs = groupAccDAO.getAll(GroupAcc.class);
            updateComboGroupAccount();
            listBank = bankDAO.getAll(Bank.class);
            updateBank();
        } catch (Exception ex) {
            Logger.getLogger(GLAccountUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateComboGroupAccount() {
        GroupAcc ga = new GroupAcc();
        ga.setNamaGroup("");
        listGroupAccs.add(0, ga);
        Object data[] = new Object[listGroupAccs.size()];
        int x = 0;
        for (GroupAcc groupAcc : listGroupAccs) {
            data[x] = groupAcc.getNamaGroup();
            x++;
        }
        comboBoxGroupAccount.setModel(new DefaultComboBoxModel(data));
    }

    private void updateBank() {
        Object data[] = new Object[listBank.size()];
        int x = 0;
        for (Bank bank : listBank) {
            data[x] = bank.getNama();
            x++;
        }
        comboBoxBank.setModel(new DefaultComboBoxModel(data));
    }

    private void validate(GLAccount gLAccount) {
        if (gLAccount == null) {
            JOptionPane.showMessageDialog(this, "GL Account tidak boleh null");
        } else if (gLAccount.getGroupACC().equals("0")) {
            JOptionPane.showMessageDialog(this, "Jenis Account tidak boleh null");
        } else if (gLAccount.getGroupACC().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Jenis Account tidak boleh Kosong");
        } else if (gLAccount.getKode() == null) {
            JOptionPane.showMessageDialog(this, "Kode tidak boleh null");
        } else if (gLAccount.getKode().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Kode tidak boleh kosong");
        } else if (gLAccount.getNama() == null) {
            JOptionPane.showMessageDialog(this, "Bank tidak boleh null");
        } else if (gLAccount.getNoGL().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No GL tidak boleh kosong");
        } else if (gLAccount.getNameGL() == null) {
            JOptionPane.showMessageDialog(this, "Nama GL tidak boleh null");
        } else if (gLAccount.getNameGL().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama GL tidak boleh kosong");
        } else if (gLAccount.getDeskripsi() == null) {
            JOptionPane.showMessageDialog(this, "Keterangan tidak boleh null");
        } else if (gLAccount.getDeskripsi().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Keterangan tidak boleh kosong");
        } else {
            try {
                if (gLAccountDAO.validateField(GLAccount.class, "noGL", gLAccount.getNoGL()).equals("Data sudah ada")) {
                    JOptionPane.showMessageDialog(this, "No GL sudah ada");
                } else {
                    if (gLAccount.getGroupACC().equals("Kreditur")) {
                        gLAccountDAO.saveGLKrediturWithSetting(gLAccount);
                    } else if (gLAccount.getGroupACC().equals("BiayaLain")) {
                        gLAccountDAO.saveGLBiayaLainWithSetting(gLAccount);
                    } else {
                        gLAccountDAO.saveOrUpdate(gLAccount);
                    }
                    dispose();
                }
            } catch (Exception ex) {
                Logger.getLogger(GLAccountUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private String getGenereateKode() {
        String kode = null;
        try {
            kode = gLAccountDAO.getLastNoTransaksi();
            if (!"".equals(kode)) {
                int count = Integer.parseInt(kode);
                count += 1;
                if (count >= 890) {
                    JOptionPane.showMessageDialog(this, "Kode lebih dari 3 digit");
                } else {
                    kode = String.format("%03d", count);
                }

            } else {
                kode = String.format("%03d", 1);
            }
        } catch (Exception ex) {
            Logger.getLogger(GLAccountUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kode;
    }
}
