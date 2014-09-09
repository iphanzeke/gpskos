/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.model;

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
    private String terbilang;

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

    /**
     * @return the terbilang
     */
    public String getTerbilang() {
        return terbilang;
    }

    /**
     * @param terbilang the terbilang to set
     */
    public void setTerbilang(String terbilang) {
        this.terbilang = terbilang;
    }
}
