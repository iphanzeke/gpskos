/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao;

import com.ivanbiz.model.Pembayaran;

/**
 *
 * @author ivan
 */
public interface PembayaranDAO extends GenericDAO {

    public String postingJurnalPembayaran(Pembayaran pembayaran) throws Exception;

    public String postingJurnalPembayaranVA(Pembayaran pembayaran, String virtualAccount) throws Exception;

    public String postingJurnalPembayaranLain(Pembayaran pembayaran) throws Exception;

    public String getLastNoTransaksi() throws Exception;
    
    public String postingJurnalTransKreditur(Pembayaran pembayaran)throws Exception;
}
