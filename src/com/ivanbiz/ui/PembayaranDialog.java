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

import com.ivanbiz.dao.GLAccountDAO;
import com.ivanbiz.dao.impl.GLAccountDAOImpl;
import com.ivanbiz.model.GLAccount;
import com.ivanbiz.service.ServiceHelper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Shbt Peterpan
 */
public class PembayaranDialog extends JDialog {

    GLAccount gLAccount;
    List<GLAccount> listGlAccount;
    GLAccountDAO gLAccountDAO;

    /** Creates new form PengajarDialog */
    public PembayaranDialog() {
        initComponents();
        gLAccountDAO = new GLAccountDAOImpl();
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGLAccount = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButtonTambah = new javax.swing.JButton();
        jButtonUbah = new javax.swing.JButton();
        jButtonHapus = new javax.swing.JButton();

        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Daftar GL Account");

        jTableGLAccount.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableGLAccount);

        jButtonTambah.setText("Tambah Murid Baru");
        jButtonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionButton(evt);
            }
        });
        jPanel2.add(jButtonTambah);

        jButtonUbah.setText("Ubah Murid Terseleksi");
        jButtonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionButton(evt);
            }
        });
        jPanel2.add(jButtonUbah);

        jButtonHapus.setText("Hapus Murid Terseleksi");
        jButtonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionButton(evt);
            }
        });
        jPanel2.add(jButtonHapus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(753, 488));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void actionButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionButton
        if (evt.getSource() == jButtonTambah) {
            dispose();
            new GLAccountUpdateDialog().setVisible(true);
        } else if (evt.getSource() == jButtonUbah) {
            if (jTableGLAccount.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Pilih data yang akan diubah", "warning", JOptionPane.WARNING_MESSAGE);
            } else {
                dispose();
                gLAccount = listGlAccount.get(jTableGLAccount.getSelectedRow());
                new GLAccountUpdateDialog(gLAccount).setVisible(true);
            }
        } else if (evt.getSource() == jButtonHapus) {
            if (jTableGLAccount.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus", "warning", JOptionPane.WARNING_MESSAGE);
            } else {
                gLAccount = listGlAccount.get(jTableGLAccount.getSelectedRow());
                try {
                    gLAccountDAO.delete(gLAccount);
                } catch (Exception ex) {
                    Logger.getLogger(GLAccountDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
                refresh();
            }
        }
    }//GEN-LAST:event_actionButton

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonHapus;
    private javax.swing.JButton jButtonTambah;
    private javax.swing.JButton jButtonUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGLAccount;
    // End of variables declaration//GEN-END:variables

    private void refresh() {
        try {
            listGlAccount = gLAccountDAO.getAll(GLAccount.class);
            updateTablePengajar();
        } catch (Exception ex) {
            Logger.getLogger(GLAccountDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateTablePengajar() {
        String[] judul = {"No GL", "Nama GL", "Keterangan"};
        Object[][] isi = new Object[listGlAccount.size()][3];
        int x = 0;
        for (GLAccount gLAccounts : listGlAccount) {
            isi[x][0] = gLAccounts.getNoGL();
            isi[x][1] = gLAccounts.getNameGL();
            isi[x][2] = gLAccounts.getGroupACC();
            x++;
        }
        new ServiceHelper().setAutoRize(isi, judul, jTableGLAccount);
    }
}
