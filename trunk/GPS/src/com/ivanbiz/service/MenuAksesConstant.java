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

    //lihat
    LIHAT_PENGAJAR("Lihat Pengajar"),
    LIHAT_MURID("Lihat Murid"),
    LIHAT_KELAS("Lihat Kelas"),
    LIHAT_KELULUSAN("Lihat Kelulusan"),
    LIHAT_BANK("Lihat Bank"),
    LIHAT_GROUP("Lihat Group"),
    LIHAT_PENGGUNA("Lihat Pengguna"),
    LIHAT_PERUSAHAAN("Lihat Perusahaan"),
    LIHAT_TAGIHAN("Lihat Tagihan"),
    LIHAT_GLACCOUNT("Lihat GL ACCOUNT"),
    LIHAT_PEMBAYARAN_TAGIHAN("Lihat Pembayaran Tagihan"),
    LIHAT_PEMBAYARAN_LAIN("Lihat Pembayaran Lain - Lain"),
    //tambah
    TAMBAH_PENGAJAR("Tambah Pengajar"),
    TAMBAH_MURID("Tambah Murid"),
    TAMBAH_KELAS("Tambah Kelas"),
    TAMBAH_BANK("Tambah Bank"),
    TAMBAH_GROUP("Tambah Group"),
    TAMBAH_PENGGUNA("Tambah Pengguna"),
    TAMBAH_DAFTAR_KELAS("Tambah Daftar Kelas"),
    TAMBAH_GLACCOUNT("Tambah GL Account"),
    TAMBAH_TAGIHAN("Tambah Tagihan"),
    TAMBAH_PEMBAYARAN_TAGIHAN("Tambah Pembayaran Tagihan"),
    TAMBAH_PEMBAYARAN_LAIN("Tambah Pembayaran Lain - Lain"),
    //ubah
    UBAH_PENGAJAR("Ubah Pengajar"),
    UBAH_MURID("Ubah Murid"),
    UBAH_KELAS("Ubah Kelas"),
    UBAH_BANK("Ubah Bank"),
    UBAH_GROUP("Ubah Group"),
    UBAH_PENGGUNA("Ubah Pengguna"),
    UBAH_PASSWORD("Ubah Password"),
    UBAH_GLACCOUNT("Ubah GL Account"),
    UBAH_TAGIHAN("Ubah Tagihan"),
    UBAH_PEMBAYARAN_TAGIHAN("Ubah Pembayaran Tagihan"),
    UBAH_PEMBAYARAN_LAIN("Ubah Pembayaran Lain - Lain"),
    UBAH_KELULUSAN("Ubah Kelulusan"),
    //hapus
    HAPUS_PENGAJAR("Hapus Pengajar"),
    HAPUS_KELAS("Hapus Kelas"),
    HAPUS_MURID("Hapus Murid"),
    HAPUS_BANK("Hapus Bank"),
    HAPUS_GROUP("Hapus Group"),
    HAPUS_PENGGUNA("Ubah Pengguna"),
    HAPUS_DAFTAR_KELAS("Hapus Daftar Kelas"),
    HAPUS_GLACCOUNT("Hapus GL Account"),
    HAPUS_TAGIHAN("Hapus Tagihan"),
    HAPUS_PEMBAYARAN_TAGIHAN("Hapus Pembayaran Tagihan"),
    HAPUS_PEMBAYARAN_LAIN("Hapus Pembayaran Lain - Lain"),
    //
    TUTUP_KELAS("Tutup Kelas"),
    KIRIM_TAGIHAN("Kirim Tagihan"),
    //Report
    REPORT_DAFTAR_KELAS("Report Daftar Kelas"),
    REPORT_TAGIHAN("Report Tagihan"),
    REPORT_PEMBAYARAN_TAGIHAN("Report Pembayaran Tagihan"),
    REPORT_PEMBAYARAN_LAIN("Report Pembayaran Lain - Lain"),
    REPORT_RECONSILE("Report Data Kelas / Reconsile"),
    REPORT_JURNAL("Report Jurnal"),
    REPORT_KELULUSAN("Report Kelulusan");

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