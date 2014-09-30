/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.report;

import com.ivanbiz.model.DaftarKelas;
import com.ivanbiz.model.Invoice;
import com.ivanbiz.model.Pembayaran;
import com.ivanbiz.model.Perusahaan;
import java.util.List;

/**
 *
 * @author Shbt Peterpan
 */
public class GlobalReport {

    private Perusahaan perusahaan;
    private Invoice invoice;
    private String namaGLDebitur;
    private String namaGLKreditur;
    private String logo;
    private String jumlah;
    private Pembayaran pembayaran;
    private List<DaftarKelas> listDaftarKelas;
    private DaftarKelas daftarKelas;

    public DaftarKelas getDaftarKelas() {
        return daftarKelas;
    }

    public void setDaftarKelas(DaftarKelas daftarKelas) {
        this.daftarKelas = daftarKelas;
    }

    public List<DaftarKelas> getListDaftarKelas() {
        return listDaftarKelas;
    }

    public void setListDaftarKelas(List<DaftarKelas> listDaftarKelas) {
        this.listDaftarKelas = listDaftarKelas;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }

    public String getNamaGLKreditur() {
        return namaGLKreditur;
    }

    public void setNamaGLKreditur(String namaGLKreditur) {
        this.namaGLKreditur = namaGLKreditur;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNamaGLDebitur() {
        return namaGLDebitur;
    }

    public void setNamaGLDebitur(String namaGLDebitur) {
        this.namaGLDebitur = namaGLDebitur;
    }

    public Perusahaan getPerusahaan() {
        return perusahaan;
    }

    public void setPerusahaan(Perusahaan perusahaan) {
        this.perusahaan = perusahaan;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
