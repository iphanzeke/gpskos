/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PenggunaUpdateDialog.java
 *
 * Created on 10 Sep 14, 23:01:25
 */
package com.ivanbiz.ui;

import com.ivanbiz.dao.GroupsDAO;
import com.ivanbiz.dao.PenggunaDAO;
import com.ivanbiz.dao.impl.GroupsDAOImpl;
import com.ivanbiz.dao.impl.PenggunaDAOImpl;
import com.ivanbiz.model.Groups;
import com.ivanbiz.model.Pengguna;
import com.ivanbiz.service.JTextFieldLimit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Shbt Peterpan
 */
public class PenggunaUpdateDialog extends javax.swing.JDialog {

    Pengguna pengguna;
    PenggunaDAO penggunaDAO = new PenggunaDAOImpl();
    GroupsDAO groupsDAO = new GroupsDAOImpl();
    List<Groups> listGroups;

    /**
     * Creates new form PenggunaUpdateDialog
     *
     * @param mainFrame
     * @param modal
     */
    public PenggunaUpdateDialog(MainFrame mainFrame, boolean modal) {
        initComponents();
        textKode.setText(getGenereateKode());
        refresh();
    }

    PenggunaUpdateDialog(MainFrame mainFrame, boolean modal, Pengguna pengguna) {
        initComponents();
        refresh();
        this.pengguna = pengguna;
        labelPengguna.setText("Ubah Pengguna");
        textKode.setText(pengguna.getKode());
        textUserName.setText(pengguna.getUserName());
        comboGroup.setSelectedItem(pengguna.getGroups().getNama());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelPengguna = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        textUserName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboGroup = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        textKode = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        buttonSimpan = new javax.swing.JButton();
        buttonBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        labelPengguna.setFont(new java.awt.Font("Tahoma", 1, 24));
        labelPengguna.setText("Tambah Pengguna Baru");

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("User Name :");

        textUserName.setDocument(new JTextFieldLimit(10));

        jLabel5.setText("Group :");

        jLabel4.setText("Kode :");

        textKode.setDocument(new JTextFieldLimit(10));
        textKode.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(textUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(comboGroup, 0, 354, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(textKode, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        buttonSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/simpan.jpg"))); // NOI18N
        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });
        jPanel3.add(buttonSimpan);

        buttonBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/batal.jpg"))); // NOI18N
        buttonBatal.setText("Batal");
        buttonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBatalActionPerformed(evt);
            }
        });
        jPanel3.add(buttonBatal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPengguna, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPengguna)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-416)/2, (screenSize.height-304)/2, 416, 304);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        if (pengguna == null) {
            pengguna = new Pengguna();
        }
        pengguna.setKode(textKode.getText());
        pengguna.setUserName(textUserName.getText());
        pengguna.setPassword(textUserName.getText());
        pengguna.setGroups(listGroups.get(comboGroup.getSelectedIndex()));
        validate(pengguna);
}//GEN-LAST:event_buttonSimpanActionPerformed

    private void buttonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBatalActionPerformed
        dispose();
}//GEN-LAST:event_buttonBatalActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBatal;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JComboBox comboGroup;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelPengguna;
    private javax.swing.JTextField textKode;
    private javax.swing.JTextField textUserName;
    // End of variables declaration//GEN-END:variables

    private void refresh() {
        try {
            listGroups = groupsDAO.getAll(Groups.class);
            updateComboGroup();
        } catch (Exception ex) {
            Logger.getLogger(PenggunaUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateComboGroup() {
        Object data[] = new Object[listGroups.size()];
        int x = 0;
        for (Groups groupss : listGroups) {
            data[x] = groupss.getNama();
            x++;
        }
        comboGroup.setModel(new DefaultComboBoxModel(data));
    }

    private void validate(Pengguna pengguna) {
        if (pengguna == null) {
            JOptionPane.showMessageDialog(this, "Pengguna tidak boleh null");
        } else if (pengguna.getUserName() == null) {
            JOptionPane.showMessageDialog(this, "User Name tidak boleh null");
        } else if (pengguna.getUserName().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "User Name tidak boleh kosong");
        } else if (pengguna.getGroups() == null) {
            JOptionPane.showMessageDialog(this, "Group tidak boleh null");
        } else {
            try {
                penggunaDAO.saveOrUpdate(pengguna);
                dispose();
            } catch (Exception ex) {
                Logger.getLogger(PenggunaUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private String getGenereateKode() {
        String kode = null;
        try {
            kode = penggunaDAO.getLastKode();
            if (!"".equals(kode)) {
                int count = Integer.parseInt(kode);
                count += 1;
                if (count >= 999) {
                    JOptionPane.showMessageDialog(this, "Kode lebih dari 3 digit");
                } else {
                    kode = String.format("%03d", count);
                }

            } else {
                kode = String.format("%03d", 1);
            }
        } catch (Exception ex) {
            Logger.getLogger(PenggunaUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kode;
    }
}