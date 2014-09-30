/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on Aug 26, 2014, 7:29:02 PM
 */
package com.ivanbiz.ui;

import com.ivanbiz.dao.AksesMatrixDAO;
import com.ivanbiz.dao.impl.AksesMatrixDAOImpl;
import com.ivanbiz.model.AksesMatrix;
import com.ivanbiz.model.Pengguna;
import com.ivanbiz.service.GlobalSession;
import com.ivanbiz.service.MenuAksesConstant;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Shbt Peterpan
 */
public class MainFrame extends JFrame {

    Pengguna pengguna;
    AksesMatrixDAO aksesMatrixDAO;
    List<AksesMatrix> listAksesMatrix;

    /**
     * Creates new form MainFrame
     *
     * @param pengguna
     */
    public MainFrame(Pengguna pengguna) {
        initComponents();
//        setUndecorated(true);
//        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
//        this.setExtendedState(MainFrame.MAXIMIZED_BOTH);
        this.pengguna = pengguna;
        aksesMatrixDAO = new AksesMatrixDAOImpl();
        renderMenuAkses(pengguna);
    }

    private void renderMenuAkses(Pengguna pengguna) {
        try {
            listAksesMatrix = aksesMatrixDAO.getDataByEquals(AksesMatrix.class, "groups.id", pengguna.getGroups().getId());
            GlobalSession.setListAksesMatrix(listAksesMatrix);
            GlobalSession.setPengguna(pengguna);
            menuItemPengajar.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.LIHAT_PENGAJAR, listAksesMatrix));
            menuItemMurid.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.LIHAT_MURID, listAksesMatrix));
            menuItemKelas.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.LIHAT_KELAS, listAksesMatrix));
            menuItemBank.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.LIHAT_BANK, listAksesMatrix));
            menuItemPerusahaan.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.LIHAT_PERUSAHAAN, listAksesMatrix));
            menuItemGroup.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.LIHAT_GROUP, listAksesMatrix));
            menuItemPengguna.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.LIHAT_PENGGUNA, listAksesMatrix));
            menuItemPassword.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.UBAH_PASSWORD, listAksesMatrix));
            menuItemTagihan.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.LIHAT_TAGIHAN, listAksesMatrix));
            menuItemJurnal.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.REPORT_JURNAL, listAksesMatrix));
            menuItemTagihanReport.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.REPORT_TAGIHAN, listAksesMatrix));
            menuItemPembayaran.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.LIHAT_PEMBAYARAN_TAGIHAN, listAksesMatrix));
            menuItemPembayaranReport.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.REPORT_PEMBAYARAN, listAksesMatrix));
            menuItemDaftarKelasReport.setEnabled(MenuAksesConstant.validate(MenuAksesConstant.REPORT_DAFTAR_KELAS, listAksesMatrix));
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBarApp = new javax.swing.JMenuBar();
        menuAplikasi = new javax.swing.JMenu();
        menuItemKeluar = new javax.swing.JMenuItem();
        menuItemTutup = new javax.swing.JMenuItem();
        menuMaster = new javax.swing.JMenu();
        menuItemPengajar = new javax.swing.JMenuItem();
        menuItemMurid = new javax.swing.JMenuItem();
        menuItemKelas = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        menuItemBank = new javax.swing.JMenuItem();
        menuItemPerusahaan = new javax.swing.JMenuItem();
        menuItemTagihan = new javax.swing.JMenuItem();
        menuItemGLAccounts = new javax.swing.JMenuItem();
        menuItemPembayaran = new javax.swing.JMenuItem();
        menuHakAkses = new javax.swing.JMenu();
        menuItemGroup = new javax.swing.JMenuItem();
        menuItemPengguna = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        menuItemPassword = new javax.swing.JMenuItem();
        menuLaporan = new javax.swing.JMenu();
        menuItemJurnal = new javax.swing.JMenuItem();
        menuItemTagihanReport = new javax.swing.JMenuItem();
        menuItemPembayaranReport = new javax.swing.JMenuItem();
        menuItemDaftarKelasReport = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        menuAplikasi.setText("Aplikasi");

        menuItemKeluar.setText("Keluar Pengguna");
        menuItemKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemKeluarActionPerformed(evt);
            }
        });
        menuAplikasi.add(menuItemKeluar);

        menuItemTutup.setText("Tutup Aplikasi");
        menuItemTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTutupActionPerformed(evt);
            }
        });
        menuAplikasi.add(menuItemTutup);

        menuBarApp.add(menuAplikasi);

        menuMaster.setText("Data Master");

        menuItemPengajar.setText("Pengajar");
        menuItemPengajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPengajarActionPerformed(evt);
            }
        });
        menuMaster.add(menuItemPengajar);

        menuItemMurid.setText("Murid");
        menuItemMurid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMuridActionPerformed(evt);
            }
        });
        menuMaster.add(menuItemMurid);

        menuItemKelas.setText("Kelas");
        menuItemKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemKelasActionPerformed(evt);
            }
        });
        menuMaster.add(menuItemKelas);
        menuMaster.add(jSeparator1);

        menuItemBank.setText("Bank");
        menuItemBank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBankActionPerformed(evt);
            }
        });
        menuMaster.add(menuItemBank);

        menuItemPerusahaan.setText("Perusahaan");
        menuItemPerusahaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPerusahaanActionPerformed(evt);
            }
        });
        menuMaster.add(menuItemPerusahaan);

        menuItemTagihan.setText("Tagihan");
        menuItemTagihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTagihanActionPerformed(evt);
            }
        });
        menuMaster.add(menuItemTagihan);

        menuItemGLAccounts.setText("GL Account");
        menuItemGLAccounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGLAccountsActionPerformed(evt);
            }
        });
        menuMaster.add(menuItemGLAccounts);

        menuItemPembayaran.setText("Pembayaran");
        menuItemPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPembayaranActionPerformed(evt);
            }
        });
        menuMaster.add(menuItemPembayaran);

        menuBarApp.add(menuMaster);

        menuHakAkses.setText("Hak Akses");

        menuItemGroup.setText("Group");
        menuItemGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGroupActionPerformed(evt);
            }
        });
        menuHakAkses.add(menuItemGroup);

        menuItemPengguna.setText("Pengguna");
        menuItemPengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPenggunaActionPerformed(evt);
            }
        });
        menuHakAkses.add(menuItemPengguna);
        menuHakAkses.add(jSeparator2);

        menuItemPassword.setText("Password");
        menuItemPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPasswordActionPerformed(evt);
            }
        });
        menuHakAkses.add(menuItemPassword);

        menuBarApp.add(menuHakAkses);

        menuLaporan.setText("Laporan");

        menuItemJurnal.setText("Jurnal");
        menuItemJurnal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemJurnalActionPerformed(evt);
            }
        });
        menuLaporan.add(menuItemJurnal);

        menuItemTagihanReport.setText("Tagihan");
        menuItemTagihanReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTagihanReportActionPerformed(evt);
            }
        });
        menuLaporan.add(menuItemTagihanReport);

        menuItemPembayaranReport.setText("Pembayaran");
        menuItemPembayaranReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPembayaranReportActionPerformed(evt);
            }
        });
        menuLaporan.add(menuItemPembayaranReport);

        menuItemDaftarKelasReport.setText("Daftar Kelas");
        menuItemDaftarKelasReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDaftarKelasReportActionPerformed(evt);
            }
        });
        menuLaporan.add(menuItemDaftarKelasReport);

        menuBarApp.add(menuLaporan);

        setJMenuBar(menuBarApp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(816, 638));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemPengajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPengajarActionPerformed
        new PengajarDialog().setVisible(true);
    }//GEN-LAST:event_menuItemPengajarActionPerformed

    private void menuItemKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemKelasActionPerformed
        new KelasDialog().setVisible(true);
    }//GEN-LAST:event_menuItemKelasActionPerformed

    private void menuItemMuridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMuridActionPerformed
        new MuridDialog().setVisible(true);
    }//GEN-LAST:event_menuItemMuridActionPerformed

    private void menuItemBankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBankActionPerformed
        new BankDialog().setVisible(true);
    }//GEN-LAST:event_menuItemBankActionPerformed

    private void menuItemGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGroupActionPerformed
        new GroupDialog().setVisible(true);
    }//GEN-LAST:event_menuItemGroupActionPerformed

    private void menuItemJurnalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemJurnalActionPerformed
        new JurnalDialog().setVisible(true);
    }//GEN-LAST:event_menuItemJurnalActionPerformed

    private void menuItemPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPenggunaActionPerformed
        new PenggunaDialog().setVisible(true);
    }//GEN-LAST:event_menuItemPenggunaActionPerformed

    private void menuItemPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPasswordActionPerformed
        new PasswordDialog().setVisible(true);
    }//GEN-LAST:event_menuItemPasswordActionPerformed

    private void menuItemKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemKeluarActionPerformed
        dispose();
        new LoginDialog().setVisible(true);
    }//GEN-LAST:event_menuItemKeluarActionPerformed

    private void menuItemTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTutupActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuItemTutupActionPerformed

    private void menuItemPerusahaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPerusahaanActionPerformed
        new PerusahaanDialog().setVisible(true);
    }//GEN-LAST:event_menuItemPerusahaanActionPerformed

    private void menuItemTagihanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTagihanActionPerformed
        new TagihanDialog().setVisible(true);
    }//GEN-LAST:event_menuItemTagihanActionPerformed

    private void menuItemGLAccountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGLAccountsActionPerformed
        new GLAccountDialog().setVisible(true);
    }//GEN-LAST:event_menuItemGLAccountsActionPerformed

    private void menuItemTagihanReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTagihanReportActionPerformed
        new TagihanReportDialog().setVisible(true);
    }//GEN-LAST:event_menuItemTagihanReportActionPerformed

    private void menuItemPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPembayaranActionPerformed
        new PembayaranDialog().setVisible(true);
    }//GEN-LAST:event_menuItemPembayaranActionPerformed

    private void menuItemPembayaranReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPembayaranReportActionPerformed
        new PembayaranReportDialog().setVisible(true);
    }//GEN-LAST:event_menuItemPembayaranReportActionPerformed

    private void menuItemDaftarKelasReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDaftarKelasReportActionPerformed
        new DaftarKelasReportDialog().setVisible(true);
    }//GEN-LAST:event_menuItemDaftarKelasReportActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JMenu menuAplikasi;
    private javax.swing.JMenuBar menuBarApp;
    private javax.swing.JMenu menuHakAkses;
    private javax.swing.JMenuItem menuItemBank;
    private javax.swing.JMenuItem menuItemDaftarKelasReport;
    private javax.swing.JMenuItem menuItemGLAccounts;
    private javax.swing.JMenuItem menuItemGroup;
    private javax.swing.JMenuItem menuItemJurnal;
    private javax.swing.JMenuItem menuItemKelas;
    private javax.swing.JMenuItem menuItemKeluar;
    private javax.swing.JMenuItem menuItemMurid;
    private javax.swing.JMenuItem menuItemPassword;
    private javax.swing.JMenuItem menuItemPembayaran;
    private javax.swing.JMenuItem menuItemPembayaranReport;
    private javax.swing.JMenuItem menuItemPengajar;
    private javax.swing.JMenuItem menuItemPengguna;
    private javax.swing.JMenuItem menuItemPerusahaan;
    private javax.swing.JMenuItem menuItemTagihan;
    private javax.swing.JMenuItem menuItemTagihanReport;
    private javax.swing.JMenuItem menuItemTutup;
    private javax.swing.JMenu menuLaporan;
    private javax.swing.JMenu menuMaster;
    // End of variables declaration//GEN-END:variables
}
