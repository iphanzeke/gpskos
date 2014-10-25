/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao.impl;

import com.ivanbiz.dao.InvoiceDAO;
import com.ivanbiz.dao.JurnalDAO;
import com.ivanbiz.dao.PembayaranDAO;
import com.ivanbiz.model.Invoice;
import com.ivanbiz.model.Jurnal;
import com.ivanbiz.model.Pembayaran;
import com.ivanbiz.service.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author City_Z
 */
public class InvoiceDAOImpl extends GenericDAOImpl implements InvoiceDAO {

    @Override
    public String sendInvoiceWithJurnal(Invoice invoice, String proCode, String glCredit) throws Exception {
        String sukses = "";
        if (invoice.getStatus().equals("1")) {
            sukses = "Sudah Dalam Proses";
            return sukses;
        }
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            invoice.setStatus("1");
            session.save(invoice);
            JurnalDAO jurnalDAO = new JurnalDAOImpl();
            jurnalDAO.saveJurnal("005" + proCode, invoice.getJumlahTagihan(), invoice.getNII(), "", glCredit, session);
            HibernateUtil.commitTransaction();
            sukses = "sukses";
        } catch (Exception e) {
            sukses = "error";
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
        return sukses;
    }

    @Override
    public String sendInvoice(Invoice invoice, String proCode, String glCredit) throws Exception {
        String sukses = "";
        if (invoice.getStatus().equals("1")) {
            sukses = "Sudah Dalam Proses";
            return sukses;
        }
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            invoice.setStatus("1");
            session.update(invoice);
            JurnalDAO jurnalDAO = new JurnalDAOImpl();
            jurnalDAO.saveJurnal("005" + proCode, invoice.getJumlahTagihan(), invoice.getNII(), "", glCredit, session);
            HibernateUtil.commitTransaction();
            sukses = "sukses";
        } catch (Exception e) {
            sukses = "error";
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
        return sukses;
    }

    @Override
    public List<Invoice> getDataByEquals(String status) throws Exception {
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            Query queryInvoice = session.createQuery("select i from Invoice i where i.status = :status or i.status = 2");
            queryInvoice.setParameter("status", status);
            Query queryPembayaran = session.createQuery("select p.invoice from Pembayaran p where p.status = :status or p.status = 0");
            queryPembayaran.setParameter("status", status);
            List<Invoice> listInvoice = queryInvoice.list();
            List<Invoice> listPembayaran = queryPembayaran.list();
            List<Invoice> list = new ArrayList<Invoice>();
            for (Invoice invoice : listInvoice) {
                if (!listPembayaran.contains(invoice)) {
                    list.add(invoice);
                }
            }
            HibernateUtil.commitTransaction();
            return list;
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    @Override
    public List getDataByLike(Class clasImpl, String variable, Object input) throws Exception {
        List list = null;
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            Criteria crit = session.createCriteria(clasImpl);
            crit.add(Restrictions.like(variable, "%" + input + "%"));
            crit.add(Restrictions.ne("status", "0"));
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

    public List<Invoice> getDataByNotEquals(Class clazImpl, String variable, Object input) throws Exception {
        List list = null;
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            Criteria crit = session.createCriteria(clazImpl);
            crit.add(Restrictions.ne(variable, input));
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
    public String rejectInvoice(String noInvoice) throws Exception {
        String status = "";
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            JurnalDAO jurnalDAO = new JurnalDAOImpl();
            PembayaranDAO pembayaranDAO = new PembayaranDAOImpl();
            Pembayaran pembayaran = (Pembayaran) pembayaranDAO.getDataByEqual(Pembayaran.class, "transactionReference", noInvoice);
            if (pembayaran == null) {
                List listJurnal = jurnalDAO.getDataByEquals(Jurnal.class, "transactionReference", noInvoice);
                for (int x = 0; x < listJurnal.size(); x++) {
                    Jurnal jurnal = (Jurnal) listJurnal.get(x);
                    Jurnal jurnal1 = new Jurnal();
                    jurnal1.setAccountingReference(jurnal.getAccountingReference());
                    jurnal1.setCurrency(jurnal.getCurrency());
                    jurnal1.setDateReference(new Date());
                    jurnal1.setGLAccount(jurnal.getGLAccount());
                    jurnal1.setStatus(jurnal.getStatus());
                    jurnal1.setTransactionReference(jurnal.getTransactionReference());
                    jurnal1.setCredit(jurnal.getDebit());
                    jurnal1.setDebit(jurnal.getCredit());
                    session.save(jurnal1);
                }
                 status = "sukses";
            }else{
                status = "gagal";
            }
            Invoice invoice = (Invoice) getDataByEqual(Invoice.class, "NII", noInvoice);
            invoice.setStatus("5");
            session.update(invoice);
            HibernateUtil.commitTransaction();           
        } catch (Exception e) {
            status = "gagal";
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
        return status;
    }
}
