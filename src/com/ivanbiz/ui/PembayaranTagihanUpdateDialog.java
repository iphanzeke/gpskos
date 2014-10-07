/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PengajarUpdateDialog.java
 *
 * Created on 27 Agu 14, 18:59:19
 */
package com.ivanbiz.ui;

import com.ivanbiz.dao.GLAccountDAO;
import com.ivanbiz.dao.InvoiceDAO;
import com.ivanbiz.dao.PembayaranDAO;
import com.ivanbiz.dao.impl.GLAccountDAOImpl;
import com.ivanbiz.dao.impl.InvoiceDAOImpl;
import com.ivanbiz.dao.impl.PembayaranDAOImpl;
import com.ivanbiz.model.GLAccount;
import com.ivanbiz.model.Invoice;
import com.ivanbiz.model.Pembayaran;
import com.ivanbiz.service.FileUpload;
import java.io.File;
import java.io.IOException;
import java.util.Date;
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
public class PembayaranTagihanUpdateDialog extends JDialog {

    Pembayaran pembayaran;
    GLAccountDAO gLAccountDAO = new GLAccountDAOImpl();
    PembayaranDAO pembayaranDAO = new PembayaranDAOImpl();
    InvoiceDAO invoiceDAO = new InvoiceDAOImpl();
    List<Invoice> listInvoice;
    GLAccount glDebitur;
    GLAccount glKreditur;
    String path;

    /**
     * Creates new form PengajarUpdateDialog
     *
     * @param mainFrame
     * @param modal
     */
    public PembayaranTagihanUpdateDialog(MainFrame mainFrame, boolean modal) {
        initComponents();
        renderNoInvoice();
    }

    public PembayaranTagihanUpdateDialog(MainFrame mainFrame, boolean modal, Pembayaran pembayaran) {
        initComponents();
        this.pembayaran = pembayaran;
        labelPembayaran.setText("Ubah Pembayaran Tagihan");
        dateChooserPosting.setDate(pembayaran.getDatePosting());
        renderUbahNoInvoice();
        comboInvoice.setSelectedItem(pembayaran.getInvoice().getNII());
        textDebitur.setText(pembayaran.getDebitBankAccount().getNameGL() + " A/C No. " + pembayaran.getDebitBankAccount().getNoGL());
        glDebitur = pembayaran.getDebitBankAccount();
        textKreditur.setText(pembayaran.getKreditBankAccount().getNameGL() + " A/C No. " + pembayaran.getKreditBankAccount().getNoGL());
        glKreditur = pembayaran.getKreditBankAccount();
        textJumlah.setText(String.valueOf(new Double(pembayaran.getJumlah()).intValue()));
        textDeskripsi.setText(pembayaran.getDeskripsi());
        if (pembayaran.getStatusPajak().equals("1")) {
            checkBoxPajak.setSelected(true);
            textPajak.setEditable(true);
        } else {
            checkBoxPajak.setSelected(false);
            textPajak.setEditable(false);
        }
        textPajak.setText(String.valueOf(new Double(pembayaran.getBiayaPajak()).intValue()));
        textImage.setText(pembayaran.getPathImage());
        this.path = pembayaran.getPathImage();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelPembayaran = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        dateChooserPosting = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        comboInvoice = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textJumlah = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textDebitur = new javax.swing.JTextField();
        textKreditur = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textDeskripsi = new javax.swing.JTextArea();
        textPajak = new javax.swing.JTextField();
        checkBoxPajak = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        textImage = new javax.swing.JTextField();
        buttonBrowse = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        buttonSimpan = new javax.swing.JButton();
        buttonBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        labelPembayaran.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelPembayaran.setText("Tambah Pembayaran Tagihan");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setText("Date Posting :");

        dateChooserPosting.setDate(new Date());
        dateChooserPosting.setDateFormatString("dd MMM yyyy");
        dateChooserPosting.setEnabled(false);

        jLabel6.setText("No Tagihan / Invoice :");

        comboInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboInvoiceActionPerformed(evt);
            }
        });

        jLabel2.setText("Debitur :");

        jLabel3.setText("Kreditur :");

        jLabel4.setText("Jumlah :");

        textJumlah.setEditable(false);
        textJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textJumlahKeyReleased(evt);
            }
        });

        jLabel5.setText("Deskripsi :");

        textDebitur.setEditable(false);

        textKreditur.setEditable(false);

        textDeskripsi.setColumns(20);
        textDeskripsi.setEditable(false);
        textDeskripsi.setRows(5);
        textDeskripsi.setEnabled(false);
        jScrollPane1.setViewportView(textDeskripsi);

        textPajak.setEditable(false);
        textPajak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textPajakKeyReleased(evt);
            }
        });

        checkBoxPajak.setText("Pajak :");
        checkBoxPajak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxPajakActionPerformed(evt);
            }
        });

        jLabel1.setText("Bukti Pembayaran :");

        textImage.setEditable(false);

        buttonBrowse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/pencarian.jpg"))); // NOI18N
        buttonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChooserPosting, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addComponent(comboInvoice, 0, 328, Short.MAX_VALUE)
                    .addComponent(textJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addComponent(textDebitur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addComponent(textKreditur, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                    .addComponent(textPajak)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(checkBoxPajak)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textImage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonBrowse)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateChooserPosting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(5, 5, 5)
                .addComponent(comboInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textDebitur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textKreditur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxPajak)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPajak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textImage, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBrowse))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/simpan.jpg"))); // NOI18N
        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });
        jPanel2.add(buttonSimpan);

        buttonBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/batal.jpg"))); // NOI18N
        buttonBatal.setText("Batal");
        buttonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionButton(evt);
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
                    .addComponent(labelPembayaran)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPembayaran)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(390, 596));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void actionButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionButton
        dispose();
    }//GEN-LAST:event_actionButton

    private void textJumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textJumlahKeyReleased
        try {
            Long.parseLong(textJumlah.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Format salah, harus angka", "warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_textJumlahKeyReleased

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        if (pembayaran == null) {
            pembayaran = new Pembayaran();
        }
        pembayaran.setDateCreated(new Date());
        pembayaran.setStatus("0");
        pembayaran.setDatePosting(new Date());
        pembayaran.setInvoice(listInvoice.get(comboInvoice.getSelectedIndex()));
        pembayaran.setTransactionReference(pembayaran.getInvoice().getNII());
        pembayaran.setDebitBankAccount(glDebitur);
        pembayaran.setKreditBankAccount(glKreditur);
        pembayaran.setJumlah(textJumlah.getText().isEmpty() ? (double) 0 : new Double(textJumlah.getText()));
        pembayaran.setDeskripsi(textDeskripsi.getText());
        pembayaran.setPathImage(textImage.getText());
        if (checkBoxPajak.isSelected()) {
            pembayaran.setStatusPajak("1");
            pembayaran.setBiayaPajak(textPajak.getText().isEmpty() ? (double) 0 : new Double(textPajak.getText()));
        } else {
            pembayaran.setStatusPajak("0");
            pembayaran.setBiayaPajak((double) 0);
        }
        validate(pembayaran);
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void comboInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboInvoiceActionPerformed
        try {
            Invoice invoice = listInvoice.get(comboInvoice.getSelectedIndex());
            String kepada[] = invoice.getDeskripsiKepada().split("#");
            glDebitur = (GLAccount) gLAccountDAO.getDataByEqual(GLAccount.class, "noGL", kepada[0]);
            textDebitur.setText(glDebitur.getNameGL() + " A/C No. " + glDebitur.getNoGL());
            String untuk[] = invoice.getDeskripsiUntuk().split("#");
            glKreditur = (GLAccount) gLAccountDAO.getDataByEqual(GLAccount.class, "noGL", untuk[0]);
            textKreditur.setText(untuk[1] + " A/C No. " + untuk[0]);
            textJumlah.setText(String.valueOf(new Double(invoice.getJumlahTagihan()).intValue()));
            textDeskripsi.setText(invoice.getDeskripsiUntukPembayaran() + "\n" + "dengan peserta sebanyak " + invoice.getDeskripsiJumlahPeserta() + " orang");
        } catch (Exception ex) {
            Logger.getLogger(PembayaranTagihanUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboInvoiceActionPerformed

    private void textPajakKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPajakKeyReleased
        try {
            Long.parseLong(textPajak.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Format salah, harus angka", "warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_textPajakKeyReleased

    private void checkBoxPajakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxPajakActionPerformed
        if (checkBoxPajak.isSelected()) {
            textPajak.setEditable(true);
        } else {
            textPajak.setEditable(false);
            textPajak.setText("");
        }
    }//GEN-LAST:event_checkBoxPajakActionPerformed

    private void buttonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBrowseActionPerformed
        try {
            if (pembayaran != null) {
                new FileUpload().download("127.0.0.1", "Shbt Peterpan", "admin", pembayaran.getTransactionReference() + ".JPG", new File(pembayaran.getPathImage()));
                textImage.setText(pembayaran.getPathImage());
            }
            PembayaranBuktiDialog image = new PembayaranBuktiDialog(null, true, textImage.getText());
            textImage.setText(image.getImage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex);
            Logger.getLogger(PembayaranTagihanUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonBrowseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBatal;
    private javax.swing.JButton buttonBrowse;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JCheckBox checkBoxPajak;
    private javax.swing.JComboBox comboInvoice;
    private com.toedter.calendar.JDateChooser dateChooserPosting;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPembayaran;
    private javax.swing.JTextField textDebitur;
    private javax.swing.JTextArea textDeskripsi;
    private javax.swing.JTextField textImage;
    private javax.swing.JTextField textJumlah;
    private javax.swing.JTextField textKreditur;
    private javax.swing.JTextField textPajak;
    // End of variables declaration//GEN-END:variables

    private void renderNoInvoice() {
        try {
            listInvoice = invoiceDAO.getDataByEquals("1");
            Invoice invoice = new Invoice();
            invoice.setNII("");
            listInvoice.add(0, invoice);
            updateComboInvoice();
        } catch (Exception ex) {
            Logger.getLogger(PembayaranTagihanUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateComboInvoice() {
        Object data[] = new Object[listInvoice.size()];
        int x = 0;
        for (Invoice invoice : listInvoice) {
            data[x] = invoice.getNII();
            x++;
        }
        comboInvoice.setModel(new DefaultComboBoxModel(data));
    }

    private void validate(Pembayaran pembayaran) {
        if (pembayaran == null) {
            JOptionPane.showMessageDialog(this, "Pembayaran tidak boleh null");
        } else if (pembayaran.getInvoice() == null) {
            JOptionPane.showMessageDialog(this, "Invoice tidak boleh null");
        } else if (pembayaran.getDebitBankAccount() == null) {
            JOptionPane.showMessageDialog(this, "Debitur tidak boleh kosong");
        } else if (pembayaran.getKreditBankAccount() == null) {
            JOptionPane.showMessageDialog(this, "Kreditur tidak boleh null");
        } else if (pembayaran.getJumlah() == (double) 0) {
            JOptionPane.showMessageDialog(this, "Jumlah tidak boleh kosong");
        } else if (pembayaran.getDeskripsi().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Deskripsi tidak boleh kosong");
        } else if (pembayaran.getPathImage().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bukti Pembayaran tidak boleh kosong");
        } else {
            try {
                if (null != path && path.equals(textImage.getText())) {
                } else {
                    new FileUpload().upload("127.0.0.1", "Shbt Peterpan", "admin", pembayaran.getTransactionReference() + ".JPG", new File(textImage.getText()));
                }
                File file = new File(pembayaran.getPathImage());
                if (file.exists()) {
                    file.delete();
                }
                pembayaran.setPathImage(System.getProperty("user.dir") + "\\image\\" + pembayaran.getTransactionReference() + ".JPG");
                pembayaranDAO.saveOrUpdate(pembayaran);
                dispose();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex);
                Logger.getLogger(PembayaranTagihanUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(PembayaranTagihanUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void renderUbahNoInvoice() {
        try {
            listInvoice = invoiceDAO.getDataByEquals("1");
            listInvoice.add(0, pembayaran.getInvoice());
            updateComboInvoice();
        } catch (Exception ex) {
            Logger.getLogger(PembayaranTagihanUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
