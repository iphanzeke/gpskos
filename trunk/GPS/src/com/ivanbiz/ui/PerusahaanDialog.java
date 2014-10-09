/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PerusahaanDialog.java
 *
 * Created on 12 Sep 14, 22:08:12
 */
package com.ivanbiz.ui;

import com.ivanbiz.dao.PerusahaanDAO;
import com.ivanbiz.dao.impl.PerusahaanDAOImpl;
import com.ivanbiz.model.Perusahaan;
import com.ivanbiz.service.GlobalSession;
import com.ivanbiz.service.JTextFieldLimit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Shbt Peterpan
 */
public class PerusahaanDialog extends javax.swing.JDialog {

    Perusahaan perusahaan;
    PerusahaanDAO perusahaanDAO = new PerusahaanDAOImpl();
    List<Perusahaan> listPerusahaan;

    public PerusahaanDialog() {
        initComponents();
        perusahaan = GlobalSession.getPerusahaan();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAlamat = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        textTelephone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textFax = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        buttonRegistrasi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Nama :");

        textNama.setDocument(new JTextFieldLimit(50));

        jLabel3.setText("Alamat :");

        textAlamat.setDocument(new JTextFieldLimit(150));
        textAlamat.setRows(5);
        jScrollPane1.setViewportView(textAlamat);

        jLabel4.setText("Telephone :");

        textTelephone.setDocument(new JTextFieldLimit(20));

        jLabel7.setText("Fax :");

        textFax.setDocument(new JTextFieldLimit(20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNama, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(textTelephone, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addComponent(textFax, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel2.setText("Perusahaan");

        buttonRegistrasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/process.jpg"))); // NOI18N
        buttonRegistrasi.setText("Registrasi");
        buttonRegistrasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistrasiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(buttonRegistrasi, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonRegistrasi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-416)/2, (screenSize.height-415)/2, 416, 415);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRegistrasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistrasiActionPerformed
        if (null == perusahaan) {
            perusahaan = new Perusahaan();
        }
        perusahaan.setNama(textNama.getText());
        perusahaan.setAlamat(textAlamat.getText());
        perusahaan.setTelephone(textTelephone.getText());
        perusahaan.setFax(textFax.getText());
        validate(perusahaan);
}//GEN-LAST:event_buttonRegistrasiActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonRegistrasi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAlamat;
    private javax.swing.JTextField textFax;
    private javax.swing.JTextField textNama;
    private javax.swing.JTextField textTelephone;
    // End of variables declaration//GEN-END:variables

    private void refresh() {
        if (perusahaan == null) {
            textNama.setText("");
            textAlamat.setText("");
            textTelephone.setText("");
            textFax.setText("");
        } else {
            textNama.setText(perusahaan.getNama());
            textAlamat.setText(perusahaan.getAlamat());
            textTelephone.setText(perusahaan.getTelephone());
            textFax.setText(perusahaan.getFax());
        }
    }

    private void validate(Perusahaan perusahaan) {
        if (perusahaan == null) {
            JOptionPane.showMessageDialog(this, "Perusahaan tidak boleh null");
        } else if (perusahaan.getNama() == null) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh null");
        } else if (perusahaan.getNama().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong");
        } else if (perusahaan.getAlamat() == null) {
            JOptionPane.showMessageDialog(this, "Alamat tidak boleh null");
        } else if (perusahaan.getAlamat().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Alamat tidak boleh kosong");
        } else if (perusahaan.getTelephone() == null) {
            JOptionPane.showMessageDialog(this, "Telephone tidak boleh null");
        } else if (perusahaan.getTelephone().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Telephone tidak boleh kosong");
        } else if (perusahaan.getFax() == null) {
            JOptionPane.showMessageDialog(this, "FAX tidak boleh null");
        } else if (perusahaan.getFax().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FAX tidak boleh kosong");
        } else {
            try {
                perusahaanDAO.saveOrUpdate(perusahaan);
                GlobalSession.setPerusahaan(perusahaan);
                perusahaan = GlobalSession.getPerusahaan();
                refresh();
                JOptionPane.showMessageDialog(this, "Data sudah disimpan");
            } catch (Exception ex) {
                Logger.getLogger(PerusahaanDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
