/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.ui;

import com.ivanbiz.model.Pembayaran;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Shbt Peterpan
 */
public class PembayaranBuktiDialog extends javax.swing.JDialog {

    JFileChooser browseImage;
    String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public PembayaranBuktiDialog(MainFrame mainFrame, boolean modal, String image) {
        initComponents();
        this.image = image;
        labelImage.setIcon(new ImageIcon(image));
        setVisible(true);
    }

    public PembayaranBuktiDialog(MainFrame mainFrame, boolean modal, String images, Pembayaran pembayaran) {
        try {
            initComponents();
            this.image = pembayaran.getPathImage();
            labelImage.setIcon(new ImageIcon(new URL(images)));
            setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(PembayaranBuktiDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PembayaranBuktiDialog(MainFrame mainFrame, boolean modal, String images, Pembayaran pembayaran, String report) {
        try {
            initComponents();
            this.image = pembayaran.getPathImage();
            labelImage.setIcon(new ImageIcon(new URL(images)));
            buttonBrowse.setVisible(false);
            buttonSimpan.setVisible(false);
            setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(PembayaranBuktiDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        labelImage = new javax.swing.JLabel();
        buttonBrowse = new javax.swing.JButton();
        buttonSimpan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImage, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImage, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addContainerGap())
        );

        buttonBrowse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/process.jpg"))); // NOI18N
        buttonBrowse.setText("Browse");
        buttonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBrowseActionPerformed(evt);
            }
        });

        buttonSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ivanbiz/ui/icon/simpan.jpg"))); // NOI18N
        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonBrowse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSimpan)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonBrowse)
                    .addComponent(buttonSimpan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-616)/2, (screenSize.height-438)/2, 616, 438);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBrowseActionPerformed
        browseImage = new JFileChooser();
        browseImage.setCurrentDirectory(null);
        browseImage.setAcceptAllFileFilterUsed(false);
        browseImage.addChoosableFileFilter(new FileNameExtensionFilter("JPG", "JPG"));
        browseImage.showOpenDialog(this);
        if (browseImage.getSelectedFile() != null) {
            labelImage.setIcon(new ImageIcon(browseImage.getSelectedFile().getAbsolutePath()));
        }
    }//GEN-LAST:event_buttonBrowseActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        try {
            image = browseImage.getSelectedFile().getAbsolutePath();
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Pilih gambar yang akan disimpan");
        }
    }//GEN-LAST:event_buttonSimpanActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBrowse;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelImage;
    // End of variables declaration//GEN-END:variables
}
