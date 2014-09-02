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

    LIHAT_JABATAN("Lihat Jabatan"),
    TAMBAH_JABATAN("Tambah Jabatan"),
    UBAH_JABATAN("Ubah Jabatan"),
    HAPUS_JABATAN("Hapus Jabatan"),
    LIHAT_MURID("Lihat Murid"),
    TAMBAH_MURID("Tambah Murid"),
    UBAH_MURID("Ubah Murid"),
    HAPUS_MURID("Hapus Murid"),
    LIHAT_KELAS("Lihat Kelas"),
    TAMBAH_KELAS("Tambah Kelas"),
    UBAH_KELAS("Ubah Kelas"),
    HAPUS_KELAS("Hapus Kelas"),
    LIHAT_BANK("Lihat Bank"),
    TAMBAH_BANK("Tambah Bank"),
    UBAH_BANK("Ubah Bank"),
    HAPUS_BANK("Hapus Bank"),
    LIHAT_GROUP("Lihat Group"),
    TAMBAH_GROUP("Tambah Group"),
    UBAH_GROUP("Ubah Group"),
    HAPUS_GROUP("Hapus Group"),;

    public static boolean validate(MenuAksesConstant menuAksesConstant, List<AksesMatrix> listAksesMatrix) {
        for (AksesMatrix aksesMatrix : listAksesMatrix) {
            if (aksesMatrix.getNama().equals(menuAksesConstant.toString())) {
                return true;
            }
        }
        return false;
    }
    private String nama;

    private MenuAksesConstant(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return nama;
    }
}
