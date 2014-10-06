/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.ui;

import com.ivanbiz.dao.DaftarKelasDAO;
import com.ivanbiz.dao.KelasDAO;
import com.ivanbiz.dao.impl.DaftarKelasDAOImpl;
import com.ivanbiz.dao.impl.KelasDAOImpl;
import com.ivanbiz.model.DaftarKelas;
import com.ivanbiz.model.Kelas;
import com.ivanbiz.report.DaftarKelasReport;
import com.ivanbiz.service.ServiceHelper;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Shbt Peterpan
 */
public class DaftarKelasReportDialog extends javax.swing.JDialog {

    DaftarKelasDAO daftarKelasDAO;
    List<DaftarKelas> listDaftarKelas;
    List<Kelas> listKelas;
    KelasDAO kelasDAO;
    SimpleDateFormat sdf;

    public DaftarKelasReportDialog() {
        initComponents();
        daftarKelasDAO = new DaftarKelasDAOImpl();
        kelasDAO = new KelasDAOImpl();
        sdf = new SimpleDateFormat("dd-MMMM-yyyy");
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
        tableKelas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        buttonPreview = new javax.swing.JButton();
        buttonCetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Daftar Kelas");

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

        buttonPreview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/preview.jpg"))); // NOI18N
        buttonPreview.setText("Preview");
        buttonPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPreviewActionPerformed(evt);
            }
        });
        jPanel1.add(buttonPreview);

        buttonCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/cetak.jpg"))); // NOI18N
        buttonCetak.setText("Cetak");
        buttonCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCetakActionPerformed(evt);
            }
        });
        jPanel1.add(buttonCetak);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(808, 627));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPreviewActionPerformed
        if (tableKelas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dipreview", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                listDaftarKelas = daftarKelasDAO.getDataByEquals(DaftarKelas.class, "transactionReference", listKelas.get(tableKelas.getSelectedRow()).getTransactionReference());
                new DaftarKelasReport().previewAndCetakTagihan(listDaftarKelas, "preview");
            } catch (Exception ex) {
                Logger.getLogger(DaftarKelasReportDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonPreviewActionPerformed

    private void buttonCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCetakActionPerformed
        if (tableKelas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dicetak", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                listDaftarKelas = daftarKelasDAO.getDataByEquals(DaftarKelas.class, "transactionReference", listKelas.get(tableKelas.getSelectedRow()).getTransactionReference());
                new DaftarKelasReport().previewAndCetakTagihan(listDaftarKelas, "cetak");
            } catch (Exception ex) {
                Logger.getLogger(DaftarKelasReportDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonCetakActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCetak;
    private javax.swing.JButton buttonPreview;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableKelas;
    // End of variables declaration//GEN-END:variables
    private void refresh() {
        try {
            listKelas = kelasDAO.getAll(Kelas.class);
            updateTableDaftarKelas();
        } catch (Exception ex) {
            Logger.getLogger(DaftarKelasReportDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateTableDaftarKelas() {
        String[] judul = {"No", "Transaksi Reference", "NIK", "Deskripsi", "Pengajar", "Tanggal", "Tempat", "Alamat"};
        Object[][] isi = new Object[listKelas.size()][8];
        int x = 0;
        int no = 0;
        for (Kelas kelass : listKelas) {
            no += 1;
            isi[x][0] = no;
            isi[x][1] = kelass.getTransactionReference();
            isi[x][2] = kelass.getNIK();
            isi[x][3] = kelass.getDeskripsi();
            isi[x][4] = "(" + kelass.getPengajar().getNIP() + ") - " + kelass.getPengajar().getNama();
            isi[x][5] = sdf.format(kelass.getTanggalKelas());
            isi[x][6] = kelass.getTempatKelas();
            isi[x][7] = kelass.getAlamatKelas();
            x++;
        }
        new ServiceHelper().setAutoRize(isi, judul, tableKelas);
    }
}
