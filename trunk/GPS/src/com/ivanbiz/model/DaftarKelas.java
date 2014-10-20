/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.model;

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
    private String keterangan;
    private String ujian;

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

    public String getUjian() {
        return ujian;
    }

    public void setUjian(String ujian) {
        this.ujian = ujian;
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
