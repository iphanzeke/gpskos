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

import com.ivanbiz.dao.DaftarKelasDAO;
import com.ivanbiz.dao.MuridDAO;
import com.ivanbiz.dao.impl.DaftarKelasDAOImpl;
import com.ivanbiz.dao.impl.MuridDAOImpl;
import com.ivanbiz.model.AksesMatrix;
import com.ivanbiz.model.DaftarKelas;
import com.ivanbiz.model.Kelas;
import com.ivanbiz.model.Murid;
import com.ivanbiz.service.GlobalSession;
import com.ivanbiz.service.MenuAksesConstant;
import com.ivanbiz.service.ServiceHelper;
import java.text.SimpleDateFormat;
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
public class MuridDialog extends JDialog {

    Murid murid;
    List<Murid> listMurid;
    MuridDAO muridDAO = new MuridDAOImpl();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy");
    Kelas kelas;
    List<DaftarKelas> listDaftarKelas;
    DaftarKelas daftarKelas;
    DaftarKelasDAO daftarKelasDAO;

    public MuridDialog() {
        initComponents();
        renderButtonAkses(GlobalSession.getListAksesMatrix());
        refresh();
    }

    public MuridDialog(MainFrame mainFrame, boolean modal, List<DaftarKelas> listDaftarKelas, Kelas kelas) {
        initComponents();
        daftarKelasDAO = new DaftarKelasDAOImpl();
        this.kelas = kelas;
        this.listDaftarKelas = listDaftarKelas;
        renderButtonAkses(GlobalSession.getListAksesMatrix());
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
        jPanel1 = new javax.swing.JPanel();
        comboBoxCari = new javax.swing.JComboBox();
        textCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMurid = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        buttonTambah = new javax.swing.JButton();
        buttonUbah = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();

        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Daftar Murid");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pencarian Murid"));

        textCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textCariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboBoxCari, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textCari, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableMurid.setAutoCreateRowSorter(true);
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
        tableMurid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMuridMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMurid);

        buttonTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/tambah.jpg"))); // NOI18N
        buttonTambah.setText("Tambah Murid Baru");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });
        jPanel2.add(buttonTambah);

        buttonUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/ubah.jpg"))); // NOI18N
        buttonUbah.setText("Ubah Murid Terseleksi");
        buttonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahActionPerformed(evt);
            }
        });
        jPanel2.add(buttonUbah);

        buttonHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/hapus.jpg"))); // NOI18N
        buttonHapus.setText("Hapus Murid Terseleksi");
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(816, 638));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void renderButtonAkses(List<AksesMatrix> listAksesMatrix) {
        buttonTambah.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.TAMBAH_MURID, listAksesMatrix));
        buttonUbah.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.UBAH_MURID, listAksesMatrix));
        buttonHapus.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.HAPUS_MURID, listAksesMatrix));
    }

    private void textCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCariKeyReleased
        try {
            if (comboBoxCari.getSelectedItem().toString().equals("bank")) {
                listMurid = muridDAO.getDataByLikeBank(textCari.getText());
            } else {
                listMurid = muridDAO.getDataByLike(Murid.class, comboBoxCari.getSelectedItem().toString(), textCari.getText());
            }
            updateTableMurid();
        } catch (Exception ex) {
            Logger.getLogger(MuridDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_textCariKeyReleased

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        new MuridUpdateDialog(null, rootPaneCheckingEnabled).setVisible(true);
        refresh();
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void buttonUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahActionPerformed
        if (tableMurid.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan diubah", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            murid = listMurid.get(tableMurid.getSelectedRow());
            new MuridUpdateDialog(null, rootPaneCheckingEnabled, murid).setVisible(true);
            refresh();
        }
    }//GEN-LAST:event_buttonUbahActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        if (tableMurid.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                murid = listMurid.get(tableMurid.getSelectedRow());
                muridDAO.delete(murid);
                refresh();
            } catch (Exception ex) {
                Logger.getLogger(MuridDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void tableMuridMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMuridMouseClicked
        if (null != kelas) {
            if (evt.getClickCount() == 2) {
                int response = JOptionPane.showConfirmDialog(this, "Tambah murid Ke Daftar Kelas ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    murid = listMurid.get(tableMurid.getSelectedRow());
                    for (DaftarKelas daftarKelass : listDaftarKelas) {
                        if (daftarKelass.getMurid().getId() == murid.getId()) {
                            JOptionPane.showMessageDialog(this, "Murid sudah ada pada daftar Kelas", "warning", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                    }
                    daftarKelas = new DaftarKelas();
                    daftarKelas.setKelas(kelas);
                    daftarKelas.setMurid(murid);
                    daftarKelas.setTransactionReference(kelas.getTransactionReference());
                    daftarKelas.setStatus("1");
                    daftarKelas.setKehadiran("1");
                    daftarKelas.setKeterangan("");
                    daftarKelas.setUjian("");
                    validateDaftarKelas(daftarKelas);
                }
            }
        }
    }//GEN-LAST:event_tableMuridMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JComboBox comboBoxCari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMurid;
    private javax.swing.JTextField textCari;
    // End of variables declaration//GEN-END:variables

    private void refresh() {
        try {
            listMurid = muridDAO.getAll(murid);
            updateTableMurid();
            updateComboCari();
        } catch (Exception ex) {
            Logger.getLogger(MuridDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateComboCari() {
        Object[] dataClass = new ServiceHelper().getPropertyClass(Murid.class);
        Object[] dataSearch = new Object[3];
        dataSearch[0] = dataClass[2];
        dataSearch[1] = dataClass[7];
        dataSearch[2] = dataClass[1];
        comboBoxCari.setModel(new DefaultComboBoxModel(dataSearch));
    }

    private void updateTableMurid() {
        String[] judul = {"No", "NIM", "Nama", "Institusi", "Telp", "Handphone", "Email", "Date", "Alamat"};
        Object[][] isi = new Object[listMurid.size()][9];
        int x = 0;
        int no = 0;
        for (Murid murids : listMurid) {
            no += 1;
            isi[x][0] = no;
            isi[x][1] = murids.getNIM();
            isi[x][2] = murids.getNama();
            isi[x][3] = murids.getBank().getNama();
            isi[x][4] = murids.getTelp();
            isi[x][5] = murids.getHandphone();
            isi[x][6] = murids.getEmail();
            isi[x][7] = sdf.format(murids.getDate());
            isi[x][8] = murids.getAlamat();
            x++;
        }
        new ServiceHelper().setAutoRize(isi, judul, tableMurid);
    }

    private void validateDaftarKelas(DaftarKelas daftarKelas) {
        if (daftarKelas == null) {
            JOptionPane.showMessageDialog(this, "Daftar Kelas tidak boleh null");
        } else if (daftarKelas.getKelas() == null) {
            JOptionPane.showMessageDialog(this, "Kelas tidak boleh null");
        } else if (daftarKelas.getMurid() == null) {
            JOptionPane.showMessageDialog(this, "Murid tidak boleh null");
        } else {
            try {
                daftarKelasDAO.save(daftarKelas);
                dispose();
            } catch (Exception ex) {
                Logger.getLogger(MuridDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
