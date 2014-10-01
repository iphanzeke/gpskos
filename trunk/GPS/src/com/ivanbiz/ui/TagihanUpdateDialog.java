/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.ui;

import com.ivanbiz.dao.BankDAO;
import com.ivanbiz.dao.DaftarKelasDAO;
import com.ivanbiz.dao.GLAccountDAO;
import com.ivanbiz.dao.InvoiceDAO;
import com.ivanbiz.dao.KelasDAO;
import com.ivanbiz.dao.impl.BankDAOImpl;
import com.ivanbiz.dao.impl.DaftarKelasDAOImpl;
import com.ivanbiz.dao.impl.GLAccountDAOImpl;
import com.ivanbiz.dao.impl.InvoiceDAOImpl;
import com.ivanbiz.dao.impl.KelasDAOImpl;
import com.ivanbiz.model.Bank;
import com.ivanbiz.model.DaftarKelas;
import com.ivanbiz.model.GLAccount;
import com.ivanbiz.model.Invoice;
import com.ivanbiz.model.Kelas;
import com.ivanbiz.service.JTextFieldLimit;
import com.ivanbiz.service.ServiceHelper;
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
    DaftarKelasDAO daftarKelasDAO = new DaftarKelasDAOImpl();
    List<Kelas> listKelas;
    List<Bank> listBank;
    List<GLAccount> listGLAccounts;
    List<GLAccount> listGLAccountsKreditur;
    List<DaftarKelas> listDaftarKelas;

    /**
     * Creates new form TagihanDialog
     *
     * @param mainFrame
     * @param modal
     */
    public TagihanUpdateDialog(MainFrame mainFrame, boolean modal) {
        initComponents();
        dateChooserDate.setDate(new Date());
        renderKelas();
        renderDitranfer();
    }

    public TagihanUpdateDialog(MainFrame mainFrame, boolean modal, Invoice invoice) {
        initComponents();
        this.invoice = invoice;
        labelTagihan.setText("Ubah Tagihan");
        dateChooserDate.setDate(invoice.getDate());
        textNII.setText(invoice.getNII());
        renderKelas();
        comboKelas.setSelectedItem(invoice.getKelas().getTransactionReference());
        renderBankUbah(invoice.getKelas().getTransactionReference());
        comboBank.setSelectedItem(invoice.getBank().getNama());
        renderKepada(invoice.getBank());
        String[] kepada = invoice.getDeskripsiKepada().split("#");
        comboKepada.setSelectedItem(kepada[1] + " A/C No. " + kepada[0]);
        textAreaKepada.setText(listGLAccounts.get(comboKepada.getSelectedIndex()).getDeskripsi());
        textPembayaran.setText(invoice.getDeskripsiUntukPembayaran());
        textPeserta.setText(invoice.getDeskripsiJumlahPeserta());
        textJumlah.setText(String.valueOf(new Double(invoice.getJumlahTagihan()).intValue()));
        textTerbilang.setText(ServiceHelper.bilang(Integer.parseInt(String.valueOf(new Double(invoice.getJumlahTagihan()).intValue()))) + " rupiah");
        textJatuhTempo.setText(invoice.getJatuhTempo());
        renderDitranfer();
        String[] ditransferKe = invoice.getDeskripsiUntuk().split("#");
        comboDitransfer.setSelectedItem(ditransferKe[1] + " A/C No. " + ditransferKe[0]);
        textAreaDitransferKe.setText(listGLAccountsKreditur.get(comboDitransfer.getSelectedIndex()).getDeskripsi());
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
        jLabel10 = new javax.swing.JLabel();
        dateChooserDate = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        textNII = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboKelas = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        comboBank = new javax.swing.JComboBox();
        buttonDaftarMurid = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        textPeserta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboKepada = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        textAreaKepada = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        textPembayaran = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textJumlah = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textJatuhTempo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textTerbilang = new javax.swing.JEditorPane();
        jLabel12 = new javax.swing.JLabel();
        comboDitransfer = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaDitransferKe = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        buttonSimpan = new javax.swing.JButton();
        buttonBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        labelTagihan.setFont(new java.awt.Font("Tahoma", 1, 24));
        labelTagihan.setText("Tambah Tagihan Baru");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setText("Date :");

        dateChooserDate.setEnabled(false);

        jLabel2.setText("No Tagihan / Invoice :");

        textNII.setDocument(new JTextFieldLimit(50));

        jLabel3.setText("Kelas :");

        comboKelas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboKelasItemStateChanged(evt);
            }
        });

        jLabel4.setText("Bank :");

        comboBank.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBankItemStateChanged(evt);
            }
        });

        buttonDaftarMurid.setText("Daftar Murid");
        buttonDaftarMurid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDaftarMuridActionPerformed(evt);
            }
        });

        jLabel7.setText("Jumlah Peserta :");

        textPeserta.setDocument(new JTextFieldLimit(250));
        textPeserta.setEnabled(false);
        textPeserta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textPesertaKeyReleased(evt);
            }
        });

        jLabel5.setText("Kepada :");

        comboKepada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKepadaActionPerformed(evt);
            }
        });

        textAreaKepada.setColumns(20);
        textAreaKepada.setEditable(false);
        textAreaKepada.setRows(5);
        textAreaKepada.setEnabled(false);
        jScrollPane3.setViewportView(textAreaKepada);

        jLabel6.setText("Untuk Pembayaran :");

        textPembayaran.setDocument(new JTextFieldLimit(250));

        jLabel8.setText("Jumlah Tagihan :");

        textJumlah.setDocument(new JTextFieldLimit(15)
        );
        textJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textJumlahKeyReleased(evt);
            }
        });

        jLabel11.setText("Jatuh Tempo ( Hari ) :");

        textJatuhTempo.setDocument(new JTextFieldLimit(3)
        );
        textJatuhTempo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textJatuhTempoKeyReleased(evt);
            }
        });

        jLabel9.setText("Terbilang :");

        textTerbilang.setFont(new java.awt.Font("Tahoma", 1, 14));
        textTerbilang.setEnabled(false);
        jScrollPane1.setViewportView(textTerbilang);

        jLabel12.setText("Mohon Di Transfer ke : ");

        comboDitransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDitransferActionPerformed(evt);
            }
        });

        textAreaDitransferKe.setColumns(20);
        textAreaDitransferKe.setEditable(false);
        textAreaDitransferKe.setRows(5);
        textAreaDitransferKe.setEnabled(false);
        jScrollPane2.setViewportView(textAreaDitransferKe);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(dateChooserDate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(165, 165, 165))
                            .addComponent(textNII, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(comboKelas, 0, 224, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(comboBank, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(textPeserta, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDaftarMurid))
                    .addComponent(jLabel5)
                    .addComponent(comboKepada, javax.swing.GroupLayout.Alignment.TRAILING, 0, 457, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addComponent(textPembayaran, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 232, Short.MAX_VALUE))
                            .addComponent(textJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(textJatuhTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel12)
                    .addComponent(comboDitransfer, 0, 457, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dateChooserDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addComponent(textNII, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPeserta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDaftarMurid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboKepada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textJatuhTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboDitransfer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTagihan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))
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

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-519)/2, (screenSize.height-728)/2, 519, 728);
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
        invoice.setBank(null == listBank ? null : listBank.get(comboBank.getSelectedIndex()));
        invoice.setDeskripsiKepada(comboKepada.getSelectedIndex() == -1 ? null : listGLAccounts.get(comboKepada.getSelectedIndex()).getNoGL() + "#" + listGLAccounts.get(comboKepada.getSelectedIndex()).getNameGL() + "#" + listGLAccounts.get(comboKepada.getSelectedIndex()).getKode());
        invoice.setDeskripsiUntukPembayaran(textPembayaran.getText());
        invoice.setDeskripsiJumlahPeserta(textPeserta.getText());
        invoice.setJumlahTagihan(textJumlah.getText().isEmpty() ? (double) 0 : new Double(textJumlah.getText()));
        invoice.setStatus("0");
        invoice.setJatuhTempo(textJatuhTempo.getText());
        invoice.setDeskripsiUntuk(comboDitransfer.getSelectedIndex() == -1 ? null : listGLAccountsKreditur.get(comboDitransfer.getSelectedIndex()).getNoGL() + "#" + listGLAccountsKreditur.get(comboDitransfer.getSelectedIndex()).getNameGL());
        validate(invoice);
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void textJumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textJumlahKeyReleased
        if (textJumlah.getText().isEmpty()) {
            textTerbilang.setText("");
        } else {
            try {
                Long.parseLong(textJumlah.getText());
                textTerbilang.setText(ServiceHelper.bilang(Long.parseLong(textJumlah.getText())) + " rupiah");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Format salah, harus angka", "warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_textJumlahKeyReleased

    private void comboBankItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBankItemStateChanged
        renderKepada(listBank.get(comboBank.getSelectedIndex()));
        renderJumlahPeserta(listKelas.get(comboKelas.getSelectedIndex()), listBank.get(comboBank.getSelectedIndex()));
    }//GEN-LAST:event_comboBankItemStateChanged

    private void comboKelasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboKelasItemStateChanged
        renderBank(comboKelas.getSelectedItem().toString());
    }//GEN-LAST:event_comboKelasItemStateChanged

    private void textJatuhTempoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textJatuhTempoKeyReleased
        try {
            Long.parseLong(textJatuhTempo.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Format salah, harus angka", "warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_textJatuhTempoKeyReleased

    private void comboKepadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKepadaActionPerformed
        textAreaKepada.setText(listGLAccounts.get(comboKepada.getSelectedIndex()).getDeskripsi());
    }//GEN-LAST:event_comboKepadaActionPerformed

    private void comboDitransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDitransferActionPerformed
        textAreaDitransferKe.setText(listGLAccountsKreditur.get(comboDitransfer.getSelectedIndex()).getDeskripsi());
    }//GEN-LAST:event_comboDitransferActionPerformed

    private void textPesertaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPesertaKeyReleased
        try {
            Long.parseLong(textPeserta.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Format salah, harus angka", "warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_textPesertaKeyReleased

    private void buttonDaftarMuridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDaftarMuridActionPerformed
        try {
            Kelas kelas = listKelas.get(comboKelas.getSelectedIndex());
            Bank bank = listBank.get(comboBank.getSelectedIndex());
            listDaftarKelas = daftarKelasDAO.getDataByEqualsMore(kelas, bank);
            new DaftarKelasDialog(kelas, listDaftarKelas).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TagihanUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonDaftarMuridActionPerformed

    private void validate(Invoice invoice) {
        if (invoice == null) {
            JOptionPane.showMessageDialog(this, "Murid tidak boleh null");
        } else if (invoice.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Date tidak boleh null");
        } else if (invoice.getNII() == null) {
            JOptionPane.showMessageDialog(this, "NII tidak boleh null");
        } else if (invoice.getNII().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "NII tidak boleh kosong");
        } else if (invoice.getKelas().getTransactionReference().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Kelas tidak boleh kosong");
        } else if (invoice.getBank().getNama().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bank tidak boleh kosong");
        } else if (invoice.getDeskripsiKepada().equals("##null")) {
            JOptionPane.showMessageDialog(this, "Kepada tidak boleh kosong");
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
        } else if (invoice.getJumlahTagihan() == ((double) 0)) {
            JOptionPane.showMessageDialog(this, "Jumlah Tagihan tidak boleh kosong");
        } else if (invoice.getJatuhTempo().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Jumlah Tagihan tidak boleh kosong");
        } else if (invoice.getDeskripsiUntuk().equals("#null")) {
            JOptionPane.showMessageDialog(this, "Mohon Ditranfer ke tidak boleh kosong");
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
    private javax.swing.JButton buttonDaftarMurid;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JComboBox comboBank;
    private javax.swing.JComboBox comboDitransfer;
    private javax.swing.JComboBox comboKelas;
    private javax.swing.JComboBox comboKepada;
    private com.toedter.calendar.JDateChooser dateChooserDate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelTagihan;
    private javax.swing.JTextArea textAreaDitransferKe;
    private javax.swing.JTextArea textAreaKepada;
    private javax.swing.JTextField textJatuhTempo;
    private javax.swing.JTextField textJumlah;
    private javax.swing.JTextField textNII;
    private javax.swing.JTextField textPembayaran;
    private javax.swing.JTextField textPeserta;
    private javax.swing.JEditorPane textTerbilang;
    // End of variables declaration//GEN-END:variables

    private void renderKelas() {
        try {
            listKelas = kelasDAO.getDataByEquals(Kelas.class, "statusKelas", "N");
            Kelas kelas = new Kelas();
            kelas.setTransactionReference("");
            listKelas.add(0, kelas);
            updateComboKelas();
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

    private void renderKepada(Bank bank) {
        try {
            Map map = new HashMap();
            map.put("nama", bank.getNama());
            map.put("groupACC", "Debitur");
            listGLAccounts = gLAccountDAO.getDataByEqualsMore(GLAccount.class, map);
            GLAccount gLAccount = new GLAccount();
            gLAccount.setNameGL("");
            gLAccount.setNoGL("");
            listGLAccounts.add(0, gLAccount);
            updateComboKepada();
        } catch (Exception ex) {
            Logger.getLogger(TagihanUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateComboKepada() {
        Object data[] = new Object[listGLAccounts.size()];
        int x = 0;
        for (GLAccount gLAccount : listGLAccounts) {
            data[0] = "";
            data[x] = gLAccount.getNameGL() + " A/C No. " + gLAccount.getNoGL();
            x++;
        }
        comboKepada.setModel(new DefaultComboBoxModel(data));
    }

    private void renderBank(String kelas) {
        try {
            listBank = bankDAO.getDataBankByKelas(kelas);
            Bank bank = new Bank();
            bank.setNama("");
            listBank.add(0, bank);
            updateComboBank();
        } catch (Exception ex) {
            Logger.getLogger(TagihanUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void renderDitranfer() {
        try {
            listGLAccountsKreditur = gLAccountDAO.getDataByEquals(GLAccount.class, "groupACC", "Kreditur");
            GLAccount gLAccount = new GLAccount();
            gLAccount.setNoGL("");
            listGLAccountsKreditur.add(0, gLAccount);
            updateComboDitransfer();
        } catch (Exception ex) {
            Logger.getLogger(TagihanUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateComboDitransfer() {
        Object data[] = new Object[listGLAccountsKreditur.size()];
        int x = 0;
        for (GLAccount gLAccounts : listGLAccountsKreditur) {
            data[0] = "";
            data[x] = gLAccounts.getNameGL() + " A/C No. " + gLAccounts.getNoGL();
            x++;
        }
        comboDitransfer.setModel(new DefaultComboBoxModel(data));
    }

    private void renderJumlahPeserta(Kelas kelas, Bank bank) {
        try {
            String peserta = kelasDAO.getDataPeserta(kelas, bank);
            textPeserta.setText(peserta);
        } catch (Exception ex) {
            Logger.getLogger(TagihanUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void renderBankUbah(String transactionReference) {
        try {
            listBank = bankDAO.getDataBankByKelas(transactionReference);
            listBank.add(0, invoice.getBank());
            updateComboBank();
        } catch (Exception ex) {
            Logger.getLogger(TagihanUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}