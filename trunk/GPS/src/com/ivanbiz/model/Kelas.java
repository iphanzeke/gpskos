/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ivanbiz.model;

import java.util.Date;

/**
 *
 * @author ivan
 */
public class Kelas {
    private long id;
    private String NIK;
    private String deskripsi;
    private Date tanggalKelas;
    private String tempatKelas;
    private String alamatKelas;
    private Pengajar pengajar;
    private String statusKelas;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the NIK
     */
    public String getNIK() {
        return NIK;
    }

    /**
     * @param NIK the NIK to set
     */
    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    /**
     * @return the deskripsi
     */
    public String getDeskripsi() {
        return deskripsi;
    }

    /**
     * @param deskripsi the deskripsi to set
     */
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }


    /**
     * @return the tempatKelas
     */
    public String getTempatKelas() {
        return tempatKelas;
    }

    /**
     * @param tempatKelas the tempatKelas to set
     */
    public void setTempatKelas(String tempatKelas) {
        this.tempatKelas = tempatKelas;
    }

    /**
     * @return the alamatKelas
     */
    public String getAlamatKelas() {
        return alamatKelas;
    }

    /**
     * @param alamatKelas the alamatKelas to set
     */
    public void setAlamatKelas(String alamatKelas) {
        this.alamatKelas = alamatKelas;
    }

    /**
     * @return the pengajar
     */
    public Pengajar getPengajar() {
        return pengajar;
    }

    /**
     * @param pengajar the pengajar to set
     */
    public void setPengajar(Pengajar pengajar) {
        this.pengajar = pengajar;
    }

    /**
     * @return the statusKelas
     */
    public String getStatusKelas() {
        return statusKelas;
    }

    /**
     * @param statusKelas the statusKelas to set
     */
    public void setStatusKelas(String statusKelas) {
        this.statusKelas = statusKelas;
    }

    /**
     * @return the tanggalKelas
     */
    public Date getTanggalKelas() {
        return tanggalKelas;
    }

    /**
     * @param tanggalKelas the tanggalKelas to set
     */
    public void setTanggalKelas(Date tanggalKelas) {
        this.tanggalKelas = tanggalKelas;
    }
    
    
}
