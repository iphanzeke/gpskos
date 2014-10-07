/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao.impl;

import com.ivanbiz.dao.JurnalDAO;
import com.ivanbiz.dao.PembayaranDAO;
import com.ivanbiz.model.Invoice;
import com.ivanbiz.model.Kelas;
import com.ivanbiz.model.Pembayaran;
import com.ivanbiz.service.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
            if ("1".equals(pembayaran.getStatusPajak())) {
                jurnalDAO.saveJurnal("999999", pembayaran.getBiayaPajak(), pembayaran.getInvoice().getNII(), pembayaran.getKreditBankAccount().getNoGL(), "GPSPAJAK", session);
            }
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
//            Invoice invoice = pembayaran.getInvoice();
//            invoice.setStatus("2");
            pembayaran.setStatus("3");
            String proCode = pembayaran.getDebitBankAccount().getKode() + pembayaran.getKreditBankAccount().getKode();
            JurnalDAO jurnalDAO = new JurnalDAOImpl();
            if (!"PRO_Code tidak ditemukan".equals(jurnalDAO.saveJurnal(proCode, pembayaran.getJumlah(), pembayaran.getTransactionReference(), pembayaran.getDebitBankAccount().getNoGL(), pembayaran.getKreditBankAccount().getNoGL(), session))) {
                session.update(pembayaran);
            }
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
    public List getDataByLike(Class clasImpl, String variable, Object input) throws Exception {
        List list = null;
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            Criteria crit = session.createCriteria(clasImpl);
            crit.add(Restrictions.like(variable, "%" + input + "%"));
            crit.add(Restrictions.eq("status", "1"));
            list = crit.list();
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
        return list;
    }

    @Override
    public String getLastNoTransaksi() throws Exception {
        Pembayaran pembayaran = null;
        String noTransaksi = "";
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            Query query = session.createQuery("from Pembayaran p where p.transactionReference like '%PL%' order by p.id desc");
            query.setFirstResult(0);
            query.setMaxResults(1);
            pembayaran = (Pembayaran) query.uniqueResult();
            if (pembayaran != null) {
                noTransaksi = pembayaran.getTransactionReference();
            }
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
        return noTransaksi;
    }
}
