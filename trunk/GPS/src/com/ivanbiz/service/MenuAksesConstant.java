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
    LIHAT_BANK("Lihat Bank"),
    LIHAT_GROUP("Lihat Group"),
    LIHAT_JURNAL("Lihat Jurnal"),
    LIHAT_PENGGUNA("Lihat Pengguna"),
    LIHAT_PERUSAHAAN("Lihat Perusahaan"),
    LIHAT_TAGIHAN("Lihat Tagihan"),
    //tambah
    TAMBAH_PENGAJAR("Tambah Pengajar"),
    TAMBAH_MURID("Tambah Murid"),
    TAMBAH_KELAS("Tambah Kelas"),
    TAMBAH_BANK("Tambah Bank"),
    TAMBAH_GROUP("Tambah Group"),
    TAMBAH_PENGGUNA("Tambah Pengguna"),
    TAMBAH_DAFTAR_KELAS("Tambah Daftar Kelas"),
    TAMBAH_TAGIHAN("Tambah Tagihan"),
    TAMBAH_GLACCOUNT("Tambah GL Account"),
    //ubah
    UBAH_PENGAJAR("Ubah Pengajar"),
    UBAH_MURID("Ubah Murid"),
    UBAH_KELAS("Ubah Kelas"),
    UBAH_BANK("Ubah Bank"),
    UBAH_GROUP("Ubah Group"),
    UBAH_PENGGUNA("Ubah Pengguna"),
    UBAH_PASSWORD("Ubah Password"),
    UBAH_TAGIHAN("Ubah Tagihan"),
    //hapus
    HAPUS_PENGAJAR("Hapus Pengajar"),
    HAPUS_KELAS("Hapus Kelas"),
    HAPUS_MURID("Hapus Murid"),
    HAPUS_BANK("Hapus Bank"),
    HAPUS_GROUP("Hapus Group"),
    HAPUS_PENGGUNA("Ubah Pengguna"),
    HAPUS_DAFTAR_KELAS("Hapus Daftar Kelas"),
    HAPUS_TAGIHAN("Hapus Tagihan"),
    HAPUS_GLACCOUNT("Hapus GL Account"),
    TUTUP_KELAS("Tutup Kelas");

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