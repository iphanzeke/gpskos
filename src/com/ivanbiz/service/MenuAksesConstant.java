/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.service;

import com.ivanbiz.model.AksesMatrix;
import java.util.List;

/**
 *
 * @author echo
 */
public enum MenuAksesConstant {

    //Data Master
    LIHAT_PENGAJAR("Menu Pengajar"),
    LIHAT_MURID("Menu Murid"),
    LIHAT_KELAS("Menu Kelas"),
    LIHAT_BANK("Menu Bank"),
    LIHAT_PERUSAHAAN("Menu Perusahaan"),
    LIHAT_GLACCOUNT("Menu GL Account"),
    //Transaksi
    LIHAT_TAGIHAN("Menu Tagihan"),
    LIHAT_PEMBAYARAN_TAGIHAN("Menu Pembayaran Tagihan"),
    LIHAT_PEMBAYARAN_LAIN("Menu Pembayaran Lain - Lain"),
    LIHAT_KELULUSAN("Menu Kelulusan/Kehadiran/Tanggal Ujian"),
    LIHAT_BUAT_JADWAl_KELAS("Menu Buat Jadwal Kelas"),
    LIHAT_SALDO_KAS("Menu Saldo Kas"),
    RETUR_TAGIHAN("Menu Retur Tagihan"),
    PROSES_TRANSFER_KREDITUR_TO_KREDITUR("Menu Transfer Kreditur to Kreditur"),
    //Hak Akses
    LIHAT_GROUP("Menu Group"),
    LIHAT_PENGGUNA("Menu Pengguna"),
    UBAH_PASSWORD("Menu Password"),
    //Laporan
    REPORT_TAGIHAN("Menu Laporan Tagihan"),
    REPORT_PEMBAYARAN_TAGIHAN("Menu Laporan Pembayaran Tagihan"),
    REPORT_PEMBAYARAN_LAIN("Menu Laporan Pembayaran Lain - Lain"),
    REPORT_DAFTAR_KELAS("Menu Laporan Daftar Kelas"),
    REPORT_KELULUSAN("Menu Laporan Kelulusan"),
    REPORT_JURNAL("Menu Laporan Jurnal"),
    REPORT_RECONSILE("Menu Laporan Reconsile Kelas"),
    REPORT_SUM_ACCOUNT_KREDITUR("Menu Laporan Account Kreditur"),
    REPORT_PEMBAYARAN_SUM_LAIN("Menu Laporan Account Biaya Lain - Lain"),
    REPORT_LABA_RUGI("Menu Laporan Laba Rugi"),
    REPORT_SALDO_KAS("Menu Laporan Saldo Kas"),
    //Tambah
    TAMBAH_PENGAJAR("Tambah Pengajar"),
    TAMBAH_MURID("Tambah Murid"),
    TAMBAH_KELAS("Tambah Kelas"),
    TAMBAH_BANK("Tambah Bank"),
    TAMBAH_GLACCOUNT("Tambah GL Account"),
    TAMBAH_TAGIHAN("Tambah Tagihan"),
    TAMBAH_PEMBAYARAN_TAGIHAN("Tambah Pembayaran Tagihan"),
    TAMBAH_PEMBAYARAN_LAIN("Tambah Pembayaran Lain - Lain"),
    TAMBAH_GROUP("Tambah Group"),
    TAMBAH_PENGGUNA("Tambah Pengguna"),
    TAMBAH_SALDO_KAS("Tambah Saldo Kas"),
    //Ubah
    UBAH_PENGAJAR("Ubah Pengajar"),
    UBAH_MURID("Ubah Murid"),
    UBAH_KELAS("Ubah Kelas"),
    UBAH_BANK("Ubah Bank"),
    UBAH_TAGIHAN("Ubah Tagihan"),
    UBAH_PEMBAYARAN_TAGIHAN("Ubah Pembayaran Tagihan"),
    UBAH_PEMBAYARAN_LAIN("Ubah Pembayaran Lain - Lain"),
    UBAH_GROUP("Ubah Group"),
    UBAH_PENGGUNA("Ubah Pengguna"),    
    //Hapus
    HAPUS_PENGAJAR("Hapus Pengajar"),
    HAPUS_MURID("Hapus Murid"),
    HAPUS_KELAS("Hapus Kelas"),
    HAPUS_BANK("Hapus Bank"),
    HAPUS_GLACCOUNT("Hapus GL Account"),
    HAPUS_TAGIHAN("Hapus Tagihan"),
    HAPUS_PEMBAYARAN_TAGIHAN("Hapus Pembayaran Tagihan"),
    HAPUS_PEMBAYARAN_LAIN("Hapus Pembayaran Lain - Lain"),
    HAPUS_GROUP("Hapus Group"),
    HAPUS_PENGGUNA("Hapus Pengguna"),
    HAPUS_SALDO_KAS("Hapus Saldo Kas"),
    //Others
    KIRIM_TAGIHAN("Proses Tagihan"),
    PROSES_PEMBAYARAN_TAGIHAN("Proses Pembayaran Tagihan"),
    PROSES_PEMBAYARAN_LAIN("Proses Pembayaran Lain - Lain"),
    TUTUP_KELAS("Tutup Kelas"),
    TUTUP_SALDO_KAS("Tutup Saldo Kas");

    public static boolean validate(MenuAksesConstant menuAksesConstant, List<AksesMatrix> listAksesMatrix) {
        for (AksesMatrix aksesMatrix : listAksesMatrix) {
            if (aksesMatrix.getNama().equals(menuAksesConstant.toString())) {
                return true;
            }
        }
        return false;
    }
    private final String nama;

    private MenuAksesConstant(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return nama;
    }
}
