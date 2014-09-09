/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MuridIFrame.java
 *
 * Created on Sep 2, 2014, 9:10:07 AM
 */
package com.ivanbiz.ui;

import com.ivanbiz.dao.BankDAO;
import com.ivanbiz.dao.MuridDAO;
import com.ivanbiz.dao.impl.BankDAOImpl;
import com.ivanbiz.dao.impl.MuridDAOImpl;
import com.ivanbiz.model.AksesMatrix;
import com.ivanbiz.model.Bank;
import com.ivanbiz.model.Murid;
import com.ivanbiz.service.MenuAksesConstant;
import com.ivanbiz.service.ServiceHelper;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author IW20149X
 */
public class MuridIFrame extends javax.swing.JInternalFrame {

    Murid murid;
    MuridDAO muridDAO;
    BankDAO bankDAO;
    List<Murid> listMurid;
    List<Bank> listBank;

    /** Creates new form MuridIFrame */
    public MuridIFrame(List<AksesMatrix> listAksesMatrix) {
        initComponents();
        renderHakAkses(listAksesMatrix);
        muridDAO = new MuridDAOImpl();
        bankDAO = new BankDAOImpl();
        refresh();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MuridUpdateDialog = new javax.swing.JDialog();
        jLabelMurid = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaAlamat = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxBank = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jButtonSimpan = new javax.swing.JButton();
        jButtonBatal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jComboBoxCari = new javax.swing.JComboBox();
        jTextFieldCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMurid = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        buttonTambah = new javax.swing.JButton();
        buttonUbah = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();

        jLabelMurid.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabelMurid.setText("{} Murid");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Murid"));

        jLabel2.setText("NIM :");

        jLabel3.setText("Nama :");

        jLabel4.setText("Telp :");

        jLabel5.setText("Handphone :");

        jLabel6.setText("Email :");

        jLabel7.setText("Tanggal Lahir :");

        jLabel8.setText("Alamat :");

        jTextAreaAlamat.setColumns(20);
        jTextAreaAlamat.setRows(5);
        jScrollPane2.setViewportView(jTextAreaAlamat);

        jLabel9.setText("Bank :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNIM, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNama, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(jComboBoxBank, 0, 348, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addComponent(jDateChooserTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldHP, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldTelp, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
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
                .addComponent(jComboBoxBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonSimpan.setText("Simpan");
        jButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanactionButton(evt);
            }
        });
        jPanel4.add(jButtonSimpan);

        jButtonBatal.setText("Batal");
        jButtonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBatalactionButton(evt);
            }
        });
        jPanel4.add(jButtonBatal);

        javax.swing.GroupLayout MuridUpdateDialogLayout = new javax.swing.GroupLayout(MuridUpdateDialog.getContentPane());
        MuridUpdateDialog.getContentPane().setLayout(MuridUpdateDialogLayout);
        MuridUpdateDialogLayout.setHorizontalGroup(
            MuridUpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(MuridUpdateDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MuridUpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMurid)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        MuridUpdateDialogLayout.setVerticalGroup(
            MuridUpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
            .addGroup(MuridUpdateDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMurid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setClosable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("Daftar Murid");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pencarian Murid"));

        jTextFieldCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxCari, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldCari, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableMurid.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableMurid);

        buttonTambah.setText("Tambah Murid Baru");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahactionButton(evt);
            }
        });
        jPanel2.add(buttonTambah);

        buttonUbah.setText("Ubah Murid Terseleksi");
        buttonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahactionButton(evt);
            }
        });
        jPanel2.add(buttonUbah);

        buttonHapus.setText("Hapus Murid Terseleksi");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusactionButton(evt);
            }
        });
        jPanel2.add(buttonHapus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-800)/2, (screenSize.height-632)/2, 800, 632);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCariKeyReleased
}//GEN-LAST:event_jTextFieldCariKeyReleased

    private void buttonTambahactionButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahactionButton
        try {
            jLabelMurid.setText("Tambah Murid Baru");
            jTextFieldNIM.setText("");
            jTextFieldNama.setText("");
            jTextFieldTelp.setText("");
            jTextFieldHP.setText("");
            jTextFieldEmail.setText("");
            jTextAreaAlamat.setText("");
            jDateChooserTanggal.setDate(new Date());
            jComboBoxBank.setSelectedItem(listBank);
            renderMuridUpdateDialog();
        } catch (Exception ex) {
            Logger.getLogger(MuridIFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_buttonTambahactionButton

    private void buttonUbahactionButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahactionButton
        if (tableMurid.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih salah satu data", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                murid = listMurid.get(tableMurid.getSelectedRow());
                jLabelMurid.setText("Ubah Murid");
                jTextFieldNIM.setText(murid.getNIM());
                jTextFieldNama.setText(murid.getNama());
                jTextFieldTelp.setText(murid.getTelp());
                jTextFieldHP.setText(murid.getHandphone());
                jTextFieldEmail.setText(murid.getEmail());
                jTextAreaAlamat.setText(murid.getAlamat());
                jDateChooserTanggal.setDate(murid.getDate());
                jComboBoxBank.setSelectedItem(murid.getBank().getNama());
                renderMuridUpdateDialog();
            } catch (Exception ex) {
                Logger.getLogger(MuridIFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}//GEN-LAST:event_buttonUbahactionButton

    private void buttonHapusactionButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusactionButton
        try {
            if (tableMurid.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Pilih salah satu data", "warning", JOptionPane.WARNING_MESSAGE);
            } else {
                murid = listMurid.get(tableMurid.getSelectedRow());
                muridDAO.delete(murid);
                refresh();
            }
        } catch (Exception ex) {
            Logger.getLogger(MuridIFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_buttonHapusactionButton

    private void jButtonSimpanactionButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanactionButton
        if (jLabelMurid.getText().equals("Tambah Murid Baru")) {
            murid = new Murid();
        }
        murid.setNIM(jTextFieldNIM.getText());
        murid.setNama(jTextFieldNama.getText());
        murid.setTelp(jTextFieldTelp.getText());
        murid.setHandphone(jTextFieldHP.getText());
        murid.setEmail(jTextFieldEmail.getText());
        murid.setAlamat(jTextAreaAlamat.getText());
        murid.setDate(jDateChooserTanggal.getDate());
        murid.setBank((Bank) listBank.get(jComboBoxBank.getSelectedIndex()));
        validate(murid);
}//GEN-LAST:event_jButtonSimpanactionButton

    private void jButtonBatalactionButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBatalactionButton
        MuridUpdateDialog.dispose();
}//GEN-LAST:event_jButtonBatalactionButton
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog MuridUpdateDialog;
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JButton jButtonBatal;
    private javax.swing.JButton jButtonSimpan;
    private javax.swing.JComboBox jComboBoxBank;
    private javax.swing.JComboBox jComboBoxCari;
    private com.toedter.calendar.JDateChooser jDateChooserTanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMurid;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaAlamat;
    private javax.swing.JTextField jTextFieldCari;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldHP;
    private javax.swing.JTextField jTextFieldNIM;
    private javax.swing.JTextField jTextFieldNama;
    private javax.swing.JTextField jTextFieldTelp;
    private javax.swing.JTable tableMurid;
    // End of variables declaration//GEN-END:variables

    private void refresh() {
        try {
            listMurid = muridDAO.getAll(Murid.class);
            updateTableMurid();
            listBank = bankDAO.getAll(Bank.class);
            updateComboBank();
        } catch (Exception ex) {
            Logger.getLogger(MuridIFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateTableMurid() {
        String[] judul = {"No", "NIM", "Nama", "Telp", "Handphone", "Email", "Date", "Nama Bank", "Alamat"};
        Object[][] isi = new Object[listMurid.size()][9];
        int x = 0;
        int no = 0;
        for (Murid murids : listMurid) {
            no += 1;
            isi[x][0] = no;
            isi[x][1] = murids.getNIM();
            isi[x][2] = murids.getNama();
            isi[x][3] = murids.getTelp();
            isi[x][4] = murids.getHandphone();
            isi[x][5] = murids.getEmail();
            isi[x][6] = murids.getDate();
            isi[x][7] = murids.getBank().getNama();
            isi[x][8] = murids.getAlamat();
            x++;
        }
        new ServiceHelper().setAutoRize(isi, judul, tableMurid);
    }

    private void renderMuridUpdateDialog() {
        MuridUpdateDialog.setSize(400, 625);
        MuridUpdateDialog.setVisible(true);
        MuridUpdateDialog.setLocationRelativeTo(this);
        MuridUpdateDialog.setModal(true);
    }

    private void updateComboBank() {
        Object data[] = new Object[listBank.size()];
        int x = 0;
        for (Bank bank : listBank) {
            data[x] = bank.getNama();
            x++;
        }
        jComboBoxBank.setModel(new DefaultComboBoxModel(data));
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
        } else if (murid.getAlamat() == null) {
            JOptionPane.showMessageDialog(this, "Alamat tidak boleh null");
        } else if (murid.getAlamat().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Alamat tidak boleh kosong");
        } else {
            try {
                muridDAO.saveOrUpdate(murid);
                MuridUpdateDialog.dispose();
                refresh();
            } catch (Exception ex) {
                Logger.getLogger(MuridIFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void renderHakAkses(List<AksesMatrix> listAksesMatrix) {
        buttonTambah.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.TAMBAH_MURID, listAksesMatrix));
        buttonUbah.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.UBAH_MURID, listAksesMatrix));
        buttonHapus.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.HAPUS_MURID, listAksesMatrix));
    }
}