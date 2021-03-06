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

import com.ivanbiz.dao.PembayaranDAO;
import com.ivanbiz.dao.impl.PembayaranDAOImpl;
import com.ivanbiz.model.Pembayaran;
import com.ivanbiz.report.PembayaranReport;
import com.ivanbiz.service.RenderingKanan;
import com.ivanbiz.service.ServiceHelper;
import java.text.NumberFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Shbt Peterpan
 */
public class PembayaranTagihanReportDialog extends JDialog {

    PembayaranDAO pembayaranDAO;
    List<Pembayaran> listPembayaran;
    NumberFormat numberFormat;

    /**
     * Creates new form PengajarDialog
     */
    public PembayaranTagihanReportDialog() {
        initComponents();
        pembayaranDAO = new PembayaranDAOImpl();
        numberFormat = NumberFormat.getNumberInstance();
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
        tablePembayaran = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        buttonPreview = new javax.swing.JButton();
        buttonCetak = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        comboBoxPencarian = new javax.swing.JComboBox();
        textCari = new javax.swing.JTextField();

        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("Laporan Pembayaran Tagihan");

        tablePembayaran.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablePembayaran);

        buttonPreview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/preview.jpg"))); // NOI18N
        buttonPreview.setText("Lihat Pembayaran Terseleksi");
        buttonPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPreviewActionPerformed(evt);
            }
        });
        jPanel2.add(buttonPreview);

        buttonCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/cetak.jpg"))); // NOI18N
        buttonCetak.setText("Cetak Pembayaran Terseleksi");
        buttonCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCetakActionPerformed(evt);
            }
        });
        jPanel2.add(buttonCetak);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Pencarian"));

        comboBoxPencarian.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NII" }));

        textCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textCariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboBoxPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textCari, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-816)/2, (screenSize.height-638)/2, 816, 638);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPreviewActionPerformed
        if (tablePembayaran.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dilihat", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
//            try {
                new PembayaranReport().previewAndCetakTagihan(listPembayaran.get(tablePembayaran.getSelectedRow()), "preview");
//                Pembayaran pembayaran = listPembayaran.get(tablePembayaran.getSelectedRow());
//                Properties ftpProperties = new Properties();
//                ftpProperties.load(ClassLoader.getSystemResourceAsStream("ftp.properties"));
//                String sb = "ftp://" + ftpProperties.getProperty("user") + ":" + ftpProperties.getProperty("password") + "@" + ftpProperties.getProperty("ip") + "/INBOX/" + pembayaran.getTransactionReference() + ".JPG;type=i";
//                PembayaranBuktiDialog pembayaranBuktiDialog = new PembayaranBuktiDialog(null, true, sb, pembayaran, "report");
//            } catch (IOException ex) {
//                Logger.getLogger(PembayaranTagihanReportDialog.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }//GEN-LAST:event_buttonPreviewActionPerformed

    private void buttonCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCetakActionPerformed
        if (tablePembayaran.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dicetak", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            new PembayaranReport().previewAndCetakTagihan(listPembayaran.get(tablePembayaran.getSelectedRow()), "cetak");
        }
    }//GEN-LAST:event_buttonCetakActionPerformed

    private void textCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCariKeyReleased
        try {
            listPembayaran = pembayaranDAO.getDataByLike(Pembayaran.class, "transactionReference", textCari.getText());
            updateTablePembayaran();
        } catch (Exception ex) {
            Logger.getLogger(TagihanReportDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_textCariKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCetak;
    private javax.swing.JButton buttonPreview;
    private javax.swing.JComboBox comboBoxPencarian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePembayaran;
    private javax.swing.JTextField textCari;
    // End of variables declaration//GEN-END:variables

    private void refresh() {
        try {
            listPembayaran = pembayaranDAO.getDataByEquals(Pembayaran.class, "status", "1");
            updateTablePembayaran();
        } catch (Exception ex) {
            Logger.getLogger(GLAccountDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateTablePembayaran() {
        String[] judul = {"No", "Date Posting", "No Tagihan / Invoice", "Debitur", "Kreditur", "Jumlah", "Deskripsi"};
        Object[][] isi = new Object[listPembayaran.size()][7];
        int x = 0;
        int no = 0;
        for (Pembayaran pembayaran : listPembayaran) {
            no += 1;
            isi[x][0] = no;
            isi[x][1] = pembayaran.getDatePosting();
            isi[x][2] = pembayaran.getInvoice().getNII();
            isi[x][3] = pembayaran.getDebitBankAccount().getNameGL() + " A/C NO. " + pembayaran.getDebitBankAccount().getNoGL();
            isi[x][4] = pembayaran.getKreditBankAccount().getNameGL() + " A/C NO. " + pembayaran.getKreditBankAccount().getNoGL();
            isi[x][5] = numberFormat.format(pembayaran.getJumlah());
            isi[x][6] = pembayaran.getDeskripsi();
            x++;
        }
        tablePembayaran.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        new ServiceHelper().setAutoRize(isi, judul, tablePembayaran);
        tablePembayaran.getColumnModel().getColumn(5).setCellRenderer(new RenderingKanan());
    }
}
