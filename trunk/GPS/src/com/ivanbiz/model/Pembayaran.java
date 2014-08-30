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
public class Pembayaran {
    private long id;
    private BankAccount debitBankAccount;
    private BankAccount kreditBankAccount;
    private double jumlah;
    private String deskripsi;
    private String status;
    private Date dateCreated;
    private Date datePosting;
    private String pathImage;
    private String transactionReference;
}
