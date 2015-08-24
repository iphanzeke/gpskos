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

import com.ivanbiz.dao.GLAccountDAO;
import com.ivanbiz.dao.JurnalDAO;
import com.ivanbiz.dao.impl.GLAccountDAOImpl;
import com.ivanbiz.dao.impl.JurnalDAOImpl;
import com.ivanbiz.model.GLAccount;
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
public class BiayaLainSumReportDialog extends javax.swing.JDialog {

    JurnalDAO jurnalDAO;
    SimpleDateFormat dateFormat;
    SimpleDateFormat formatDate;
    NumberFormat numberFormat;
    GLAccountDAO gLAccountDAO;
    List<GLAccount> listGLAccount;
    Date dariTanggal;
    Date sampaiTanggal;

    /**
     * Creates new form LaporanJurnalFrame
     *
     * @param dariTanggal
     * @param sampaiTanggal
     */
    public BiayaLainSumReportDialog(Date dariTanggal, Date sampaiTanggal) {
        try {
            initComponents();
            this.dariTanggal = dariTanggal;
            this.sampaiTanggal = sampaiTanggal;
            jurnalDAO = new JurnalDAOImpl();
            gLAccountDAO = new GLAccountDAOImpl();
            dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
            formatDate = new SimpleDateFormat("yyyy-MM-dd");
            numberFormat = NumberFormat.getNumberInstance();
            jLabelJudul.setText("Dari tanggal " + dateFormat.format(dariTanggal) + " sampai tanggal " + dateFormat.format(sampaiTanggal));
            listGLAccount = gLAccountDAO.getDataByEquals(GLAccount.class, "groupACC", "BiayaLain");
            updateTableJurnal(dariTanggal, sampaiTanggal);
        } catch (Exception ex) {
            Logger.getLogger(BiayaLainSumReportDialog.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel3 = new javax.swing.JLabel();
        jLabelJudul = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableJurnal = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setAlwaysOnTop(true);
        setModal(true);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel3.setText("Laporan Biaya Lain - Lain");

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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/preview.jpg"))); // NOI18N
        jButton1.setText("Lihat Detail");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(jLabelJudul, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelJudul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-816)/2, (screenSize.height-603)/2, 816, 603);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (tableJurnal.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Data belum dipilih", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            new KeuntunganReportBiayaLainDialog(listGLAccount.get(tableJurnal.getSelectedRow()), dariTanggal, sampaiTanggal).setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelJudul;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableJurnal;
    // End of variables declaration//GEN-END:variables

    private void updateTableJurnal(Date dariTanggal, Date sampaiTanggal) throws Exception {
        String[] judul = {"No", "No GL", "Nama GL", "Jumlah"};
        Object[][] isi = new Object[listGLAccount.size()][4];
        int x = 0;
        int no = 0;
        double jumlah = 0;
        for (GLAccount gLAccount : listGLAccount) {
            no += 1;
            isi[x][0] = no;
            isi[x][1] = gLAccount.getNoGL();
            isi[x][2] = gLAccount.getNameGL();
            isi[x][3] = numberFormat.format(jurnalDAO.getSumCreditGLAccount(formatDate.format(dariTanggal), formatDate.format(sampaiTanggal), gLAccount.getNoGL()));
            x++;
        }
        new ServiceHelper().setAutoRize(isi, judul, tableJurnal);
        tableJurnal.getColumnModel().getColumn(3).setCellRenderer(new RenderingKanan());
    }
}