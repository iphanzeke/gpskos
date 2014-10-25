/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.model;

import java.util.Date;

/**
 *
 * @author City_Z
 */
public class Invoice {

    private long id;
    private String NII;
    private Kelas kelas;
    private Bank bank;
    private String deskripsiKepada;
    private String deskripsiUntukPembayaran;
    private String deskripsiJumlahPeserta;
    private double jumlahTagihan;
    private Date date;
    private String status;/* 0=simpan 1=sudah kejurnal 2=sudah terbayar 5=reject */

    private String jatuhTempo;
    private String deskripsiUntuk;
    private String terbilang;

    public String getTerbilang() {
        return terbilang;
    }

    public void setTerbilang(String terbilang) {
        this.terbilang = terbilang;
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
     * @return the NII
     */
    public String getNII() {
        return NII;
    }

    /**
     * @param NII the NII to set
     */
    public void setNII(String NII) {
        this.NII = NII;
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
     * @return the bank
     */
    public Bank getBank() {
        return bank;
    }

    /**
     * @param bank the bank to set
     */
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    /**
     * @return the deskripsiKepada
     */
    public String getDeskripsiKepada() {
        return deskripsiKepada;
    }

    /**
     * @param deskripsiKepada the deskripsiKepada to set
     */
    public void setDeskripsiKepada(String deskripsiKepada) {
        this.deskripsiKepada = deskripsiKepada;
    }

    /**
     * @return the deskripsiUntukPembayaran
     */
    public String getDeskripsiUntukPembayaran() {
        return deskripsiUntukPembayaran;
    }

    /**
     * @param deskripsiUntukPembayaran the deskripsiUntukPembayaran to set
     */
    public void setDeskripsiUntukPembayaran(String deskripsiUntukPembayaran) {
        this.deskripsiUntukPembayaran = deskripsiUntukPembayaran;
    }

    /**
     * @return the deskripsiJumlahPeserta
     */
    public String getDeskripsiJumlahPeserta() {
        return deskripsiJumlahPeserta;
    }

    /**
     * @param deskripsiJumlahPeserta the deskripsiJumlahPeserta to set
     */
    public void setDeskripsiJumlahPeserta(String deskripsiJumlahPeserta) {
        this.deskripsiJumlahPeserta = deskripsiJumlahPeserta;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
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

    /**
     * @return the jatuhTempo
     */
    public String getJatuhTempo() {
        return jatuhTempo;
    }

    /**
     * @param jatuhTempo the jatuhTempo to set
     */
    public void setJatuhTempo(String jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }

    /**
     * @return the deskripsiUntuk
     */
    public String getDeskripsiUntuk() {
        return deskripsiUntuk;
    }

    /**
     * @param deskripsiUntuk the deskripsiUntuk to set
     */
    public void setDeskripsiUntuk(String deskripsiUntuk) {
        this.deskripsiUntuk = deskripsiUntuk;
    }

    /**
     * @return the jumlahTagihan
     */
    public double getJumlahTagihan() {
        return jumlahTagihan;
    }

    /**
     * @param jumlahTagihan the jumlahTagihan to set
     */
    public void setJumlahTagihan(double jumlahTagihan) {
        this.jumlahTagihan = jumlahTagihan;
    }

}
