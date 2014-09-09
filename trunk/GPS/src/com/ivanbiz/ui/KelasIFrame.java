/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * KelasIFrame.java
 *
 * Created on Sep 2, 2014, 2:34:57 PM
 */
package com.ivanbiz.ui;

import com.ivanbiz.dao.KelasDAO;
import com.ivanbiz.dao.PengajarDAO;
import com.ivanbiz.dao.impl.KelasDAOImpl;
import com.ivanbiz.dao.impl.PengajarDAOImpl;
import com.ivanbiz.model.AksesMatrix;
import com.ivanbiz.model.Kelas;
import com.ivanbiz.model.Pengajar;
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
public class KelasIFrame extends javax.swing.JInternalFrame {

    Kelas kelas;
    KelasDAO kelasDAO;
    PengajarDAO pengajarDAO;
    List<Kelas> listKelas;
    List<Pengajar> listPengajar;

    /** Creates new form KelasIFrame */
    public KelasIFrame(List<AksesMatrix> listAksesMatrix) {
        initComponents();
        renderHakAkses(listAksesMatrix);
        kelasDAO = new KelasDAOImpl();
        pengajarDAO = new PengajarDAOImpl();
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

        KelasUpdateDialog = new javax.swing.JDialog();
        jLabelKelas = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textNIK = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textDeskripsi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textTempat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textStatus = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textTanggal = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAlamat = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        comboPengajar = new javax.swing.JComboBox();
        textTransaksiReference = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButtonSimpan = new javax.swing.JButton();
        jButtonBatal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jComboBoxCari = new javax.swing.JComboBox();
        jTextFieldCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKelas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        buttonTambah = new javax.swing.JButton();
        buttonUbah = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();

        jLabelKelas.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabelKelas.setText("{} Kelas");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Kelas"));

        jLabel2.setText("NIK :");

        jLabel3.setText("Deskripsi :");

        jLabel4.setText("Tempat :");

        jLabel5.setText("Status Kelas :");

        jLabel7.setText("Tanggal :");

        jLabel8.setText("Alamat :");

        textAlamat.setColumns(20);
        textAlamat.setRows(5);
        jScrollPane2.setViewportView(textAlamat);

        jLabel9.setText("Pengajar :");

        jLabel6.setText("Transaksi Reference :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(textTempat, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(textDeskripsi, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(comboPengajar, 0, 348, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addComponent(textTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(textNIK, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(textTransaksiReference, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textTransaksiReference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textNIK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboPengajar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textTempat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        javax.swing.GroupLayout KelasUpdateDialogLayout = new javax.swing.GroupLayout(KelasUpdateDialog.getContentPane());
        KelasUpdateDialog.getContentPane().setLayout(KelasUpdateDialogLayout);
        KelasUpdateDialogLayout.setHorizontalGroup(
            KelasUpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KelasUpdateDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(KelasUpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelKelas)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        KelasUpdateDialogLayout.setVerticalGroup(
            KelasUpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KelasUpdateDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelKelas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setClosable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("Daftar Kelas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pencarian Kelas"));

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

        tableKelas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableKelas);

        buttonTambah.setText("Tambah Kelas Baru");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahactionButton(evt);
            }
        });
        jPanel2.add(buttonTambah);

        buttonUbah.setText("Ubah Kelas Terseleksi");
        buttonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahactionButton(evt);
            }
        });
        jPanel2.add(buttonUbah);

        buttonHapus.setText("Hapus Kelas Terseleksi");
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-800)/2, (screenSize.height-608)/2, 800, 608);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCariKeyReleased
}//GEN-LAST:event_jTextFieldCariKeyReleased

    private void buttonTambahactionButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahactionButton
        jLabelKelas.setText("Tambah Kelas Baru");
        textTransaksiReference.setText("");
        textNIK.setText("");
        textDeskripsi.setText("");
        comboPengajar.setSelectedItem(listPengajar);
        textTanggal.setDate(new Date());
        textStatus.setText("");
        textTempat.setText("");
        textAlamat.setText("");
        renderKelasDialog();
}//GEN-LAST:event_buttonTambahactionButton

    private void buttonUbahactionButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahactionButton
        if (tableKelas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih salah satu data", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            kelas = listKelas.get(tableKelas.getSelectedRow());
            jLabelKelas.setText("Ubah Kelas");
            textTransaksiReference.setText(kelas.getTransactionReference());
            textNIK.setText(kelas.getNIK());
            textDeskripsi.setText(kelas.getDeskripsi());
            comboPengajar.setSelectedItem(kelas.getPengajar().getNama());
            textTanggal.setDate(kelas.getTanggalKelas());
            textStatus.setText(kelas.getStatusKelas());
            textTempat.setText(kelas.getTempatKelas());
            textAlamat.setText(kelas.getAlamatKelas());
            renderKelasDialog();
        }
}//GEN-LAST:event_buttonUbahactionButton

    private void buttonHapusactionButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusactionButton
        if (tableKelas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih salah satu data", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                kelas = listKelas.get(tableKelas.getSelectedRow());
                kelasDAO.delete(kelas);
                refresh();
            } catch (Exception ex) {
                Logger.getLogger(KelasIFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}//GEN-LAST:event_buttonHapusactionButton

    private void jButtonSimpanactionButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanactionButton
        if (jLabelKelas.getText().equals("Tambah Kelas Baru")) {
            kelas = new Kelas();
        }
        kelas.setTransactionReference(textTransaksiReference.getText());
        kelas.setNIK(textNIK.getText());
        kelas.setDeskripsi(textDeskripsi.getText());
        kelas.setPengajar((Pengajar) listPengajar.get(comboPengajar.getSelectedIndex()));
        kelas.setTanggalKelas(textTanggal.getDate());
        kelas.setStatusKelas(textStatus.getText());
        kelas.setTempatKelas(textTempat.getText());
        kelas.setAlamatKelas(textAlamat.getText());
        validate(kelas);
}//GEN-LAST:event_jButtonSimpanactionButton

    private void jButtonBatalactionButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBatalactionButton
        KelasUpdateDialog.dispose();
}//GEN-LAST:event_jButtonBatalactionButton
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog KelasUpdateDialog;
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JComboBox comboPengajar;
    private javax.swing.JButton jButtonBatal;
    private javax.swing.JButton jButtonSimpan;
    private javax.swing.JComboBox jComboBoxCari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelKelas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldCari;
    private javax.swing.JTable tableKelas;
    private javax.swing.JTextArea textAlamat;
    private javax.swing.JTextField textDeskripsi;
    private javax.swing.JTextField textNIK;
    private javax.swing.JTextField textStatus;
    private com.toedter.calendar.JDateChooser textTanggal;
    private javax.swing.JTextField textTempat;
    private javax.swing.JTextField textTransaksiReference;
    // End of variables declaration//GEN-END:variables

    private void renderHakAkses(List<AksesMatrix> listAksesMatrix) {
        buttonTambah.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.TAMBAH_KELAS, listAksesMatrix));
        buttonUbah.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.UBAH_KELAS, listAksesMatrix));
        buttonHapus.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.HAPUS_KELAS, listAksesMatrix));
    }

    private void refresh() {
        try {
            listKelas = kelasDAO.getAll(Kelas.class);
            listPengajar = pengajarDAO.getAll(Pengajar.class);
            updateTableKelas();
            updateComboPengajar();
        } catch (Exception ex) {
            Logger.getLogger(KelasIFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateTableKelas() {
        String[] judul = {"No", "Transaksi Reference", "NIK", "Deskripsi", "Pengajar", "Tanggal", "Status Kelas", "Tempat", "Alamat"};
        Object[][] isi = new Object[listKelas.size()][9];
        int x = 0;
        int no = 0;
        for (Kelas kelass : listKelas) {
            no += 1;
            isi[x][0] = no;
            isi[x][1] = kelass.getTransactionReference();
            isi[x][2] = kelass.getNIK();
            isi[x][3] = kelass.getDeskripsi();
            isi[x][4] = "(" + kelass.getPengajar().getNIP() + ")" + kelass.getPengajar().getNama();
            isi[x][5] = kelass.getTanggalKelas();
            isi[x][6] = kelass.getStatusKelas();
            isi[x][7] = kelass.getTempatKelas();
            isi[x][8] = kelass.getAlamatKelas();
            x++;
        }
        new ServiceHelper().setAutoRize(isi, judul, tableKelas);
    }

    private void updateComboPengajar() {
        Object data[] = new Object[listPengajar.size()];
        int x = 0;
        for (Pengajar pengajar : listPengajar) {
            data[x] = "(" + pengajar.getNIP() + ")" + pengajar.getNama();
            x++;
        }
        comboPengajar.setModel(new DefaultComboBoxModel(data));
    }

    private void renderKelasDialog() {
        KelasUpdateDialog.setSize(400, 625);
        KelasUpdateDialog.setVisible(true);
        KelasUpdateDialog.setLocationRelativeTo(this);
        KelasUpdateDialog.setModal(true);
    }

    private void validate(Kelas kelas) {
        if (kelas == null) {
            JOptionPane.showMessageDialog(this, "Murid tidak boleh null");
        } else if (kelas.getTransactionReference() == null) {
            JOptionPane.showMessageDialog(this, "Transaksi Reference tidak boleh null");
        } else if (kelas.getTransactionReference().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Transaksi Reference tidak boleh kosong");
        } else if (kelas.getNIK() == null) {
            JOptionPane.showMessageDialog(this, "NIK tidak boleh null");
        } else if (kelas.getNIK().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "NIK tidak boleh kosong");
        } else if (kelas.getDeskripsi() == null) {
            JOptionPane.showMessageDialog(this, "Deskripsi tidak boleh null");
        } else if (kelas.getDeskripsi().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Deskripsi tidak boleh kosong");
        } else if (kelas.getStatusKelas() == null) {
            JOptionPane.showMessageDialog(this, "Status Kelas tidak boleh null");
        } else if (kelas.getStatusKelas().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Status Kelas tidak boleh kosong");
        } else if (kelas.getTempatKelas() == null) {
            JOptionPane.showMessageDialog(this, "Tempat tidak boleh null");
        } else if (kelas.getTempatKelas().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tempat tidak boleh kosong");
        } else if (kelas.getAlamatKelas() == null) {
            JOptionPane.showMessageDialog(this, "Alamat tidak boleh null");
        } else if (kelas.getAlamatKelas().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Alamat tidak boleh kosong");
        } else {
            try {
                kelasDAO.saveOrUpdate(kelas);
                KelasUpdateDialog.dispose();
                refresh();
            } catch (Exception ex) {
                Logger.getLogger(KelasIFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}