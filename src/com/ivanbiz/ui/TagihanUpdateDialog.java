/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.ui;

import com.ivanbiz.dao.BankDAO;
import com.ivanbiz.dao.GLAccountDAO;
import com.ivanbiz.dao.InvoiceDAO;
import com.ivanbiz.dao.KelasDAO;
import com.ivanbiz.dao.impl.BankDAOImpl;
import com.ivanbiz.dao.impl.GLAccountDAOImpl;
import com.ivanbiz.dao.impl.InvoiceDAOImpl;
import com.ivanbiz.dao.impl.KelasDAOImpl;
import com.ivanbiz.model.Bank;
import com.ivanbiz.model.GLAccount;
import com.ivanbiz.model.Invoice;
import com.ivanbiz.model.Kelas;
import com.ivanbiz.service.JTextFieldLimit;
import com.ivanbiz.service.ServiceHelper;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Shbt Peterpan
 */
public class TagihanUpdateDialog extends javax.swing.JDialog {

    Invoice invoice;
    InvoiceDAO invoiceDAO = new InvoiceDAOImpl();
    KelasDAO kelasDAO = new KelasDAOImpl();
    BankDAO bankDAO = new BankDAOImpl();
    GLAccountDAO gLAccountDAO = new GLAccountDAOImpl();
    List<Kelas> listKelas;
    List<Bank> listBank;
    List<GLAccount> listGLAccounts;

    /**
     * Creates new form TagihanDialog
     *
     * @param mainFrame
     * @param modal
     */
    public TagihanUpdateDialog(MainFrame mainFrame, boolean modal) {
        initComponents();
        dateChooserDate.setDate(new Date());
        refresh();
    }

    public TagihanUpdateDialog(MainFrame mainFrame, boolean modal, Invoice invoice) {
        initComponents();
        this.invoice = invoice;
        refresh();
        refreshKepada(invoice.getBank().getNama());
        labelTagihan.setText("Ubah Tagihan");
        dateChooserDate.setDate(invoice.getDate());
        textNII.setText(invoice.getNII());
        comboBank.setSelectedItem(invoice.getBank().getNama());
        comboKelas.setSelectedItem(invoice.getKelas().getTransactionReference());
        comboBoxKepada.setSelectedItem(listGLAccounts);
        textPembayaran.setText(invoice.getDeskripsiUntukPembayaran());
        textPeserta.setText(invoice.getDeskripsiJumlahPeserta());
        textJumlah.setText(invoice.getJumlahTagihan().toBigInteger().toString());
        textTerbilang.setText(ServiceHelper.bilang(Long.parseLong(invoice.getJumlahTagihan().toBigInteger().toString())));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTagihan = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textNII = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboKelas = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        comboBank = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        textPembayaran = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textPeserta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textJumlah = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dateChooserDate = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        textTerbilang = new javax.swing.JEditorPane();
        comboBoxKepada = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        buttonSimpan = new javax.swing.JButton();
        buttonBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        labelTagihan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelTagihan.setText("Tambah Tagihan Baru");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("NII :");

        textNII.setDocument(new JTextFieldLimit(50));

        jLabel3.setText("Kelas :");

        jLabel4.setText("Bank :");

        comboBank.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBankItemStateChanged(evt);
            }
        });

        jLabel5.setText("Kepada :");

        textPembayaran.setDocument(new JTextFieldLimit(250));

        jLabel6.setText("Untuk Pembayaran :");

        textPeserta.setDocument(new JTextFieldLimit(250));

        jLabel7.setText("Jumlah Peserta :");

        textJumlah.setDocument(new JTextFieldLimit(15)
        );
        textJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textJumlahKeyReleased(evt);
            }
        });

        jLabel8.setText("Jumlah Tagihan :");

        jLabel9.setText("Terbilang :");

        jLabel10.setText("Date :");

        dateChooserDate.setEnabled(false);

        textTerbilang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textTerbilang.setEnabled(false);
        jScrollPane1.setViewportView(textTerbilang);

        comboBoxKepada.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBank, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textNII)
                    .addComponent(comboKelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textPembayaran)
                    .addComponent(textPeserta)
                    .addComponent(textJumlah)
                    .addComponent(dateChooserDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(comboBoxKepada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateChooserDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textNII, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxKepada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPeserta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });
        jPanel2.add(buttonSimpan);

        buttonBatal.setText("Batal");
        buttonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBatalActionPerformed(evt);
            }
        });
        jPanel2.add(buttonBatal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTagihan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTagihan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(508, 626));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBatalActionPerformed
        dispose();
    }//GEN-LAST:event_buttonBatalActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        if (invoice == null) {
            invoice = new Invoice();
        }
        invoice.setDate(dateChooserDate.getDate());
        invoice.setNII(textNII.getText());
        invoice.setKelas(listKelas.get(comboKelas.getSelectedIndex()));
        invoice.setBank(listBank.get(comboBank.getSelectedIndex()));
        invoice.setDeskripsiKepada(comboBoxKepada.getSelectedItem().toString());
        invoice.setDeskripsiUntukPembayaran(textPembayaran.getText());
        invoice.setDeskripsiJumlahPeserta(textPeserta.getText());
        invoice.setJumlahTagihan(new BigDecimal(textJumlah.getText().replaceAll(",", "")));
        validate(invoice);
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void textJumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textJumlahKeyReleased
        if (textJumlah.getText().isEmpty()) {
            textTerbilang.setText("");
        } else {
            try {
                Long.parseLong(textJumlah.getText());
                textTerbilang.setText(ServiceHelper.bilang(Long.parseLong(textJumlah.getText())));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Format uang salah, harus angka", "warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_textJumlahKeyReleased

    private void comboBankItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBankItemStateChanged
        refreshKepada(comboBank.getSelectedItem().toString());
        comboBoxKepada.setSelectedItem(listGLAccounts);
        comboBoxKepada.setEnabled(true);
    }//GEN-LAST:event_comboBankItemStateChanged

    private void validate(Invoice invoice) {
        if (invoice == null) {
            JOptionPane.showMessageDialog(this, "Murid tidak boleh null");
        } else if (invoice.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Date tidak boleh null");
        } else if (invoice.getNII() == null) {
            JOptionPane.showMessageDialog(this, "NII tidak boleh null");
        } else if (invoice.getNII().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "NII tidak boleh kosong");
        } else if (invoice.getKelas() == null) {
            JOptionPane.showMessageDialog(this, "Kelas tidak boleh null");
        } else if (invoice.getBank() == null) {
            JOptionPane.showMessageDialog(this, "Bank tidak boleh null");
        } else if (invoice.getDeskripsiKepada() == null) {
            JOptionPane.showMessageDialog(this, "Kepada tidak boleh null");
        } else if (invoice.getDeskripsiKepada().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Kepada tidak boleh kosong");
        } else if (invoice.getDeskripsiUntukPembayaran() == null) {
            JOptionPane.showMessageDialog(this, "Untuk Pembayaran tidak boleh null");
        } else if (invoice.getDeskripsiUntukPembayaran().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Untuk Pembayaran tidak boleh kosong");
        } else if (invoice.getDeskripsiJumlahPeserta() == null) {
            JOptionPane.showMessageDialog(this, "Jumlah Peserta tidak boleh null");
        } else if (invoice.getDeskripsiJumlahPeserta().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Jumlah Peserta tidak boleh kosong");
        } else if (invoice.getJumlahTagihan() == null) {
            JOptionPane.showMessageDialog(this, "Jumlah Tagihan tidak boleh null");
        } else {
            try {
                invoiceDAO.saveOrUpdate(invoice);
                dispose();
            } catch (Exception ex) {
                Logger.getLogger(TagihanUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBatal;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JComboBox comboBank;
    private javax.swing.JComboBox comboBoxKepada;
    private javax.swing.JComboBox comboKelas;
    private com.toedter.calendar.JDateChooser dateChooserDate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTagihan;
    private javax.swing.JTextField textJumlah;
    private javax.swing.JTextField textNII;
    private javax.swing.JTextField textPembayaran;
    private javax.swing.JTextField textPeserta;
    private javax.swing.JEditorPane textTerbilang;
    // End of variables declaration//GEN-END:variables

    private void refresh() {
        try {
            listKelas = kelasDAO.getAll(Kelas.class);
            updateComboKelas();
            listBank = bankDAO.getAll(Bank.class);
            updateComboBank();
        } catch (Exception ex) {
            Logger.getLogger(TagihanUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateComboKelas() {
        Object data[] = new Object[listKelas.size()];
        int x = 0;
        for (Kelas kelas : listKelas) {
            data[x] = kelas.getTransactionReference();
            x++;
        }
        comboKelas.setModel(new DefaultComboBoxModel(data));
    }

    private void updateComboBank() {
        Object data[] = new Object[listBank.size()];
        int x = 0;
        for (Bank bank : listBank) {
            data[x] = bank.getNama();
            x++;
        }
        comboBank.setModel(new DefaultComboBoxModel(data));
    }

    private void refreshKepada(String nama) {
        try {
            Map map = new HashMap();
            map.put("nama", nama);
            map.put("groupACC", "2");
            listGLAccounts = gLAccountDAO.getDataByEqualsMore(GLAccount.class, map);
        } catch (Exception ex) {
            Logger.getLogger(TagihanUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
