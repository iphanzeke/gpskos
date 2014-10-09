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

import com.ivanbiz.dao.PengajarDAO;
import com.ivanbiz.dao.impl.PengajarDAOImpl;
import com.ivanbiz.model.AksesMatrix;
import com.ivanbiz.model.Pengajar;
import com.ivanbiz.service.GlobalSession;
import com.ivanbiz.service.MenuAksesConstant;
import com.ivanbiz.service.ServiceHelper;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Shbt Peterpan
 */
public class PengajarDialog extends JDialog {

    Pengajar pengajar;
    List<Pengajar> listPengajar;
    PengajarDAO pengajarDAO = new PengajarDAOImpl();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy");
    String callPengajar;

    public PengajarDialog() {
        initComponents();
        renderButtonAkses(GlobalSession.getListAksesMatrix());
        refresh();
    }

    public PengajarDialog(String callPengajar) {
        initComponents();
        renderButtonAkses(GlobalSession.getListAksesMatrix());
        refresh();
        this.callPengajar = callPengajar;
        setVisible(true);
    }

    public Pengajar getPengajar() {
        return pengajar;
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
        tablePengajar = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        buttonTambah = new javax.swing.JButton();
        buttonUbah = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("Daftar Pengajar");

        tablePengajar.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePengajar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePengajarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePengajar);

        buttonTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/tambah.jpg"))); // NOI18N
        buttonTambah.setText("Tambah Pengajar Baru");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });
        jPanel2.add(buttonTambah);

        buttonUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/ubah.jpg"))); // NOI18N
        buttonUbah.setText("Ubah Pengajar Terseleksi");
        buttonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahActionPerformed(evt);
            }
        });
        jPanel2.add(buttonUbah);

        buttonHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/hapus.jpg"))); // NOI18N
        buttonHapus.setText("Hapus Pengajar Terseleksi");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-816)/2, (screenSize.height-638)/2, 816, 638);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        new PengajarUpdateDialog(null, rootPaneCheckingEnabled).setVisible(true);
        refresh();
}//GEN-LAST:event_buttonTambahActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        if (tablePengajar.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                pengajar = listPengajar.get(tablePengajar.getSelectedRow());
                pengajarDAO.delete(pengajar);
                refresh();
            } catch (Exception ex) {
                Logger.getLogger(PengajarDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void buttonUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahActionPerformed
        if (tablePengajar.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan diubah", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            pengajar = listPengajar.get(tablePengajar.getSelectedRow());
            new PengajarUpdateDialog(null, rootPaneCheckingEnabled, pengajar).setVisible(true);
            refresh();
        }
    }//GEN-LAST:event_buttonUbahActionPerformed

    private void tablePengajarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePengajarMouseClicked
        if (callPengajar != null) {
            if (evt.getClickCount() == 2) {
                pengajar = listPengajar.get(tablePengajar.getSelectedRow());
                dispose();
            }
        }
    }//GEN-LAST:event_tablePengajarMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePengajar;
    // End of variables declaration//GEN-END:variables

    private void refresh() {
        try {
            listPengajar = pengajarDAO.getAll(Pengajar.class);
            updateTablePengajar();
        } catch (Exception ex) {
            Logger.getLogger(PengajarDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void renderButtonAkses(List<AksesMatrix> listAksesMatrix) {
        buttonTambah.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.TAMBAH_PENGAJAR, listAksesMatrix));
        buttonUbah.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.UBAH_PENGAJAR, listAksesMatrix));
        buttonHapus.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.HAPUS_PENGAJAR, listAksesMatrix));
    }

    private void updateTablePengajar() {
        String[] judul = {"No", "NIP", "Nama", "Telp", "Handphone", "Email", "Date", "Alamat"};
        Object[][] isi = new Object[listPengajar.size()][8];
        int x = 0;
        int no = 0;
        for (Pengajar pengajars : listPengajar) {
            no += 1;
            isi[x][0] = no;
            isi[x][1] = pengajars.getNIP();
            isi[x][2] = pengajars.getNama();
            isi[x][3] = pengajars.getTelp();
            isi[x][4] = pengajars.getHandphone();
            isi[x][5] = pengajars.getEmail();
            isi[x][6] = sdf.format(pengajars.getDate());
            isi[x][7] = pengajars.getAlamat();
            x++;
        }
        new ServiceHelper().setAutoRize(isi, judul, tablePengajar);
    }
}