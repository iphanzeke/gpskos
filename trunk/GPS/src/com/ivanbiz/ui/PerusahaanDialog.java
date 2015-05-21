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

        jLabel2 = new javax.swing.JLabel();
        buttonRegistrasi = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAlamat = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        textTelephone = new javax.swing.JTextField();
        textFax = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textNama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textPassEmail = new javax.swing.JPasswordField();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        textIP = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        textUser = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textPassFTP = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel2.setText("Perusahaan");

        buttonRegistrasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/process.jpg"))); // NOI18N
        buttonRegistrasi.setText("Registrasi");
        buttonRegistrasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistrasiActionPerformed(evt);
            }
        });

        textAlamat.setDocument(new JTextFieldLimit(150));
        textAlamat.setRows(5);
        jScrollPane1.setViewportView(textAlamat);

        jLabel4.setText("Telephone :");

        textTelephone.setDocument(new JTextFieldLimit(20));

        textFax.setDocument(new JTextFieldLimit(20));

        jLabel3.setText("Alamat :");

        jLabel7.setText("Fax :");

        textNama.setDocument(new JTextFieldLimit(50));

        jLabel1.setText("Nama :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(textFax, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addComponent(textTelephone, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addComponent(textNama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Profil", jPanel4);

        jLabel8.setText("User :");

        textEmail.setDocument(new JTextFieldLimit(50));

        jLabel9.setText("Password :");

        textPassEmail.setDocument(new JTextFieldLimit(100));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textPassEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addComponent(textEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPassEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Email", jPanel5);

        jLabel10.setText("IP :");

        textIP.setDocument(new JTextFieldLimit(20));

        jLabel12.setText("User :");

        textUser.setDocument(new JTextFieldLimit(20));

        jLabel11.setText("Password :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textPassFTP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addComponent(textIP, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPassFTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("FTP", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonRegistrasi)
                .addGap(32, 32, 32))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-416)/2, (screenSize.height-437)/2, 416, 437);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRegistrasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistrasiActionPerformed
        if (null == perusahaan) {
            perusahaan = new Perusahaan();
        }
        perusahaan.setNama(textNama.getText());
        perusahaan.setAlamat(textAlamat.getText());
        perusahaan.setTelephone(textTelephone.getText());
        perusahaan.setFax(textFax.getText());
        perusahaan.setEmail(textEmail.getText());
        perusahaan.setPassEmail(textPassEmail.getText());
        perusahaan.setFtpIP(textIP.getText());
        perusahaan.setFtpUser(textUser.getText());
        perusahaan.setFtpPass(textPassFTP.getText());
        validate(perusahaan);
}//GEN-LAST:event_buttonRegistrasiActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonRegistrasi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea textAlamat;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textFax;
    private javax.swing.JTextField textIP;
    private javax.swing.JTextField textNama;
    private javax.swing.JPasswordField textPassEmail;
    private javax.swing.JPasswordField textPassFTP;
    private javax.swing.JTextField textTelephone;
    private javax.swing.JTextField textUser;
    // End of variables declaration//GEN-END:variables

    private void refresh() {
        if (perusahaan == null) {
            textNama.setText("");
            textAlamat.setText("");
            textTelephone.setText("");
            textFax.setText("");
            textEmail.setText("");
            textPassEmail.setText("");
            textIP.setText("");
            textUser.setText("");
            textPassFTP.setText("");
        } else {
            textNama.setText(perusahaan.getNama());
            textAlamat.setText(perusahaan.getAlamat());
            textTelephone.setText(perusahaan.getTelephone());
            textFax.setText(perusahaan.getFax());
            textEmail.setText(perusahaan.getEmail());
            textPassEmail.setText(perusahaan.getPassEmail());
            textIP.setText(perusahaan.getFtpIP());
            textUser.setText(perusahaan.getFtpUser());
            textPassFTP.setText(perusahaan.getFtpPass());
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
