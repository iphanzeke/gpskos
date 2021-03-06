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
public class DaftarKelas {

    private long id;
    private Kelas kelas;
    private Murid murid;
    private String transactionReference;
    private String status;/*0=belum ada hasil 1=lulus   2=tidak lulus*/

    private String kehadiran; /*0=tidak Hadir 1=Hadir*/

    private String kehadiran2;
    private String keterangan;
    private String keterangan2;
    private Date ujian;

    public Date getUjian() {
        return ujian;
    }

    public void setUjian(Date ujian) {
        this.ujian = ujian;
    }

    public String getKeterangan2() {
        return keterangan2;
    }

    public void setKeterangan2(String keterangan2) {
        this.keterangan2 = keterangan2;
    }

    public String getKehadiran2() {
        return kehadiran2;
    }

    public void setKehadiran2(String kehadiran2) {
        this.kehadiran2 = kehadiran2;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getKehadiran() {
        return kehadiran;
    }

    public void setKehadiran(String kehadiran) {
        this.kehadiran = kehadiran;
    }

    private boolean choose;

    public boolean isChoose() {
        return choose;
    }

    public void setChoose(boolean choose) {
        this.choose = choose;
    }

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
     * @return the kelas
     */
    public Kelas getKelas() {
        return kelas;
    }

    /**
     * @param kelas the kelas to set
     */
    public void setKelas(Kelas kelas) {
        this.kelas = kelas;
    }

    /**
     * @return the murid
     */
    public Murid getMurid() {
        return murid;
    }

    /**
     * @param murid the murid to set
     */
    public void setMurid(Murid murid) {
        this.murid = murid;
    }

    /**
     * @return the transactionReference
     */
    public String getTransactionReference() {
        return transactionReference;
    }

    /**
     * @param transactionReference the transactionReference to set
     */
    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
