/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.report;

import com.ivanbiz.model.Invoice;
import com.ivanbiz.model.Perusahaan;

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
