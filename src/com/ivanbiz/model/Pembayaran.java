/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ivanbiz.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author ivan
 */
public class Pembayaran {
    private long id;
    private GLAccount debitBankAccount;
    private GLAccount kreditBankAccount;
    private BigDecimal jumlah;
    private String deskripsi;
    private String status;
    private Date dateCreated;
    private Date datePosting;
    private String pathImage;
    private String transactionReference;
    private Invoice invoice;
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
     * @return the dateCreated
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * @param dateCreated the dateCreated to set
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * @return the datePosting
     */
    public Date getDatePosting() {
        return datePosting;
    }

    /**
     * @param datePosting the datePosting to set
     */
    public void setDatePosting(Date datePosting) {
        this.datePosting = datePosting;
    }

    /**
     * @return the pathImage
     */
    public String getPathImage() {
        return pathImage;
    }

    /**
     * @param pathImage the pathImage to set
     */
    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
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
     * @return the invoice
     */
    public Invoice getInvoice() {
        return invoice;
    }

    /**
     * @param invoice the invoice to set
     */
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    /**
     * @return the debitBankAccount
     */
    public GLAccount getDebitBankAccount() {
        return debitBankAccount;
    }

    /**
     * @param debitBankAccount the debitBankAccount to set
     */
    public void setDebitBankAccount(GLAccount debitBankAccount) {
        this.debitBankAccount = debitBankAccount;
    }

    /**
     * @return the kreditBankAccount
     */
    public GLAccount getKreditBankAccount() {
        return kreditBankAccount;
    }

    /**
     * @param kreditBankAccount the kreditBankAccount to set
     */
    public void setKreditBankAccount(GLAccount kreditBankAccount) {
        this.kreditBankAccount = kreditBankAccount;
    }

    /**
     * @return the jumlah
     */
    public BigDecimal getJumlah() {
        return jumlah;
    }

    /**
     * @param jumlah the jumlah to set
     */
    public void setJumlah(BigDecimal jumlah) {
        this.jumlah = jumlah;
    }
}
