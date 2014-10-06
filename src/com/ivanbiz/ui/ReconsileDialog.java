/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DataKelasReportDialog.java
 *
 * Created on Oct 3, 2014, 10:14:44 PM
 */
package com.ivanbiz.ui;

import com.ivanbiz.dao.KelasDAO;
import com.ivanbiz.dao.ReconDAO;
import com.ivanbiz.dao.impl.KelasDAOImpl;
import com.ivanbiz.dao.impl.ReconDAOImpl;
import com.ivanbiz.model.DaftarKelas;
import com.ivanbiz.model.Invoice;
import com.ivanbiz.model.Jurnal;
import com.ivanbiz.model.Kelas;
import com.ivanbiz.model.Pembayaran;
import com.ivanbiz.service.ServiceHelper;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author City_Z
 */
public class ReconsileDialog extends javax.swing.JFrame {

    List<Kelas> listKelas;
    KelasDAO kelasDAO;
    ReconDAO reconDAO;
    List<DaftarKelas> listDaftarKelas;
    List<Invoice> listInvoice;
    List<Pembayaran> listPembayaran;
    List<Jurnal> listJurnal;
    SimpleDateFormat sdf;
    NumberFormat numberFormat;

    /** Creates new form DataKelasReportDialog */
    public ReconsileDialog() {
        initComponents();
        kelasDAO = new KelasDAOImpl();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboBoxKelas = new javax.swing.JComboBox();
        buttonTampil = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDaftarKelas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textPeserta = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableJurnal = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textInvoice = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableTagihan = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textPembayaran = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablePembayaran = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setExtendedState(MainFrame.MAXIMIZED_BOTH);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Kelas :");
        jPanel1.add(jLabel2);

        jPanel1.add(comboBoxKelas);

        buttonTampil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/lihat_laporan.jpg"))); // NOI18N
        buttonTampil.setText("Tampillkan Data");
        buttonTampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTampilActionPerformed(evt);
            }
        });
        jPanel1.add(buttonTampil);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tableDaftarKelas.setAutoCreateRowSorter(true);
        tableDaftarKelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableDaftarKelas);

        jLabel1.setText("Daftar Kelas :");

        jLabel6.setText("Jumlah Peserta :");

        textPeserta.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(textPeserta, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPeserta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tableJurnal.setAutoCreateRowSorter(true);
        tableJurnal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tableJurnal);

        jLabel5.setText("Jurnal :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                    .addComponent(jLabel5))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setPreferredSize(new java.awt.Dimension(316, 170));

        jLabel3.setText("Tagihan / Invoice :");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Total Tagihan :");

        textInvoice.setEditable(false);

        tableTagihan.setAutoCreateRowSorter(true);
        tableTagihan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tableTagihan);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("Pembayaran :");
        jLabel4.setPreferredSize(new java.awt.Dimension(90, 14));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Total Pembayaran :");

        textPembayaran.setEditable(false);

        tablePembayaran.setAutoCreateRowSorter(true);
        tablePembayaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tablePembayaran);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addGap(40, 40, 40)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1025, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1053, 627));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTampilActionPerformed
        try {
            sdf = new SimpleDateFormat("dd-MMMM-yyyy");
            numberFormat = NumberFormat.getCurrencyInstance();
            reconDAO = new ReconDAOImpl();
            Map map = reconDAO.getDataByKelas(listKelas.get(comboBoxKelas.getSelectedIndex()).getId());
            listDaftarKelas = (List<DaftarKelas>) map.get("listDaftarKelas");
            updateTableDaftarKelas();
            listInvoice = (List<Invoice>) map.get("listInvoice");
            updateTableInvoice();
            listPembayaran = (List<Pembayaran>) map.get("listPembayaran");
            updateTablePembayaran();
            listJurnal = (List<Jurnal>) map.get("listJurnal");
            updateTableJurnal();
        } catch (Exception ex) {
            Logger.getLogger(ReconsileDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonTampilActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonTampil;
    private javax.swing.JComboBox comboBoxKelas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tableDaftarKelas;
    private javax.swing.JTable tableJurnal;
    private javax.swing.JTable tablePembayaran;
    private javax.swing.JTable tableTagihan;
    private javax.swing.JTextField textInvoice;
    private javax.swing.JTextField textPembayaran;
    private javax.swing.JTextField textPeserta;
    // End of variables declaration//GEN-END:variables

    private void refresh() {
        try {
            listKelas = kelasDAO.getDataByEquals(Kelas.class, "statusKelas", "N");
            updateComboKelas();
        } catch (Exception ex) {
            Logger.getLogger(ReconsileDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateComboKelas() {
        Object data[] = new Object[listKelas.size()];
        int x = 0;
        for (Kelas kelas : listKelas) {
            data[x] = kelas.getNIK();
            x++;
        }
        comboBoxKelas.setModel(new DefaultComboBoxModel(data));
    }

    private void updateTableDaftarKelas() {
        String[] judul = {"No", "Bank", "Nama", "Telp/Hp", "Kelulusan"};
        Object[][] isi = new Object[listDaftarKelas.size()][5];
        int x = 0;
        int no = 0;
        for (DaftarKelas daftarKelass : listDaftarKelas) {
            no += 1;
            isi[x][0] = no;
            isi[x][1] = daftarKelass.getMurid().getNama();
            isi[x][2] = daftarKelass.getMurid().getBank().getNama();
            isi[x][3] = daftarKelass.getMurid().getTelp() + "/" + daftarKelass.getMurid().getHandphone();
            isi[x][4] = null == daftarKelass.getStatus() ? "N" : "Y";
            x++;
        }
        textPeserta.setText(String.valueOf(listDaftarKelas.size()));
        new ServiceHelper().setAutoRize(isi, judul, tableDaftarKelas);
    }

    private void updateTableInvoice() {
        System.out.println("list==" + listInvoice.toString());
        for (Invoice invoice : listInvoice) {
            System.out.println("invoice=" + invoice.getId());
        }
        String[] judul = {"No", "Tanggal", "No Tagihan", "Bank", "Jumlah Tagihan", "Proses"};
        Object[][] isi = new Object[listInvoice.size()][6];
        int x = 0;
        int no = 0;
        double total = 0;
        for (Invoice invoice : listInvoice) {
            no += 1;
            isi[x][0] = no;
            isi[x][1] = sdf.format(invoice.getDate());
            isi[x][2] = invoice.getNII();
            isi[x][3] = invoice.getBank().getNama();
            isi[x][4] = numberFormat.format(invoice.getJumlahTagihan());
            isi[x][5] = invoice.getStatus().equals("0") ? "N" : "Y";
            total += invoice.getJumlahTagihan();
            x++;
        }
        textInvoice.setText(numberFormat.format(total));
        new ServiceHelper().setAutoRize(isi, judul, tableTagihan);
    }

    private void updateTablePembayaran() {
        String[] judul = {"No", "Tanggal", "No Tagihan", "Jumlah", "Proses"};
        Object[][] isi = new Object[listPembayaran.size()][5];
        int x = 0;
        int no = 0;
        double total = 0;
        for (Pembayaran pembayaran : listPembayaran) {
            no += 1;
            isi[x][0] = no;
            isi[x][1] = pembayaran.getDatePosting();
            isi[x][2] = pembayaran.getInvoice().getNII();
            isi[x][3] = numberFormat.format(pembayaran.getJumlah());
            isi[x][4] = pembayaran.getStatus().equals("0") ? "N" : "Y";
            total += pembayaran.getJumlah();
            x++;
        }
        textPembayaran.setText(numberFormat.format(total));
        new ServiceHelper().setAutoRize(isi, judul, tablePembayaran);
    }

    private void updateTableJurnal() {
        String[] judul = {"No", "Date Reference", "Transaction Reference", "Accounting Reference", "Currency", "Debet", "Credit", "GL Account"};
        Object[][] isi = new Object[listJurnal.size()][8];
        int x = 0;
        int no = 0;
        String kode = "";
        for (Jurnal jurnal : listJurnal) {
            if (!jurnal.getTransactionReference().equals(kode)) {
                no += 1;
                kode = jurnal.getTransactionReference();
                isi[x][0] = no;
                isi[x][1] = sdf.format(jurnal.getDateReference());
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
    }
}
