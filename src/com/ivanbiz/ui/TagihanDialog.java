/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.ui;

import com.ivanbiz.dao.InvoiceDAO;
import com.ivanbiz.dao.impl.InvoiceDAOImpl;
import com.ivanbiz.model.AksesMatrix;
import com.ivanbiz.model.Invoice;
import com.ivanbiz.service.GlobalSession;
import com.ivanbiz.service.MenuAksesConstant;
import com.ivanbiz.service.RenderingKanan;
import com.ivanbiz.service.ServiceHelper;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Shbt Peterpan
 */
public class TagihanDialog extends javax.swing.JDialog {

    Invoice invoice;
    InvoiceDAO invoiceDAO;
    List<Invoice> listInvoice;
    SimpleDateFormat sdf;
    NumberFormat numberFormat;

    public TagihanDialog() {
        initComponents();
        renderButtonAkses(GlobalSession.getListAksesMatrix());
        invoiceDAO = new InvoiceDAOImpl();
        sdf = new SimpleDateFormat("dd-MMMM-yyyy");
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
        tableTagihan = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        buttonTambah = new javax.swing.JButton();
        buttonUbah = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();
        buttonKirim = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("Daftar Tagihan");

        tableTagihan.setAutoCreateRowSorter(true);
        tableTagihan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableTagihan);

        buttonTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/tambah.jpg"))); // NOI18N
        buttonTambah.setText("Tambah TagihanTerseleksi");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });
        jPanel1.add(buttonTambah);

        buttonUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/ubah.jpg"))); // NOI18N
        buttonUbah.setText("Ubah Tagihan Terseleksi");
        buttonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahActionPerformed(evt);
            }
        });
        jPanel1.add(buttonUbah);

        buttonHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/hapus.jpg"))); // NOI18N
        buttonHapus.setText("Hapus Tagihan Terseleksi");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });
        jPanel1.add(buttonHapus);

        buttonKirim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/process.jpg"))); // NOI18N
        buttonKirim.setText("Proses Tagihan Terseleksi");
        buttonKirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKirimActionPerformed(evt);
            }
        });
        jPanel1.add(buttonKirim);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE))
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

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-866)/2, (screenSize.height-638)/2, 866, 638);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        new TagihanUpdateDialog(null, true).setVisible(true);
        refresh();
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void buttonUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahActionPerformed
        if (tableTagihan.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan diubah", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            invoice = listInvoice.get(tableTagihan.getSelectedRow());
            new TagihanUpdateDialog(null, true, invoice).setVisible(true);
            refresh();
        }
    }//GEN-LAST:event_buttonUbahActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        if (tableTagihan.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                invoice = listInvoice.get(tableTagihan.getSelectedRow());
                invoiceDAO.delete(invoice);
                refresh();
            } catch (Exception ex) {
                Logger.getLogger(TagihanDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void buttonKirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKirimActionPerformed
        if (tableTagihan.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dikirim", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            int response = JOptionPane.showConfirmDialog(this, "Apakah Tagihan ingin dikirim ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                try {
                    invoice = listInvoice.get(tableTagihan.getSelectedRow());
                    String[] kode_noGL = invoice.getDeskripsiKepada().split("#");
                    invoiceDAO.sendInvoice(invoice, kode_noGL[2], kode_noGL[0]);
                    refresh();
                } catch (Exception ex) {
                    Logger.getLogger(TagihanDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_buttonKirimActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonKirim;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableTagihan;
    // End of variables declaration//GEN-END:variables

    private void refresh() {
        try {
            listInvoice = invoiceDAO.getDataByEquals(Invoice.class, "status", "0");
            updateTableTagihan();
        } catch (Exception ex) {
            Logger.getLogger(TagihanDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateTableTagihan() {
        String[] judul = {"No", "Date", "NII", "Kelas", "Bank", "Kepada", "Untuk Pembayaran", "Jumlah Peserta", "Jumlah Tagihan", "Jatuh Tempo", "Mohon Ditransfer Ke"};
        Object[][] isi = new Object[listInvoice.size()][11];
        int x = 0;
        int no = 0;
        for (Invoice invoices : listInvoice) {
            no += 1;
            String[] kepada;
            kepada = invoices.getDeskripsiKepada().split("#");
            String[] deskripsi;
            deskripsi = invoices.getDeskripsiUntuk().split("#");
            isi[x][0] = no;
            isi[x][1] = sdf.format(invoices.getDate());
            isi[x][2] = invoices.getNII();
            isi[x][3] = invoices.getKelas().getTransactionReference();
            isi[x][4] = invoices.getBank().getNama();
            isi[x][5] = kepada[1] + " A/C No. " + kepada[0];
            isi[x][6] = invoices.getDeskripsiUntukPembayaran();
            isi[x][7] = invoices.getDeskripsiJumlahPeserta();
            isi[x][8] = numberFormat.format(invoices.getJumlahTagihan());
            isi[x][9] = invoices.getJatuhTempo();
            isi[x][10] = deskripsi[1] + " A/C No. " + deskripsi[0];
            x++;
        }
        tableTagihan.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        new ServiceHelper().setAutoRize(isi, judul, tableTagihan);
        tableTagihan.getColumnModel().getColumn(8).setCellRenderer(new RenderingKanan());
    }

    private void renderButtonAkses(List<AksesMatrix> listAksesMatrix) {
        buttonTambah.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.TAMBAH_TAGIHAN, listAksesMatrix));
        buttonUbah.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.UBAH_TAGIHAN, listAksesMatrix));
        buttonHapus.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.HAPUS_TAGIHAN, listAksesMatrix));
        buttonKirim.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.KIRIM_TAGIHAN, listAksesMatrix));
    }
}
