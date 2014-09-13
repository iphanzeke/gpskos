/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ivanbiz.dao.impl;

import com.ivanbiz.dao.JurnalDAO;
import com.ivanbiz.dao.PembayaranDAO;
import com.ivanbiz.model.Pembayaran;
import com.ivanbiz.service.HibernateUtil;
import java.math.BigDecimal;
import org.hibernate.Session;

/**
 *
 * @author ivan
 */
public class PembayaranDAOImpl extends GenericDAOImpl implements PembayaranDAO{

    @Override
    public String postingJurnalPembayaran(Pembayaran pembayaran) throws Exception {
        String status = "";
        HibernateUtil.beginTransaction();
        try{
            Session session = HibernateUtil.getSession();
            session.save(pembayaran);
            String proCode = pembayaran.getDebitBankAccount().getKode()+pembayaran.getKreditBankAccount().getKode();
            JurnalDAO jurnalDAO = new JurnalDAOImpl();
            jurnalDAO.saveJurnal(proCode, pembayaran.getJumlah(), pembayaran.getTransactionReference(), pembayaran.getDebitBankAccount().getNoGL(),pembayaran.getKreditBankAccount().getNoGL(),session);
            if(pembayaran.getJumlah().compareTo(pembayaran.getInvoice().getJumlahTagihan())==0){
                
            }
            
            HibernateUtil.commitTransaction();
            status = "sukses";
        }catch(Exception ex){
            status = "error";
            HibernateUtil.rollbackTransaction();
            throw ex;
        }finally{
            HibernateUtil.closeSession();
        }
       return status;
    }

    @Override
    public String postingJurnalPembayaranVA(Pembayaran pembayaran,String virtualAccount) throws Exception {
         String status = "";
        HibernateUtil.beginTransaction();
        try{
            Session session = HibernateUtil.getSession();
            session.save(pembayaran);
            String proCode = pembayaran.getDebitBankAccount().getKode()+pembayaran.getKreditBankAccount().getKode();
            JurnalDAO jurnalDAO = new JurnalDAOImpl();
            jurnalDAO.saveJurnalWithVA(proCode, pembayaran.getJumlah(), pembayaran.getTransactionReference(), virtualAccount,pembayaran.getDebitBankAccount().getNoGL(),pembayaran.getKreditBankAccount().getNoGL(),session);
            HibernateUtil.commitTransaction();
            status = "sukses";
        }catch(Exception ex){
            status = "error";
            HibernateUtil.rollbackTransaction();
            throw ex;
        }finally{
            HibernateUtil.closeSession();
        }
       return status;
       
    }
    
}
