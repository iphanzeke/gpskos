/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao.impl;

import com.ivanbiz.dao.JurnalDAO;
import com.ivanbiz.dao.PembayaranDAO;
import com.ivanbiz.model.Invoice;
import com.ivanbiz.model.Pembayaran;
import com.ivanbiz.service.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ivan
 */
public class PembayaranDAOImpl extends GenericDAOImpl implements PembayaranDAO {

    @Override
    public String postingJurnalPembayaran(Pembayaran pembayaran) throws Exception {
        String status = "";
        HibernateUtil.beginTransaction();
        try {
            Session session = HibernateUtil.getSession();
            pembayaran.setTransactionReference(pembayaran.getInvoice().getNII());
            pembayaran.setStatus("1");
            Invoice invoice = pembayaran.getInvoice();
            invoice.setStatus("2");
            session.update(invoice);
            session.update(pembayaran);
            String proCode = pembayaran.getDebitBankAccount().getKode() + pembayaran.getKreditBankAccount().getKode();
            JurnalDAO jurnalDAO = new JurnalDAOImpl();
            jurnalDAO.saveJurnal(proCode, pembayaran.getJumlah(), pembayaran.getInvoice().getNII(), pembayaran.getDebitBankAccount().getNoGL(), pembayaran.getKreditBankAccount().getNoGL(), session);

            HibernateUtil.commitTransaction();
            status = "sukses";
        } catch (Exception ex) {
            status = "error";
            HibernateUtil.rollbackTransaction();
            throw ex;
        } finally {
            HibernateUtil.closeSession();
        }
        return status;
    }

    @Override
    public String postingJurnalPembayaranVA(Pembayaran pembayaran, String virtualAccount) throws Exception {
        String status = "";
        HibernateUtil.beginTransaction();
        try {
            Session session = HibernateUtil.getSession();
            Invoice invoice = pembayaran.getInvoice();
            invoice.setStatus("2");
            pembayaran.setStatus("1");
            pembayaran.setTransactionReference(pembayaran.getInvoice().getNII());
            session.update(pembayaran);
            String proCode = pembayaran.getDebitBankAccount().getKode() + pembayaran.getKreditBankAccount().getKode();
            JurnalDAO jurnalDAO = new JurnalDAOImpl();
            jurnalDAO.saveJurnalWithVA(proCode, pembayaran.getJumlah(), pembayaran.getTransactionReference(), virtualAccount, pembayaran.getDebitBankAccount().getNoGL(), pembayaran.getKreditBankAccount().getNoGL(), session);
            HibernateUtil.commitTransaction();
            status = "sukses";
        } catch (Exception ex) {
            status = "error";
            HibernateUtil.rollbackTransaction();
            throw ex;
        } finally {
            HibernateUtil.closeSession();
        }
        return status;

    }

    @Override
    public String postingJurnalPembayaranLain(Pembayaran pembayaran) throws Exception {
        String status = "";
        HibernateUtil.beginTransaction();
        try {
            Session session = HibernateUtil.getSession();
            Invoice invoice = pembayaran.getInvoice();
            invoice.setStatus("2");
            pembayaran.setStatus("1");
            session.update(pembayaran);
            String proCode = pembayaran.getDebitBankAccount().getKode() + pembayaran.getKreditBankAccount().getKode();
            JurnalDAO jurnalDAO = new JurnalDAOImpl();
            jurnalDAO.saveJurnal(proCode, pembayaran.getJumlah(), pembayaran.getTransactionReference(), pembayaran.getDebitBankAccount().getNoGL(), pembayaran.getKreditBankAccount().getNoGL(), session);
            HibernateUtil.commitTransaction();
            status = "sukses";
        } catch (Exception ex) {
            status = "error";
            HibernateUtil.rollbackTransaction();
            throw ex;
        } finally {
            HibernateUtil.closeSession();
        }
        return status;
    }
}
