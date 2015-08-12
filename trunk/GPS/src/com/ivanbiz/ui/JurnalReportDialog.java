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

import com.ivanbiz.dao.JurnalDAO;
import com.ivanbiz.dao.impl.JurnalDAOImpl;
import com.ivanbiz.model.Jurnal;
import com.ivanbiz.service.RenderingKanan;
import com.ivanbiz.service.ServiceHelper;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shbt Peterpan
 */
public class JurnalReportDialog extends javax.swing.JDialog {

    List<Jurnal> listJurnal;
    JurnalDAO jurnalDAO;
    SimpleDateFormat dateFormat;
    NumberFormat numberFormat;

    /**
     * Creates new form LaporanJurnalFrame
     *
     * @param dariTanggal
     * @param sampaiTanggal
     */
    public JurnalReportDialog(Date dariTanggal, Date sampaiTanggal) {
        try {
            initComponents();
            jurnalDAO = new JurnalDAOImpl();
            dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
            numberFormat = NumberFormat.getNumberInstance();
            jLabelJudul.setText("Dari tanggal " + dateFormat.format(dariTanggal) + " sampai tanggal " + dateFormat.format(sampaiTanggal));
            listJurnal = jurnalDAO.getData(Jurnal.class, dariTanggal, sampaiTanggal);
            updateTableJurnal();
        } catch (Exception ex) {
            Logger.getLogger(JurnalReportDialog.class.getName()).log(Level.SEVERE, null, ex);
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

        setAlwaysOnTop(true);
        setModal(true);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel3.setText("Laporan Jurnal");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-816)/2, (screenSize.height-638)/2, 816, 638);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelJudul;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableJurnal;
    // End of variables declaration//GEN-END:variables

    private void updateTableJurnal() {
        String[] judul = {"No", "Date Reference", "Transaction Reference", "Accounting Reference", "Currency", "Debet", "Credit", "GL Account"};
        Object[][] isi = new Object[listJurnal.size()][8];
        int x = 0;
        int no = 0;
        String kode = "";
        for (Jurnal jurnal : listJurnal) {
            if (!kode.equals(jurnal.getTransactionReference())) {
                no += 1;
                kode = jurnal.getTransactionReference();
                isi[x][0] = no;
                isi[x][1] = dateFormat.format(jurnal.getDateReference());
                isi[x][2] = kode;
                isi[x][3] = jurnal.getAccountingReference();
                isi[x][4] = jurnal.getCurrency();
            } else {
                isi[x][0] = "";
                isi[x][1] = "";
                isi[x][2] = "";
                isi[x][3] = "";
                isi[x][4] = "";
            }
            isi[x][5] = numberFormat.format(jurnal.getDebit());
            isi[x][6] = numberFormat.format(jurnal.getCredit());
            isi[x][7] = jurnal.getGLAccount();
            x++;
        }
        new ServiceHelper().setAutoRize(isi, judul, tableJurnal);
        tableJurnal.getColumnModel().getColumn(5).setCellRenderer(new RenderingKanan());
        tableJurnal.getColumnModel().getColumn(6).setCellRenderer(new RenderingKanan());
    }
}
